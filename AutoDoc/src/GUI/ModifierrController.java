/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.reclamations;
import services.CrudReclamation;


/**
 * FXML Controller class
 *
 * @author achra
 */
public class ModifierrController implements Initializable {

    @FXML
    private Button btmRetourner;
    @FXML
    private AnchorPane supperson;
    @FXML
    private Button btmsupp;
    @FXML
    private TextField supi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retperson(ActionEvent event) {
        Parent root;
            try {
            
            
           
            root = FXMLLoader.load(getClass().getResource("DashFX.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)btmRetourner.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjouterrController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    @FXML
    private void suprimer(ActionEvent event) {
       CrudReclamation cr=new CrudReclamation();
        reclamations r =new reclamations();
        int id_Reclamation = cr.getid(Integer.parseInt(supi.getText())) ; 
        r.setId(id_Reclamation);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation de Suppression !");
        alert.setContentText("Voulez-Vous Vraiment Supprimer");
       
            
                }
    }
    

