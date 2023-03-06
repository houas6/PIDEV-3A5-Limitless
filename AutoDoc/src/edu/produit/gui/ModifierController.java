/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rassa
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField fxnomproduit1;
    @FXML
    private TextField fxprix1;
    @FXML
    private TextField fxdescription1;
    @FXML
    private Button modifier;
    @FXML
    private TextField fxidproduit1;
    @FXML
    private TextField fxiduser1;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void retour(MouseEvent event) {
    }
    
}
