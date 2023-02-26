    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package GUI;

    import java.io.IOException;
    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.StackPane;
    import javafx.stage.Stage;
    import java.io.IOException;
    import java.io.InputStream;
    import java.util.List;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.fxml.JavaFXBuilderFactory;
    import javafx.scene.Group;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.layout.AnchorPane;
    import javafx.scene.layout.BorderPane;
    import javafx.stage.Stage;
import javafx.stage.StageStyle;

    /**
     *
     * @author rassa
     */
    public class firstwindow extends Application {
 private Group root = new Group();
        @Override
        public void start(Stage primaryStage) {
            Parent root;
            try{
            root=FXMLLoader.load(getClass().getResource("payment.fxml"));
  

            Scene scene = new Scene(root);

            primaryStage.setTitle("Store");
           // primaryStage.initStyle(StageStyle.TRANSPARENT);
            
            primaryStage.setScene(scene);
            primaryStage.show();

            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
 


   
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            launch(args);
        }

    }
