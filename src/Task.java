public class Task {
    private int id;
    private String description;
    private boolean done;

    public Task(int id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String toFileLine() {
        return id + "|" + done + "|" + description;
    }

    public String toString() {
        String mark = "[ ]";
        if (done) {
            mark = "[x]";
        }
        return id + ". " + mark + " " + description;
    }
}
