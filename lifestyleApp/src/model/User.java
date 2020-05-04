package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Journal journal = new Journal();
    private List<Ratings> ratings= new ArrayList<>();

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
/*
    void addRatingEntry(String topic, LocalDate date){
        boolean exists = false;
        for (Ratings r : ratings){
            if (r.getTopic().equals(topic)){
                r.addRatingEntry(date);
                exists = true;
                break;
            }
        }
        if(!exists){
            Ratings tempRatings = new Ratings(topic);
            ratings.add(tempRatings);
            tempRatings.addRatingEntry(date);
        }
    }*/

    // Getters and Setters
    public Journal getJournal() {
        return journal;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }
}
