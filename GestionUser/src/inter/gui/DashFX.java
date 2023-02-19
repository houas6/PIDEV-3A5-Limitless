/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter.gui;

import Entities.Utilisateur;
import conexionbd.services.Auth;
import conexionbd.services.CRUDUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class DashFX implements Initializable {

    @FXML
    private TextField fxemail;
    @FXML
    private PasswordField fxpassword;
    @FXML
    private Button fxlogin;

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
        Auth.signIn(email, password);
    }

}
