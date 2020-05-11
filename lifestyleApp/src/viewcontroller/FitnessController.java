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

public class FitnessController implements page{

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
        workoutMinute = (Integer) workoutMinSpinner.getValue();

    }

    @FXML
    void setIntensity(MouseEvent event) {
        intensity = sliderIntensity.getValue();
        intensityLabel.setText(String.valueOf(new DecimalFormat("#.#").format(intensity)));

    }

    @FXML
    void setTrainingTypeMindFull(MouseEvent event) {
        type = WorkoutEntry.TrainingType.MINDFULNESS;
    }

    @FXML
    void setTrainingTypeOther(MouseEvent event) {
        type = WorkoutEntry.TrainingType.OTHER;
    }

    @FXML
    void setTrainingTypeRunning(MouseEvent event) {
        type = WorkoutEntry.TrainingType.RUNNING;
    }

    @FXML
    void setTrainingTypeWalk(MouseEvent event) {
        type = WorkoutEntry.TrainingType.WALKING;
    }

    @FXML
    void setTrainingTypeWeight(MouseEvent event) {
        type = WorkoutEntry.TrainingType.WEIGHT;
    }

    void setWorkoutTime(int workoutHour, int workoutMinute){
        workoutHour = (Integer) workoutHourSpinner.getValue();
        workoutMinute = (Integer) workoutMinSpinner.getValue();

    }



    @FXML
    void saveWorkout(ActionEvent event) {
        WorkoutEntry entry = new WorkoutEntry(workoutHour, workoutMinute, intensity, type);
        workoutEntries.add(entry.toString());
        workoutListView.setItems(workoutEntries);
    }

    @FXML
    void deleteWorkout(ActionEvent event) {

      final int selectedWorkout = workoutListView.getSelectionModel().getSelectedIndex();
      if (selectedWorkout!= -1) {
          final int newSelectedWorkout = (selectedWorkout == workoutListView.getItems().size() - 1) ? selectedWorkout - 1 : selectedWorkout;
          workoutListView.getItems().remove(selectedWorkout);
          workoutListView.getSelectionModel().select(newSelectedWorkout);
      }

    }

    @Override
    public void initPage(MainModel model, Optional<MainPageController> mainPage) {

    }
}






