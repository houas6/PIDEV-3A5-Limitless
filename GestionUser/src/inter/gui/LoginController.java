/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter.gui;

import Entities.Utilisateur;
import conexionbd.services.Auth;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class LoginController implements Initializable {

  
    @FXML
    private TextField fxemail;
    @FXML
    private TextField fxpassword;
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
        String email=fxemail.getText();
        String password=fxpassword.getText();
        Utilisateur u=new Utilisateur(email,password);
        Auth.signIn(email, password);
        
    }
    
}
