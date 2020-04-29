package viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import model.RatingEntry;
import model.Ratings;
import sun.awt.ConstrainableGraphics;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class StatisticsPageController  implements DateObserver, RatingObserver {


    private MainModel mainmodel;
    private LocalDate currentDate;

    //-----------FXML variables-------------

    @FXML
    private AnchorPane weekAnchorPane;

    @FXML
    private AnchorPane monthAnchorPane;

    @FXML
    private BarChart<?, ?> monthGraph;

    @FXML
    private BarChart<?, ?> weekGraph;

    @FXML
    private ComboBox<String> ratingTopicComboBox;

    @FXML
    private Label weekLabel;

    private TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();


    public void initPage(MainModel model, Optional<MainPageController> parent) {
        this.mainmodel = model;
        mainmodel.attachDateOb(this); //For Date
        mainmodel.attachRateOb(this); //For Rate

        currentDate = model.getDate();
        initGraphs();
        initTopicComoBox();
        populateWeekGraph();
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

    @FXML
    private void populateWeekGraph(){
        List<RatingEntry> weekStatistics = getWeekStatistics(currentDate, ratingTopicComboBox.getSelectionModel().getSelectedItem());

        XYChart.Series dataSeries1 = new XYChart.Series();

        for (RatingEntry entry : weekStatistics){
            switch (entry.getDate().getDayOfWeek()){
                case MONDAY: dataSeries1.getData().add(new XYChart.Data("Monday", entry.getRating())); break;
                case TUESDAY: dataSeries1.getData().add(new XYChart.Data("Tuesday", entry.getRating())); break;
                case WEDNESDAY: dataSeries1.getData().add(new XYChart.Data("Wednesday", entry.getRating())); break;
                case THURSDAY: dataSeries1.getData().add(new XYChart.Data("Thursday", entry.getRating())); break;
                case FRIDAY: dataSeries1.getData().add(new XYChart.Data("Friday", entry.getRating())); break;
                case SATURDAY: dataSeries1.getData().add(new XYChart.Data("Saturday", entry.getRating())); break;
                case SUNDAY: dataSeries1.getData().add(new XYChart.Data("Sunday", entry.getRating())); break;
            }
        }
        weekGraph.getData().setAll(dataSeries1);


    }

    @FXML
    void changeTopicActionEvent(ActionEvent event) {
        populateWeekGraph();

    }

//------------functionality------------------
    private List<RatingEntry> getWeekStatistics(LocalDate date, String topic){
        int weeknumber = date.get(woy);
        List<RatingEntry> entries = new ArrayList<>();



        for(Ratings ratings: mainmodel.getRatings()){
            if( ratings.getTopic().equals(topic)){

                for( RatingEntry entry: ratings.getRatings()){
                    if( weeknumber == entry.getDate().get(woy)){
                        entries.add(entry);
                    }
                }
                break;
            }
        }
        return entries;

    }

   // ------------Observer stuff-----------------------

    @Override
    public void notified() {
        update();
    }

    private void update() {
       currentDate = mainmodel.getDate();
       populateWeekGraph();
       weekLabel.setText("" + currentDate.get(woy));
    }

    //-----------init GUI  methods------------

    private void initGraphs(){
        weekGraph.getYAxis().setLabel("Rating");
        weekGraph.getYAxis().setAutoRanging(false);
        NumberAxis weekAxisY = (NumberAxis) weekGraph.getYAxis();
        weekAxisY.setLowerBound(0);
        weekAxisY.setUpperBound(5);


        CategoryAxis weekAxisX = (CategoryAxis) weekGraph.getXAxis();
        ObservableList<String> weekdays = FXCollections.observableArrayList("Monday", "Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday");
        weekAxisX.setCategories(weekdays);

        monthGraph.getYAxis().setLabel("Rating");
        monthGraph.getXAxis().setLabel("Time");
        NumberAxis monthAxisY = (NumberAxis) monthGraph.getYAxis();
        monthGraph.getYAxis().setAutoRanging(false);
        monthAxisY.setLowerBound(0);
        monthAxisY.setUpperBound(5);
    }

    //Bör läggas till en Observer för  om fler rating(topics) skapas.
    private void initTopicComoBox(){
        //TODO
        ArrayList<String> ratingTopics = new ArrayList<>();

        for( Ratings rating : mainmodel.getUser().getRatings()){
          ratingTopics.add(rating.getTopic());
        }

        ObservableList<String> topics = FXCollections.observableArrayList(ratingTopics);
        ratingTopicComboBox.setItems(topics);
        ratingTopicComboBox.getSelectionModel().select(0);
    }
}
