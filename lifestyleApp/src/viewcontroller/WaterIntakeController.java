package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import model.RatingEntry;
import model.WaterEntry;
import viewcontroller.observers.DateObserver;

import java.util.Optional;

public class WaterIntakeController implements page {
    private WaterEntry we;
    private MainModel model;

    private double totalWaterIntake;

    @FXML
    private Label drinkLabel;

    @FXML
    private AnchorPane water1;

    @FXML
    private AnchorPane water2;

    @FXML
    private AnchorPane water3;

    @FXML
    private AnchorPane water4;

    @FXML
    private AnchorPane water5;

    @FXML
    private AnchorPane water10;

    @FXML
    private AnchorPane water9;

    @FXML
    private AnchorPane water8;

    @FXML
    private AnchorPane water7;

    @FXML
    private AnchorPane water6;

    @FXML
    void intake1(MouseEvent event) {
        if (water1.getBlendMode() == BlendMode.SRC_OVER && water2.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            oneGlass();
        }
    }



    @FXML
    void intake2(MouseEvent event) {
        if (water2.getBlendMode() == BlendMode.SRC_OVER && water3.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            twoGlass();
        }
    }

    @FXML
    void intake3(MouseEvent event) {
        if (water3.getBlendMode() == BlendMode.SRC_OVER && water4.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            threeGlass();
        }
    }

    @FXML
    void intake4(MouseEvent event) {
        if (water4.getBlendMode() == BlendMode.SRC_OVER && water5.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            fourGlass();
        }
    }

    @FXML
    void intake5(MouseEvent event) {
        if (water5.getBlendMode() == BlendMode.SRC_OVER && water6.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            fiveGlass();
        }
    }

    @FXML
    void intake6(MouseEvent event) {
        if (water6.getBlendMode() == BlendMode.SRC_OVER && water7.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            sixGlass();
        }
    }

    @FXML
    void intake7(MouseEvent event) {
        if (water7.getBlendMode() == BlendMode.SRC_OVER && water8.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            sevenGlass();
        }
    }

    @FXML
    void intake8(MouseEvent event) {
        if (water8.getBlendMode() == BlendMode.SRC_OVER && water9.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            eightGlass();
        }
    }

    @FXML
    void intake9(MouseEvent event) {
        if (water9.getBlendMode() == BlendMode.SRC_OVER && water10.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
        } else {
            nineGlass();
        }
    }

    @FXML
    void intake10(MouseEvent event) {
        if (water10.getBlendMode() == BlendMode.SRC_OVER) {
            resetGlasses();
        } else {
            tenGlass();
        }
    }

    private void resetGlasses(){
        water1.setBlendMode(BlendMode.OVERLAY);
        water2.setBlendMode(BlendMode.OVERLAY);
        water3.setBlendMode(BlendMode.OVERLAY);
        water4.setBlendMode(BlendMode.OVERLAY);
        water5.setBlendMode(BlendMode.OVERLAY);
        water6.setBlendMode(BlendMode.OVERLAY);
        water7.setBlendMode(BlendMode.OVERLAY);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("0 L");
        we.setWaterEntry(0);
        model.statsChanged();
    }

