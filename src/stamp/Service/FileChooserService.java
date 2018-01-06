package stamp.Service;

import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class FileChooserService {
    public static Optional<File> selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BITMAPS","*.bmp"));
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setTitle("Open file to edit...");
        File selectedFile = fileChooser.showOpenDialog(null);
        return Optional.of(selectedFile);
    }
}
