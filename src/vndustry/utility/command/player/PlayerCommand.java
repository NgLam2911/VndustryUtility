package vndustry.utility.command.player;

import arc.util.Nullable;
import mindustry.gen.Player;
import vndustry.utility.command.Command;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;

public abstract class PlayerCommand extends Command {
    protected @Nullable PermissionLevel permissionLevel = null;

    PlayerCommand() {
        prepare();
    }

    public void execute(String[] args, Player player) {
        Session session = SessionManager.getSession(player);
        if (session != null) {
            if (getPermissionLevel() == null) {
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

    protected void setPermissionLevel(PermissionLevel level) {
        this.permissionLevel = level;
    }

    public @Nullable PermissionLevel getPermissionLevel() {
        return this.permissionLevel;
    }
}
