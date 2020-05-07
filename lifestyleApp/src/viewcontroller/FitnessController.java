package viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.TodoEntry;
import model.WorkoutEntry;

import java.text.DecimalFormat;
import java.util.Optional;

public class FitnessController {

    private int workoutHour;
    private int workoutMinute;
    private double intensity;
    private WorkoutEntry.TrainingType type;
    private ObservableList<String> workoutEntries = FXCollections.observableArrayList();

    @FXML
    private ListView<String> workoutListView = new ListView<>();



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

    @FXML
    void saveWorkout(ActionEvent event) {
        WorkoutEntry entry = new WorkoutEntry(workoutHour, workoutMinute, intensity, type);
        workoutEntries.add(entry.toString());
        workoutListView.setItems(workoutEntries);
    }


}






