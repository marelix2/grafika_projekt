package stamp.Service.informations;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import stamp.Service.AppCloseService;
import stamp.Service.FileChooserService;

import java.io.IOException;
import java.util.Optional;

public class ExitAlertService {
    public static void showExitAlert(ImageView picView) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText("Do you want save your work?");
        alert.setContentText(null);

        ButtonType buttonTypeOne = new ButtonType("YES");
        ButtonType buttonTypeTwo = new ButtonType("NO");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            FileChooserService.saveToFile(picView.getImage());
        } else if(result.get() == buttonTypeTwo) {
            AppCloseService.closeApp();
        }
            // ... user chose CANCEL or closed the dialog
    }
}

