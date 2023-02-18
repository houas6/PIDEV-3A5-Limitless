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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addperson(ActionEvent event) {
        
       
        int produit_echange= Integer.parseInt(fxproduitechange.getText());
        int produit_offert= Integer.parseInt(fxproduitoffert.getText());
        String statut=fxstatut.getText();
        String commentaire=fxcommentaire.getText();
        Echanges e1= new Echanges(produit_echange,produit_offert,statut,commentaire);
        CRUDEchange ce = new CRUDEchange();
        ce.ajouterechange(e1);
       
        
        
       Alert alert = new Alert(Alert.AlertType.INFORMATION);

alert.setTitle("Information Dialog");

alert.setHeaderText(null);

alert.setContentText("demande dechange  effectue avec succés!");

alert.show();

    }
        private void redirectToList(){
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/masterhrdesktopv2/views/recrutement/Candidat.fxml"));
            Scene c=new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(AjoutereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
