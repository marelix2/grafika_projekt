package stamp.Service.informations;

import javafx.scene.control.Alert;

public class InstructionService {
    public static void showInstruction() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Manual");
        alert.setHeaderText(null);
        alert.setContentText("1.Wybierz kształt pędzla.\n2.wybierz rozmiar pędzla\n3.Przytrzymując L_Shift kliknij obszar by skopiować do bufora\n4.Kliknij na obraz by wstawić warość z bufora");
        alert.showAndWait();
    }
}
