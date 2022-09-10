package vndustry.utility.command.player;

import mindustry.Vars;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.type.UnitType;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Players;

public class Unit extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("unit");
        setParams("<unit> [player]");
        setDescription("Change unit");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        UnitType unitType = Vars.content.units().find(b -> b.name.equals(args[0]));
        if (unitType == null) {
            player.sendMessage("[scarlet]Unit not found !");
            player.sendMessage("[scarlet]Available units: []" + Vars.content.units().toString("[scarlet], []"));
            return;
        }

        if (args.length > 1) {
            Player target = Players.getPlayerbyPrefix(args[1]);
            if (target != null) {
                changeUnit(target, unitType);
                player.sendMessage("[green]Changed " + target.name + "'s unit to " + unitType.name);
            } else {
                player.sendMessage("[scarlet]Player not found !");
            }
        } else {
            changeUnit(player, unitType);
            player.sendMessage("[green]Changed your unit to " + unitType.name);
        }
    }

    private void changeUnit(Player player, UnitType unitType) {
        Call.unitControl(player, unitType.spawn(player.team(), player.x, player.y));
    }
}
