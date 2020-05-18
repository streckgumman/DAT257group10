package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Ratings {
    private List<RatingEntry> ratings = new ArrayList<>();
    private String topic;

    Ratings(String topic) {
        this.topic = topic;
    }

    // Getters and setters
    public String getTopic() {
        return topic;
    }


    public RatingEntry getRating(LocalDate date){
        for (RatingEntry re : ratings){
            if (re.getDate().equals(date)){
                return re;
            }
        }
        RatingEntry nueva = new RatingEntry(topic, date);
        nueva.setRating(0);
        ratings.add(nueva);
        return nueva;
    }

    public List<RatingEntry> getRatings(){
        return ratings;
    }

}
