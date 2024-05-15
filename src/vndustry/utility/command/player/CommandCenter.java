package vndustry.utility.command.player;

import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.world.Block;
import mindustry.world.blocks.legacy.LegacyCommandCenter;
import vndustry.utility.utils.PermissionLevel;

public class CommandCenter extends PlayerCommand{

    @Override
    protected void prepare() {
        setName("commandcenter");
        setParams("");
        setDescription("Place Legacy command center block");
        setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Block block = new LegacyCommandCenter("command-center");
        Call.constructFinish(player.tileOn(), block, player.unit(), (byte) 0, player.team(), false);
        player.sendMessage("[green]Placed a legacy command center block at your location");
    }

    @Override
    public boolean isLocked() {
        return true;
    }
}
