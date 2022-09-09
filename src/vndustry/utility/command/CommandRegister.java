package vndustry.utility.command;

import arc.util.CommandHandler;
import vndustry.utility.command.player.*;

public class CommandRegister {
    public static void registerPlayerCommands(CommandHandler handler) {
        register(handler, new GG());
        register(handler, new Chat());
        register(handler, new Kill());
        register(handler, new Kick());
        register(handler, new BuildCore());
        register(handler, new Mute());
        register(handler, new Unmute());
    }

    public static void registerServerCommands(CommandHandler handler) {
        //TODO: Register server commands
    }

    public static void register(CommandHandler handler, PlayerCommand command) {
        handler.register(command.getName(), command.getParams(), command.getDescription(), command::execute);
    }
}
