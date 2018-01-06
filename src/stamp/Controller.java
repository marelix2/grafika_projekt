package stamp;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import stamp.Listenrs.CircleCursor;
import stamp.Listenrs.SavingImageListener;
import stamp.Listenrs.SquareCursor;
import stamp.Service.AppCloseService;
import stamp.Service.FileChooserService;
import stamp.controlers.CursorControler;


import java.beans.EventHandler;
import java.io.File;
import java.io.FileNotFoundException;
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

    @FXML
    private Button circleButton;

    @FXML
    private Button squareButton;

    private ObservableValue<File> selectedImage = new SimpleObjectProperty<>();

    private ObservableValue<ImageCursor> selectedCursor = new SimpleObjectProperty<>();




    @FXML
    public void initialize(){
        sizeSlider.setMin(1);

        sizeSlider.valueProperty().addListener((observable,oldValue,newValue)-> {
            sizeSlider.setValue(newValue.intValue());
            sizeLabel.setText("Size:" + newValue.intValue());
        });

        fileOpen.setOnAction(e ->{
              selectedImage = new SimpleObjectProperty<>(FileChooserService.selectFile().orElse(selectedImage.getValue()));
             SavingImageListener savingImageListener = new SavingImageListener(this.picView);

            try {
                savingImageListener.addImageView(selectedImage.getValue());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

        });

        circleButton.setOnAction( e -> {
            CircleCursor circleCursor = new CircleCursor();
            selectedCursor = new SimpleObjectProperty<>(circleCursor.generateCursorShape(sizeSlider.getValue()));
            System.out.print(selectedCursor.toString());


        });

        squareButton.setOnAction( e ->{
            SquareCursor squareCursor = new SquareCursor();
            selectedCursor = new SimpleObjectProperty<>(squareCursor.generateCursorShape(sizeSlider.getValue()));
            System.out.print("chuj");

        });




        fileClose.setOnAction(e -> AppCloseService.closeApp());

    }

    public void handleWindowShownEvent() {
        this.CursorControlerManagment();

    }

    public void CursorControlerManagment(){

        CursorControler cursorControler = new CursorControler(this.picView);
        cursorControler.addEventListener(this.selectedCursor.getValue());
        System.out.print(selectedCursor.toString());



    }


    public Controller() {

    }


}
