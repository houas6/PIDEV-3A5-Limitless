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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.reclamations;
import services.CrudReclamation;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ListReclamationController implements Initializable {

    @FXML
    private TableView<reclamations> listReclamation;
    @FXML
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
    private TextField textNom;
    @FXML
    private TextField textEtat;
    @FXML
    private TextArea textDescription;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CrudReclamation crud = new CrudReclamation();
            ObservableList<reclamations> data = FXCollections.observableArrayList(crud.afficherreclamation());
            System.out.println("///////");
            System.out.println(data);
            System.out.println("///////");
            NomColumn.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listReclamation.setItems(data);
            throw new SQLException("Sample SQLException");
        } catch (SQLException ex) {
            System.out.println("here");
            Logger.getLogger(ListReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            NomColumn.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
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
        int idRec=listReclamation.getSelectionModel().getSelectedItem().getId();
        textEtat.setText(listReclamation.getSelectionModel().getSelectedItem().getEtat());
        textNom.setText(listReclamation.getSelectionModel().getSelectedItem().getNomClient());
        textDescription.setText(listReclamation.getSelectionModel().getSelectedItem().getDescription());
        
        }
        
    }
    public void modifier(ActionEvent event) throws ParseException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (textNom.getText().isEmpty()| textDescription.getText().isEmpty() | textEtat.getText().isEmpty()){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas modifier une reclamation avec un champ vide!!");
            alert.show();
        }
        else{
        int idRec=listReclamation.getSelectionModel().getSelectedItem().getId();
        reclamations r = new reclamations(idRec,textNom.getText(), textDescription.getText(),textEtat.getText());
        CrudReclamation crud = new CrudReclamation();
        crud.modifierreclamation(r);
        textEtat.clear();
        textNom.clear();
        textDescription.clear();
        
            ObservableList<reclamations> data = FXCollections.observableArrayList(crud.afficherreclamation());
            NomColumn.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listReclamation.setItems(data);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton Modifiée Avec succées");
            alert.show();
    }
    }
    }    
    
