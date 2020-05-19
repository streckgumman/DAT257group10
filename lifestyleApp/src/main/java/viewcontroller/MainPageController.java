package viewcontroller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import viewcontroller.observers.DateObserver;
import viewcontroller.observers.MainObserver;
import viewcontroller.observers.UserObserver;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MainPageController implements UserObserver, page {

    MainModel model;

    // Other Pages
    private AnchorPane homePage;
    private AnchorPane statisticPage;
    private AnchorPane settingsPage;
    private AnchorPane fitnessPage;

    @FXML
    private Button nameMainPage;

    @FXML
    private DatePicker datePicker;

    @FXML
    private AnchorPane mainPageAnchorPane;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView statisticsImage;

    @FXML
    private ImageView settingsImage;

    @FXML
    private ImageView fitnessImage;

    // Pages

    @FXML
    void showHomePage(ActionEvent event) {
        showPage(homePage);
        homeImage.setBlendMode(BlendMode.COLOR_BURN);
    }

    @FXML
    void showSettingsPage(MouseEvent event) {
        showPage(settingsPage);
        notifyAllObservers();
    }

    @FXML
    void showStatisticsPage(MouseEvent event) {
        showPage(statisticPage);
    }

    @FXML
    void showHomepage2(MouseEvent event) {
        showPage(homePage);
    }

    @FXML
    void showFitnessPage(MouseEvent event) {
        showPage(fitnessPage);
        notifyAllObservers();
    }



    //-------------- Date Buttons -------------------
    @FXML
    void previousDate(MouseEvent event){
        model.setDate(model.getDate().minusDays(1));
        updateDateLabel();
    }

    @FXML
    void nextDate(MouseEvent event){
        model.setDate(model.getDate().plusDays(1));
        updateDateLabel();
    }

    public void initPage(MainModel model, Optional<MainPageController> empty) {
        this.model = model;
        updateDateLabel();
        model.attachUserOb(this);
        update();
        homePage = PageLoader.createHomePage();
        statisticPage = PageLoader.createStatisticsPage();
        settingsPage = PageLoader.createSettingsPage(this);
        fitnessPage = PageLoader.createFitnessPage(this);
        showPage(homePage);

        datePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            model.setDate(datePicker.getValue());
        });

    }

    private void showPage(AnchorPane pane) {
        mainPageAnchorPane.getChildren().clear();
        mainPageAnchorPane.getChildren().add(pane);
        mainPageAnchorPane.toFront();
    }

    private void updateDateLabel() {
        datePicker.setValue(model.getDate());
    }


    @Override
    public void notified() {
        update();
    }

    private void update() {
        nameMainPage.setText(model.getUser().getName());
    }

    private List<MainObserver> observers = new ArrayList<MainObserver>();

    public void attachMainOb(MainObserver observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (MainObserver o : observers) {
            o.notified();
        }
    }
}
