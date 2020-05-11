package model;

import java.time.LocalDate;

public class WeatherEntry {
    private WeatherType weatherType;
    private LocalDate date;

    public WeatherEntry(LocalDate date) {
        this.date = date;
    }

    public enum WeatherType{
        SUN,
        SUNCLOUD,
        CLOUD,
        RAIN,
        THUNDER,
        WINDY,
        SNOW
    }

    // Getters and Setters

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(WeatherType wt) {
        this.weatherType = wt;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
