package viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.MainModel;

import java.util.Optional;

public class MainPageController {

    @FXML
    private Button headerButtonCalendar;

    @FXML
    private ImageView HeaderImage1;

    @FXML
    private Button headerButtonStatistics;


    private MainModel model;


    private AnchorPane homePage;
    private AnchorPane calendarPage;
    private AnchorPane statisticsPage;


    public void initPage(MainModel model, Optional<MainPageController> mainPage) {
       /* this.model = model;
         homePage = (AnchorPane) PageLoader.createMainPage(this);
        calendarPage = PageLoader.createCalendarPage(this);
        statisticsPage = PageLoader.createStatisticsPage(this);*/

    }

    @FXML
    private void showHomePage(ActionEvent actionEvent) {
        showPage(homePage);
    }

    @FXML
    private void showCourseSelectionPage(ActionEvent event) {
        showPage(calendarPage);
    }

    @FXML
    private void showStatisticPage(ActionEvent event) {
        showPage(statisticsPage);
    }

    private void showPage(AnchorPane pane) {
        homePage.getChildren().clear();
        homePage.getChildren().add(pane);
        homePage.toFront();
    }


  /*  @FXML
    void headerButtonStatistics(ActionEvent actionEvent) {
        statisticsAnchorPane.toFront();
        System.out.print("HEj");
    }

    @FXML
    void headerButtonCalendar(ActionEvent event) {
        calendarAnchorPane.toFront();
    }
*/



}
