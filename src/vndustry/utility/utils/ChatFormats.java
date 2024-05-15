package vndustry.utility.utils;

public class ChatFormats {
    // Builtin colors
    public static final String CLEAR = "[clear]";
    public static final String BLACK = "[black]";
    public static final String WHITE = "[white]";
    public static final String LIGHTGRAY = "[lightgray]";
    public static final String GRAY = "[gray]";
    public static final String DARKGRAY = "[darkgray]";
    public static final String BLUE = "[blue]";
    public static final String NAVY = "[navy]";
    public static final String ROYAL = "[royal]";
    public static final String SLATE = "[slate]";
    public static final String SKY = "[sky]";
    public static final String CYAN = "[cyan]";
    public static final String TEAL = "[teal]";
    public static final String GREEN = "[green]";
    public static final String ACID = "[acid]";
    public static final String LIME = "[lime]";
    public static final String FOREST = "[forest]";
    public static final String OLIVE = "[olive]";
    public static final String YELLOW = "[yellow]";
    public static final String GOLD = "[gold]";
    public static final String GOLDENROD = "[goldenrod]";
    public static final String ORANGE = "[orange]";
    public static final String BROWN = "[brown]";
    public static final String TAN = "[tan]";
    public static final String BRICK = "[brick]";
    public static final String RED = "[red]";
    public static final String SCARLET = "[scarlet]";
    public static final String CORAL = "[coral]";
    public static final String SALMON = "[salmon]";
    public static final String PINK = "[pink]";
    public static final String MAGENTA = "[magenta]";
    public static final String PURPLE = "[purple]";
    public static final String VIOLET = "[violet]";
    public static final String MAROON = "[maroon]";

    public static String fromRGB(int r, int g, int b) {
        return "[#" + Integer.toHexString((r << 16) + (g << 8) + b) + "]";
    }

    public static String fromRGBA(int r, int g, int b, int a) {
        return "[#" + Integer.toHexString((r << 16) + (g << 8) + b + (a << 24)) + "]";
    }
}
