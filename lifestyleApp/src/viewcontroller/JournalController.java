package viewcontroller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import model.JournalEntry;
import model.MainModel;

import java.util.Date;
import java.util.Optional;

public class JournalController {

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

   public void createJournalEntry(String text, Date date) {

       JournalEntry entry =  new JournalEntry(text, date);



   }

}
