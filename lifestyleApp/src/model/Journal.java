package model;

import java.rmi.NoSuchObjectException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Journal extends RuntimeException {

    private ArrayList<JournalEntry> journal = new ArrayList<>();

    public void newEntry(String text, LocalDate date){
        addEntry(new JournalEntry(text,date));
    }

    public void addEntry(JournalEntry entry) {
        journal.add(entry);
    }

    public void deleteEntry(JournalEntry entry) {
        journal.remove(entry);
    }

    public JournalEntry getCurrentEntry(LocalDate date) {

        for (JournalEntry entry : journal) {
            if (entry.getDate().equals(date)) {
                return entry;
            }
        }
        return null;
    }
}