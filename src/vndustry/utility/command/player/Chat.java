package vndustry.utility.command.player;

import mindustry.gen.Player;
import vndustry.utility.session.Session;
import vndustry.utility.session.SessionManager;
import vndustry.utility.utils.PermissionLevel;

public class Chat extends PlayerCommand{
    @Override
    protected void prepare() {
        setName("chat");
        setParams("");
        setDescription("Disable or enable the chat");
        setPermissionLevel(PermissionLevel.Player);
    }

    @Override
    protected void onRun(Player player, String[] args) {
        Session session = SessionManager.getSession(player);
        if (session == null){
            return;
        }
        if (session.chat){
            session.chat = false;
            player.sendMessage("[scarlet]Chat disabled");
        } else {
            session.chat = true;
            player.sendMessage("[scarlet]Chat enabled");
        }
    }

    @Override
    public boolean isLocked() {
        return true;
    }
}
