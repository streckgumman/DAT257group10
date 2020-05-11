package model;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<WorkoutEntry> workoutEntryList = new ArrayList<>();
    public void newEntry(int hour, int minute, double intensity, WorkoutEntry.TrainingType type){
        addEntry(new WorkoutEntry(hour, minute, intensity, type));
    }

    public void addEntry(WorkoutEntry entry) {
        workoutEntryList.add(entry);
    }

    public void deleteEntry(TodoEntry entry) {
        workoutEntryList.remove(entry);
    }

}
