import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import persistence.JsonPersistence;
import persistence.Persistence;
import viewcontroller.PageLoader;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class LifestyleApp extends Application {
    private static MainModel model;

    @Override
    public void start(Stage stage) throws IOException {
        model = MainModel.createMainController();

        File save = new File("data.json");

        if (!save.toString().isEmpty()) {
            Persistence jsonPersistence = new JsonPersistence(model);
            try {
                jsonPersistence.load();
            } catch (IOException e) {
            }
        }

        // can be more users
        model.login("My Lifestyle");
        model.setDate(LocalDate.now());

        PageLoader.setModel(model);
        Scene scene = new Scene(PageLoader.createMainPage(), 1200, 700);
        stage.setTitle("LifeStyle");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);

        Runtime.getRuntime()
                .addShutdownHook(
                        new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        Persistence jsonPersistence = new JsonPersistence(model);
                                        try {
                                            jsonPersistence.save();
                                        } catch (IOException e) {

                                        }
                                    }
                                }));
    }
}