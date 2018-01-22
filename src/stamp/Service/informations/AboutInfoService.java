package stamp.Service.informations;

import javafx.scene.control.Alert;

public class AboutInfoService {
    public static void showAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacje");
        alert.setHeaderText(null);
        alert.setContentText("Aplikacja została stworzona w ramach zajęć projektowych z podstaw grafiki komputerowej.\nAutorzy:\nMichał Rusinek\nJarosław Składanowski");

        alert.showAndWait();
    }
}
