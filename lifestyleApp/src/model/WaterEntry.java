package model;

import java.awt.*;
import java.time.LocalDate;

public class WaterEntry {
    private double waterEntry;
    private LocalDate date;

    public WaterEntry(double waterEntry, LocalDate date) {
        this.waterEntry = waterEntry;
        this.date = date;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }
}