/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.gui;

import edu.Gestion_Echange.entites.Echanges;
import edu.Gestion_Echange.services.CRUDEchange;
import edu.Gestion_Echange.utils.EchangesHolder;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<Echanges> table;
    @FXML
    private TableColumn<Echanges, Integer> id_echange;
    @FXML
    private TableColumn<Echanges, Integer> produit_echange;
    @FXML
    private TableColumn<Echanges, Integer> produit_offert;
    @FXML
    private TableColumn<Echanges, String> statut;
    @FXML
    private TableColumn<Echanges, String> commentaire;
    private CRUDEchange ce=new CRUDEchange();
    Echanges e;
    @FXML
    private Button fxsupprimerechangeback;
    @FXML
    private TextField idechangesupp;
    @FXML
    private Button fxrefreshsupp;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //EchangesHolder pt = EchangesHolder.getInstance();
        //e =pt.getEchanges();
        id_echange.setCellValueFactory(new PropertyValueFactory<>("id_echange"));
        produit_echange.setCellValueFactory(new PropertyValueFactory<>("produit_echange"));
        
        produit_offert.setCellValueFactory(new PropertyValueFactory<>("produit_offert"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
             for (Echanges c : ce.afficherechange()) {
            table.getItems().add(c);
        }
           
        
    }    

    @FXML
    private void supprimerechange(ActionEvent event) {
      CRUDEchange cee=new CRUDEchange();
       Echanges ee= new Echanges();
        int id_echange = cee.getIdechange(Integer.parseInt(idechangesupp.getText())) ;
        ee.setId_echange(id_echange);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation de Suppression !");
        alert.setContentText("Voulez-Vous Vraiment Supprimer");
       
        Optional<ButtonType> btn = alert.showAndWait();
        if(btn.get() == ButtonType.OK){
            ce.supprimerechange(id_echange);
    }
    }

    @FXML
    private void refreshechanges(MouseEvent event) {
        this.redirectToListEchangerefresh();
    }
    private void redirectToListEchangerefresh(){
        Parent root;
        try { 
            root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)fxrefreshsupp.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
