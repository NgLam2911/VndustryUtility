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
                for (Team t : Team.all) {
                    player.sendMessage("[white] - [yellow]" + t.name);
                }
                return;
            }
        }
        CoreBlock coreBlock = fromString(args[0]);
        if (coreBlock == null) {
            player.sendMessage("[scarlet]Invalid core type !");
            return;
        }
        Call.constructFinish(player.tileOn(), coreBlock, player.unit(), (byte) 0, team, false);
        player.sendMessage("[green]Core built for the team " + team.name + " !");
    }

    protected CoreBlock fromString(String name) {
        return switch (name) {
            case "shard" -> (CoreBlock) Blocks.coreShard;
            case "foundation" -> (CoreBlock) Blocks.coreFoundation;
            case "nucleus" -> (CoreBlock) Blocks.coreNucleus;
            case "bastion" -> (CoreBlock) Blocks.coreBastion;
            case "citadel" -> (CoreBlock) Blocks.coreCitadel;
            case "acropolis" -> (CoreBlock) Blocks.coreAcropolis;
            default -> null;
        };
    }
}
