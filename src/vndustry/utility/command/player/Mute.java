package vndustry.utility.command.player;

import mindustry.gen.Player;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Players;

public class Mute extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("mute");
        setParams("<player>");
        setDescription("Mute player");
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
            //I haz no idea why its return null...
            return;
        }
        session.muted = true;
        player.sendMessage("[scarlet]Muted " + target.name + "!");
    }
}
