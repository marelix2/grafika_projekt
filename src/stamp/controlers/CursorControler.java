package stamp.controlers;

import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;


/**
 * Created by Michał on 06.01.2018.
 */
public class CursorControler {

    private ImageView  imageView;
    private MarkerController markerController;
    private ArrayList<Integer> pixels =new ArrayList<>();

    ImageCursor imageCursor;

    public void setImageCursor(ImageCursor imageCursor) {
        this.imageCursor = imageCursor;
    }

    public void setCircle(boolean circle) {
        isCircle = circle;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    boolean isCircle;
    double radius;




    public CursorControler(ImageView imageView){
        this.imageView = imageView;


    }

    public void addEventListener(){


        this.imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {

            if (event.isShiftDown()) {
                this.imageView.getScene().setCursor(imageCursor);

            }

        });

       this.imageView.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {

           if (event.isShiftDown()) {
               this.imageView.getScene().setCursor(imageCursor);
               //System.out.println(imageCursor.toString());

           }

       });

       this.imageView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {

               this.imageView.getScene().setCursor(Cursor.DEFAULT);
              // System.out.println(imageCursor.toString());

       });

       this.imageView.addEventHandler(MouseEvent.MOUSE_CLICKED , event -> {

           this.markerController = new MarkerController(this.imageView,this.imageView.getImage().getPixelReader());



           if (event.isShiftDown()) {

               markerController.CopyPixels((int) event.getX(), (int) event.getY(), radius, isCircle );
               pixels = markerController.getPixels();

           }else {


               if(!pixels.isEmpty())
                   markerController.putImage(event.getX(),event.getY(), radius,pixels);
                    System.out.println("X : "+ event.getX() + " Y: "+event.getY() );



           }



       });


   }
}
