package model;

import viewcontroller.observers.DateObserver;
import viewcontroller.observers.RatingObserver;
import viewcontroller.observers.UserObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    public void notifyAllDateObservers(){
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

    public void removeRating(Ratings rating) {
        user.getRatings().remove(rating);
        notifyAllRateObservers();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setUserName(String name){
        user.setName(name);
        notifyAllUserObservers();
    }

    public String getUserName(){return user.getName();}

    public void addRating(String topic){
        boolean found = false;
        for(Ratings r : user.getRatings()){
            if (r.getTopic().equals(topic)){
                found = true;
            }
        }
        if (!found && !topic.equals("")){
            user.addRating(topic);
            notifyAllRateObservers(); 
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        notifyAllDateObservers();
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

    //-------------observer stuff-------------


    private List<UserObserver> userObservers = new ArrayList<>();

    public void attachUserOb(UserObserver observer){
        userObservers.add(observer);
    }

    public void notifyAllUserObservers(){
        for (UserObserver o : userObservers) {
            o.notified();

        }
    }


}
