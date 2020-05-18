package viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.MainModel;
import model.Ratings;

import java.util.Optional;

public class RateItemSettingsController implements page {
    private MainModel model;
    private Ratings rating;

    @FXML
    private AnchorPane confirmationAnchorPane;

    @FXML
    private Text ratingName;

    @FXML
    void cancel(ActionEvent event){
        confirmationAnchorPane.toBack();
    }

    @FXML
    void confirm(ActionEvent event){
        model.removeRating(rating);
    }

    @FXML
    void delete(ActionEvent event){
        confirmationAnchorPane.toFront();
    }

    @Override
    public void initPage(MainModel model, Optional<MainPageController> mainPage) {
        this.model = model;
        ratingName.setText(rating.getTopic());
    }

    public void setRating(Ratings r) {
        this.rating = r;
    }
}
