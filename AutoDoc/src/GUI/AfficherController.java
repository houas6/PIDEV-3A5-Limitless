/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.*;
import services.*;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.util.stream.Collectors;
import javafx.scene.Node;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author amine
 */
public class AfficherController implements Initializable {
   //***************données tablesview****************
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
    @FXML
    private TableColumn<Echanges, String> option;
    @FXML
    private TableColumn<Echanges, String> modd;
    //
    private CRUDEchange ce=new CRUDEchange();
    Echanges e;
    //************listes recherche************
    private final ObservableList<Echanges> dataList = FXCollections.observableArrayList();
    private List <Echanges>  echange;
    private List <Echanges>  echangefiltre;
    //****** holder pour l'echange  selectionné avec le btn update *********
    private Echanges selectedEchange;
    @FXML
    private Button modifierfx;
    @FXML
    private TextField filterField;
    @FXML
    private Label headerlist;
    @FXML
    private Button fxpanier;
    @FXML
    private Button storebouton;
    @FXML
    private Button boutonrec;
    @FXML
    private Button profileboutton;
    @FXML
    private ImageView fxmonprofile;
    @FXML
    private Button fxechanges;
    @FXML
    private Label Nomclient;
    
   Utilisateur u=Auth.getCurrentUtilisateur();

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
        Nomclient.setText(u.getNom());
        //*************affichage*****************
       echange= ce.afficherechange();
        table.setItems(FXCollections.observableArrayList(echange));
        id_echange.setCellValueFactory(new PropertyValueFactory<>("id_echange"));
        produit_echange.setCellValueFactory(new PropertyValueFactory<>("produit_echange"));       
        produit_offert.setCellValueFactory(new PropertyValueFactory<>("produit_offert"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));   
             //*************recherche*****************
          filterField.textProperty().addListener((observable, oldValue, newValue) -> {
    echangefiltre = echange.stream()
        .filter(Echanges ->            
            Echanges.getStatut().toLowerCase().contains(newValue.toLowerCase()) || 
            Echanges.getCommentaire().toLowerCase().contains(newValue.toLowerCase())
        )
        .collect(Collectors.toList());                  
    table.setItems(FXCollections.observableArrayList(echangefiltre));
});

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
                                                                        redirectToListEchangerefresh();
                                                                       }
                                                                    });
                                                        }
                                                    }
                                                }; 
                                            });
       //tests                         
        //*********************** btn modifier et fnction sypprimer******************************
                                            modd.setCellFactory(column -> {
                                                return new TableCell<Echanges, String>() {
                                                  
                                                    final Button updateButton = new Button("Update");
                                                    @Override
                                                    protected void updateItem(String item, boolean empty) {
                                                        super.updateItem(item, empty);
                                                        if (empty) {
                                                            setGraphic(null);
                                                        } else {
                                                            setGraphic(updateButton);
                                                               updateButton.setOnAction((ActionEvent event) -> {
                                                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                                                    alert.setTitle("Confirmation");
                                                                    alert.setHeaderText("Confirmation de modification !");
                                                                    alert.setContentText("Voulez-Vous Vraiment modifier");
                                                                    
                                                                     Optional<ButtonType> btn = alert.showAndWait();
                                                                     Echanges data1 = getTableView().getItems().get(getIndex());
                                                                        System.out.println(data1);                         
                                                                        System.out.println("selectedData: " + data1.getId_echange());
                                                                        selectedEchange = data1;
                                                                    if(btn.get() == ButtonType.OK){
                                                                      //   redirectToupdateechange();
                                                                       
                                                                        try {
                                                                           // redirectToupdateechange();
                                                                             
                                                                          Echanges selectedEchange = table.getSelectionModel().getSelectedItem();
                                                                            
                                                                            // Open the ModifierController and pass the selected echange as a parameter
                                                                            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierechange.fxml"));
                                                                            Parent root = loader.load();
                                                                            ModifierechangeController controller = loader.getController();
                                                                            controller.setEchange(data1);
                                                                            System.out.println("lecontr"+data1); 
                                                                            
                                                                            Stage stage = new Stage();
                                                                            Scene scene = new Scene(root);
                                                                            stage.setScene(scene);
                                                                            stage.show();
                                                                        } catch (IOException ex) {
                                                                            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
                                                                        }
                                                                       }
                                                                    });
                                                        }
                                                    }
                                                }; 
                                            });
             
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
    private void boutonpanier(ActionEvent event) {
      try {
            Parent root = FXMLLoader.load(getClass().getResource("Back.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void storebouton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void boutonrec(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ListReclamation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void profileboutton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("afficherlisteutilisateur.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void boutonechanges(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    } 
}
