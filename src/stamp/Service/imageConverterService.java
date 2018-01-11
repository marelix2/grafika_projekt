package stamp.Service;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Created by Michał on 10.01.2018.
 */
public class imageConverterService {

    public static WritableImage convertToWritable(Image image) {
        WritableImage writableImage = new WritableImage((int)image.getWidth(), (int)image.getHeight());
        PixelReader pixelReader = image.getPixelReader();
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                pixelWriter.setArgb(x, y, pixelReader.getArgb(x, y));
            }
        }

        return writableImage;
    }
}
