package vndustry.utility.command.player;

import mindustry.content.Blocks;
import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.gen.Player;
import mindustry.world.blocks.storage.CoreBlock;
import vndustry.utility.utils.PermissionLevel;
import vndustry.utility.utils.Teams;

public class BuildCore extends PlayerCommand {

    @Override
    protected void prepare() {
        this.setName("core");
        this.setParams("<shard|foundation|nucleus|bastion|citadel|acropolis> [team]");
        this.setDescription("Build a core at your location");
        this.setPermissionLevel(PermissionLevel.Admin);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Team team = player.team();
        if (args.length > 1) {
            team = Teams.getTeam(args[1]);
            if (team == null) {
                player.sendMessage("[scarlet]Team not found !");
                player.sendMessage("[green]Available teams:");
                for (Team t : Team.baseTeams) {
                    player.sendMessage("[white] - [yellow]" + t.name);
                }
                return;
            }
        }
        CoreBlock coreBlock = fromString(args[0]);
        Call.constructFinish(player.tileOn(), coreBlock, player.unit(), (byte) 0, team, false);
        player.sendMessage("[green]Core built for the team " + team.name + " !");
    }

    protected CoreBlock fromString(String name) {
        switch (name) {
            case "shard":
                return (CoreBlock) Blocks.coreShard;
            case "foundation":
                return (CoreBlock) Blocks.coreFoundation;
            case "nucleus":
                return (CoreBlock) Blocks.coreNucleus;
            case "bastion":
                return (CoreBlock) Blocks.coreBastion;
            case "citadel":
                return (CoreBlock) Blocks.coreCitadel;
            case "acropolis":
                return (CoreBlock) Blocks.coreAcropolis;
            default:
                return null;
        }
    }
}
