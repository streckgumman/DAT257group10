package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MainModel;
import model.RatingEntry;
import model.WaterEntry;

import java.util.Optional;

public class WaterIntakeController {
    private WaterEntry we;

    double totalWaterIntake;

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
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 0.2;

        }
    }



    @FXML
    void intake2(MouseEvent event) {
        if (water2.getBlendMode() == BlendMode.SRC_OVER && water3.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 0.4;

        }
    }

    @FXML
    void intake3(MouseEvent event) {
        if (water3.getBlendMode() == BlendMode.SRC_OVER && water4.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 0.6;

        }
    }

    @FXML
    void intake4(MouseEvent event) {
        if (water4.getBlendMode() == BlendMode.SRC_OVER && water5.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 0.8;

        }
    }

    @FXML
    void intake5(MouseEvent event) {
        if (water5.getBlendMode() == BlendMode.SRC_OVER && water6.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            drinkLabel.setText("1 L");
            totalWaterIntake = 1;

        }
    }

    @FXML
    void intake6(MouseEvent event) {
        if (water6.getBlendMode() == BlendMode.SRC_OVER && water7.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 1.2;

        }
    }

    @FXML
    void intake7(MouseEvent event) {
        if (water7.getBlendMode() == BlendMode.SRC_OVER && water8.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 1.4;

        }
    }

    @FXML
    void intake8(MouseEvent event) {
        if (water8.getBlendMode() == BlendMode.SRC_OVER && water9.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 1.6;

        }
    }

    @FXML
    void intake9(MouseEvent event) {
        if (water9.getBlendMode() == BlendMode.SRC_OVER && water10.getBlendMode() == BlendMode.OVERLAY) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            totalWaterIntake = 1.8;

        }
    }

    @FXML
    void intake10(MouseEvent event) {
        if (water10.getBlendMode() == BlendMode.SRC_OVER) {
            resetGlasses();
            totalWaterIntake = 0;
            drinkLabel.setText("0 L");
        } else {
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
            drinkLabel.setText("2 L");
            totalWaterIntake = 2;

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
    }

    public void initPage(MainModel model, Optional<Object> empty) {
        // images
        resetGlasses();
    }


    public void setWaterEntry(WaterEntry we) {
        this.we = we;
    }


}