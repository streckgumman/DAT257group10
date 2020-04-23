package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Ratings {
    private List<RatingEntry> ratings = new ArrayList<>();
    private String topic;

    public Ratings(String topic) {
        this.topic = topic;
    }

    public void addRatingEntry(LocalDate date) {
        ratings.add(new RatingEntry(topic, date));
    }

    // Getters and setters
    public String getTopic() {
        return topic;
    }


    public RatingEntry getRating(LocalDate date){
        for (RatingEntry re : ratings){
            if (re.getDate()==date){
                return re;
            }
        }
        return null;
    }

}
