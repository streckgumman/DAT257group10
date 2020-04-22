package model;

import java.util.Date;

public class RatingEntry {
    private String name;
    private int rating;
    private Date date;

    public RatingEntry(String name) {
        this.name = name;
        this.date = getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
