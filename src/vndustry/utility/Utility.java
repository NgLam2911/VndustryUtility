package vndustry.utility;

import arc.util.CommandHandler;
import jdk.internal.org.jline.utils.Log;
import mindustry.mod.Plugin;
import vndustry.utility.command.CommandRegister;

public class Utility extends Plugin {

    private static final boolean IS_DEVELOPMENT_BUILD = true;

    @Override
    public void init() {
        EventHandler.initEvents();
        Filters.initFilters();

        if (IS_DEVELOPMENT_BUILD) {
            Log.warn("You are running a VndustryUtility DEVELOPMENT build !");
            Log.warn("The build may have bugs, crash, corrupt your data");
        }
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
