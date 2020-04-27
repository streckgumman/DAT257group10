package viewcontroller;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import model.Journal;
import model.MainModel;
import model.RatingEntry;
import model.Sleep;

public class PageLoader {
    private static MainModel model;

    // Sets the model
    public static void setModel(MainModel model) {
        PageLoader.model = model;
    }

    // This is a new class in which way we can create a result
    private static class Result<T> {
        T ctrl;
        AnchorPane root;

        Result(T page, AnchorPane root) {
            this.ctrl = page;
            this.root = root;
        }
    }

    // This will be a standard fxml loader that will give us the ctrl and the root that we can load.
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

    // Create pages
    public static Parent createMainPage() {
        Result<MainPageController> res = loadPage("fxml/mainPage.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

    public static AnchorPane createRateItem(RatingEntry re) {
        Result<RateController> res = loadPage("fxml/rate.fxml");
        res.ctrl.setRating(re);
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

    public static AnchorPane createCalendarPage() {
        Result<CalendarPageController> res = loadPage("fxml/calendarPage.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

    public static AnchorPane createHomePage() {
        Result<HomePageController> res = loadPage("fxml/homePage.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

    public static AnchorPane createStatisticsPage() {
        Result<StatisticsPageController> res = loadPage("fxml/statisticsPage.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

    public static AnchorPane createSettingsPage() {
        Result<SettingsPageController> res = loadPage("fxml/settingsPage.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

    public static AnchorPane createJournal(Journal journal) {
        Result<JournalController> res = loadPage("fxml/Journal.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

   public static AnchorPane createSleepPage() {
        Result<SleepController> res = loadPage("fxml/sleepPanel.fxml");
        res.ctrl.initPage(model, Optional.empty());
        return res.root;
    }

}

