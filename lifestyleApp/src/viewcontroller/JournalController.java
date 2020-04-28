package viewcontroller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.Journal;
import model.JournalEntry;
import model.MainModel;

import java.util.Optional;

public class JournalController implements DateObserver{
    private MainModel model;
    private Journal journal;

    @FXML
    private TextArea textArea;

    public void initPage(MainModel model, Optional<Object> empty) {
        model.attach(this);
        this.model = model;
        this.journal = model.getJournal();
    }

    @FXML
    void saveEntry(ActionEvent event){
        String text = textArea.getText();
        journal.newEntry(text,model.getDate());
        update();
    }

    @FXML
    void deleteEntry(ActionEvent e){
        journal.deleteEntry(journal.getCurrentEntry(model.getDate()));
        update();
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
