package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import model.MainModel;
import model.Ratings;

import java.util.Optional;

public class HomePageController {
    private MainModel model;

    @FXML
    private AnchorPane journalAnchorPane;

    public void initPage(MainModel model, Optional<Object> empty) {
        this.model=model;
        showRatings(model.getRatings());
        initJournal();
    }

    private void initJournal() {
        journalAnchorPane.getChildren().clear();
        journalAnchorPane.getChildren().add(PageLoader.createJournal(model.getJournal()));
    }

    @FXML
    private FlowPane ratingFlowPane;

    void showRatings(Iterable<Ratings> ratings) {
        ratingFlowPane.getChildren().clear();

        for (Ratings rating : ratings) {
            AnchorPane ratingItem = PageLoader.createRateItem(rating.getRating(model.getDate()));
            //setShadow(ratingItem);
            ratingFlowPane.getChildren().add(ratingItem);
        }
    }

    private static void setShadow(AnchorPane courseItem) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.DARKGRAY);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        courseItem.setEffect(dropShadow);
    }
}
