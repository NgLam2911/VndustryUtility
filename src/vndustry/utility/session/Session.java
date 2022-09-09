package vndustry.utility.session;

import mindustry.gen.Player;
import vndustry.utility.utils.PermissionLevel;

public class Session {

    protected Player player;

    public boolean chat = true;
    public boolean muted = false;

    Session(Player player) {
        this.player = player;
    }

    public PermissionLevel getPermissionLevel() {
        //TODO: Adapt with ranks
        if (this.getPlayer().admin()) {
            return PermissionLevel.Admin;
        }
        return PermissionLevel.Player;
    }

    public Player getPlayer() {
        return player;
    }
}
