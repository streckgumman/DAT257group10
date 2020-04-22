package viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import model.RatingEntry;

import javax.swing.text.html.ImageView;
import java.util.Optional;

public class RateController {
    private RatingEntry re;


    @FXML
    private Label topic;

    @FXML
    private AnchorPane star1anchor;

    @FXML
    private AnchorPane star2anchor;

    @FXML
    private AnchorPane star3anchor;

    @FXML
    private AnchorPane star4anchor;

    @FXML
    private AnchorPane star5anchor;

    @FXML
    void rate1star(MouseEvent event) {
        if (star1anchor.getBlendMode() == BlendMode.SRC_OVER && star2anchor.getBlendMode() == BlendMode.SRC_OVER)
            re.setRating(1);
        star1anchor.setBlendMode(BlendMode.SRC_OVER);
    }

    @FXML
    void rate2star(MouseEvent event) {

    }

    @FXML
    void rate3star(MouseEvent event) {

    }

    @FXML
    void rate4star(MouseEvent event) {

    }

    @FXML
    void rate5star(MouseEvent event) {

    }

    public void initPage(MainModel model, Optional<Object> empty) {
        topic.setText(re.getName());
        //filledBlend.setMode(BlendMode.SRC_OVER);
        //fadeBlend.setMode(BlendMode.OVERLAY);

        // images
        star1anchor.setBlendMode(BlendMode.OVERLAY);
    }

    public void setRating(RatingEntry re) {
        this.re = re;
    }
}
