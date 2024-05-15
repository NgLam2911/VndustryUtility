package vndustry.utility.command.player;

import mindustry.content.Blocks;
import mindustry.gen.Call;
import mindustry.gen.Player;
import vndustry.utility.utils.PermissionLevel;

public class ItemSource extends PlayerCommand {

    @Override
    protected void prepare() {
        setName("item");
        setParams("");
        setDescription("Place a item source at your location");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Call.constructFinish(player.tileOn(), Blocks.itemSource, player.unit(), (byte) 0, player.team(), false);
        player.sendMessage("Placed a power source at your location");
    }
}