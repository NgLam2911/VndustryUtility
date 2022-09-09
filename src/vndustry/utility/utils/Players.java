package vndustry.utility.utils;

import arc.util.Nullable;
import mindustry.gen.Groups;
import mindustry.gen.Player;

public class Players {
    public static @Nullable Player getPlayer(String name){
        return Groups.player.find(p -> p.name.equals(name));
    }

    public static @Nullable Player getPlayerbyUUID(String UUID){
        return Groups.player.find(p -> p.uuid().equals(UUID));
    }

    public static @Nullable Player getPlayerbyID(int id){
        return Groups.player.find(p -> p.id == id);
    }

    public static @Nullable Player getPlayerbyPrefix(String prefix){
        return Groups.player.find(p -> p.name.startsWith(prefix));
    }
}
