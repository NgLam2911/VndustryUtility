package vndustry.utility.command.player;

import mindustry.Vars;
import mindustry.game.Team;
import mindustry.gen.Player;
import mindustry.type.UnitType;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Teams;

public class Summon extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("summon");
        setParams("<unit> [count] [~|posX] [~|posY] [team]");
        setDescription("Spawn a unit");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        UnitType unit = Vars.content.units().find(b -> b.name.equals(args[0]));
        if (unit == null) {
            player.sendMessage("[scarlet]Unit not found !");
            player.sendMessage("[scarlet]Available units: []" + Vars.content.units().toString("[scarlet], []"));
            return;
        }
        int count = 1;
        if (args.length > 1) {
            try {
                count = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                player.sendMessage("[scarlet]Count must be a number !");
                return;
            }
        }
        if (count < 1) {
            player.sendMessage("[scarlet]Count must be greater than 0 !");
            return;
        }
        float x = player.x();
        float y = player.y();
        if (args.length > 2) {
            if (args[2].equals("~")) {
                x = player.x();
            } else {
                try {
                    x = Float.parseFloat(args[2]);
                } catch (NumberFormatException e) {
                    player.sendMessage("[scarlet]X must be a number !");
                    return;
                }
            }
        }
        if (args.length > 3) {
            if (args[3].equals("~")) {
                y = player.y();
            } else {
                try {
                    y = Float.parseFloat(args[3]);
                } catch (NumberFormatException e) {
                    player.sendMessage("[scarlet]Y must be a number !");
                    return;
                }
            }
        }
        Team team = player.team();
        if (args.length > 4) {
            team = Teams.getTeam(args[4]);
        }
        if (team == null){
            player.sendMessage("[scarlet]Team not found !");
            player.sendMessage("[scarlet]Available teams: []");
            for (Team t : Team.all) {
                player.sendMessage("[white] - [yellow]" + t.name);
            }
            return;
        }
        for (int i = 0; i < count; i++) {
            unit.spawn(team, x, y);
        }
    }
}
