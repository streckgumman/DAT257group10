package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.TodoEntry;

import java.text.DecimalFormat;
import java.util.Optional;

public class FitnessController {

    public TodoEntry todoEntry;
    private int workoutHour;
    private int workoutMinute;
    private double intensity;


    @FXML
    private Label intensityLabel;

    @FXML
    private Spinner<?> workoutHourSpinner;

    @FXML
    private Spinner<?> workoutMinSpinner;

    @FXML
    private Slider sliderIntensity;

    @FXML
    private Button saveTraningButton;

    @FXML
    void setWorkoutHour(MouseEvent event) {
        workoutHour = (Integer) workoutHourSpinner.getValue();

    }

    @FXML
    void setWorkoutMin(MouseEvent event) {
      setWorkoutTime(workoutHour,workoutMinute);

    }

    @FXML
    void setIntensity(MouseEvent event) {
        intensity = sliderIntensity.getValue();
        intensityLabel.setText(String.valueOf(new DecimalFormat("#.#").format(intensity)));

    }

    @FXML
    void setTrainingTypeMindFull(MouseEvent event) {

    }

    @FXML
    void setTrainingTypeOther(MouseEvent event) {

    }

    @FXML
    void setTrainingTypeRunning(MouseEvent event) {

    }

    @FXML
    void setTrainingTypeWalk(MouseEvent event) {

    }

    @FXML
    void setTrainingTypeWieght(MouseEvent event) {

    }

    void setWorkoutTime(int workoutHour, int workoutMinute){
        workoutHour = (Integer) workoutHourSpinner.getValue();
        workoutMinute = (Integer) workoutMinSpinner.getValue();

    }
    public void initPage(MainModel model, Optional<Object> empty) {
    }

}






