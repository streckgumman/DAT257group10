package model;

import java.awt.*;
import java.time.LocalDate;

public class WaterEntry {
    private double waterEntry;

    private double glassVolume;
    private LocalDate date;

    public WaterEntry(LocalDate date, Double glassVolume) {
        this.date = date;
        this.glassVolume = glassVolume;
    }

    // Getters and Setters


    public double getWaterEntry() {
        return waterEntry;
    }

    public void setWaterEntry(double waterEntry) {
        this.waterEntry= waterEntry;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) { this.date = date; }

    public double getGlassVolume() { return glassVolume; }

    public void setGlassVolume(double glassVolume) { this.glassVolume = glassVolume; }
}


