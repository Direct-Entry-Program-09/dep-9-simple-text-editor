package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TextEditorFormController {
    public MenuBar mnuBar;
    public MenuItem mnuNew;
    public MenuItem mnuOpen;
    public MenuItem mnuSave;
    public MenuItem mnuPrint;
    public MenuItem mnuClose;
    public MenuItem mnuCut;
    public MenuItem mnuCopy;
    public MenuItem mnuPaste;
    public MenuItem mnuSelectAll;
    public MenuItem mnuAbout;
    public HTMLEditor txtEditor;

    public void initialize(){


        mnuNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtEditor.setHtmlText("");
            }
        });
        mnuClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        mnuAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL resource = this.getClass().getResource("/view/About.fxml");
                try {
                    Parent container= FXMLLoader.load(resource);
                    Scene scene=new Scene(container);

                    Stage s = new Stage();
                    s.setScene(scene);
                    s.setTitle("About");
                    s.initModality(Modality.APPLICATION_MODAL);
                    s.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void mnuNewOnAction(ActionEvent actionEvent) {
    }

    public void mnuOpenOnAction(ActionEvent actionEvent) {
    }

    public void mnuSaveOnAction(ActionEvent actionEvent) {
    }

    public void mnuPrintOnAction(ActionEvent actionEvent) {
    }

    public void mnuCloseOnAction(ActionEvent actionEvent) {
    }

    public void mnuCutOnAction(ActionEvent actionEvent) {
    }

    public void mnuCopyOnAction(ActionEvent actionEvent) {
    }

    public void mnuPasteOnAction(ActionEvent actionEvent) {
    }

    public void mnuSelectAllOnAction(ActionEvent actionEvent) {
    }
}
