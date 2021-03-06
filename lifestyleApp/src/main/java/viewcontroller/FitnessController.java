package viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.MainModel;
import model.TodoEntry;
import model.Workout;
import model.WorkoutEntry;
import viewcontroller.observers.DateObserver;
import viewcontroller.observers.MainObserver;

import java.text.DecimalFormat;
import java.util.Optional;

public class FitnessController implements page, DateObserver, MainObserver {

    private MainModel model;
    private MainPageController parent;
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
    private Spinner<Integer> workoutHourSpinner;

    @FXML
    private Spinner<Integer> workoutMinSpinner;

    @FXML
    private Slider sliderIntensity;

    @FXML
    private Button saveTraningButton;

    @FXML
    private Label samePageErrorWorkout;

    @FXML
    private Label fillAllFieldsLabel;

    @FXML
    private ImageView weightPicture;

    @FXML
    private ImageView runningPictures;

    @FXML
    private ImageView walkingPicture;

    @FXML
    private ImageView mindfullnessPicuture;

    @FXML
    private ImageView otherPicture;

    @FXML
    private Button deleteWorkoutButton;


    // TODO-when fxml is done edited then these two are to be removed (serve no purpose)
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
        if(type == null || !(type.toString().equals("MINDFULNESS"))){
            type = WorkoutEntry.TrainingType.MINDFULNESS;
            feedbackMindfullness();
        }
        else{
            resetInputs();
            resetPictures();
        }

    }

    @FXML
    void setTrainingTypeOther(MouseEvent event) {
        if(type == null || !(type.toString().equals("OTHER"))) {
            type = WorkoutEntry.TrainingType.OTHER;
            feedbackOther();
        }else {
            resetPictures();
            resetInputs();
        }
    }

    @FXML
    void setTrainingTypeRunning(MouseEvent event) {
        if(type == null || !(type.toString().equals("RUNNING"))) {
            type = WorkoutEntry.TrainingType.RUNNING;
            feedbackRunning();
        }else {
            resetPictures();
            resetInputs();
        }
    }

    @FXML
    void setTrainingTypeWalk(MouseEvent event) {
        if(type == null || !(type.toString().equals("WALKING"))) {
            type = WorkoutEntry.TrainingType.WALKING;
            feedbackWalking();
        }else {
            resetPictures();
            resetInputs();
        }
    }

    @FXML
    void setTrainingTypeWeight(MouseEvent event) {
        if(type == null || !(type.toString().equals("WEIGHT"))) {
            type = WorkoutEntry.TrainingType.WEIGHT;
            feedbackWeight();
        }
        else {
            resetPictures();
            resetInputs();
        }
    }

    private void setTraingsTypeNull(){
        type = null;
        resetPictures();
    }



    @FXML
    void saveWorkout(ActionEvent event) {

        if (type != null && !(workoutHourSpinner.getValue() == 0 && workoutMinSpinner.getValue() == 0)) {
            workout.addEntry(new WorkoutEntry(workoutHourSpinner.getValue(), workoutMinSpinner.getValue(), sliderIntensity.getValue(), type));
            deleteWorkoutButton.setBlendMode(BlendMode.SRC_OVER);
            samePageErrorWorkout.setText("");
            loadWorkout();
            resetInputs();
            fillAllFieldsLabel.setText("");
            sliderIntensity.setValue(1);
            intensityLabel.setText("1");
        }else{
            fillAllFieldsLabel.setText("*Fill in all fields to save the workout.");
        }
        model.statsChanged();

    }

    void loadWorkout(){
        workoutEntries.clear();
        for (WorkoutEntry we : workout.getWorkouts()){
            workoutEntries.add(we);
        }
        workoutListView.setItems(workoutEntries);

    }



    void fill() {
        walkingPicture.setBlendMode(BlendMode.SRC_OVER);
        runningPictures.setBlendMode(BlendMode.SRC_OVER);
        mindfullnessPicuture.setBlendMode(BlendMode.SRC_OVER);
        otherPicture.setBlendMode(BlendMode.SRC_OVER);
        weightPicture.setBlendMode(BlendMode.SRC_OVER);
    }

    @FXML
    void deleteWorkout(ActionEvent event) {
      final int selectedWorkout = workoutListView.getSelectionModel().getSelectedIndex();
      if (selectedWorkout == -1){
          samePageErrorWorkout.setText("*You need to select a workout to delete it.");

      }
      else {
          final int newSelectedWorkout = (selectedWorkout == workoutListView.getItems().size() - 1) ? selectedWorkout - 1 : selectedWorkout;

          workout.removeEntry(workoutListView.getSelectionModel().getSelectedItem());
          workoutListView.getItems().remove(selectedWorkout);
          workoutListView.getSelectionModel().select(newSelectedWorkout);

          samePageErrorWorkout.setText("");
          if (workoutEntries.size() == 0) {
              deleteWorkoutButton.setBlendMode(BlendMode.OVERLAY);
          }
      }

    }

    private void feedbackOther(){
       otherPicture.setBlendMode(BlendMode.SRC_OVER);
        weightPicture.setBlendMode(BlendMode.OVERLAY);
        runningPictures.setBlendMode(BlendMode.OVERLAY);
        walkingPicture.setBlendMode(BlendMode.OVERLAY);
        mindfullnessPicuture.setBlendMode(BlendMode.OVERLAY);
    }


    private void feedbackWeight(){
        weightPicture.setBlendMode(BlendMode.SRC_OVER);
        otherPicture.setBlendMode(BlendMode.OVERLAY);
        runningPictures.setBlendMode(BlendMode.OVERLAY);
        walkingPicture.setBlendMode(BlendMode.OVERLAY);
        mindfullnessPicuture.setBlendMode(BlendMode.OVERLAY);
    }

    private void feedbackRunning(){
        runningPictures.setBlendMode(BlendMode.SRC_OVER);
        weightPicture.setBlendMode(BlendMode.OVERLAY);
        otherPicture.setBlendMode(BlendMode.OVERLAY);
        walkingPicture.setBlendMode(BlendMode.OVERLAY);
        mindfullnessPicuture.setBlendMode(BlendMode.OVERLAY);
    }

    private void feedbackWalking(){
        walkingPicture.setBlendMode(BlendMode.SRC_OVER);
        weightPicture.setBlendMode(BlendMode.OVERLAY);
        runningPictures.setBlendMode(BlendMode.OVERLAY);
        otherPicture.setBlendMode(BlendMode.OVERLAY);
        mindfullnessPicuture.setBlendMode(BlendMode.OVERLAY);
    }

    private void feedbackMindfullness(){
        mindfullnessPicuture.setBlendMode(BlendMode.SRC_OVER);
        weightPicture.setBlendMode(BlendMode.OVERLAY);
        runningPictures.setBlendMode(BlendMode.OVERLAY);
        walkingPicture.setBlendMode(BlendMode.OVERLAY);
        otherPicture.setBlendMode(BlendMode.OVERLAY);
    }

    private void resetPictures(){
        mindfullnessPicuture.setBlendMode(BlendMode.SRC_OVER);
        weightPicture.setBlendMode(BlendMode.SRC_OVER);
        runningPictures.setBlendMode(BlendMode.SRC_OVER);
        walkingPicture.setBlendMode(BlendMode.SRC_OVER);
        otherPicture.setBlendMode(BlendMode.SRC_OVER);
    }
    void resetInputs(){
        workoutHourSpinner.getValueFactory().setValue(0);
        workoutMinSpinner.getValueFactory().setValue(0);
        setTraingsTypeNull();
    }

    @Override
    public void initPage(MainModel model, Optional<MainPageController> mainPage) {
        this.model = model;
        mainPage.ifPresent(page -> parent = page);
        parent.attachMainOb(this);
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
        resetInputs();
    }
}






