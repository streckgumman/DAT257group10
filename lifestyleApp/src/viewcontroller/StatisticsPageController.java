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
import model.*;
import sun.awt.ConstrainableGraphics;
import viewcontroller.observers.DateObserver;
import viewcontroller.observers.RatingObserver;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

import java.util.ArrayList;
import java.util.Collections;

public class StatisticsPageController implements page, DateObserver, RatingObserver {


    private MainModel mainmodel;
    private LocalDate currentDate;
    private Boolean isWeekGraphShowing = true;

    //-----------FXML variables-------------

    @FXML
    private AnchorPane weekAnchorPane;

    @FXML
    private AnchorPane monthAnchorPane;

    @FXML
    private BarChart<?, ?> weekGraph;

    @FXML
    private LineChart<String, Number> monthLineGraph;

    @FXML
    private ComboBox<String> ratingTopicComboBox;

    @FXML
    private Label weekMonthLabel;

    @FXML
    private Label specWeekMonthLabel;

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
    private void weekGraphToFront(ActionEvent event) {
        weekAnchorPane.toFront();
        isWeekGraphShowing = true;
        weekMonthLabel.setText("Week: ");
        specWeekMonthLabel.setText("" + currentDate.get(woy));
    }

    @FXML
    private void monthGraphToFront(ActionEvent event) {
        monthAnchorPane.toFront();
        isWeekGraphShowing = false;
        weekMonthLabel.setText("Month: ");
        specWeekMonthLabel.setText("" + currentDate.getMonth().toString());
    }

    @FXML
    private void populateWeekGraph() {
        List<RatingEntry> weekStatistics = getWeekStatistics(currentDate, ratingTopicComboBox.getSelectionModel().getSelectedItem());

        XYChart.Series dataSeries1 = new XYChart.Series();

        for (RatingEntry entry : weekStatistics) {
            switch (entry.getDate().getDayOfWeek()) {
                case MONDAY:
                    dataSeries1.getData().add(new XYChart.Data("Monday", entry.getRating()));
                    break;
                case TUESDAY:
                    dataSeries1.getData().add(new XYChart.Data("Tuesday", entry.getRating()));
                    break;
                case WEDNESDAY:
                    dataSeries1.getData().add(new XYChart.Data("Wednesday", entry.getRating()));
                    break;
                case THURSDAY:
                    dataSeries1.getData().add(new XYChart.Data("Thursday", entry.getRating()));
                    break;
                case FRIDAY:
                    dataSeries1.getData().add(new XYChart.Data("Friday", entry.getRating()));
                    break;
                case SATURDAY:
                    dataSeries1.getData().add(new XYChart.Data("Saturday", entry.getRating()));
                    break;
                case SUNDAY:
                    dataSeries1.getData().add(new XYChart.Data("Sunday", entry.getRating()));
                    break;
            }
        }
        weekGraph.getData().setAll(dataSeries1);

    }

    @FXML
    private void populateMonthGraph() {
        List<RatingEntry> monthStatistics = getMonthStatistics(currentDate, ratingTopicComboBox.getSelectionModel().getSelectedItem());

        XYChart.Series dataSeries2 = new XYChart.Series();
        Collections.sort(monthStatistics);

        for (RatingEntry entry : monthStatistics) {
            dataSeries2.getData().add(new XYChart.Data("" + entry.getDate().getDayOfMonth(), entry.getRating()));
        }
        monthLineGraph.getData().setAll(dataSeries2);

    }


    @FXML
    void changeTopicActionEvent(ActionEvent event) {
        populateWeekGraph();
        populateMonthGraph();

    }

    //------------functionality------------------
    private List<RatingEntry> getWeekStatistics(LocalDate date, String topic) {
        int weeknumber = date.get(woy);
        List<RatingEntry> entries = new ArrayList<>();


        for (Ratings ratings : mainmodel.getRatings()) {
            if (ratings.getTopic().equals(topic)) {

                for (RatingEntry entry : ratings.getRatings()) {
                    if ((weeknumber == entry.getDate().get(woy)) && (date.getYear() == entry.getDate().getYear())) {
                        entries.add(entry);
                    }
                }
                break;
            }
        }
        return entries;

    }

