import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * A Factory Method that loads and creates all the fxml/Anchorpanes that we need
 *
 * @author Hanna
 */
public class PageLoader {
    private static MainController model;

    /**
     * Needs to be a static variable so that we can divide min5a to the controllers that are in need
     * of the information
     *
     * @param model min5a
     */
    public static void setModel(MainController model) {
        PageLoader.model = model;
    }

    private static class Result<T> {
        T ctrl;
        AnchorPane root;

        Result(T page, AnchorPane root) {
            this.ctrl = page;
            this.root = root;
        }
    }

    private static <T> Result<T> loadPage(String fxml) {
        Result<T> result = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PageLoader.class.getClassLoader().getResource(fxml));
            AnchorPane root = fxmlLoader.load();
            T ctrl = fxmlLoader.getController();
            //model.register(ctrl); -- A way for us to check that one page changed and that changes all!
            result = new Result<T>(ctrl, root);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public static Parent createMainPage() {
        Result<MainPageController> res = loadPage("resources/fxml/mainPage.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }
}
