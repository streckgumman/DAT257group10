package viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.MainModel;
import model.Sleep;
import model.SleepEntry;

import java.time.LocalDate;
import java.util.Optional;


public class SleepController {

    private SleepEntry currentEntry = null;
    private Sleep sleep;
    @FXML
    private TextField bedtimeTextArea;

    public SleepController(Sleep sleep) {
        this.sleep = sleep;
    }

    public void initPage(MainModel model, Optional<Object> empty) {
    }

    @FXML
    void saveBedTimeButton(ActionEvent event) {
        String text = bedtimeTextArea.getText();
        if(currentEntry == null){
            LocalDate date = LocalDate.now();
            SleepEntry entry =  new SleepEntry(text,date);
            createBedTimeSleepEntry(entry);
            currentEntry = entry;

        }
        currentEntry.setText(text);
    }


    public void createBedTimeSleepEntry(SleepEntry entry){
        sleep.addBedTimeEntry(entry);
    }



}
