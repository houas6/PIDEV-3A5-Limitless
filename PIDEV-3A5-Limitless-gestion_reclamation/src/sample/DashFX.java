/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author achra
 */
public class DashFX implements Initializable {

    @FXML
    private TextField textNom;
    @FXML
    private TextField textEtat;
    @FXML
    private TextArea textDescription;
    @FXML
    private TextArea tfReponse;
    @FXML
    private Button btnEnvoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
    }
    
}
