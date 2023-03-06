/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.Utilisateur;
import services.CRUDUtilisateur;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class InterfaceController implements Initializable {

    @FXML
    private TextField fxusername;
    @FXML
    private TextField fxpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addperson(ActionEvent event) {
        try {
            String nom=fxusername.getText();
            String prenom=fxpassword.getText();
            Utilisateur u1 =new Utilisateur(nom,prenom,"dhiaafaf@gmail.com");
            CRUDUtilisateur cuser=new CRUDUtilisateur();
            cuser.ajouterUtilisateur2(u1);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detail.fxml"));
            Parent root=loader.load();
            DetailController dt = loader.getController();
            dt.setNom(u1.getUsername());
            dt.setPrenom(u1.getPassword());
            fxpassword.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
