package model;

import java.util.ArrayList;

public class Sleep {

    private ArrayList<SleepEntry> bedtimesleep = new ArrayList<>();
    private ArrayList<SleepEntry> wakeuptimesleep = new ArrayList<>();
    private SleepEntry currentEntry;

    public void addBedTimeEntry(SleepEntry entry){
        bedtimesleep.add(entry);
        currentEntry = entry;
    }


    public SleepEntry getCurrentEntry(){
        return currentEntry;
    }


}
