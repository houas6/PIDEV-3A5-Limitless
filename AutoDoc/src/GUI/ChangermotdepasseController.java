/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.*;
import services.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class ChangermotdepasseController implements Initializable {

    @FXML
    private PasswordField fxoldpassword;
    @FXML
    private PasswordField fxnewpassword;
    @FXML
    private Button fxchanger;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changermdp(ActionEvent event) {
        
        String oldPassword = fxoldpassword.getText();
String newPassword = fxnewpassword.getText();

// Récupérer l'utilisateur connecté
Utilisateur u = Auth.getCurrentUtilisateur();

// Vérifier si l'ancien mot de passe est correct
if (u.getPassword().equals(oldPassword)) {
    // Mettre à jour le mot de passe dans la base de données
    boolean updateResult = Auth.changePassword(u.getMail(), newPassword);
    if (updateResult) {
        // Afficher un message de succès dans une alerte box
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Changement de mot de passe");
        alert.setHeaderText("Votre mot de passe a été modifié avec succès.");
        alert.showAndWait();
    } else {
        // Afficher un message d'erreur dans une alerte box
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Une erreur s'est produite lors de la mise à jour du mot de passe.");
        alert.showAndWait();
    }
} else {
    // Afficher un message d'erreur dans une alerte box
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Erreur");
    alert.setHeaderText("L'ancien mot de passe est incorrect.");
    alert.showAndWait();
}

    }

    @FXML
    private void refresh(MouseEvent event) {
    }
    
}
