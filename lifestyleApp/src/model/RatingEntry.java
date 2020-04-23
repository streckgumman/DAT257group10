package model;

import java.time.LocalDate;
import java.util.Date;

public class RatingEntry {
    private int rating;
    private String topic;
    private LocalDate date;

    public RatingEntry(String topic, LocalDate date) {
        this.topic = topic;
        this.date = date;
    }

    // Getters and Setters

    public String getTopic() {
        return topic;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
