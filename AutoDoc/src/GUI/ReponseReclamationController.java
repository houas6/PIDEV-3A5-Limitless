/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.*;
import services.CrudReclamation;
import services.CrudReponseReclamation;
import services.MetierReclamation;

/**
 * FXML Controller class
 *
 * @author achra
 */
public class ReponseReclamationController implements Initializable {

    private reclamations ReclamationSelected;
    private Utilisateur user;
    @FXML
    private TextArea tfReponse;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textEtat;
    @FXML
    private TextArea textDescription;
    @FXML
    private Button btnEnvoyer;
    @FXML
    private TextField textTel;
    @FXML
    private TextField textMail;
    @FXML
    private Button fxpanier;
    @FXML
    private Button storebouton;
    @FXML
    private Button boutonrec;
    @FXML
    private Button profileboutton;
    @FXML
    private ImageView fxmonprofile;
    @FXML
    private Button fxechanges;
    public void initData(int idRec) throws SQLException {
        MetierReclamation met = new MetierReclamation();
        ReclamationSelected = met.findById(idRec);
        user=met.getUserById(ReclamationSelected.getid_client());
        System.out.println(user);
        textNom.setText(user.getNom());
        textTel.setText(user.getNumero());
        textMail.setText(user.getMail());
        textEtat.setText(ReclamationSelected.getEtat());
        //textNom.setText(listReclamation.getSelectionModel().getSelectedItem().getid_client());
        textDescription.setText(ReclamationSelected.getDescription());
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
private void redirectToListeRec(){
            Parent root;
            try {
            root = FXMLLoader.load(getClass().getResource("ListReclamation.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)btnEnvoyer.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjouterrController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
    }
    @FXML
    private void envoyer(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        int id_client = ReclamationSelected.getid_client();
        String reponse = tfReponse.getText();
        if (id_client==0| reponse.isEmpty() ){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas envoyer une réponse vide!!");
            alert.show();
        }
        else {
            MetierReclamation met = new MetierReclamation();
            reponse_reclamation r = new reponse_reclamation(reponse,ReclamationSelected.getId());
            CrudReponseReclamation CR = new CrudReponseReclamation();
            try {
                met.sendMail(r, user.getMail());
            } catch (Exception ex) {
                Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            CR.ajouterReponse(r);
            alert.setTitle("Reponse");
            alert.setContentText("Reponse envoyé Avec succées");
            alert.show();
            this.redirectToListeRec();
            
        }
        }

     @FXML
    private void boutonpanier(ActionEvent event) {
      try {
            Parent root = FXMLLoader.load(getClass().getResource("Back.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void storebouton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void boutonrec(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ListReclamation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void profileboutton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("afficherlisteutilisateur.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void boutonechanges(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    }
    

