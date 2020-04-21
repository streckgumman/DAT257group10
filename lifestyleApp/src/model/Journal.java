package model;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.Date;

public class Journal extends RuntimeException {

    private ArrayList<JournalEntry> journal = new ArrayList<>();



    private JournalEntry currentEntry;



    public void addEntry(JournalEntry entry) {
        journal.add(entry);
        currentEntry = entry;
    }

    public void deleteEntry(JournalEntry entry) {
        int indexOfcurrent = journal.indexOf(entry);
        currentEntry = journal.get(indexOfcurrent -1);
        journal.remove(entry);

    }

    public void getNewEntry(Date date) {

        for (JournalEntry entry : journal) {
            if (entry.getDate().equals(date)) {
                currentEntry = entry; //TODO se till så att den skickar felmeddelnade om Entry inte existerar

            }

        }
    }

    public JournalEntry getCurrentEntry() {
        return currentEntry;
    }
}