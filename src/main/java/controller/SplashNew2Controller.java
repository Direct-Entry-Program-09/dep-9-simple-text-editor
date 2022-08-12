package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashNew2Controller {
    public Label lblLoading;

    public void initialize(){
        Timeline timeline=new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Initializing ...");
            }
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Initializing ...2");
            }
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Initializing ...3");
            }
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Initializing ...4");
            }
        });
        KeyFrame keyFrame5 = new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL resource=this.getClass().getResource("/view/TextEditorForm.fxml");
                Parent container= null;
                try {
                    container = FXMLLoader.load(resource);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene editorScene=new Scene(container);
                Stage s = new Stage();
                s.setScene(editorScene);
                s.setTitle("Simple Text Editor");
                s.show();

            }
        });
        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5);
        timeline.playFromStart();




    }
}
