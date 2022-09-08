package vndustry.utility;

import arc.Events;
import arc.util.CommandHandler;
import mindustry.game.EventType;
import mindustry.mod.Plugin;
import vndustry.utility.command.CommandRegister;

public class Utility extends Plugin {

    @Override
    public void init() {
        Events.on(EventType.PlayerJoin.class, EventHandler::onPlayerJoin);
        Events.on(EventType.PlayerLeave.class, EventHandler::onPlayerLeave);
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        CommandRegister.registerPlayerCommands(handler);
    }

    @Override
    public void registerServerCommands(CommandHandler handler) {
        CommandRegister.registerServerCommands(handler);
    }
}
