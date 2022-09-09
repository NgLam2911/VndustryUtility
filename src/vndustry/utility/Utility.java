package vndustry.utility;

import arc.util.CommandHandler;
import mindustry.mod.Plugin;
import vndustry.utility.command.CommandRegister;

public class Utility extends Plugin {

    @Override
    public void init() {
        EventHandler.initEvents();
        Filters.initFilters();
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
