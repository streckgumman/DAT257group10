package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MainModel {
    User user;
    LocalDate date; // TODO ändra

    public static MainModel createMainController() {
        return new MainModel();
    }

    public Journal getJournal(){
        return user.getJournal();
    }

    public List<Ratings> getRatings(){
        return user.getRatings();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void addRating(String topic){
        user.addRating(topic,date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
