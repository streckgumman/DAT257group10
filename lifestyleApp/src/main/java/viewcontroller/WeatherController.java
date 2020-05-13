package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import model.WeatherEntry;
import model.WorkoutEntry;
import viewcontroller.observers.DateObserver;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.util.Optional;

public class WeatherController implements page {
    private MainModel model;
    private WeatherEntry wea;
    private WeatherEntry.WeatherType type;

    @FXML
    private AnchorPane anch4;

    @FXML
    private AnchorPane anch5;

    @FXML
    private AnchorPane anch2;

    @FXML
    private AnchorPane anch3;

    @FXML
    private AnchorPane anch6;

    @FXML
    private AnchorPane anch7;

    @FXML
    private AnchorPane anch1;

    @FXML
    void click1(MouseEvent event) {
        if (anch1.getBlendMode() == BlendMode.SRC_OVER) {
            anch1.setBlendMode(BlendMode.OVERLAY);
            wea.setWeatherType(null);
        } else {
            sun();
            wea.setWeatherType(WeatherEntry.WeatherType.SUN);
        }

    }


    @FXML
    void click2(MouseEvent event) {
        if (anch2.getBlendMode() == BlendMode.SRC_OVER) {
            anch2.setBlendMode(BlendMode.OVERLAY);
            wea.setWeatherType(null);
        } else {
            sunCloud();
            wea.setWeatherType(WeatherEntry.WeatherType.SUNCLOUD);
        }

    }

    @FXML
    void click3(MouseEvent event) {
        if (anch3.getBlendMode() == BlendMode.SRC_OVER) {
            anch3.setBlendMode(BlendMode.OVERLAY);
            wea.setWeatherType(null);
        } else {
            cloud();
            wea.setWeatherType(WeatherEntry.WeatherType.CLOUD);
        }

    }

    @FXML
    void click4(MouseEvent event) {
        if (anch4.getBlendMode() == BlendMode.SRC_OVER) {
            anch4.setBlendMode(BlendMode.OVERLAY);
            wea.setWeatherType(null);
        } else {
            rain();
            wea.setWeatherType(WeatherEntry.WeatherType.RAIN);
        }

    }

    @FXML
    void click5(MouseEvent event) {
        if (anch5.getBlendMode() == BlendMode.SRC_OVER) {
            anch5.setBlendMode(BlendMode.OVERLAY);
            wea.setWeatherType(null);
        } else {
            thunder();
            wea.setWeatherType(WeatherEntry.WeatherType.THUNDER);
        }

    }

    @FXML
    void click6(MouseEvent event) {
        if (anch6.getBlendMode() == BlendMode.SRC_OVER) {
            anch6.setBlendMode(BlendMode.OVERLAY);
            wea.setWeatherType(null);
        } else {
            windy();
            wea.setWeatherType(WeatherEntry.WeatherType.WINDY);
        }

    }

    @FXML
    void click7(MouseEvent event) {
        if (anch7.getBlendMode() == BlendMode.SRC_OVER) {
            anch7.setBlendMode(BlendMode.OVERLAY);
            wea.setWeatherType(null);
        } else {
            snow();
            wea.setWeatherType(WeatherEntry.WeatherType.SNOW);
        }

    }

    void sun() {
        anch1.setBlendMode(BlendMode.SRC_OVER);
        anch2.setBlendMode(BlendMode.OVERLAY);
        anch3.setBlendMode(BlendMode.OVERLAY);
        anch4.setBlendMode(BlendMode.OVERLAY);
        anch5.setBlendMode(BlendMode.OVERLAY);
        anch6.setBlendMode(BlendMode.OVERLAY);
        anch7.setBlendMode(BlendMode.OVERLAY);
    }

