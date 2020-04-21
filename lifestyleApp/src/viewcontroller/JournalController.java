package viewcontroller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import model.Journal;
import model.JournalEntry;
import model.MainModel;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class JournalController {

    private Journal journal;

    @FXML
    private TextArea textArea;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private DatePicker datePicker;

    public void initPage(MainModel model, Optional<Object> empty) {
    }

    @FXML
    void saveEntry( ActionEvent event){
       String text = textArea.getText();
       LocalDate date = datePicker.getValue();
       createJournalEntry( text, date);
    }

    @FXML
    void deleteEntry(ActionEvent e){
        journal.deleteEntry(journal.getCurrentEntry());
        textArea.setText(journal.getCurrentEntry().getEntry());
        datePicker.setValue(journal.getCurrentEntry().getDate());
    }





                   // ----------funktionalitet--------------------
   public void createJournalEntry(String text, LocalDate date) {
       JournalEntry entry =  new JournalEntry(text, date);
       journal.addEntry(entry);

   }

   public void setJournal(Journal j){
        this.journal = j;

   }

}
