package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Ratings> getRatings() {
        return ratings;
    }

    private List<Ratings> ratings= new ArrayList<>();

    void addRating(String topic, LocalDate date){
        Boolean exists = false;
        for (Ratings r : ratings){
            if (r.getTopic().equals(topic)){
                r.addRatingEntry(date);
                exists = true;
                break;
            }
        }
        if(exists == false){
            Ratings tempRatings = new Ratings(topic);
            ratings.add(tempRatings);
            tempRatings.addRatingEntry(date);
        }
    }

}
