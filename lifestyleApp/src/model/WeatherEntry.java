package model;

import java.time.LocalDate;

public class WeatherEntry {
    private double weatherEntry;
    private LocalDate date;

    public WeatherEntry(double weatherEntry, LocalDate date) {
        this.weatherEntry = weatherEntry;
        this.date = date;
    }

    // Getters and Setters

    public double getWeatherEntry() {
        return weatherEntry;
    }

    public void setWeatherEntry(double waterEntry) {
        this.weatherEntry= weatherEntry;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
