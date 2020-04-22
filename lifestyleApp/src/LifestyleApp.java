import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MainModel;
import model.RatingEntry;
import viewcontroller.PageLoader;

import java.io.IOException;

public class LifestyleApp extends Application {
    private static MainModel model;

    @Override
    public void start(Stage stage) throws IOException {
        model = MainModel.createMainController();

        RatingEntry re = new RatingEntry("hej");
        PageLoader.setModel(model);
        Scene scene = new Scene(PageLoader.createRateItem(re), 532, 79);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }
}
