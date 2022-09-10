package vndustry.utility;

import mindustry.Vars;
import mindustry.gen.Player;
import mindustry.net.Administration.PlayerAction;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;

public class NetworkFilters {
    public static void initFilters() {
        Vars.netServer.admins.addActionFilter(NetworkFilters::handleAction);
        Vars.netServer.admins.addChatFilter(NetworkFilters::handleChat);
    }

    private static boolean handleAction(PlayerAction action) {
        //TODO: Handle Actions
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