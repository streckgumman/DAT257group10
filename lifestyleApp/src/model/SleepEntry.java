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

    public int getMinutesOfSleep() {
        if (bedtimeMinute < wakeupTimeMinute) {
            return (wakeupTimeMinute - bedtimeMinute);

        } else if (bedtimeMinute > wakeupTimeMinute) {
            return ((60 - bedtimeMinute) + wakeupTimeMinute);
        }

        return 0;
    }

    public int getHoursOfSleep(){
        if(bedtimeHour < wakeupTimeHour){
            if(wakeupTimeMinute < bedtimeMinute) {
                return (wakeupTimeHour - bedtimeHour - 1);
            }             return (wakeupTimeHour - bedtimeHour);
        } else if (bedtimeHour > wakeupTimeHour){
            if(wakeupTimeMinute < bedtimeMinute) {
                return ((24-bedtimeHour) + wakeupTimeHour -1);
            }
            return ((24-bedtimeHour) + wakeupTimeHour);
        }
        return 0;
    }


}
