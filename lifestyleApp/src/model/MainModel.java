package model;

import viewcontroller.DateObserver;
import viewcontroller.RatingObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;


public class MainModel {
    User user;
    LocalDate date;

    public static MainModel createMainController() {
        return new MainModel();
    }

    //----------------Date-Observers-------------------------

    private List<DateObserver> observers = new ArrayList<DateObserver>();

    public void attachDateOb(DateObserver observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (DateObserver o : observers) {
            o.notified();
        }
    }

    //---------------Setters and Getters----------------

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
        user.addRating(topic);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        notifyAllObservers();
    }


    public void setRateing (RatingEntry re, int rateing){
        for (Ratings r : user.getRatings()){
            if (r.getTopic().equals(re.getTopic())){
                r.getRating(re.getDate()).setRating(rateing);
            }
        }
        notifyAllRateObservers();

    }

    //-------------observer stuff-------------


    private List<RatingObserver> rateObservers = new ArrayList<>();

    public void attachRateOb(RatingObserver observer){
        rateObservers.add(observer);
    }

    public void notifyAllRateObservers(){
        for (RatingObserver o : rateObservers) {
            o.notified();

        }
    }
}
