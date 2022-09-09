package vndustry.utility.command.player;

import mindustry.gen.Player;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Players;

public class Kill extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("kill");
        setParams("[player]");
        setDescription("Kill a player");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        if (args.length == 0) {
            player.unit().kill();
            player.sendMessage("[green]Killed yourself");
        }
        Player target = Players.getPlayerbyPrefix(args[0]);
        if (target != null) {
            target.unit().kill();
            player.sendMessage("[green]Killed " + target.name);
        } else {
            player.sendMessage("[scarlet]Player not found !");
        }
    }
}

