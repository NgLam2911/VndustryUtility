package vndustry.utility.command;

import arc.util.CommandHandler;
import vndustry.utility.command.player.*;
import vndustry.utility.command.server.ServerCommand;

public class CommandRegister {
    public static void registerPlayerCommands(CommandHandler handler) {
        register(handler, new GG());
        register(handler, new Chat());
        register(handler, new Kill());
        register(handler, new Kick());
        register(handler, new BuildCore());
        register(handler, new Mute());
        register(handler, new Unmute());
        register(handler, new Summon());
        register(handler, new ChangeTeam());
        register(handler, new Unit());
        register(handler, new Sandbox());
        register(handler, new Power());
        register(handler, new CommandCenter());
    }

    public static void registerServerCommands(CommandHandler handler) {
        //TODO: Register server commands
    }

    private static void register(CommandHandler handler, PlayerCommand command) {
        handler.register(command.getName(), command.getParams(), command.getDescription(), command::execute);
    }

    private static void register(CommandHandler handler, ServerCommand command) {
        handler.register(command.getName(), command.getParams(), command.getDescription(), command::execute);
    }
}
