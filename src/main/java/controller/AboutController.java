package controller;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.xml.stream.FactoryConfigurationError;

public class AboutController {
    public Text txtAbout;
    public ImageView imgView;
    public AnchorPane anchrPane;

    public void initialize(){


//        RotateTransition rt=new RotateTransition(Duration.millis(550),imgView);
//        rt.setFromAngle(0);
//        rt.setToAngle(270);
//        rt.playFromStart();
//
//        TranslateTransition tt= new TranslateTransition(Duration.millis(500),imgView);
//        tt.setFromX(-500);
//        tt.setFromY(50);
//        tt.playFromStart();

        FadeTransition ff=new FadeTransition(Duration.millis(78),anchrPane);
                ff.setFromValue(0);
        ff.setToValue(1);
        ff.playFromStart();

        ScaleTransition t  = new ScaleTransition(Duration.millis(750),anchrPane);
        t.setFromX(0);
        t.setFromY(0);
        t.setToX(1);
        t.setToY(1);
        t.playFromStart();


//        RotateTransition rt=new RotateTransition(Duration.millis(1200),anchrPane);
//        rt.setToAngle(0);
//        rt.setToAngle(360);
//        rt.playFromStart();
    }
}
