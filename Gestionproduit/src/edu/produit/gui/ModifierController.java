/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import edu.produit.entites.Produit;
import edu.produit.services.CRUDProduit;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
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
        CRUDProduit cr = new CRUDProduit(); 
           int id_produit = cr.getid(Integer.parseInt(fxidproduit1.getText())) ;  
            
        Produit p = new Produit( id_produit, fxnomproduit1.getText(),Integer.parseInt(fxprix1.getText()),  fxdescription1.getText(),Integer.parseInt(fxiduser1.getText()));
        

        cr.modifierproduit(p);
        
        fxnomproduit1.clear(); 
         fxprix1.clear() ; 
         fxdescription1.clear(); 
         fxiduser1.clear();
         
        
        
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Produit modifier avec succès!");
            alert.showAndWait();
    } 

        
    
    private void redirectToPage3(){
            Parent root;
            try {
            
            
           
            root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)retour.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
    }
    @FXML
    private void retour(MouseEvent event) {
        this.redirectToPage3();
    }
    
}
