package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Workout {

    private LocalDate date;
    private List<WorkoutEntry> workoutEntryList = new ArrayList<>();

    public Workout(LocalDate date){
        this.date=date;
    }

    public List<WorkoutEntry> getWorkouts(){ return workoutEntryList;}

    public void newEntry(int hour, int minute, double intensity, WorkoutEntry.TrainingType type){
        addEntry(new WorkoutEntry(hour, minute, intensity, type));
    }

    public void addEntry(WorkoutEntry entry) {
        workoutEntryList.add(entry);
    }

    public void deleteEntry(WorkoutEntry entry) {
        workoutEntryList.remove(entry);
    }

    public LocalDate getDate(){ return this.date; }

    public void removeEntry(WorkoutEntry we){ workoutEntryList.remove(we); }



}
