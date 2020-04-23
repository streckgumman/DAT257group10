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
    private JournalEntry currentEntry = null;

    @FXML
    private TextArea textArea;
    @FXML
    private Button saveButton;
    @FXML
    private Button deleteButton;




    public void initPage(MainModel model, Optional<Object> empty) {
        //För att init sidan , måste vi matcha datum och JournalEntries.

    }

    @FXML
    void saveEntry( ActionEvent event){
        String text = textArea.getText();
        if(currentEntry == null){
            //TODO just nu hårdkodat, kommer kopplas ihop med mainpage datum.
            LocalDate date = LocalDate.now();
            JournalEntry entry =  new JournalEntry(text, date);
            createJournalEntry(entry);
            currentEntry = entry;

        }
        currentEntry.setText(text);


    }

    @FXML
    void deleteEntry(ActionEvent e){
        journal.deleteEntry(journal.getCurrentEntry());
        textArea.setText("");

    }





                   // ----------funktionalitet--------------------
   public void createJournalEntry(JournalEntry entry) {
       journal.addEntry(entry);
       System.out.println("create journal method");

   }

   public void setJournal(Journal j){
        this.journal = j;

   }

}
