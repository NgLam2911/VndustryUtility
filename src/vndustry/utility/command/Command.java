package vndustry.utility.command;

public abstract class Command {

    private String name = "";
    private String params = "";
    private String description = "";

    protected Command() {
        prepare();
    }

    protected abstract void prepare();

    protected void setName(String name) {
        this.name = name;
    }

    protected void setParams(String params) {
        this.params = params;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getParams() {
        return this.params;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLocked() {
        return false;
    }
}
