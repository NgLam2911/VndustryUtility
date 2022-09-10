package vndustry.utility.utils;

public enum PermissionLevel {
    Player(1),
    Admin(2147483647);
    //TODO: More roles
    private final int level;

    PermissionLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
