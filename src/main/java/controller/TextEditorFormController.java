package controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

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
    public AnchorPane pneMain;

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

    public void mnuNewOnAction(ActionEvent actionEvent) throws IOException {
        if (txtEditor.getHtmlText().isEmpty()){
            loadNewWindow();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to save this file ?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)){
                mnuSaveOnAction(new ActionEvent());
            }else {
                loadNewWindow();
            }
        }
    }
    private void loadNewWindow() throws IOException {
        Stage stage = (Stage) pneMain.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/TextEditorForm.fxml"))));
        stage.show();

    }

    public void mnuOpenOnAction(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser=new FileChooser();
       fileChooser.setTitle("Open a File");
        File file = fileChooser.showOpenDialog(null);

        if (file!=null){
            Path path = Paths.get(file.getAbsolutePath());
            byte[] bytes = Files.readAllBytes(path);
            txtEditor.setHtmlText(new String(bytes));
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to select path again ?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Open Path Confirmation");
            Optional<ButtonType> buttonType=alert.showAndWait();
            if (buttonType.get().equals(ButtonType.YES)){
                mnuOpenOnAction(new ActionEvent());
            }else {
                return;
            }

        }
    }

    public void mnuSaveOnAction(ActionEvent actionEvent) {
    }

    public void mnuPrintOnAction(ActionEvent actionEvent) {
    }

    public void mnuCloseOnAction(ActionEvent actionEvent) {
        Stage stage= (Stage) pneMain.getScene().getWindow();
        if (txtEditor.getHtmlText().isEmpty()){
            stage.close();
        }else {
            mnuSaveOnAction(new ActionEvent());
        }
    }

    public void mnuCutOnAction(ActionEvent actionEvent) {
        setSelectedText();
        txtEditor.setHtmlText(txtEditor.getHtmlText().replace(txtEditor.getHtmlText()," "));

    }
    private void setSelectedText(){
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(txtEditor.getHtmlText());
        systemClipboard.setContent(clipboardContent);
    }

    public void mnuCopyOnAction(ActionEvent actionEvent) {
        setSelectedText();
    }

    public void mnuPasteOnAction(ActionEvent actionEvent) {
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        String string = systemClipboard.getString();
    }

    public void mnuSelectAllOnAction(ActionEvent actionEvent) {

    }
}
