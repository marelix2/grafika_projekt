package stamp.controlers;



import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import stamp.Service.imageConverterService;

import java.util.ArrayList;


/**
 * Created by Michał on 10.01.2018.
 */
public class MarkerController {

    private  PixelReader pixelReader;
    private ImageView imageView;
    private boolean isCircle;


    public ArrayList<Integer> getPixels() {
        return pixels;
    }

    private ArrayList<Integer> pixels = new ArrayList<>();




    public MarkerController(ImageView imageView, PixelReader pixelReader) {
        this.imageView = imageView;
        this.pixelReader = pixelReader;

    }


    public void CopyPixels(int x , int y, double radius, boolean isCircle){


        if(isCircle) {
            this.CircleShape( x , y, radius);
        }
        else{
            this.SquareShape( x , y, radius);
        }



    }


    public  void CircleShape(int x, int y, double radius){

        for(int tmpX = (int)(x - radius); tmpX <= (int)(x + radius); tmpX++) {
            for (int tmpY = (int)(y - radius); tmpY <= (int)(y + radius); tmpY++) {
                double squaredDx = Math.pow((tmpX - x), 2);
                double squaredDy = Math.pow((tmpY - y), 2);
                double rootDistance = Math.sqrt(squaredDx + squaredDy);

                    if (rootDistance <= radius) {
                        try {
                            pixels.add(pixelReader.getArgb(tmpX, tmpY));

                        } catch (IndexOutOfBoundsException e) {
                            pixels.add(null);
                        }
                    }

            }
        }


    }

    public void SquareShape( int x, int y, double radius){

        radius *=2;

        for(int tmpX = 0; tmpX <= (int)radius; tmpX++) {
            for (int tmpY = 0 ; tmpY <= (int)(radius); tmpY++) {

                    try {
                        pixels.add(pixelReader.getArgb(tmpX,tmpY));
                    } catch (IndexOutOfBoundsException e) {
                        pixels.add(null);
                    }


            }
        }

    }

    public void putImage(double x, double y, double radius, ArrayList<Integer> pixelss, boolean isCircle){

        if(isCircle) {
            this.circleMarker( x , y, radius, pixelss);
        }
        else{
            this.squareMarker( x , y, radius,pixelss);
        }


    }


    public void circleMarker (double x, double y, double radius, ArrayList<Integer> pixelss){

        imageConverterService imageConverterService = new imageConverterService();
        WritableImage dest = imageConverterService.convertToWritable(this.imageView.getImage());
        PixelWriter writer = dest.getPixelWriter();


        int width =  (int) this.imageView.getImage().getWidth();
        int height = (int) this.imageView.getImage().getHeight();

        int listIndex = 0;
        for(int tmpX = (int)(x - radius); tmpX <= (int)(x + radius); tmpX++) {
            for (int tmpY = (int)(y - radius); tmpY <= (int)(y + radius); tmpY++) {
                double squaredDx = Math.pow((tmpX - x), 2);
                double squaredDy = Math.pow((tmpY - y), 2);
                double rootDistance = Math.sqrt(squaredDx + squaredDy);
                if (rootDistance <= radius) {
                    boolean isPixelInImage = tmpX >= 0  && tmpX < width && tmpY >= 0 && tmpY < height;
                    //System.out.println(isPixelInImage + " width: " + width + "height: "+ height);
                    if (isPixelInImage) {
                        try {

                            writer.setArgb(tmpX  + (int) radius , tmpY  + (int) radius, pixelss.get(listIndex));

                        } catch (NullPointerException e) {
                            continue;
                        }
                    }
                    listIndex++;
                }
            }
        }


        this.imageView.setImage(dest);

    }

    public void squareMarker (double x, double y, double radius, ArrayList<Integer> pixelss){
        imageConverterService imageConverterService = new imageConverterService();
        WritableImage dest = imageConverterService.convertToWritable(this.imageView.getImage());
        PixelWriter writer = dest.getPixelWriter();


        int width =  (int) this.imageView.getImage().getWidth();
        int height = (int) this.imageView.getImage().getHeight();

        int listIndex = 0;
        for(int tmpX = (int)(x - radius); tmpX <= (int)(x + radius); tmpX++) {
            for (int tmpY = (int)(y - radius); tmpY <= (int)(y + radius); tmpY++) {

                    boolean isPixelInImage = tmpX >= 0  && tmpX < width && tmpY >= 0 && tmpY < height;
                    //System.out.println(isPixelInImage + " width: " + width + "height: "+ height);
                    if (isPixelInImage) {
                        try {

                            writer.setArgb(tmpX  + (int) radius , tmpY  + (int) radius, pixelss.get(listIndex));

                        } catch (NullPointerException e) {
                            continue;
                        }
                    }
                    listIndex++;
                }
            }
        this.imageView.setImage(dest);
        }




    }



