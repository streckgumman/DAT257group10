package viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import model.RatingEntry;
import model.Ratings;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class StatisticsPageController {

    @FXML
    private AnchorPane weekAnchorPane;

    @FXML
    private AnchorPane monthAnchorPane;

    @FXML
    private Button weekButton;

    @FXML
    private Button monthbutton;

    @FXML
    private AnchorPane statisticsPageAnchorpane;

    @FXML
    private BarChart<?, ?> monthGraph;

    @FXML
    private BarChart<?, ?> weekGraph;

    private MainModel mainmodel;



    private TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();


    public void initPage(MainModel model, Optional<MainPageController> parent) {


        //Init  graphs
        weekGraph.getYAxis().setLabel("Rating");
        weekGraph.getYAxis().setAutoRanging(false);
        NumberAxis weekAxisY = (NumberAxis) weekGraph.getYAxis();
        weekAxisY.setLowerBound(0);
        weekAxisY.setUpperBound(5);

        weekGraph.getXAxis().setLabel("Weekday");
        CategoryAxis weekAxisX = (CategoryAxis) weekGraph.getXAxis();
        ObservableList<String> weekdays = FXCollections.observableArrayList("Monday", "Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday");
        weekAxisX.setCategories(weekdays);




        monthGraph.getYAxis().setLabel("Rating");
        monthGraph.getXAxis().setLabel("Weekday");
        NumberAxis monthAxisY = (NumberAxis) monthGraph.getYAxis();
        monthGraph.getYAxis().setAutoRanging(false);
        monthAxisY.setLowerBound(0);
        monthAxisY.setUpperBound(5);


    }


//----------------GUI-------------------
    @FXML
    private void weekGraphToFront(ActionEvent event){
        weekAnchorPane.toFront();
    }

    @FXML
    private void monthGraphToFront(ActionEvent event){
        monthAnchorPane.toFront();
    }

//------------functionality------------------
    private void getWeekStatistics(LocalDate date){
        int weeknumber = date.get(woy);
        List<RatingEntry> entries = new ArrayList<>();



        for(Ratings ratings: mainmodel.getRatings()){
            if( ratings.getTopic().equals("Overall")){

                for( RatingEntry entry: ratings.getRatings()){
                    if( weeknumber == entry.getDate().get(woy)){
                        entries.add(entry);
                    }
                }
            }
        }

    }

}
