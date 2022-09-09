package vndustry.utility.command.player;

import mindustry.gen.Player;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Players;

public class Kick extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("kick");
        setParams("[player]");
        setDescription("Kick a player");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        if (args.length == 0) {
            player.sendMessage("[scarlet]Please specify a player !");
        } else {
            Player target = Players.getPlayerbyPrefix(args[0]);
            if (target != null) {
                target.kick("Kicked by administrator");
                player.sendMessage("[green]Kicked " + target.name);
            } else {
                player.sendMessage("[scarlet]Player not found !");
            }
        }
    }
}
