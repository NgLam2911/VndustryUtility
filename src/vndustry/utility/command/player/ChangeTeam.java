package vndustry.utility.command.player;

import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.gen.Player;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Players;
import vndustry.utility.utils.Teams;

public class ChangeTeam extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("team");
        setParams("<team> [player]");
        setDescription("Change team");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Team team = Teams.getTeam(args[0]);
        if (team == null) {
            player.sendMessage("[scarlet]Team not found !");
            player.sendMessage("[green]Available teams:");
            for (Team t : Team.all) {
                player.sendMessage("[white] - [yellow]" + t.name);
            }
            return;
        }
        if (args.length > 1) {
            Player target = Players.getPlayerbyPrefix(args[1]);
            if (target != null) {
                changeTeam(target, team);
                player.sendMessage("[green]Changed team of " + target.name + " to " + team.name);
            } else {
                player.sendMessage("[scarlet]Player not found !");
            }
        } else {
            changeTeam(player, team);
        }
    }

    private void changeTeam(Player player, Team team) {
        Call.setPlayerTeamEditor(player, team);
        player.team(team);
        player.unit().team(team);
        player.sendMessage("[green]Your team have been changed to " + team.name);
    }
}
