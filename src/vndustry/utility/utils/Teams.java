package vndustry.utility.utils;

import arc.struct.Seq;
import arc.util.Nullable;
import mindustry.game.Team;

public class Teams {
    public static @Nullable Team getTeam(String teamName) {
        return Seq.with(Team.all).find(t -> t.name.equalsIgnoreCase(teamName));
    }
}
