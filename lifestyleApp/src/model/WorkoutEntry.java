package model;

import java.text.DecimalFormat;

public class WorkoutEntry {

    private int hour;
    private int minute;
    private double intensity;
    private TrainingType type;

    public enum TrainingType{
        WEIGHT,
        RUNNING,
        WALKNING,
        MINDFULLNESS,
        OTHER
    }

    public WorkoutEntry(int hour, int minute, double intensity, TrainingType type){
        this.hour=hour;
        this.minute = minute;
        //enum
        this.intensity = intensity;
        this.type = type;
    }

    // Getters and setters

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public TrainingType getType() {
        return type;
    }

    public void setType(TrainingType type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "Workout: " + hour + " hour(s), " + minute + " minutes. " + " Workouttype: " + type +  ", intensity: " + String.valueOf(new DecimalFormat("#.#").format(intensity));
    }

}