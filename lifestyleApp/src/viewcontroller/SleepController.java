package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.Sleep;

import java.util.Optional;

public class SleepController {
    private int bedTimeHour;
    private int bedTimeMinute;
    private int wakeUpTimeHour;
    private int wakeUpTimeMinute;

    Sleep sleep;

    @FXML
    private Spinner<?> bedTimeHourSpinner;

    @FXML
    private Spinner<?> bedTimeMinuteSpinner;

    @FXML
    private Spinner<?> wakeUpTimeHourSpinner;

    @FXML
    private Spinner<?> wakeUpTimeMinuteSpinner;


    @FXML
    void setWakeUpTimeHour(MouseEvent event) {
        wakeUpTimeHour= (Integer) wakeUpTimeHourSpinner.getValue();
        System.out.print(wakeUpTimeHour);
    }

    @FXML
    void setWakeUpTimeMinute(MouseEvent event) {
        wakeUpTimeMinute = (Integer) wakeUpTimeMinuteSpinner.getValue();
        System.out.print(wakeUpTimeMinute);

    }


    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setBedTimeHour(MouseEvent event) {
       bedTimeHour = (Integer) bedTimeHourSpinner.getValue();
       System.out.print(bedTimeHour);
    }

    //Funkar bara när man ändrar tiden med knapparna
    @FXML
    void setBedTimeMinute(MouseEvent event) {
        bedTimeMinute = (Integer) bedTimeMinuteSpinner.getValue();
        System.out.print(bedTimeMinute);
    }


    public int getBedTimeHour() {
        return bedTimeHour;
    }

    public int getBedTimeMinute(){
        return bedTimeMinute;
    }



    public void initPage(MainModel model, Optional<Object> empty) {
    }
}
