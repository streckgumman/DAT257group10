package viewcontroller;

import model.MainModel;

import java.util.Optional;

public interface page {
    void initPage(MainModel model, Optional<MainPageController> mainPage);
}
