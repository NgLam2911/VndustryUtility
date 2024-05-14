package vndustry.utility;

import arc.Events;
import mindustry.game.EventType;
import mindustry.game.EventType.PlayerJoin;
import mindustry.game.EventType.PlayerLeave;
import mindustry.gen.Player;
import vndustry.utility.session.SessionManager;

public class EventHandler {
    public static void initEvents() {
        Events.on(EventType.PlayerJoin.class, EventHandler::onPlayerJoin);
        Events.on(EventType.PlayerLeave.class, EventHandler::onPlayerLeave);
        Events.on(EventType.PlayerChatEvent.class, EventHandler::onPlayerChatEvent);
    }

    private static void onPlayerJoin(PlayerJoin event) {
        Player player = event.player;
        SessionManager.registerSession(player);
    }

    private static void onPlayerLeave(PlayerLeave event) {
        Player player = event.player;
        SessionManager.unregisterSession(player);
    }
}
