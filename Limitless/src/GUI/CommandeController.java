/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import models.panier;
import models.utilisateur;
import services.ServicePanier;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author rassa
 */
public class CommandeController implements Initializable {

    @FXML
    private VBox vbox1;
    @FXML
    private RadioButton livArtziiNow;
    @FXML
    private ToggleGroup modeLivraison;
    @FXML
    private RadioButton livDomicile;
    @FXML
    private RadioButton livArtziiNow1;
    @FXML
    private ToggleGroup modeLivraison1;
    @FXML
    private RadioButton livDomicile1;
    @FXML
    private ToggleGroup modeLivraison2;
    @FXML
    private TextField adresse;
    
    ServicePanier spanier = new ServicePanier();
    panier panier ;
    ServiceUtilisateur sclient = new ServiceUtilisateur();
    utilisateur client;
    @FXML
    private Button retour;
    @FXML
    private AnchorPane bord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
          adresse.setText(sclient.getutilisateur(1).getAdresse());
        
        
        // TODO
    }    

    @FXML
    private void retour(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("panier.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
        
        
    }
    
}
