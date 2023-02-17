/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import edu.produit.entites.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DetailsController implements Initializable {

    @FXML
    private TableColumn<String, Produit> fxxnomproduit;
    @FXML
    private TableColumn<Float, Produit> fxxprix;
    @FXML
    private TableColumn<String, Produit> fxxdescription;
    @FXML
    private TableView<Produit> table_produit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setNom_produit(String message)
       {
       this.fxxnomproduit.setText(message);
       }
       public void setPrix(String message)
       {
       this.fxxprix.setText(message);
       }
       public void setDescription(String message)
       {
       this.fxxdescription.setText(message);
       }

    @FXML
    private void getselected(MouseEvent event) {
        String nom_produit=fxxnomproduit.getText();
        float prix= Float.parseFloat(fxxprix.getText());
        String description= fxxdescription.getText();
        Produit P = new Produit(nom_produit,prix,description); 
   P=table_produit.getSelectionModel().getSelectedItem();  
   nom_produit.setText(P.getNom_produit()); 
   prix.setValue(P.getPrix()); 
   description.setValue(P.getDescription());
   
    }
    
}
