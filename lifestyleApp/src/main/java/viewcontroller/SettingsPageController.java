package viewcontroller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import model.MainModel;
import model.Ratings;
import viewcontroller.observers.MainObserver;
import viewcontroller.observers.RatingObserver;

import java.util.Optional;

public class SettingsPageController implements page, MainObserver, RatingObserver {

    private MainModel model;
    private MainPageController parent;




    @FXML
    private FlowPane ratingFlowPane;

    @FXML
    private TextField newRatingField;

    @FXML
    private TextField avgGlassField;

    @FXML
    private TextField homepageTitleField;

    @FXML
    private Spinner<?> wakeUpHourSpinner;

    @FXML
    private Spinner<?> wakeUpMinSpinner;

    @FXML
    private Spinner<?> bedTimeHourSpinner;

    @FXML
    private Spinner<?> bedTimeMinSpinner;

    @FXML
    void saveSettings(ActionEvent event) {
        model.setUserName(homepageTitleField.getText());
    }

    @FXML
    void createRating(ActionEvent event) {
        model.addRating(newRatingField.getText());
    }

    @FXML
    void saveGlassSize(ActionEvent event) {
        String glassSize = avgGlassField.getText();
        model.getUser().setGlassSize(Double.valueOf(glassSize));

    }

    public void initPage(MainModel model, Optional<MainPageController> mainPage) {
        this.model = model;
        mainPage.ifPresent(page -> parent = page);
        parent.attachMainOb(this);
        model.attachRateOb(this);
        addTextLimiter(homepageTitleField, 15);
        addTextLimiter(newRatingField, 10);
        homepageTitleField.setText(model.getUserName());
    }

    void showRatings() {
        ratingFlowPane.getChildren().clear();

        for (Ratings rating : model.getRatings()) {
            AnchorPane ratingItem = PageLoader.createItemSettingsPage(rating);
            ratingFlowPane.getChildren().add(ratingItem);
        }
    }

    static void addTextLimiter(TextField text, int limit) {
        text
                .textProperty()
                .addListener(
                        new ChangeListener<String>() {
                            @Override
                            public void changed(
                                    final ObservableValue<? extends String> ov,
                                    final String oldValue,
                                    final String newValue) {
                                if (text.getText().length() > limit) {
                                    String s = text.getText().substring(0, limit);
                                    text.setText(s);
                                }
                            }
                        });
    }

    @Override
    public void notified() {
        update();
    }

    private void update() {
        homepageTitleField.setText(model.getUserName());
        newRatingField.setText("");
        ratingFlowPane.getChildren().clear();   
        showRatings();
    }


}
