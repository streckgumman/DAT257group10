package viewcontroller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import model.Journal;
import model.JournalEntry;
import model.MainModel;
import viewcontroller.observers.DateObserver;

import java.util.Optional;

public class JournalController implements DateObserver, page {
    private MainModel model;
    private Journal journal;
    private Boolean isTextareaShowing = true;

    @FXML
    private TextArea textArea;

    @FXML
    private Label showJournal;

    @FXML
    private Button saveButton;

    @FXML
    private AnchorPane labelAnchorpane;


    @FXML
    private AnchorPane textAreaAnchorpane;

    public void initPage(MainModel model, Optional<MainPageController> empty) {
        model.attachDateOb(this);
        this.model = model;
        this.journal = model.getJournal();
        update();
    }

    @FXML
    void saveEntry(ActionEvent event){
        if(isTextareaShowing) {
            journal.deleteEntry(journal.getCurrentEntry(model.getDate()));
            String text = textArea.getText();
            journal.newEntry(text, model.getDate());
            showJournal.setText(text);
            textAreaAnchorpane.setVisible(false);
            isTextareaShowing = false;
            saveButton.setText("Edit journal");
            update();
        }
        else{
        resetJournal();
        }
    }

    @FXML
    void deleteEntry(ActionEvent e){
        journal.deleteEntry(journal.getCurrentEntry(model.getDate()));
        showJournal.setText("");
        resetJournal();
        update();
    }

    void resetJournal(){
        textAreaAnchorpane.setVisible(true);
        saveButton.setText("Save");
        isTextareaShowing=true;

    }
    @Override
    public void notified() {
        update();
    }

    private void update() {
        JournalEntry entry = journal.getCurrentEntry(model.getDate());
        if(entry != null){
            textArea.setText(entry.getEntry());
        } else {
            textArea.setText("");
        }
    }
}
