package stamp.Service;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Jarek
 */

public class FileChooserService {
    public static Optional<File> selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("BITMAPS","*.bmp"));
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setTitle("Open file to edit...");
        File selectedFile = fileChooser.showOpenDialog(null);
        return Optional.of(selectedFile);
    }

    public static void saveToFile(Image image) throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files","*.png"));
        File file = fileChooser.showSaveDialog(null);
        System.out.println(file);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        System.out.println(bufferedImage);
            ImageIO.write(bufferedImage, "PNG", file);
        System.out.println(file);

    }
}
