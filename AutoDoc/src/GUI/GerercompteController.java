/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class GerercompteController implements Initializable {

    @FXML
    private Button fxmdp;
    @FXML
    private Button fxsupprimercompte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierproduit(MouseEvent event) {
    }

    @FXML
    private void modifiemdp(ActionEvent event) {
         
    }

    @FXML
    private void refresh(MouseEvent event) {
    }

    @FXML
    private void supprimercompte(ActionEvent event) {
    }
    
}
