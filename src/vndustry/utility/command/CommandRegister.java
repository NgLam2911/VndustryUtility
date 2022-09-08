package vndustry.utility.command;

import arc.util.CommandHandler;
import vndustry.utility.command.player.Chat;
import vndustry.utility.command.player.GG;
import vndustry.utility.command.player.PlayerCommand;

public class CommandRegister {
    public static void registerPlayerCommands(CommandHandler handler){
        register(handler, new GG());
        register(handler, new Chat());
    }

    public static void registerServerCommands(CommandHandler handler){
        //TODO: Register server commands
    }

    public static void register(CommandHandler handler, PlayerCommand command){
        handler.register(command.getName(), command.getParams(), command.getDescription(), command::execute);
    }
}
