package stamp.Listenrs.cursor;


import javafx.scene.ImageCursor;

import javax.swing.text.html.ImageView;

/**
 * Created by Michał on 06.01.2018.
 */
public interface CursorStategy {

    ImageCursor generateCursorShape(double radius);

}
