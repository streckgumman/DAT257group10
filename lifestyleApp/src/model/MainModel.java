package model;

import viewcontroller.DateObserver;

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

    public void attach(DateObserver observer){
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
}
