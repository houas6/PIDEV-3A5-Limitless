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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    
    @FXML
    private Button afficher;
    @FXML
    private TableView<Produit> table_produit;
    @FXML
    private TableColumn<?, ?> fxxidproduit;
    @FXML
    private TableColumn<?, ?> fxxnomproduit;
    @FXML
    private TableColumn<?, ?> fxxprix;
    @FXML
    private TableColumn<?, ?> fxxdescription;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void afficher(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("Details.fxml"));
        Parent root = loader.load();
        afficher.getScene().setRoot(root);
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
        FXMLLoader loader=FXMLLoader.load(getClass().getResource("Details.fxml"));
        Parent root = loader.load();
        root=FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    

    @FXML
    private void supprimer(ActionEvent event) {
        CRUDProduit cr=new CRUDProduit();
        Produit P =new Produit();
        int id_produit = cr.getid(Integer.parseInt(idproduit.getText())) ; 
        P.setId_produit(id_produit);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation de Suppression !");
        alert.setContentText("Voulez-Vous Vraiment Supprimer");
        
        Optional<ButtonType> btn = alert.showAndWait();
        if(btn.get() == ButtonType.OK){
            cr.supprimerproduit(id_produit);
            
                }
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
   
    
    

