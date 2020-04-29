package model;

import java.time.LocalDate;

public class SleepEntry {

    private int bedtimeHour;
    private int bedtimeMinute;
    private int wakeupTimeHour;
    private int wakeupTimeMinute;
    private LocalDate date;

    public SleepEntry(int bedtimeHour, int bedtimeMinute, int wakeupTimeHour, int wakeupTimeMinute, LocalDate date) {
        this.bedtimeHour = bedtimeHour;
        this.bedtimeMinute = bedtimeMinute;
        this.wakeupTimeHour = wakeupTimeHour;
        this.wakeupTimeMinute = wakeupTimeMinute;
        this.date = date;
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

    //Gettes

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
}
