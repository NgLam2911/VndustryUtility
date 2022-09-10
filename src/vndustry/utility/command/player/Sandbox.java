package vndustry.utility.command.player;

import mindustry.gen.Player;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Players;

public class Sandbox extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("sandbox");
        setParams("[player]");
        setDescription("Toggle sandbox build speed");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        if (args.length > 0) {
            Player target = Players.getPlayerbyPrefix(args[0]);
            if (target != null) {
                Session session = SessionManager.getSession(target);
                if (session == null) {
                    return;
                }
                if (session.sandbox) {
                    session.sandbox = false;
                    player.sendMessage("[scarlet]Disabled sandbox build speed for " + target.name);
                } else {
                    session.sandbox = true;
                    player.sendMessage("[scarlet]Enabled sandbox build speed for " + target.name);
                }
            } else {
                player.sendMessage("[scarlet]Player not found !");
            }
        } else {
            Session session = SessionManager.getSession(player);
            if (session == null) {
                return;
            }
            if (session.sandbox) {
                session.sandbox = false;
                player.sendMessage("[scarlet]Sandbox disabled");
            } else {
                session.sandbox = true;
                player.sendMessage("[scarlet]Sandbox enabled");
            }
        }
    }
}
