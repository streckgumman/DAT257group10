package model;

public class WorkoutEntry {

    private int hour;
    private int minute;



    enum trainingtype{
        WEIGHT,
        RUNNING,
        WALKNING,
        MINDFULLNESS,
        OTHER
    }


    public WorkoutEntry(int hour,int minute){
        this.hour=hour;
        this.minute = minute;
        //enum
    }
}