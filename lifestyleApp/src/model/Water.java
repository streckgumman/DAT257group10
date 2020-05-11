package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Water {
    private List<WaterEntry> waterEntries = new ArrayList<>();
    private double waterEntry;

    public void setWaterEntry(LocalDate date, double intake){
        getWaterEntry(date).setWaterEntry(intake);
    }

    public WaterEntry getWaterEntry(LocalDate date){
        for (WaterEntry we : waterEntries){
            if (we.getDate().equals(date)){
                return we;
            }
        }
        WaterEntry nueva = new WaterEntry(date);
        nueva.setWaterEntry(0);
        waterEntries.add(nueva);
        return nueva;
    }

    public List<WaterEntry> getWaterEntries(){
        return waterEntries;
    }

}