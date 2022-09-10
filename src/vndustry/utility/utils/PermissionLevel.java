package vndustry.utility.utils;

public enum PermissionLevel {
    Player(1),
    Admin(Integer.MAX_VALUE);
    //TODO: More roles
    private final int level;

    PermissionLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
