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
import model.Ratings;

import javax.swing.text.html.ImageView;
import java.util.Optional;

public class RateController {
    private Ratings r;
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
            oneStars();
            re.setRating(1);
        }
    }

    @FXML
    void rate2star(MouseEvent event) {
        if (star2anchor.getBlendMode() == BlendMode.SRC_OVER && star3anchor.getBlendMode() == BlendMode.OVERLAY) {
            resetStars();
            re.setRating(0);
        } else {
            twoStars();
            re.setRating(2);
        }
    }

    @FXML
    void rate3star(MouseEvent event) {
        if (star3anchor.getBlendMode() == BlendMode.SRC_OVER && star4anchor.getBlendMode() == BlendMode.OVERLAY) {
            resetStars();
            re.setRating(0);
        } else {
            threeStars();
            re.setRating(3);
        }
    }

    @FXML
    void rate4star(MouseEvent event) {
        if (star4anchor.getBlendMode() == BlendMode.SRC_OVER && star5anchor.getBlendMode() == BlendMode.OVERLAY) {
            resetStars();
            re.setRating(0);
        } else {
            fourStars();
            re.setRating(4);
        }
    }

    @FXML
    void rate5star(MouseEvent event) {
        if (star5anchor.getBlendMode() == BlendMode.SRC_OVER) {
            resetStars();
            re.setRating(0);
        } else {
            fiveStars();
            re.setRating(5);
        }
    }
    private void oneStars(){
        star1anchor.setBlendMode(BlendMode.SRC_OVER);
        star2anchor.setBlendMode(BlendMode.OVERLAY);
        star3anchor.setBlendMode(BlendMode.OVERLAY);
        star4anchor.setBlendMode(BlendMode.OVERLAY);
        star5anchor.setBlendMode(BlendMode.OVERLAY);
    }

    private void twoStars(){
        star1anchor.setBlendMode(BlendMode.SRC_OVER);
        star2anchor.setBlendMode(BlendMode.SRC_OVER);
        star3anchor.setBlendMode(BlendMode.OVERLAY);
        star4anchor.setBlendMode(BlendMode.OVERLAY);
        star5anchor.setBlendMode(BlendMode.OVERLAY);
    }

    private void threeStars(){
        star1anchor.setBlendMode(BlendMode.SRC_OVER);
        star2anchor.setBlendMode(BlendMode.SRC_OVER);
        star3anchor.setBlendMode(BlendMode.SRC_OVER);
        star4anchor.setBlendMode(BlendMode.OVERLAY);
        star5anchor.setBlendMode(BlendMode.OVERLAY);
    }

    private void fourStars(){
        star1anchor.setBlendMode(BlendMode.SRC_OVER);
        star2anchor.setBlendMode(BlendMode.SRC_OVER);
        star3anchor.setBlendMode(BlendMode.SRC_OVER);
        star4anchor.setBlendMode(BlendMode.SRC_OVER);
        star5anchor.setBlendMode(BlendMode.OVERLAY);
    }

    private void fiveStars(){
        star1anchor.setBlendMode(BlendMode.SRC_OVER);
        star2anchor.setBlendMode(BlendMode.SRC_OVER);
        star3anchor.setBlendMode(BlendMode.SRC_OVER);
        star4anchor.setBlendMode(BlendMode.SRC_OVER);
        star5anchor.setBlendMode(BlendMode.SRC_OVER);
    }

    private void resetStars(){
        star1anchor.setBlendMode(BlendMode.OVERLAY);
        star2anchor.setBlendMode(BlendMode.OVERLAY);
        star3anchor.setBlendMode(BlendMode.OVERLAY);
        star4anchor.setBlendMode(BlendMode.OVERLAY);
        star5anchor.setBlendMode(BlendMode.OVERLAY);
    }

    public void initPage(MainModel model, Optional<Object> empty) {
        r.addRatingEntry(model.getDate());
        this.re = r.getRating(model.getDate());
        setStars();

    }

    private void setStars(){
        switch (re.getRating()){
            case 0:
                resetStars();
                break;
            case 1:
                oneStars();
                break;
            case 2:
                twoStars();
                break;
            case 3:
                threeStars();
                break;
            case 4:
                fourStars();
                break;
            case 5:
                fiveStars();
                break;
        }
    }

    public void setRating(Ratings r) {
        this.r = r;
    }
}
