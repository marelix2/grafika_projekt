package stamp.Listenrs;

import javafx.scene.ImageCursor;
import javafx.scene.SnapshotParameters;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Michał on 06.01.2018.
 */
public class SquareCursor implements CursorStategy {
    @Override
    public ImageCursor generateCursorShape(double radius) {
        Rectangle rec = new Rectangle();
       rec.setWidth(radius*2);
       rec.setHeight(radius*2);
       rec.setStroke(Color.BLACK);

        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);

        Image image = rec.snapshot(sp, null);

        return new ImageCursor(image);
    }
}
