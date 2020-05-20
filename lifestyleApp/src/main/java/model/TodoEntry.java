package model;

public class TodoEntry {

    private boolean isDone;
    private String description;

    // Constructor, a todoItem is not done when created
    public TodoEntry(String description) {
        this.description = description;

    }

    // Makes the ToDos show up as strings in the CourseMainPage ListView
    @Override
    public String toString() {
        return this.getDescription();
    }

    // Getters and Setters
    public boolean getIsDone() {
        return isDone;
    }

    public void setActive() {
        this.isDone = false;
    }

    public void setInactive() {
        this.isDone = true;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}