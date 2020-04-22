package model;

import java.util.ArrayList;
import java.util.List;

public class Ratings {
    private List<RatingEntry> ratings = new ArrayList<>();

    private void addRating(RatingEntry re){
        ratings.add(re);
    }

    private void removeRating(RatingEntry re){
        ratings.remove(re);
    }
}
