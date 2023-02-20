/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.gui;
import edu.Gestion_Echange.entites.Echanges;
import edu.Gestion_Echange.services.CRUDEchange;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class AjoutereController implements Initializable {

    @FXML
    private TextField fxproduitechange;
    @FXML
    private TextField fxproduitoffert;
    @FXML
    private TextField fxstatut;
    @FXML
    private TextArea fxcommentaire;
    @FXML
    private Button fxajout;
    @FXML
    private Button rliste;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addperson(ActionEvent event) {
        
      
       CRUDEchange ce = new CRUDEchange();
        String produit_echangestr= fxproduitechange.getText();
        String produit_offertstr= fxproduitoffert.getText();

           
        String statut=fxstatut.getText();
        String commentaire=fxcommentaire.getText();
          if (produit_echangestr.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("produit à echanger doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();
    } else if (produit_offertstr.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Produit offert doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();  
    }
          else if (commentaire.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("commentaire doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();  
    }
          else {
        try {
            int produit_echange= Integer.parseInt(fxproduitechange.getText());
       int produit_offert= Integer.parseInt(fxproduitoffert.getText());
             Echanges e1= new Echanges(produit_echange,produit_offert,statut,commentaire);
             ce.ajouterechange(e1);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
               alert.setContentText("ajout!");
                alert.show();
                 this.redirectToList();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Produit à echanger et produit offert  doivent etre des nombres");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }    
     }


    
        private void redirectToList(){
            Parent root;
            try {
            
            root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
            Scene c=new Scene(root);
             Stage stage=(Stage)fxajout.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjoutereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rlist(MouseEvent event) {
        this.redirectToList();
    }

   
   
    
}
