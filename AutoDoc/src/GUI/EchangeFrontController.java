/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Echanges;
import models.Utilisateur;
import services.Auth;
import services.CRUDEchange;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class EchangeFrontController implements Initializable {

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
    private List <Echanges>  echange;
    Utilisateur u= Auth.getCurrentUtilisateur();
    @FXML
    private Button fxpanier;
    @FXML
    private Button storebouton;
    @FXML
    private Button boutonrec;
    @FXML
    private Button profilebou;
    @FXML
    private ImageView fxmonprofile1;
    @FXML
    private AnchorPane bord;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             //*************affichage*****************
       echange= ce.afficherechangeFont(u.getId_user());
        table.setItems(FXCollections.observableArrayList(echange));
        id_echange.setCellValueFactory(new PropertyValueFactory<>("id_echange"));
        produit_echange.setCellValueFactory(new PropertyValueFactory<>("produit_echange"));       
        produit_offert.setCellValueFactory(new PropertyValueFactory<>("produit_offert"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));   
            
    
}

    @FXML
    private void boutonrec(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajouterr.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    private void profileboutton(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("gerercompte.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
        
    }

    @FXML
    private void boutonpanier(ActionEvent event) {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("panier.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
        
    }

    @FXML
    private void boutton(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("EchangeFront.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void storebouton(ActionEvent event) {
    }


}