import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import viewcontroller.PageLoader;

import java.io.IOException;
import java.time.LocalDate;

public class LifestyleApp extends Application {
    private static MainModel model;

    @Override
    public void start(Stage stage) throws IOException {
        model = MainModel.createMainController();

        User user = new User();
        model.setUser(user);
        model.setUserName("Johanna Wiberg");

        model.setDate(LocalDate.now());
        model.addRating("Overall");
        model.addRating("Mood");
        model.addRating("Sleep");


        PageLoader.setModel(model);
        Scene scene = new Scene(PageLoader.createMainPage(), 1200, 700);
        stage.setTitle("LifeStyle");
        stage.setScene(scene);
        stage.show();
    }
}