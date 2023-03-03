/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author achra
 */
public class firstWindow extends Application {
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
//       Parent root;
        try{
            //Partie ajouter
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Ajouter.fxml"));
            Parent root = loader.load();
            AjouterController dcc=loader.getController();
            Scene scene = new Scene(root);
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            dcc.initData(12);
            primaryStage.setTitle("Liste des reclamations");
            primaryStage.setScene(scene);
            primaryStage.show();
         ///////////////////////////////////////////////////////////
         //Partie admin : liste des reclamatioins
//         FXMLLoader loader=new FXMLLoader(getClass().getResource("listReclamation.fxml"));
//            Parent root = loader.load();
//            ListReclamationController dcc=loader.getController();
//            Scene scene = new Scene(root);
//            //user ca=listStaff.getSelectionModel().getSelectedItem();
//            primaryStage.setTitle("Liste des reclamations");
//            primaryStage.setScene(scene);
//            primaryStage.show();
            
            
        
 
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
