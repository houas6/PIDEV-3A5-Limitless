/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
import model.reclamations;
import services.CrudReclamation;

/**
 * FXML Controller class
 *
 * @author achra
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField tfNom;
     @FXML
    private TextArea tfDesc;
    @FXML
    private TextField tfEtat;
    @FXML
    private Button btmAjouter;
    @FXML
    private Button btmModifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void addReclamation(ActionEvent event) throws ParseException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String nomClient = tfNom.getText();
        String desc = tfDesc.getText();
        String Etat = tfEtat.getText();
        if (nomClient.isEmpty()| desc.isEmpty() | Etat.isEmpty()){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas envoyer une reclamation avec un champ vide!!");
            alert.show();
        }
        else {
            reclamations r = new reclamations(nomClient, desc, Etat);
            CrudReclamation CR = new CrudReclamation();
            CR.ajouterreclamation(r);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton ajoutée Avec succées");
            alert.show();
            tfNom.clear();
            tfDesc.clear();
            tfEtat.clear();
        }
        }}

    
    
    
    

   // private void addperson(ActionEvent event) {
      //  String nom=fxnom.getText();
      //  String prenom=fxnom.getText();
        
        
        
 //   }
    
//}
