/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.gui;

import edu.Gestion_Echange.entites.Echanges;
import edu.Gestion_Echange.services.CRUDEchange;
import edu.Gestion_Echange.utils.EchangesHolder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
            //Candidature cand = new Candidature(c.getNom(),c.getPrenom(),c.getCurriculumVitae(),c.getEtat(),c.getScore(),cp);
            
         //   Echanges e1 =new Echanges(e.getId_echange(),e.getProduit_echange(),e.getProduit_offert(),e.getStatut(),e.getCommentaire());
         //   table.getItems().add(e1);
            //System.out.println(c.toString());
        
    }    
    
}
