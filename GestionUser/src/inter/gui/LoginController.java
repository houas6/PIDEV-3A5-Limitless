/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter.gui;

import Entities.MailSender;
import Entities.Utilisateur;
import conexionbd.services.Auth;
import conexionbd.services.CRUDUtilisateur;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class LoginController implements Initializable {

    @FXML
    private TextField fxemail;
    @FXML
    private PasswordField fxpassword;
    @FXML
    private Button fxlogin;
    @FXML
    private AnchorPane creeruncompte;
    @FXML
    private Button stosignup;
    @FXML
    private Label resetpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) {

        String email = fxemail.getText();
        String password = fxpassword.getText();
        Utilisateur currentUtilisateur = Auth.signIn(email, password);
            if (currentUtilisateur != null) {
                String role = currentUtilisateur.getRole();
                if (role.equals("admin")) {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/edu/produit/gui/Admin.fxml")); // correction
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                } else if (role.equals("client")) {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/edu/produit/gui/Ajouter.fxml")); // correction
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }}
        
    }

    @FXML
    private void redirectToSignUp(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void resetpassword(MouseEvent event) {
        
        try {
            MailSender.sendMail("dhiasaibi@yahoo.com", "Dhia", "s");
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}



        