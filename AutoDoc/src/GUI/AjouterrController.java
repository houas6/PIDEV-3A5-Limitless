/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import models.*;
import services.Auth;
import services.CrudReclamation;
import services.MetierReclamation;

/**
 * FXML Controller class
 *
 * @author achra
 */
public class AjouterrController implements Initializable {

    @FXML
    private TextField tfNom;
     @FXML
    private TextArea tfDesc;
    @FXML
    private TextField tfEtat;
    @FXML
    private Button btmAjouter;
    private Utilisateur user=Auth.getCurrentUtilisateur();
    private String num_user;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    public void initData(int id_user) throws SQLException {
        MetierReclamation met = new MetierReclamation();
        this.user=met.getUserById(id_user);
        System.out.println(user);
        num_user=user.getNumero();
        
    }

    @FXML
    private void addReclamation(ActionEvent event) throws ParseException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String num = tfNom.getText();
        int id_client = user.getId_user();
        String desc = tfDesc.getText();
        String Etat = tfEtat.getText();
        if (id_client==0| desc.isEmpty() | Etat.isEmpty()){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas envoyer une reclamation avec un champ vide!!");
            alert.show();
        }
        else {
            System.out.println("dans ajouter"+num_user);
            reclamations r = new reclamations(id_client, desc, Etat);
            CrudReclamation CR = new CrudReclamation();
            CR.ajouterreclamation(r);
            MetierReclamation met = new MetierReclamation();
            met.sendSms(num, "Votre Reclamation est envoyé , vous recevrez une reponse en mail.");
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
