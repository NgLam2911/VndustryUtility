package vndustry.utility;

import mindustry.game.EventType.*;
import mindustry.gen.Player;
import vndustry.utility.session.SessionManager;

public class EventHandler {

    public static void onPlayerJoin(PlayerJoin event){
        Player player = event.player;
        SessionManager.registerSession(player);
    }

    public static void onPlayerLeave(PlayerLeave event){
        Player player = event.player;
        SessionManager.unregisterSession(player);
    }

}
