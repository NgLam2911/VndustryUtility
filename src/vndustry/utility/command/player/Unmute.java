package vndustry.utility.command.player;

import mindustry.gen.Player;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Players;

public class Unmute extends PlayerCommand {
    @Override
    protected void prepare() {
        setName("unmute");
        setParams("<player>");
        setDescription("Unmute player");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Player target = Players.getPlayerbyPrefix(args[0]);
        if (target == null) {
            player.sendMessage("[scarlet]Player not found !");
            return;
        }
        Session session = SessionManager.getSession(target);
        if (session == null) {
            return;
        }
        session.muted = false;
        player.sendMessage("[scarlet]Unmuted " + target.name + "!");
    }
}
