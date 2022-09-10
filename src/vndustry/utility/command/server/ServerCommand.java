package vndustry.utility.command.server;

import arc.util.Log;
import vndustry.utility.command.Command;

public abstract class ServerCommand extends Command {

    ServerCommand(){
        prepare();
    }

    public final void execute(String[] args){
        if (this.isLocked()){
            Log.err("This command is not available :(");
        } else {
            onRun(args);
        }
    }

    protected abstract void onRun(String[] args);
}
