package stamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));

        primaryStage.setTitle("FotoSklep");

        final Controller controller = new Controller();
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root, 800,600));
        primaryStage.setResizable(false); //blokowanie zmiany rozmiaru
        primaryStage.show();
        
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
