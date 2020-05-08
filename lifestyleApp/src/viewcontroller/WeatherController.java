package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import model.WeatherEntry;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.util.Optional;

public class WeatherController implements page{
    private WeatherEntry wea;

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
    private AnchorPane weather;

    @FXML
    void click1(MouseEvent event) {
        if (anch1.getBlendMode() == BlendMode.SRC_OVER) {
            anch1.setBlendMode(BlendMode.OVERLAY);
        } else {
            anch1.setBlendMode(BlendMode.SRC_OVER);
            anch2.setBlendMode(BlendMode.OVERLAY);
            anch3.setBlendMode(BlendMode.OVERLAY);
            anch4.setBlendMode(BlendMode.OVERLAY);
            anch5.setBlendMode(BlendMode.OVERLAY);
            anch6.setBlendMode(BlendMode.OVERLAY);
            anch7.setBlendMode(BlendMode.OVERLAY);
        }

    }


    @FXML
    void click2(MouseEvent event) {
        if (anch2.getBlendMode() == BlendMode.SRC_OVER) {
            anch2.setBlendMode(BlendMode.OVERLAY);
        } else {
            anch1.setBlendMode(BlendMode.OVERLAY);
            anch2.setBlendMode(BlendMode.SRC_OVER);
            anch3.setBlendMode(BlendMode.OVERLAY);
            anch4.setBlendMode(BlendMode.OVERLAY);
            anch5.setBlendMode(BlendMode.OVERLAY);
            anch6.setBlendMode(BlendMode.OVERLAY);
            anch7.setBlendMode(BlendMode.OVERLAY);
        }

    }

    @FXML
    void click3(MouseEvent event) {
        if (anch3.getBlendMode() == BlendMode.SRC_OVER) {
            anch3.setBlendMode(BlendMode.OVERLAY);
        } else {
            anch1.setBlendMode(BlendMode.OVERLAY);
            anch2.setBlendMode(BlendMode.OVERLAY);
            anch3.setBlendMode(BlendMode.SRC_OVER);
            anch4.setBlendMode(BlendMode.OVERLAY);
            anch5.setBlendMode(BlendMode.OVERLAY);
            anch6.setBlendMode(BlendMode.OVERLAY);
            anch7.setBlendMode(BlendMode.OVERLAY);
        }

    }

    @FXML
    void click4(MouseEvent event) {
        if (anch4.getBlendMode() == BlendMode.SRC_OVER) {
            anch4.setBlendMode(BlendMode.OVERLAY);
        } else {
            anch1.setBlendMode(BlendMode.OVERLAY);
            anch2.setBlendMode(BlendMode.OVERLAY);
            anch3.setBlendMode(BlendMode.OVERLAY);
            anch4.setBlendMode(BlendMode.SRC_OVER);
            anch5.setBlendMode(BlendMode.OVERLAY);
            anch6.setBlendMode(BlendMode.OVERLAY);
            anch7.setBlendMode(BlendMode.OVERLAY);
        }

    }

    @FXML
    void click5(MouseEvent event) {
        if (anch5.getBlendMode() == BlendMode.SRC_OVER) {
            anch5.setBlendMode(BlendMode.OVERLAY);
        } else {
            anch1.setBlendMode(BlendMode.OVERLAY);
            anch2.setBlendMode(BlendMode.OVERLAY);
            anch3.setBlendMode(BlendMode.OVERLAY);
            anch4.setBlendMode(BlendMode.OVERLAY);
            anch5.setBlendMode(BlendMode.SRC_OVER);
            anch6.setBlendMode(BlendMode.OVERLAY);
            anch7.setBlendMode(BlendMode.OVERLAY);
        }

    }

    @FXML
    void click6(MouseEvent event) {
        if (anch6.getBlendMode() == BlendMode.SRC_OVER) {
            anch6.setBlendMode(BlendMode.OVERLAY);
        } else {
            anch1.setBlendMode(BlendMode.OVERLAY);
            anch2.setBlendMode(BlendMode.OVERLAY);
            anch3.setBlendMode(BlendMode.OVERLAY);
            anch4.setBlendMode(BlendMode.OVERLAY);
            anch5.setBlendMode(BlendMode.OVERLAY);
            anch6.setBlendMode(BlendMode.SRC_OVER);
            anch7.setBlendMode(BlendMode.OVERLAY);
        }

    }

    @FXML
    void click7(MouseEvent event) {
        if (anch7.getBlendMode() == BlendMode.SRC_OVER) {
            anch7.setBlendMode(BlendMode.OVERLAY);
        } else {
            anch1.setBlendMode(BlendMode.OVERLAY);
            anch2.setBlendMode(BlendMode.OVERLAY);
            anch3.setBlendMode(BlendMode.OVERLAY);
            anch4.setBlendMode(BlendMode.OVERLAY);
            anch5.setBlendMode(BlendMode.OVERLAY);
            anch6.setBlendMode(BlendMode.OVERLAY);
            anch7.setBlendMode(BlendMode.SRC_OVER);
        }

    }


    public void setWeatherEntry(WeatherEntry wea) {
        this.wea = wea;
    }

    public void initPage(MainModel model, Optional<MainPageController> empty) {
        // images
    }

}
