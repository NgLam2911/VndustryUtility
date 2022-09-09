package vndustry.utility.session;

import arc.struct.Seq;
import arc.util.Nullable;
import mindustry.gen.Player;

public class SessionManager {
    protected static Seq<Session> sessions = new Seq<>();

    public static void addSession(Session session) {
        SessionManager.sessions.add(session);
    }

    public static void removeSession(Session session) {
        SessionManager.sessions.remove(session);
    }

    public static Seq<Session> getSessions() {
        return sessions;
    }

    public static @Nullable Session getSession(Player player) {
        for (Session session : sessions) {
            if (session.getPlayer().equals(player)) {
                return session;
            }
        }
        return null;
    }

    public static void registerSession(Player player) {
        SessionManager.addSession(new Session(player));
    }

    public static void unregisterSession(Player player) {
        SessionManager.removeSession(SessionManager.getSession(player));
    }
}
