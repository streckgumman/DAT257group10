package model;

import java.time.LocalDate;


public class JournalEntry {

    private String entry;
    private LocalDate date;

    public JournalEntry(String entry, LocalDate date){
        this.entry = entry;
        this.date = date;
    }

    public String getEntry() {
        return entry;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setText(String text){
        this.entry = text;
    }

}
