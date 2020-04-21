import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MainModel;
import viewcontroller.PageLoader;

import java.io.IOException;

public class LifestyleApp extends Application {
    private static MainModel model;

    @Override
    public void start(Stage stage) throws IOException {
        model = MainModel.createMainController();

        PageLoader.setModel(model);
        Scene scene = new Scene(PageLoader.createMainPage(this), 1200, 700);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }
}
