/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import edu.produit.entites.Produit;
import edu.produit.services.CRUDProduit;
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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField fxnomproduit;
    @FXML
    private TextField fxprix;
    @FXML
    private TextField fxdescription;
    @FXML
    private Button fxajout;
    @FXML
    private TextField idproduit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouterproduit(ActionEvent event) {
        String nom_produit=fxnomproduit.getText();
        float prix= Float.parseFloat(fxprix.getText());
        String description= fxdescription.getText();
        Produit p1 = new Produit(nom_produit,prix,description);
        CRUDProduit cr = new CRUDProduit();
        cr.ajouterproduit(p1);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information Dialog");

        alert.setHeaderText(null);

        alert.setContentText("Produit insérée avec succés!");

        alert.show();}
        
    
    public void start (){
        try {
        FXMLLoader loader=FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        Parent root = loader.load();
        root=FXMLLoader.load(getClass().getResource("Details.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        CRUDProduit cr=new CRUDProduit();
        Produit P =new Produit(nom_produit,prix,description);
        int id_produit = cr.getId_produit(idproduit.getText()) ; 
        P.setId_produit(id_produit);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation de Suppression !");
        alert.setContentText("Voulez-Vous Vraiment Supprimer");
        
        Optional<ButtonType> btn = alert.showAndWait();
        if(btn.get() == ButtonType.OK){
            sc.supprimerc(t);
            populateTable();
            Notifications notificationBuilder = Notifications.create()
                                                     .title("transport supprimer")
                                                     .graphic(null)
                                                     .hideAfter(javafx.util.Duration.seconds(5) )
                                                      .position(Pos.TOP_LEFT) ;
         notificationBuilder.show(); 
           dest.clear();
         
        pays.getSelectionModel().clearSelection();
        ville.getSelectionModel().clearSelection();
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 1);
        prix.setValueFactory(svf); 
        }
        else{
            alert.close();
        } 
    }
}
    

