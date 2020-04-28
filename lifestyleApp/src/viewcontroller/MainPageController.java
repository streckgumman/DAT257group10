package viewcontroller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
    private DatePicker datePicker;

    @FXML
    private AnchorPane mainPageAnchorPane;

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
    void previousDate(MouseEvent event){
        model.setDate(model.getDate().minusDays(1));
        updateDateLabel();
    }

    @FXML
    void nextDate(MouseEvent event){
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


}
