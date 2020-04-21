import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Journal;
import model.MainModel;
import viewcontroller.PageLoader;

import java.io.IOException;

public class LifestyleApp extends Application {
    private static MainModel model;

    @Override
    public void start(Stage stage) throws IOException {
        model = MainModel.createMainController();
        Journal journal = new Journal();

        PageLoader.setModel(model);
        Scene scene = new Scene(PageLoader.createJournal(journal), 314, 430);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }
}