    private List<RatingEntry> getMonthStatistics(LocalDate date, String topic) {
        List<RatingEntry> entries = new ArrayList<>();


        for (Ratings ratings : mainmodel.getRatings()) {
            if (ratings.getTopic().equals(topic)) {

                for (RatingEntry entry : ratings.getRatings()) {
                    if ((date.getMonth().equals(entry.getDate().getMonth())) && (date.getYear() == entry.getDate().getYear())) {
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
        populateMonthGraph();
        populateWeekGraph();
        initTopicComoBox();

        if (isWeekGraphShowing) {
            weekMonthLabel.setText("Week: ");
            specWeekMonthLabel.setText("" + currentDate.get(woy));
        } else {
            weekMonthLabel.setText("Month: ");
            specWeekMonthLabel.setText("" + currentDate.getMonth().toString());
        }

    }

    //-----------init GUI  methods------------

    private void initGraphs() {
        weekGraph.getYAxis().setLabel("Rating");
        weekGraph.getYAxis().setAutoRanging(false);
        NumberAxis weekAxisY = (NumberAxis) weekGraph.getYAxis();
        weekAxisY.setLowerBound(0);
        weekAxisY.setUpperBound(5);


        CategoryAxis weekAxisX = (CategoryAxis) weekGraph.getXAxis();
        ObservableList<String> weekdays = FXCollections.observableArrayList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        weekAxisX.setCategories(weekdays);

        monthLineGraph.getYAxis().setLabel("Rating");
        monthLineGraph.getXAxis().setLabel("Time");
        NumberAxis monthAxisY = (NumberAxis) monthLineGraph.getYAxis();
        CategoryAxis monthAxisX = (CategoryAxis) monthLineGraph.getXAxis();
        monthLineGraph.getYAxis().setAutoRanging(false);

        if (isWeekGraphShowing) {
            weekMonthLabel.setText("Week: ");
            specWeekMonthLabel.setText("" + currentDate.get(woy));
        } else {
            weekMonthLabel.setText("Month: ");
            specWeekMonthLabel.setText("" + currentDate.getMonth().toString());
        }


        monthAxisY.setLowerBound(0);
        monthAxisY.setUpperBound(5);
    }

    //Bör läggas till en Observer för  om fler rating(topics) skapas.
    private void initTopicComoBox() {
        //TODO
        ArrayList<String> ratingTopics = new ArrayList<>();

        for (Ratings rating : mainmodel.getUser().getRatings()) {
            ratingTopics.add(rating.getTopic());
        }

        ObservableList<String> topics = FXCollections.observableArrayList(ratingTopics);
        ratingTopicComboBox.setItems(topics);
        ratingTopicComboBox.getSelectionModel().select(0);
    }


    //Average water intake



    @FXML
    private Label averageWaterLabel;

    @FXML
    void averageWaterIntake(ActionEvent event) {
        double av = 0;
        LocalDate startDate = mainmodel.getDate();
        LocalDate endDate = startDate.minusDays(6);
        for (LocalDate date = startDate; date.isAfter(endDate); date = date.minusDays(1)) {
            av += mainmodel.getWater().getWaterEntry(date).getWaterEntry();
        }
        av = av / 7;

        averageWaterLabel.setText(String.valueOf(new DecimalFormat("#.#").format(av)) + " liter(s)");


    }

    @FXML
    private Label averageSleepLabel;

    @FXML
    void averageSleep(ActionEvent event) {
    /*
        double hours = 0;
        double mins = 0;
        LocalDate startDate = mainmodel.getDate();
        LocalDate endDate = startDate.minusDays(6);
        for (LocalDate date = startDate; date.isAfter(endDate); date = date.minusDays(1)) {
            mins += mainmodel.getSleep().getSleepEntry(date).get
        }
        hours = hours / 7;
        mins = mins / 7;

        averageSleepLabel.setText(String.valueOf(hours) + " hours " + String.valueOf(mins) + " mins");*/

    }


}
