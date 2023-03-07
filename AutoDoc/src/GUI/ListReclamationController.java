/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.*;
import services.CrudReclamation;
import services.MetierReclamation;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ListReclamationController implements Initializable {

    @FXML
    private TableView<reclamations> listReclamation;
    private TableColumn<reclamations, String> NomColumn;
    @FXML
    private TableColumn<reclamations, String> DescriptionColumn;
    @FXML
    private TableColumn<reclamations, String> EtatColumn;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private Button btnRechercher;
    private TextField textNom;
    @FXML
    private TextField textEtat;
    @FXML
    private TextArea textDescription;
    @FXML
    private TextField recherche;
    @FXML
    private Button btnRepondre;
    @FXML
    private TextField textNom1;
    @FXML
    private TextField textMail;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CrudReclamation crud = new CrudReclamation();
            ObservableList<reclamations> data = FXCollections.observableArrayList(crud.afficherreclamation());
            System.out.println("///////");
            System.out.println(data);
            System.out.println("///////");
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listReclamation.setItems(data);
            throw new SQLException("Sample SQLException");
        } catch (SQLException ex) {
            System.out.println("here");
            Logger.getLogger(ListReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void supprimer(ActionEvent event) throws IOException {
       
        int selectedIndex = listReclamation.getSelectionModel().getSelectedIndex();

       if (selectedIndex < 0 ) {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Erreur");
           alert.setHeaderText("Aucune reclamation selectionnée!");
           alert.setContentText("Veuiller selectionner une réclamation à supprimer");
           Optional<ButtonType> result = alert.showAndWait();
       } else{
        try {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                CrudReclamation ser = new CrudReclamation();
                ser.supprimerreclamation(listReclamation.getSelectionModel().getSelectedItem().getId());
                CrudReclamation crud = new CrudReclamation();
                ObservableList<reclamations> data = FXCollections.observableArrayList(crud.afficherreclamation());
            System.out.println("///////");
            System.out.println(data);
            System.out.println("///////");
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listReclamation.setItems(data);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton supprimée Avec succées");
            alert.show();
            } else {

            }
            throw new SQLException("Sample SQLException");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}
    }
    @FXML
    public void initierReclamation(ActionEvent event) throws ParseException {
        int selectedIndex = listReclamation.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0 ) {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Erreur");
           alert.setHeaderText("Aucune reclamation selectionnée!");
           alert.setContentText("Veuiller selectionner une réclamation à modifier");
           Optional<ButtonType> result = alert.showAndWait();
       }
        else{
            
        Utilisateur user;
        MetierReclamation met = new MetierReclamation();
        user=met.getUserById(listReclamation.getSelectionModel().getSelectedItem().getid_client());
        System.out.println(user);
        System.out.println("initier////////////////");
        System.out.println(user.getNom());
        textNom1.setText(user.getNom());
        textMail.setText(user.getMail());
        //textNom.setText(listReclamation.getSelectionModel().getSelectedItem().getid_client());
        textEtat.setText(listReclamation.getSelectionModel().getSelectedItem().getEtat());
        //textNom.setText(listReclamation.getSelectionModel().getSelectedItem().getid_client());
        textDescription.setText(listReclamation.getSelectionModel().getSelectedItem().getDescription());
        
        }
        
    }
    @FXML
    public void modifier(ActionEvent event) throws ParseException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (textNom.getText().isEmpty()| textDescription.getText().isEmpty() | textEtat.getText().isEmpty()){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas modifier une reclamation avec un champ vide!!");
            alert.show();
        }
        else{
        int idRec=listReclamation.getSelectionModel().getSelectedItem().getId();
            System.out.println("idrec"+idRec);
        reclamations r = new reclamations(idRec,Integer.parseInt(textNom.getText()), textDescription.getText(),textEtat.getText());
        CrudReclamation crud = new CrudReclamation();
        crud.modifierreclamation(r);
        textEtat.clear();
        textNom.clear();
        textDescription.clear();
        
            ObservableList<reclamations> data = FXCollections.observableArrayList(crud.afficherreclamation());
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listReclamation.setItems(data);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton Modifiée Avec succées");
            alert.show();
    }
    }

    @FXML
         public void rechercher(ActionEvent event) throws IOException {
        MetierReclamation met = new MetierReclamation();
        //ServiceUser sca = new ServiceUser();
        System.out.println("/////////////recherche//////////");
        System.out.println(recherche.getText());
        ObservableList<reclamations> data = FXCollections.observableArrayList(met.SearchByEtat(recherche.getText()));
        System.out.println(data);
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
        listReclamation.setItems(data);

    }

    @FXML
    private void repondre(ActionEvent event) throws SQLException {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ReponseReclamation.fxml"));
            Parent root = loader.load();
            ReponseReclamationController dcc=loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            int idRec=listReclamation.getSelectionModel().getSelectedItem().getId();
            dcc.initData(idRec);
            btnModifier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
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
    

