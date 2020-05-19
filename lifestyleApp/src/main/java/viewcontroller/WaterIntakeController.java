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
    private double glassVolume;

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
        drinkLabel.setText(Double.toString(glassVolume));
        we.setWaterEntry(glassVolume);
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
        drinkLabel.setText(Double.toString(glassVolume*2));
        we.setWaterEntry(glassVolume*2);
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
        drinkLabel.setText(Double.toString(glassVolume*3));
        we.setWaterEntry(glassVolume*3);
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
        drinkLabel.setText(Double.toString(glassVolume*4));
        we.setWaterEntry(glassVolume*4);
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
        drinkLabel.setText(Double.toString(glassVolume*5));
        we.setWaterEntry(glassVolume*5);
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
        drinkLabel.setText(Double.toString(glassVolume*6));
        we.setWaterEntry(glassVolume*6);
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
        drinkLabel.setText(Double.toString(glassVolume*7));
        we.setWaterEntry(glassVolume*7);
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
        drinkLabel.setText(Double.toString(glassVolume*8));
        we.setWaterEntry(glassVolume*8);
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
        drinkLabel.setText(Double.toString(glassVolume*9));
        we.setWaterEntry(glassVolume*9);
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
        drinkLabel.setText(Double.toString(glassVolume*10));
        we.setWaterEntry(glassVolume*10);
        model.statsChanged();
    }


    public void initPage(MainModel model, Optional<MainPageController> empty) {
        this.model = model;
        this.we = model.getWaterIntake();
        this.glassVolume = we.getGlassVolume();
        setIntake();

    }


    private void setIntake(){
        int filledGlasses = (int) (we.getWaterEntry()/glassVolume);

        switch (filledGlasses){
            case 0:
                resetGlasses();
                break;
            case 1:
                oneGlass();
                break;
            case 2:
                twoGlass();
                break;
            case 3:
                threeGlass();
                break;
            case 4:
                fourGlass();
                break;
            case 5:
                fiveGlass();
                break;
            case 6:
                sixGlass();
                break;
            case 7:
                sevenGlass();
                break;
            case 8:
                eightGlass();
                break;
            case 9:
                nineGlass();
                break;
            case 10:
                tenGlass();
                break;
        }
    }

}