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
    @FXML
    private TableColumn<?, Produit> fxxidproduit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setID_produit(String message)
       {
       this.fxxidproduit.setText(message);
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
        
        Produit P = new Produit(); 
        P=table_produit.getSelectionModel().getSelectedItem();  
        fxxidproduit.setText(""+P.getId_produit());
        fxxnomproduit.setText(P.getNom_produit()); 
        fxxprix.setText(""+P.getPrix()); 
        fxxdescription.setText(P.getDescription());
   
    }
    
}
