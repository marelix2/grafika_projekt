package stamp.controlers;

import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import stamp.Controller;
import stamp.Listenrs.CircleCursor;




/**
 * Created by Michał on 06.01.2018.
 */
public class CursorControler {

    private ImageView  imageView;



    public CursorControler(ImageView imageView){
        this.imageView = imageView;

    }

    public void addEventListener(ImageCursor imageCursor){


        this.imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {

            if (event.isShiftDown()) {
                this.imageView.getScene().setCursor(imageCursor);

            }

        });

       this.imageView.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {

           if (event.isShiftDown()) {
               this.imageView.getScene().setCursor(imageCursor);
               System.out.println(imageCursor.toString());

           }

       });

       this.imageView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {

               this.imageView.getScene().setCursor(Cursor.DEFAULT);
               System.out.println(imageCursor.toString());

       });


   }
}
