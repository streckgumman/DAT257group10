package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Todo {
    private ArrayList<TodoEntry> todos = new ArrayList<>();

    public void newEntry(String text, LocalDate date){
        addEntry(new TodoEntry(text,date));
    }

    public void addEntry(TodoEntry entry) {
        todos.add(entry);
    }

    public void deleteEntry(TodoEntry entry) {
        todos.remove(entry);
    }

    public TodoEntry getCurrentEntry(LocalDate date) {

        for (TodoEntry entry : todos) {
            if (entry.getDate().equals(date)) {
                return entry;
            }
        }
        return null;
    }
}
