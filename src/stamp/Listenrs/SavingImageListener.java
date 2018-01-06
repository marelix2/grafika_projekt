package stamp.Listenrs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Michał on 06.01.2018.
 */
public class SavingImageListener {

    ImageView imageView;

    public SavingImageListener(ImageView imageView){

        this.imageView = imageView;

    }

    public void addImageView(File imagePath) throws FileNotFoundException {

        Image image = new Image(new FileInputStream(imagePath));
        this.imageView.setImage(image);

    }
}
