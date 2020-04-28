package viewcontroller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;


public class MainPageController {

    MainModel model;

    // Other Pages
    private AnchorPane homePage;
    private AnchorPane calendarPage;
    private AnchorPane statisticPage;
    private AnchorPane settingsPage;

    @FXML
    private Label dateLabel;

    @FXML
    private AnchorPane mainpageAnchorpane;

    @FXML
    void showHomePage(ActionEvent event) {
        showPage(homePage);
    }

    @FXML
    void showSettingsPage(MouseEvent event) {
        showPage(settingsPage);
    }

    @FXML
    void showStatisticsPage(MouseEvent event) {
        showPage(statisticPage);
    }

    @FXML
    void showCalendarPage(MouseEvent event) {
        showPage(calendarPage);
    }

    @FXML
    void showOtherPage(MouseEvent event) {

    }

    //-------------- Date Buttons -------------------
    @FXML
    void previousDate(ActionEvent event){
        model.setDate(model.getDate().minusDays(1));
        updateDateLabel();
    }

    @FXML
    void nextDate(ActionEvent event){
        model.setDate(model.getDate().plusDays(1));
        updateDateLabel();
    }

    void initPage(MainModel model, Optional<Object> empty) {
        this.model = model;
        updateDateLabel();
        calendarPage = PageLoader.createCalendarPage();
        homePage = PageLoader.createHomePage();
        statisticPage = PageLoader.createStatisticsPage();
        settingsPage = PageLoader.createSettingsPage();
        //sleepPanel = PageLoader.createSleepPage(s);
        showPage(homePage);

    }

    private void showPage(AnchorPane pane) {
        mainpageAnchorpane.getChildren().clear();
        mainpageAnchorpane.getChildren().add(pane);
        mainpageAnchorpane.toFront();
    }

    private void updateDateLabel() {
        int day = model.getDate().getDayOfMonth();
        String month = model.getDate().getMonth().toString().toLowerCase();
        String date = day + " " + month;
        dateLabel.setText(date);

    }


}
