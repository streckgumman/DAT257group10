package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import model.MainModel;
import model.Ratings;

import java.util.Optional;

public class HomePageController implements DateObserver {
    private MainModel model;

    @FXML
    private AnchorPane journalAnchorPane;

    @FXML
    private AnchorPane sleepAnchorpane;

    public void initPage(MainModel model, Optional<Object> empty) {
        this.model=model;
        model.attachDateOb(this);
        showRatings();
        initJournal();
        initSleepPanel();
    }

    private void initJournal() {
        journalAnchorPane.getChildren().clear();
        journalAnchorPane.getChildren().add(PageLoader.createJournal(model.getJournal()));
    }

    private void initSleepPanel() {
        sleepAnchorpane.getChildren().clear();
        sleepAnchorpane.getChildren().add(PageLoader.createSleepPage());
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

    private void update(){
        showRatings();
    }
}
