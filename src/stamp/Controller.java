package stamp;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import stamp.Listenrs.cursor.CircleCursor;
import stamp.Listenrs.SavingImageListener;
import stamp.Listenrs.cursor.SquareCursor;
import stamp.Service.informations.AboutInfoService;
import stamp.Service.AppCloseService;
import stamp.Service.FileChooserService;
import stamp.Service.informations.ExitAlertService;
import stamp.Service.informations.InstructionService;
import stamp.controlers.CursorControler;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Jarek
 */

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
    private MenuItem fileSaveAs;

    @FXML
    private MenuItem about;

    @FXML
    private Button circleButton;

    @FXML
    private Button squareButton;

    @FXML
    private MenuItem instruction;

    private ObservableValue<File> selectedImage = new SimpleObjectProperty<>();

    private ObservableValue<ImageCursor> selectedCursor = new SimpleObjectProperty<>();
    CircleCursor circleCursor = new CircleCursor();
    SquareCursor squareCursor = new SquareCursor();




    boolean isCircle = true;



    @FXML
    public void initialize(){
        sizeSlider.setMin(1);
        CursorControler cursorControler = new CursorControler(this.picView);
        cursorControler.addEventListener();


        sizeSlider.valueProperty().addListener((observable,oldValue,newValue)-> {
            sizeSlider.setValue(newValue.intValue());
            sizeLabel.setText("Size:" + newValue.intValue());
            CursorSizeUpdate(cursorControler);

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

        fileSaveAs.setOnAction(e->{
            try {
                FileChooserService.saveToFile(picView.getImage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        about.setOnAction(e-> AboutInfoService.showAbout());

        instruction.setOnAction(e-> InstructionService.showInstruction());

        circleButton.setOnAction( e -> {
            isCircle = true;
            selectedCursor = new SimpleObjectProperty<>(circleCursor.generateCursorShape(sizeSlider.getValue()));
            cursorControler.setImageCursor(selectedCursor.getValue());
            cursorControler.setCircle(isCircle);
            cursorControler.setRadius(sizeSlider.getValue());

        });

        squareButton.setOnAction( e ->{
            isCircle = false;
            selectedCursor = new SimpleObjectProperty<>(squareCursor.generateCursorShape(sizeSlider.getValue()));
            cursorControler.setImageCursor(selectedCursor.getValue());
            cursorControler.setCircle(isCircle);
            cursorControler.setRadius(sizeSlider.getValue());
        });


        fileClose.setOnAction(e -> {
            try {
                ExitAlertService.showExitAlert(picView);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

    public Controller() {

    }


    public void CursorSizeUpdate(CursorControler cursorControler){
        if(isCircle){

            selectedCursor = new SimpleObjectProperty<>(circleCursor.generateCursorShape(sizeSlider.getValue()));
            cursorControler.setImageCursor(selectedCursor.getValue());
            cursorControler.setCircle(isCircle);
            cursorControler.setRadius(sizeSlider.getValue());

        }else {
            selectedCursor = new SimpleObjectProperty<>(squareCursor.generateCursorShape(sizeSlider.getValue()));
            cursorControler.setImageCursor(selectedCursor.getValue());
            cursorControler.setCircle(isCircle);
            cursorControler.setRadius(sizeSlider.getValue());
        }
    }



}
