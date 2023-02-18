/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

/**
 *
 * @author hasse
 */
public class Interfaces extends Application {

    @FXML
    private TextField fxprenom;
    
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
        root=FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        
        Scene scene = new Scene(root);
         primaryStage.setTitle("L'ajout d'une personne");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
        catch (IOException ex) {
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
