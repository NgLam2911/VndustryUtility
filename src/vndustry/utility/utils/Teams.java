package vndustry.utility.utils;

import arc.util.Nullable;
import mindustry.game.Team;

public class Teams {

    public static @Nullable Team getTeam(String teamName) {
        switch (teamName) {
            case "sharded":
                return Team.sharded;
            case "crux":
                return Team.crux;
            case "malis":
                return Team.malis;
            case "green":
                return Team.green;
            case "blue":
                return Team.blue;
            case "derelict":
                return Team.derelict;
            default:
                return null;
        }
    }
}
