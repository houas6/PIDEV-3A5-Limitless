/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import models.*;
import services.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
}
