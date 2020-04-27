package model;

import java.time.LocalDate;

public class SleepEntry {

private String entry;
private LocalDate date;

    public SleepEntry(String entry, LocalDate date){
        this.entry = entry;
        this.date = date;
    }

    public void setText(String text){
        this.entry = text;
    }

    public String getEntry(){
        return entry;
    }

    public LocalDate getDate(){
        return date;
    }
}
