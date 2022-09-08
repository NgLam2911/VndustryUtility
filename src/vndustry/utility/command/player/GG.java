package vndustry.utility.command.player;

import arc.Events;
import mindustry.game.Team;
import mindustry.gen.Player;
import vndustry.utility.utils.PermissionLevel;

public class GG extends PlayerCommand {
    @Override
    protected void prepare() {
        setPermissionLevel(PermissionLevel.Admin);
        setName("gg");
        setParams("");
        setDescription("Force game over !");
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Events.fire(new mindustry.game.EventType.GameOverEvent(Team.sharded));
    }
}
