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
        feedbackMindfullness();
    }

    @FXML
    void setTrainingTypeOther(MouseEvent event) {
        type = WorkoutEntry.TrainingType.OTHER;
        feedbackOther();
    }

    @FXML
    void setTrainingTypeRunning(MouseEvent event) {
        type = WorkoutEntry.TrainingType.RUNNING;
        feedbackRunning();
    }

    @FXML
    void setTrainingTypeWalk(MouseEvent event) {
        type = WorkoutEntry.TrainingType.WALKING;
        feedbackWalking();
    }

    @FXML
    void setTrainingTypeWeight(MouseEvent event) {
        type = WorkoutEntry.TrainingType.WEIGHT;
        feedbackWeight();
    }

    private void setTraingsTypeNull(){
        type = null;
        resetPictures();

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
        setTraingsTypeNull();
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
    @Override
    public void initPage(MainModel model, Optional<MainPageController> mainPage) {

    }
}






