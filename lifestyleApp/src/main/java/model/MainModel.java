package model;

import viewcontroller.observers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class MainModel {
    LocalDate date;
    private List<User> users = new ArrayList<>();
    private Optional<User> activeUser = Optional.empty();


    public static MainModel createMainController() {
        return new MainModel();
    }

    public void login(String name) {
        boolean exists = false;
        for (User u : users)
            if (!activeUser.isPresent() && u.getName().equals(name)) {
                activeUser = Optional.of(u);
                notifyAllUserObservers();
                exists = true;
            }
        if (!exists) {
            User user = new User(name);
            users.add(user);
            activeUser = Optional.of(user);
        }
    }

    public void logout() {
        if (activeUser.isPresent()) {
            activeUser = Optional.empty();
        }
    }

    //---------------Setters and Getters----------------

    public User getUser() {
        return activeUser.get();
    }

    public List<User> getUsers() {
        return users; // use defensive copying
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setUserName(String name) {
        activeUser.get().setName(name);
        notifyAllUserObservers();
    }

    public String getUserName() {
        return activeUser.get().getName();
    }

    public Journal getJournal() {
        return activeUser.get().getJournal();
    }

    public List<Ratings> getRatings() {
        return activeUser.get().getRatings();
    }

    public List<TodoEntry> getTodos() {
        return activeUser.get().getTodos();
    }

    public Water getWater() {
        return activeUser.get().getWater();
    }

    public void removeRating(Ratings rating) {
        activeUser.get().getRatings().remove(rating);
        notifyAllRateObservers();
    }


    public void addRating(String topic) {
        boolean found = false;
        for (Ratings r : activeUser.get().getRatings()) {
            if (r.getTopic().equals(topic)) {
                found = true;
            }
        }
        if (!found && !topic.equals("")) {
            activeUser.get().addRating(topic);
            notifyAllRateObservers();
        }
    }

    public void setRating(RatingEntry re, int rateing) {
        for (Ratings r : activeUser.get().getRatings()) {
            if (r.getTopic().equals(re.getTopic())) {
                r.getRating(re.getDate()).setRating(rateing);
            }
        }
        notifyAllRateObservers();
    }

    public void removeTodo(TodoEntry todo) {
        activeUser.get().getTodos().remove(todo);
        notifyAllTodoObservers();
    }

    public void addTodo(String text) {
        activeUser.get().addTodo(text);
        notifyAllTodoObservers();
    }

    public void setWaterIntake(double intake) {
        activeUser.get().addWaterEntry(this.date, intake);
    }

    public WaterEntry getWaterIntake() {
        return activeUser.get().getWaterIntake(this.date);
    }

    public SleepEntry getSleep() {
        return activeUser.get().getSleepEntry(this.date);
    }

    public Workout getWorkout() {
        return activeUser.get().getWorkout(this.date);
    }

    public WeatherEntry getWeather() {
        return activeUser.get().getWeather(this.date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        notifyAllDateObservers();
    }



    //----------------Date-Observers-------------------------

    private List<DateObserver> observers = new ArrayList<DateObserver>();

    public void attachDateOb(DateObserver observer) {
        observers.add(observer);
    }

    public void notifyAllDateObservers() {
        for (DateObserver o : observers) {
            o.notified();
        }
    }

    //-------------Rate observer-------------


    private List<RatingObserver> rateObservers = new ArrayList<>();

    public void attachRateOb(RatingObserver observer) {
        rateObservers.add(observer);
    }

    public void notifyAllRateObservers() {
        for (RatingObserver o : rateObservers) {
            o.notified();

        }
    }

    //-------------To do observer-------------


    private List<TodoObserver> todoObservers = new ArrayList<>();

    public void attachTodoOb(TodoObserver observer) {
        todoObservers.add(observer);
    }

    public void notifyAllTodoObservers() {
        for (TodoObserver o : todoObservers) {
            o.notified();

        }
    }

    //-------------User observer-------------


    private List<UserObserver> userObservers = new ArrayList<>();

    public void attachUserOb(UserObserver observer) {
        userObservers.add(observer);
    }

    public void notifyAllUserObservers() {
        for (UserObserver o : userObservers) {
            o.notified();
        }
    }

    //-------------User observer-------------


    private List<StatsObserver> statsObservers = new ArrayList<>();

    public void attachStatsOb(StatsObserver observer) {
        statsObservers.add(observer);
    }

    public void notifyAllStatsObservers() {
        for (StatsObserver o : statsObservers) {
            o.notified();
        }
    }

    public void statsChanged() {
        notifyAllStatsObservers();
    }
}
