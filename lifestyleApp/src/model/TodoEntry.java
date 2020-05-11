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
    private boolean getIsDone() {
        return isDone;
    }

    private void setActive() {
        this.isDone = false;
    }

    private void setInactive() {
        this.isDone = true;
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}