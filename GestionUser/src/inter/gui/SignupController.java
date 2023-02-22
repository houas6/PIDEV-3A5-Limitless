/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter.gui;

import conexionbd.services.Auth;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Skymil
 */
public class SignupController implements Initializable {
    @FXML
    private Label erreurSaisie;   
    @FXML
    private TextField semail;
    @FXML
    private PasswordField spassword;
    @FXML
    private Button ssignup;
    @FXML
    private TextField snom;
    @FXML
    private TextField sprenom;
    @FXML
    private TextField scin;
    @FXML
    private TextField snumero;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signup(ActionEvent event) {
        
        String email = semail.getText();
String password = spassword.getText();
String nom = snom.getText();
String prenom = sprenom.getText();
String numero= snumero.getText();
String cin = scin.getText();
// Vérifier si tous les champs sont remplis
if (email.isEmpty() || password.isEmpty() || nom.isEmpty() || prenom.isEmpty() || numero.isEmpty() || cin.isEmpty()) {
    // afficher le message d'erreur dans une alert box
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Veuillez remplir tous les champs");
    alert.showAndWait();
    return;
}

// Vérifier si le format de l'email est valide
if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
    // afficher le message d'erreur dans une alert box
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("L'adresse e-mail est invalide.");
    alert.showAndWait();
    return;
}

// Vérifier si le format du numéro de téléphone est valide
if (!numero.matches("[0-9]{8}")) {
    // afficher le message d'erreur dans une alert box
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Le numéro de téléphone est invalide.");
    alert.showAndWait();
    return;
}

// Appeler la méthode Auth.signUp
boolean ConnexionResultat = Auth.signUp(nom, prenom,cin, email, password, numero);
if (ConnexionResultat==true) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}

}}
