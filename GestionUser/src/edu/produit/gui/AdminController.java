/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class AdminController implements Initializable {

    @FXML
    private Button fxmodifierUtilisateur;
    @FXML
    private Button fxsupprimerutilisateur;
    @FXML
    private Button fxafficherlisteutilisateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierUtilisateur(ActionEvent event) {
    }

    @FXML
    private void fxsupprimerUtilisateur(ActionEvent event) {
    }

    @FXML
    private void fxafficherlisteutilisateur(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherlisteutilisateur.fxml"));
            Parent root = loader.load();
            
            // Créer une nouvelle fenêtre pour afficher la scène chargée
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            
            // Afficher la nouvelle fenêtre
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }
    }
    
}
