package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Water water = new Water();
    private double glassSize = 0.2;
    private List<WeatherEntry> wes = new ArrayList<>();
    private String name;
    private Journal journal = new Journal();
    private List<Ratings> ratings= new ArrayList<>();
    private List<Workout> workoutList= new ArrayList<>();
    ArrayList<SleepEntry> bedtimeList= new ArrayList<SleepEntry>();
    private int[] sleepInitVal;

    public User(String name) {
        this.name = name;
    }

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
        if (glassSize == 0.0){
            glassSize = 0.2;
        }

        water.setWaterEntry(date, intake, glassSize);
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
        return getWater().getWaterEntry(date, glassSize);
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

    public Workout getWorkout(LocalDate date) {
        for (Workout wo : workoutList){
            if (wo.getDate().equals(date)){
                return wo;
            }
        }
        Workout nueva = new Workout(date);
        workoutList.add(nueva);
        return nueva;

    }

    public WeatherEntry getWeather(LocalDate date) {
        for (WeatherEntry we : wes){
            if (we.getDate().equals(date)){
                return we;
            }
        }
        WeatherEntry nueva = new WeatherEntry(date);
        wes.add(nueva);
        return nueva;

    }

    public int[] getSleepInitVal() { return sleepInitVal; }

    public void setSleepInitVal(int[] sleepInitVal) { this.sleepInitVal = sleepInitVal; }



    public double getGlassSize() {
        return glassSize;
    }

    public void setGlassSize(double glassSize) {
        this.glassSize = glassSize;
    }

}
