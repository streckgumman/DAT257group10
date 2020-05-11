package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SleepEntry {

    private int bedtimeHour;
    private int bedtimeMinute;
    private int wakeupTimeHour;
    private int wakeupTimeMinute;
    private LocalDate date;
    private double sleepEntry;

    public SleepEntry(LocalDate date) {
        this.bedtimeHour = 22;
        this.bedtimeMinute = 0;
        this.wakeupTimeHour = 6;
        this.wakeupTimeMinute = 0;
        this.date = date;
    }

    public double getSleepEntry() {
        return sleepEntry;
    }

    //setters
    public void setBedtimeHour(int bedtimeHour) {
        this.bedtimeHour = bedtimeHour;
    }

    public void setBedtimeMinute(int bedtimeMinute) {
        this.bedtimeMinute = bedtimeMinute;
    }

    public void setWakeupTimeHour(int wakeupTimeHour) {
        this.wakeupTimeHour = wakeupTimeHour;
    }

    public void setWakeupTimeMinute(int wakeupTimeMinute) {
        this.wakeupTimeMinute = wakeupTimeMinute;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //Getters

    public int getBedtimeHour() {
        return bedtimeHour;
    }

    public int getBedtimeMinute() {
        return bedtimeMinute;
    }

    public int getWakeupTimeHour() {
        return wakeupTimeHour;
    }

    public int getWakeupTimeMinute() {
        return wakeupTimeMinute;
    }

    public LocalDate getDate() {
        return date;
    }
}
