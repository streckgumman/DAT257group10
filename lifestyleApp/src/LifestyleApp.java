import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LifestyleApp extends Application {
    private static MainController model;
    @Override
    public void start(Stage stage) throws IOException {
        model = MainController.createMainController();
        PageLoader.setModel(model);
        Scene scene = new Scene(PageLoader.createMainPage(), 1200, 700);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }
}