    private void oneGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.OVERLAY);
        water3.setBlendMode(BlendMode.OVERLAY);
        water4.setBlendMode(BlendMode.OVERLAY);
        water5.setBlendMode(BlendMode.OVERLAY);
        water6.setBlendMode(BlendMode.OVERLAY);
        water7.setBlendMode(BlendMode.OVERLAY);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("0.2 L");
        we.setWaterEntry(0.2);
        model.statsChanged();
    }

    private void twoGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.OVERLAY);
        water4.setBlendMode(BlendMode.OVERLAY);
        water5.setBlendMode(BlendMode.OVERLAY);
        water6.setBlendMode(BlendMode.OVERLAY);
        water7.setBlendMode(BlendMode.OVERLAY);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("0.4 L");
        we.setWaterEntry(0.4);
        model.statsChanged();
    }

    private void threeGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.OVERLAY);
        water5.setBlendMode(BlendMode.OVERLAY);
        water6.setBlendMode(BlendMode.OVERLAY);
        water7.setBlendMode(BlendMode.OVERLAY);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("0.6 L");
        we.setWaterEntry(0.6);
        model.statsChanged();
    }

    private void fourGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.SRC_OVER);
        water5.setBlendMode(BlendMode.OVERLAY);
        water6.setBlendMode(BlendMode.OVERLAY);
        water7.setBlendMode(BlendMode.OVERLAY);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("0.8 L");
        we.setWaterEntry(0.8);
        model.statsChanged();
    }

    private void fiveGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.SRC_OVER);
        water5.setBlendMode(BlendMode.SRC_OVER);
        water6.setBlendMode(BlendMode.OVERLAY);
        water7.setBlendMode(BlendMode.OVERLAY);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("1.0 L");
        we.setWaterEntry(1.0);
        model.statsChanged();
    }

    private void sixGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.SRC_OVER);
        water5.setBlendMode(BlendMode.SRC_OVER);
        water6.setBlendMode(BlendMode.SRC_OVER);
        water7.setBlendMode(BlendMode.OVERLAY);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("1.2 L");
        we.setWaterEntry(1.2);
        model.statsChanged();
    }

    private void sevenGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.SRC_OVER);
        water5.setBlendMode(BlendMode.SRC_OVER);
        water6.setBlendMode(BlendMode.SRC_OVER);
        water7.setBlendMode(BlendMode.SRC_OVER);
        water8.setBlendMode(BlendMode.OVERLAY);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("1.4 L");
        we.setWaterEntry(1.4);
        model.statsChanged();
    }

    private void eightGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.SRC_OVER);
        water5.setBlendMode(BlendMode.SRC_OVER);
        water6.setBlendMode(BlendMode.SRC_OVER);
        water7.setBlendMode(BlendMode.SRC_OVER);
        water8.setBlendMode(BlendMode.SRC_OVER);
        water9.setBlendMode(BlendMode.OVERLAY);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("1.6 L");
        we.setWaterEntry(1.6);
        model.statsChanged();
    }

    private void nineGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.SRC_OVER);
        water5.setBlendMode(BlendMode.SRC_OVER);
        water6.setBlendMode(BlendMode.SRC_OVER);
        water7.setBlendMode(BlendMode.SRC_OVER);
        water8.setBlendMode(BlendMode.SRC_OVER);
        water9.setBlendMode(BlendMode.SRC_OVER);
        water10.setBlendMode(BlendMode.OVERLAY);
        drinkLabel.setText("1.8 L");
        we.setWaterEntry(1.8);
        model.statsChanged();
    }

    private void tenGlass(){
        water1.setBlendMode(BlendMode.SRC_OVER);
        water2.setBlendMode(BlendMode.SRC_OVER);
        water3.setBlendMode(BlendMode.SRC_OVER);
        water4.setBlendMode(BlendMode.SRC_OVER);
        water5.setBlendMode(BlendMode.SRC_OVER);
        water6.setBlendMode(BlendMode.SRC_OVER);
        water7.setBlendMode(BlendMode.SRC_OVER);
        water8.setBlendMode(BlendMode.SRC_OVER);
        water9.setBlendMode(BlendMode.SRC_OVER);
        water10.setBlendMode(BlendMode.SRC_OVER);
        drinkLabel.setText("2.0 L");
        we.setWaterEntry(2.0);
        model.statsChanged();
    }


    public void initPage(MainModel model, Optional<MainPageController> empty) {
        this.model = model;
        this.we = model.getWaterIntake();
        setIntake();
    }


    private void setIntake(){
        switch (Double.toString(we.getWaterEntry())){
            case "0.0":
                resetGlasses();
                break;
            case "0.2":
                oneGlass();
                break;
            case "0.4":
                twoGlass();
                break;
            case "0.6":
                threeGlass();
                break;
            case "0.8":
                fourGlass();
                break;
            case "1.0":
                fiveGlass();
                break;
            case "1.2":
                sixGlass();
                break;
            case "1.4":
                sevenGlass();
                break;
            case "1.6":
                eightGlass();
                break;
            case "1.8":
                nineGlass();
                break;
            case "2.0":
                tenGlass();
                break;
        }
    }

}