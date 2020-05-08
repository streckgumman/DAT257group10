package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    private List<WeatherEntry> weatherEntries = new ArrayList<>();
    private WeatherEntry wea;
    double weatherEntry;
    public Weather() {

    }

    public void addWeatherEntry(LocalDate date) {
        weatherEntries.add(new WeatherEntry(weatherEntry, date));
    }


    public WeatherEntry getWeatherEntry(LocalDate date){
        for (WeatherEntry wea : weatherEntries){
            if (wea.getDate()==date){
                return wea;
            }
        }
        return null;
    }

}
