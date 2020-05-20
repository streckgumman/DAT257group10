package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import model.MainModel;
import model.Ratings;
import viewcontroller.observers.DateObserver;
import viewcontroller.observers.RatingObserver;
import viewcontroller.observers.TodoObserver;

import java.util.Optional;

public class HomePageController implements DateObserver, RatingObserver, page {
    private MainModel model;
    private MainPageController parent;
    private TodoController tc;

    @FXML
    private AnchorPane journalAnchorPane;

    @FXML
    private AnchorPane sleepAnchorpane;

    @FXML
    private AnchorPane waterIntakeAnchorPane;

    @FXML
    private AnchorPane todoAnchorPane;

    @FXML
    private AnchorPane weatherAnchorpane;

    public void initPage(MainModel model, Optional<MainPageController> mainPage) {
        this.model = model;
        mainPage.ifPresent(page -> parent = page);
        model.attachDateOb(this);
        model.attachRateOb(this);
        showRatings();
        initJournal();
        initSleepPanel();
        initWaterIntakePanel();
        initTodoPanel();
        initWeather();
    }

    private void initWeather() {
        weatherAnchorpane.getChildren().clear();
        weatherAnchorpane.getChildren().add(PageLoader.createWeatherPane());
    }

    private void initJournal() {
        journalAnchorPane.getChildren().clear();
        journalAnchorPane.getChildren().add(PageLoader.createJournal(model.getJournal()));
    }

    private void initSleepPanel() {
        sleepAnchorpane.getChildren().clear();
        sleepAnchorpane.getChildren().add(PageLoader.createSleepPage());
    }

    private void initWaterIntakePanel() {
        waterIntakeAnchorPane.getChildren().clear();
        waterIntakeAnchorPane.getChildren().add(PageLoader.createWaterIntakePane());
    }

    private void initTodoPanel() {
        todoAnchorPane.getChildren().clear();
        todoAnchorPane.getChildren().add(PageLoader.createTodoPane());
    }

    @FXML
    private FlowPane ratingFlowPane;

    void showRatings() {
        ratingFlowPane.getChildren().clear();

        for (Ratings rating : model.getRatings()) {
            AnchorPane ratingItem = PageLoader.createRateItem(rating);
            ratingFlowPane.getChildren().add(ratingItem);
        }
    }


    @Override
    public void notified() {
        update();
    }

    private void update() {
        showRatings();
        initWaterIntakePanel();
        initSleepPanel();
        initWeather();
        initTodoPanel();
    }
}
