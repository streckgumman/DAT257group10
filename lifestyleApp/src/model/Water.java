package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Water {
    private List<WaterEntry> waterEntries = new ArrayList<>();
    private WaterEntry wa;
    double waterEntry;
    public Water() {

    }

    public void addWaterEntry(LocalDate date) {
        waterEntries.add(new WaterEntry(waterEntry, date));
    }


    public WaterEntry getWaterEntry(LocalDate date){
        for (WaterEntry we : waterEntries){
            if (we.getDate()==date){
                return we;
            }
        }
        return null;
    }
}