    void sunCloud() {
        anch1.setBlendMode(BlendMode.OVERLAY);
        anch2.setBlendMode(BlendMode.SRC_OVER);
        anch3.setBlendMode(BlendMode.OVERLAY);
        anch4.setBlendMode(BlendMode.OVERLAY);
        anch5.setBlendMode(BlendMode.OVERLAY);
        anch6.setBlendMode(BlendMode.OVERLAY);
        anch7.setBlendMode(BlendMode.OVERLAY);
    }

    void cloud() {
        anch1.setBlendMode(BlendMode.OVERLAY);
        anch2.setBlendMode(BlendMode.OVERLAY);
        anch3.setBlendMode(BlendMode.SRC_OVER);
        anch4.setBlendMode(BlendMode.OVERLAY);
        anch5.setBlendMode(BlendMode.OVERLAY);
        anch6.setBlendMode(BlendMode.OVERLAY);
        anch7.setBlendMode(BlendMode.OVERLAY);
    }

    void rain() {
        anch1.setBlendMode(BlendMode.OVERLAY);
        anch2.setBlendMode(BlendMode.OVERLAY);
        anch3.setBlendMode(BlendMode.OVERLAY);
        anch4.setBlendMode(BlendMode.SRC_OVER);
        anch5.setBlendMode(BlendMode.OVERLAY);
        anch6.setBlendMode(BlendMode.OVERLAY);
        anch7.setBlendMode(BlendMode.OVERLAY);
    }

    void thunder() {
        anch1.setBlendMode(BlendMode.OVERLAY);
        anch2.setBlendMode(BlendMode.OVERLAY);
        anch3.setBlendMode(BlendMode.OVERLAY);
        anch4.setBlendMode(BlendMode.OVERLAY);
        anch5.setBlendMode(BlendMode.SRC_OVER);
        anch6.setBlendMode(BlendMode.OVERLAY);
        anch7.setBlendMode(BlendMode.OVERLAY);
    }

    void windy() {
        anch1.setBlendMode(BlendMode.OVERLAY);
        anch2.setBlendMode(BlendMode.OVERLAY);
        anch3.setBlendMode(BlendMode.OVERLAY);
        anch4.setBlendMode(BlendMode.OVERLAY);
        anch5.setBlendMode(BlendMode.OVERLAY);
        anch6.setBlendMode(BlendMode.SRC_OVER);
        anch7.setBlendMode(BlendMode.OVERLAY);
    }

    void snow() {
        anch1.setBlendMode(BlendMode.OVERLAY);
        anch2.setBlendMode(BlendMode.OVERLAY);
        anch3.setBlendMode(BlendMode.OVERLAY);
        anch4.setBlendMode(BlendMode.OVERLAY);
        anch5.setBlendMode(BlendMode.OVERLAY);
        anch6.setBlendMode(BlendMode.OVERLAY);
        anch7.setBlendMode(BlendMode.SRC_OVER);
    }

    void reset() {
        anch1.setBlendMode(BlendMode.OVERLAY);
        anch2.setBlendMode(BlendMode.OVERLAY);
        anch3.setBlendMode(BlendMode.OVERLAY);
        anch4.setBlendMode(BlendMode.OVERLAY);
        anch5.setBlendMode(BlendMode.OVERLAY);
        anch6.setBlendMode(BlendMode.OVERLAY);
        anch7.setBlendMode(BlendMode.OVERLAY);
    }

    public void initPage(MainModel model, Optional<MainPageController> empty) {
        this.model = model;
        this.wea = model.getWeather();
        setWeather();
    }

    private void setWeather() {
        if (wea.getWeatherType() == null) {
            reset();
        } else {
            switch (wea.getWeatherType()) {
                case SUN:
                    sun();
                    break;
                case SUNCLOUD:
                    sunCloud();
                    break;
                case CLOUD:
                    cloud();
                    break;
                case RAIN:
                    rain();
                    break;
                case THUNDER:
                    thunder();
                    break;
                case WINDY:
                    windy();
                    break;
                case SNOW:
                    snow();
                    break;
            }
        }
    }
}
