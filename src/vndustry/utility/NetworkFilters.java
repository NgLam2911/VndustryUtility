package vndustry.utility;

import mindustry.Vars;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.net.Administration.PlayerAction;
import mindustry.net.Administration.ActionType;
import vndustry.utility.session.*;

public class NetworkFilters {
    public static void initFilters() {
        Vars.netServer.admins.addActionFilter(NetworkFilters::handleAction);
        Vars.netServer.admins.addChatFilter(NetworkFilters::handleChat); //Mindustry events is not cancellable
    }

    private static boolean handleAction(PlayerAction action) {
        //TODO: Handle Actions
        Session session = SessionManager.getSession(action.player);
        // Sandbox
        if ((session != null) && session.sandbox){
            if (action.type == ActionType.placeBlock){
                Call.constructFinish(action.tile, action.block, action.unit, (byte)action.rotation, action.player.team(), action.config);
            }
            if (action.type == ActionType.breakBlock){
                Call.deconstructFinish(action.tile, action.block, action.unit);
            }
        }
        return true;
    }

    private static String handleChat(Player player, String message) {
        Session session = SessionManager.getSession(player);
        if (session != null) {
            if (session.muted) {
                player.sendMessage("[scarlet]You are muted, you can't chat !");
                return null;
            }
        }
        return message;
    }
}
