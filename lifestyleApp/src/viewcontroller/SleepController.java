package viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.SleepEntry;

import java.util.Optional;

public class SleepController implements page {

    private MainModel model;
    private SleepEntry se;

    @FXML
    private Label totalSleepLabel;

    @FXML
    private Spinner<Integer> bedTimeHourSpinner;

    @FXML
    private Spinner<Integer> bedTimeMinuteSpinner;

    @FXML
    private Spinner<Integer> wakeUpTimeHourSpinner;

    @FXML
    private Spinner<Integer> wakeUpTimeMinuteSpinner;



    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setWakeUpTimeHour(MouseEvent event) {
        se.setWakeupTimeHour(wakeUpTimeHourSpinner.getValue());

    }

    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setWakeUpTimeMinute(MouseEvent event) {
        se.setWakeupTimeMinute(wakeUpTimeMinuteSpinner.getValue());
    }


    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setBedTimeHour(MouseEvent event) {
        se.setBedtimeHour(bedTimeHourSpinner.getValue());
    }

    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setBedTimeMinute(MouseEvent event) {
        se.setBedtimeMinute((Integer) bedTimeMinuteSpinner.getValue());
    }


    @FXML
    void totalSleep(ActionEvent event) {
        updateSleep();
    }

    private void updateSleep() {
        bedTimeHourSpinner.getValueFactory().setValue(se.getBedtimeHour());
        bedTimeMinuteSpinner.getValueFactory().setValue(se.getBedtimeMinute());
        wakeUpTimeHourSpinner.getValueFactory().setValue(se.getWakeupTimeHour());
        wakeUpTimeMinuteSpinner.getValueFactory().setValue(se.getWakeupTimeMinute());
        String totalHoursOfSleep = Integer.toString(se.getHoursOfSleep());
        String totalMinutesOfSleep = Integer.toString(se.getMinutesOfSleep());
        totalSleepLabel.setText(totalHoursOfSleep + " hours " + totalMinutesOfSleep + " minutes");
        model.statsChanged();
    }


    public void initPage(MainModel model, Optional<MainPageController> empty) {
        SpinnerValueFactory<Integer> bedHourFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        SpinnerValueFactory<Integer> bedMinFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
        SpinnerValueFactory<Integer> upHourFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        SpinnerValueFactory<Integer> upMinFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

        bedHourFactory.setWrapAround(true);
        bedMinFactory.setWrapAround(true);
        upHourFactory.setWrapAround(true);
        upMinFactory.setWrapAround(true);
        bedTimeHourSpinner.setValueFactory(bedHourFactory);
        bedTimeMinuteSpinner.setValueFactory(bedMinFactory);
        wakeUpTimeHourSpinner.setValueFactory(upHourFactory);
        wakeUpTimeMinuteSpinner.setValueFactory(upMinFactory);
        this.model = model;
        this.se = model.getSleep();
        updateSleep();
    }
}
