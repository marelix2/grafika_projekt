package stamp.Listenrs;

import javafx.scene.ImageCursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Michał on 06.01.2018.
 */
public class CircleCursor implements CursorStategy {
    @Override
    public ImageCursor generateCursorShape(double radius) {
        Circle circle = new Circle(radius,Color.BLACK);

        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);

        Image image = circle.snapshot(sp, null);

        return new ImageCursor(image);
    }
}
