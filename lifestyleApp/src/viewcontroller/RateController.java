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
        if (star1anchor.getBlendMode() == BlendMode.SRC_OVER && star2anchor.getBlendMode() == BlendMode.OVERLAY) {
            resetStars();
            re.setRating(0);
        } else {
            star1anchor.setBlendMode(BlendMode.SRC_OVER);
            star2anchor.setBlendMode(BlendMode.OVERLAY);
            star3anchor.setBlendMode(BlendMode.OVERLAY);
            star4anchor.setBlendMode(BlendMode.OVERLAY);
            star5anchor.setBlendMode(BlendMode.OVERLAY);
            re.setRating(1);
        }
    }

    @FXML
    void rate2star(MouseEvent event) {
        if (star2anchor.getBlendMode() == BlendMode.SRC_OVER && star3anchor.getBlendMode() == BlendMode.OVERLAY) {
            resetStars();
        } else {
            star1anchor.setBlendMode(BlendMode.SRC_OVER);
            star2anchor.setBlendMode(BlendMode.SRC_OVER);
            star3anchor.setBlendMode(BlendMode.OVERLAY);
            star4anchor.setBlendMode(BlendMode.OVERLAY);
            star5anchor.setBlendMode(BlendMode.OVERLAY);
            re.setRating(2);
        }
    }

    @FXML
    void rate3star(MouseEvent event) {
        if (star3anchor.getBlendMode() == BlendMode.SRC_OVER && star4anchor.getBlendMode() == BlendMode.OVERLAY) {
            resetStars();
        } else {
            star1anchor.setBlendMode(BlendMode.SRC_OVER);
            star2anchor.setBlendMode(BlendMode.SRC_OVER);
            star3anchor.setBlendMode(BlendMode.SRC_OVER);
            star4anchor.setBlendMode(BlendMode.OVERLAY);
            star5anchor.setBlendMode(BlendMode.OVERLAY);
            re.setRating(3);
        }
    }

    @FXML
    void rate4star(MouseEvent event) {
        if (star4anchor.getBlendMode() == BlendMode.SRC_OVER && star5anchor.getBlendMode() == BlendMode.OVERLAY) {
            resetStars();
        } else {
            star1anchor.setBlendMode(BlendMode.SRC_OVER);
            star2anchor.setBlendMode(BlendMode.SRC_OVER);
            star3anchor.setBlendMode(BlendMode.SRC_OVER);
            star4anchor.setBlendMode(BlendMode.SRC_OVER);
            star5anchor.setBlendMode(BlendMode.OVERLAY);
            re.setRating(4);
        }
    }

    @FXML
    void rate5star(MouseEvent event) {
        if (star5anchor.getBlendMode() == BlendMode.SRC_OVER) {
            resetStars();
        } else {
            star1anchor.setBlendMode(BlendMode.SRC_OVER);
            star2anchor.setBlendMode(BlendMode.SRC_OVER);
            star3anchor.setBlendMode(BlendMode.SRC_OVER);
            star4anchor.setBlendMode(BlendMode.SRC_OVER);
            star5anchor.setBlendMode(BlendMode.SRC_OVER);
            re.setRating(5);
        }
    }

    private void resetStars(){
        star1anchor.setBlendMode(BlendMode.OVERLAY);
        star2anchor.setBlendMode(BlendMode.OVERLAY);
        star3anchor.setBlendMode(BlendMode.OVERLAY);
        star4anchor.setBlendMode(BlendMode.OVERLAY);
        star5anchor.setBlendMode(BlendMode.OVERLAY);
        re.setRating(0);
    }

    public void initPage(MainModel model, Optional<Object> empty) {
        topic.setText(re.getTopic());
        //filledBlend.setMode(BlendMode.SRC_OVER);
        //fadeBlend.setMode(BlendMode.OVERLAY);

        // images
        star1anchor.setBlendMode(BlendMode.OVERLAY);
    }

    public void setRating(RatingEntry re) {
        this.re = re;
    }
}
