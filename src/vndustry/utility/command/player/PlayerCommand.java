package vndustry.utility.command.player;

import arc.util.Nullable;
import mindustry.gen.Player;
import vndustry.utility.command.Command;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;

public abstract class PlayerCommand extends Command {
    private @Nullable PermissionLevel permissionLevel = null;

    public PlayerCommand() {
        super();
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
                player.sendMessage("[scarlet]You don't have permission to use this command.");
            }
        }
    }

    protected abstract void onRun(Player player, String[] args);

    protected void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public @Nullable PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }
}
