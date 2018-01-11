package stamp.Listenrs.cursor;

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
        Circle circle = new Circle(radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.rgb(0 ,0 ,0, 0.0 ));

        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.rgb(0 ,0 ,0, 0.0 ));

        Image image = circle.snapshot(sp, null);

        return new ImageCursor(image);
    }
}
