package viewcontroller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import java.util.Optional;


public class MainPageController {

    MainModel model;

    // Other Pages
    private AnchorPane homePage;
    private AnchorPane calendarPage;
    private AnchorPane statisticPage;
    private AnchorPane settingsPage;
    private AnchorPane sleepePage;

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


    void initPage(MainModel model, Optional<Object> empty) {
        this.model = model;
        calendarPage = PageLoader.createCalendarPage();
        homePage = PageLoader.createHomePage();
        statisticPage = PageLoader.createStatisticsPage();
        settingsPage = PageLoader.createSettingsPage();


        showPage(homePage);

    }

    private void showPage(AnchorPane pane) {
        mainpageAnchorpane.getChildren().clear();
        mainpageAnchorpane.getChildren().add(pane);
        mainpageAnchorpane.toFront();
    }



}
