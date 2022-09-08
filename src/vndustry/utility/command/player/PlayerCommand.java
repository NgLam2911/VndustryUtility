package vndustry.utility.command.player;

import mindustry.gen.Player;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;

public abstract class PlayerCommand {

    protected String name;
    protected String params;
    protected String description;

    PlayerCommand(){
        prepare();
    }

    public final void execute(String[] args, Player player){
        Session session = SessionManager.getSession(player);
        if (session != null){
            if (getPermissionLevel().getLevel() <= session.getPermissionLevel().getLevel()){
                onRun(player, args);
            } else {
                player.sendMessage("[red]You don't have permission to use this command.");
            }
        }
    }

    protected PermissionLevel permissionLevel = PermissionLevel.Player;

    protected abstract void prepare();

    protected abstract void onRun(Player player, String[] args);

    protected void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setParams(String params) {
        this.params = params;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getParams() {
        return this.params;
    }

    public String getDescription() {
        return this.description;
    }

    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

}
