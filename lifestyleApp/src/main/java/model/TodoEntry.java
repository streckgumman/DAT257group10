package model;

public class TodoEntry {

    private boolean isDone;
    private String description;

    // Constructor, a todoItem is not done when created
    public TodoEntry(String description) {
        this.description = description;

    }

    // Getters and Setters
    public boolean getIsDone() {
        return isDone;
    }

    public void setActive() {
        this.isDone = true;
    }

    public void setInactive() {
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}