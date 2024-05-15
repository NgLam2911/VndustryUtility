package vndustry.utility.utils;

import arc.struct.Seq;
import mindustry.Vars;
import mindustry.maps.Map;

public class Maps {

    public static Seq<Map> getAllMaps() {
        Seq<Map> maps = new Seq<>();
        maps.addAll(Vars.maps.customMaps());
        return maps;
    }

    public static Map getMap(String mapName) {
        return Vars.maps.customMaps().find(m -> m.name().equalsIgnoreCase(mapName));
    }
}
