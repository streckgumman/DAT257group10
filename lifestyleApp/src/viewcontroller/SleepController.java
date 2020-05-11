package viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.Sleep;

import java.util.Optional;

public class SleepController implements page {
    private int bedTimeHour = 12;
    private int bedTimeMinute = 30;
    private int wakeUpTimeHour = 12;
    private int wakeUpTimeMinute = 30;

    Sleep sleep;

    @FXML
    private Label totalSleepLabel;

    @FXML
    private Spinner<?> bedTimeHourSpinner;

    @FXML
    private Spinner<?> bedTimeMinuteSpinner;

    @FXML
    private Spinner<?> wakeUpTimeHourSpinner;

    @FXML
    private Spinner<?> wakeUpTimeMinuteSpinner;


    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setWakeUpTimeHour(MouseEvent event) {
        wakeUpTimeHour = (Integer) wakeUpTimeHourSpinner.getValue();

    }

    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setWakeUpTimeMinute(MouseEvent event) {
        wakeUpTimeMinute = (Integer) wakeUpTimeMinuteSpinner.getValue();


    }


    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setBedTimeHour(MouseEvent event) {
        bedTimeHour = (Integer) bedTimeHourSpinner.getValue();
    }

    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setBedTimeMinute(MouseEvent event) {
        bedTimeMinute = (Integer) bedTimeMinuteSpinner.getValue();
    }

    public int getMinutesOfSleep() {
        if (bedTimeMinute < wakeUpTimeMinute) {
            return (wakeUpTimeMinute - bedTimeMinute);

        } else if (bedTimeMinute > wakeUpTimeMinute) {
            return ((60 - bedTimeMinute) + wakeUpTimeMinute);
        }

        return 0;
    }

    public int getHoursOfSleep() {
        if (bedTimeHour < wakeUpTimeHour) {
            if (wakeUpTimeMinute < bedTimeMinute) {
                return (wakeUpTimeHour - bedTimeHour - 1);
            }
            return (wakeUpTimeHour - bedTimeHour);
        } else if (bedTimeHour > wakeUpTimeHour) {
            if (wakeUpTimeMinute < bedTimeMinute) {
                return ((24 - bedTimeHour) + wakeUpTimeHour - 1);
            }
            return ((24 - bedTimeHour) + wakeUpTimeHour);
        }
        return 0;
    }


    public int getBedTimeHour() {
        return bedTimeHour;
    }

    public int getBedTimeMinute() {
        return bedTimeMinute;
    }

    public int getWakeUpTimeHour() {
        return wakeUpTimeHour;
    }

    public int getWakeUpTimeMinute() {
        return wakeUpTimeMinute;
    }

    @FXML
    void totalSleep(ActionEvent event) {
        String totalHoursOfSleep = Integer.toString(getHoursOfSleep());
        String totalMinutesOfSleep = Integer.toString(getMinutesOfSleep());
        totalSleepLabel.setText(totalHoursOfSleep + " hours " + totalMinutesOfSleep + " minutes");
    }


    public void initPage(MainModel model, Optional<MainPageController> empty) {
    }
}
