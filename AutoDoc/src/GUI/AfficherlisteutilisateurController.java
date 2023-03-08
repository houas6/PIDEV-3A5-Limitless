/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import models.*;
import services.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class AfficherlisteutilisateurController implements Initializable {

    @FXML
    private TableColumn<Utilisateur, Integer> fxid;
    @FXML
    private TableColumn<Utilisateur, String> fxnom;
    @FXML
    private TableColumn<Utilisateur, String> fxprenom;
    @FXML
    private TableColumn<Utilisateur, String> fxemail;
    @FXML
    private TableColumn<Utilisateur, String> fxcin;
    @FXML
    private TableView<Utilisateur> fxtableutilisateur;
    @FXML
    private TextField fxrecherche;

    private List<Utilisateur> utilisateurs;
    private List<Utilisateur> utilisateursFiltres;
    private CRUDUtilisateur cu;
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
    @FXML
    private TableColumn<Utilisateur, Void> fxsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        cu = new CRUDUtilisateur();

        utilisateurs = cu.afficherUtilisateur();

        fxtableutilisateur.setItems(FXCollections.observableArrayList(utilisateurs));

        fxid.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        fxnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        fxprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        fxemail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        fxcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        // Créer la colonne "Supprimer" avec un bouton pour chaque ligne
        fxsupprimer.setCellFactory(param -> new TableCell<Utilisateur, Void>() {
            private final Button supprimerButton = new Button("Supprimer");

            {
                supprimerButton.setOnAction(event -> {
                    Utilisateur utilisateur = getTableView().getItems().get(getIndex());
                    cu.supprimerUtilisateur(utilisateur.getId_user());
                    fxtableutilisateur.getItems().remove(utilisateur);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(supprimerButton);
                }
            }
        });

        fxrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            utilisateursFiltres = utilisateurs.stream()
                    .filter(utilisateur -> utilisateur.getNom().toLowerCase().contains(newValue.toLowerCase())
                        || utilisateur.getCin().toLowerCase().contains(newValue.toLowerCase())
                        || utilisateur.getMail().toLowerCase().contains(newValue.toLowerCase())
                        || utilisateur.getPrenom().toLowerCase().contains(newValue.toLowerCase())
                    )
                    .collect(Collectors.toList());
            fxtableutilisateur.setItems(FXCollections.observableArrayList(utilisateursFiltres));
        });

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
