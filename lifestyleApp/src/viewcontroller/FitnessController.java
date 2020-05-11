package viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.TodoEntry;
import model.Workout;
import model.WorkoutEntry;
import viewcontroller.observers.DateObserver;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Observer;
import java.util.Optional;

public class FitnessController implements page, DateObserver {

    private MainModel model;
    private int workoutHour;
    private int workoutMinute;
    private double intensity;
    private WorkoutEntry.TrainingType type;
    private Workout workout;
    private ObservableList<WorkoutEntry> workoutEntries = FXCollections.observableArrayList();

    @FXML
    private ListView<WorkoutEntry> workoutListView = new ListView<>();

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
        if (type != null) {
            workout.addEntry(new WorkoutEntry(workoutHour, workoutMinute, intensity, type));
            loadWorkout();
        }
    }

    @FXML
    void deleteWorkout(ActionEvent event) {

      final int selectedWorkout = workoutListView.getSelectionModel().getSelectedIndex();
      if (selectedWorkout!= -1) {
          final int newSelectedWorkout = (selectedWorkout == workoutListView.getItems().size() - 1) ? selectedWorkout - 1 : selectedWorkout;
          WorkoutEntry we = workoutListView.getSelectionModel().getSelectedItem();
          workout.removeEntry(we);
          workoutListView.getItems().remove(selectedWorkout);
          workoutListView.getSelectionModel().select(newSelectedWorkout);
      }

    }

    void loadWorkout(){
        workoutEntries.clear();
        for (WorkoutEntry we : workout.getWorkouts()){
            workoutEntries.add(we);
        }
        workoutListView.setItems(workoutEntries);

    }

    @Override
    public void initPage(MainModel model, Optional<MainPageController> mainPage) {
        this.model = model;
        model.attachDateOb(this);
        this.workout = model.getWorkout();
        loadWorkout();
    }

    @Override
    public void notified() {
        update();
    }

    private void update(){
        this.workout=model.getWorkout();
        loadWorkout();
    }
}






