package stamp;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import stamp.Service.AppCloseService;
import stamp.Service.FileChooserService;


import java.beans.EventHandler;
import java.io.File;
import java.util.EventListener;


public class Controller {

    @FXML
    private Slider sizeSlider;

    @FXML
    private Label sizeLabel;

    @FXML
    private ImageView picView;

    @FXML
    private MenuItem fileOpen;

    @FXML
    private Button fileChooserButton;

    @FXML
    private MenuItem fileClose;

    private ObservableValue<File> selectedImage = new SimpleObjectProperty<>();

    @FXML
    public void initialize(){
        sizeSlider.setMin(1);

        sizeSlider.valueProperty().addListener((observable,oldValue,newValue)-> {
            sizeSlider.setValue(newValue.intValue());
            sizeLabel.setText("Size:" + newValue.intValue());
        });

        fileOpen.setOnAction(e -> FileChooserService.selectFile());

        fileClose.setOnAction(e -> AppCloseService.closeApp());

    }

    public Controller() {

    }
}
