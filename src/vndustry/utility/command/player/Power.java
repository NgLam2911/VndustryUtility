package vndustry.utility.command.player;

import mindustry.content.Blocks;
import mindustry.gen.Call;
import mindustry.gen.Player;
import vndustry.utility.utils.PermissionLevel;

public class Power extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("power");
        setParams("");
        setDescription("Place a power source at your location");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Call.constructFinish(player.tileOn(), Blocks.powerSource, player.unit(), (byte) 0, player.team(), false);
        player.sendMessage("Placed a power source at your location");
    }
}
