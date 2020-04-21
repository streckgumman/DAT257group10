package model;

import java.util.Date;

public class JournalEntry {

    private String entry;
    private Date date;

    public JournalEntry(String entry, Date date){
        this.entry = entry;
        this. date = date;
    }

    public String getEntry() {
        return entry;
    }

    public Date getDate() {
        return date;
    }

}
