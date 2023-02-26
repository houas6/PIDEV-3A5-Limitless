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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;


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
    //
    private CRUDEchange ce=new CRUDEchange();
    Echanges e;
    private final ObservableList<Echanges> dataList = FXCollections.observableArrayList();
    
    @FXML
    private Button modifierfx;
    @FXML
    private Button redajout;   
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<Echanges, String> option;
    @FXML
    private Label headerlist;
    @FXML
    private Button filterbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //EchangesHolder pt = EchangesHolder.getInstance();
        //e =pt.getEchanges();
        //*************affichage*****************
        id_echange.setCellValueFactory(new PropertyValueFactory<>("id_echange"));
        produit_echange.setCellValueFactory(new PropertyValueFactory<>("produit_echange"));
        
        produit_offert.setCellValueFactory(new PropertyValueFactory<>("produit_offert"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));    
             for (Echanges c : ce.afficherechange()) {
            table.getItems().add(c);
             }                               
 //*********************** btn supprimer et fnction sypprimer******************************
                                            option.setCellFactory(column -> {
                                                return new TableCell<Echanges, String>() {
                                                    final Button deleteButton = new Button("Delete");
                                                    @Override
                                                    protected void updateItem(String item, boolean empty) {
                                                        super.updateItem(item, empty);

                                                        if (empty) {
                                                            setGraphic(null);
                                                        } else {
                                                            setGraphic(deleteButton);
                                                               deleteButton.setOnAction((ActionEvent event) -> {
                                                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                                                    alert.setTitle("Confirmation");
                                                                    alert.setHeaderText("Confirmation de Suppression !");
                                                                    alert.setContentText("Voulez-Vous Vraiment Supprimer");
                                                                     Optional<ButtonType> btn = alert.showAndWait();
                                                                     Echanges data1 = getTableView().getItems().get(getIndex());
                                                                        System.out.println(data1);                         
                                                                        System.out.println("selectedData: " + data1.getId_echange());
                                                                    if(btn.get() == ButtonType.OK){
                                                                        ce.supprimerechange(data1.getId_echange());
                                                                        //table.getItems().remove(data1);
                                                                        redirectToListEchangerefresh();
                                                                       }
                                                                    });
                                                        }
                                                    }
                                                }; 
                                            });
       //tests                         
             
    }    
//*********************refresh****************************
    private void redirectToListEchangerefresh(){
        Parent root;
        try { 
            root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)table.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //************************modifier btn********************
private void redirectToupdateechange(){
      Parent root;
    try {
            root = FXMLLoader.load(getClass().getResource("modifierechange.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)modifierfx.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
 @FXML
    private void modiferfx(MouseEvent event) {
        this.redirectToupdateechange();
    }
     //***********************ajout btn**********************************
private void redirectToaddechange(){
      Parent root;
    try {
            root = FXMLLoader.load(getClass().getResource("ajoutere.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)modifierfx.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    @FXML
    private void redajout(MouseEvent event) {
        this.redirectToaddechange();
    }
   
    @FXML
private void search(ActionEvent event) {
    // Set up the table columns
    id_echange.setCellValueFactory(new PropertyValueFactory<>("id_echange"));
    produit_echange.setCellValueFactory(new PropertyValueFactory<>("produit_echange"));
    produit_offert.setCellValueFactory(new PropertyValueFactory<>("produit_offert"));
    statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
    commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));

    // Query the database for the search term
    CRUDEchange ce = new CRUDEchange();
    List<Echanges> echangeList = ce.searchEchange(filterField.getText().trim());
    ObservableList<Echanges> dataList = FXCollections.observableArrayList(echangeList);

    // Set up the filtered and sorted data
     FilteredList<Echanges> filteredData = new FilteredList<>(dataList, b -> true);
     filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(ech -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if (ech. getStatut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                return true;
            } else if (ech.getProduit_echange() != -1) {
                return true;
            } else {               
                return false;
            }
        });
    });

    SortedList<Echanges> sortedData = new SortedList<>(filteredData);
    sortedData.comparatorProperty().bind(table.comparatorProperty());
    String searchTerm = filterField.getText().trim();
    if (!searchTerm.isEmpty()) {
        // Filter the dataList instead of querying the database again
        filteredData.setPredicate(prd -> {
            String lowerCaseFilter = searchTerm.toLowerCase();
            if (prd.getStatut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                return true;
            } else if (prd.getProduit_echange() != -1) {
                return true;
            } else {
                return false;
            }
        });

        // Set the table items with the filtered data
        table.setItems(filteredData);
    } else {
        // If the search field is empty, show all products
        table.setItems(sortedData);
    }
}

     
   
//fianl }
}
