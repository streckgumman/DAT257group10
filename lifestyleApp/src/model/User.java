package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Water water = new Water();
    private String name;
    private Journal journal = new Journal();
    private List<Ratings> ratings= new ArrayList<>();
    ArrayList<SleepEntry> bedtimeList= new ArrayList<SleepEntry>();



    void addRating(String topic){
        boolean exists = false;
        for (Ratings r : ratings){
            if (r.getTopic().equals(topic)) {
                exists = true;
                break;
            }
        }
        if (!exists){
            ratings.add(new Ratings(topic));
        }
    }

    void addWaterEntry(LocalDate date, double intake){
        water.setWaterEntry(date, intake);
    }

    // Getters and Setters
    public Journal getJournal() {
        return journal;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Water getWater() {
        return water;
    }

    public WaterEntry getWaterIntake(LocalDate date) {
        return getWater().getWaterEntry(date);
    }

    public SleepEntry getSleepEntry(LocalDate date){
        for (SleepEntry se : bedtimeList){
            if (se.getDate().equals(date)){
                return se;
            }
        }
        SleepEntry nueva = new SleepEntry(date);
        bedtimeList.add(nueva);
        return nueva;
    }

    public List<SleepEntry> getSleepEntries(){
        return bedtimeList;
    }

}
