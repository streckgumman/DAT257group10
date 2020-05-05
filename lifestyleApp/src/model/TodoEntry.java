package model;

import java.time.LocalDate;

public class TodoEntry {

    private String description;
    private LocalDate date;

    // Constructor, a todoItem is not done when created
    public TodoEntry(String description) {
        this.description = description;
        this.date = date;

    }

    @Override
    public String toString() {
        return this.getDescription();
    }

    private String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
