import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Journal;
import model.MainModel;
import model.RatingEntry;
import model.User;
import viewcontroller.PageLoader;

import java.io.IOException;
import java.time.LocalDate;

public class LifestyleApp extends Application {
    private static MainModel model;

    @Override
    public void start(Stage stage) throws IOException {
        model = MainModel.createMainController();
        Journal journal = new Journal();

        User user = new User();
        model.setUser(user);
        model.setDate(LocalDate.now());
        model.addRating("Overall");
        model.addRating("Mood");
        model.addRating("Sleep");


        PageLoader.setModel(model);
        Scene scene = new Scene(PageLoader.createJournal(journal), 314, 430);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }
}
