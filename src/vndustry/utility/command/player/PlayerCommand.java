package vndustry.utility.command.player;

import arc.util.Nullable;
import mindustry.gen.Player;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;

public abstract class PlayerCommand {

    private String name = "";
    private String params = "";
    private String description = "";
    private @Nullable PermissionLevel permissionLevel = null;

    PlayerCommand() {
        prepare();
    }

    public final void execute(String[] args, Player player) {
        Session session = SessionManager.getSession(player);
        if (session != null) {
            if (this.getPermissionLevel() == null) {
                throw new RuntimeException("Unknown command permission level !");
            }
            if (getPermissionLevel().getLevel() <= session.getPermissionLevel().getLevel()) {
                if (!isLocked()) {
                    onRun(player, args);
                } else {
                    player.sendMessage("[scarlet]This command is not available :(");
                }
            } else {
                player.sendMessage("[red]You don't have permission to use this command.");
            }
        }
    }

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

    public @Nullable PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    public boolean isLocked() {
        return false;
    }

}
