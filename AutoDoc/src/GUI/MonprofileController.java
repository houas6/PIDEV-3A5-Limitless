/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Utilisateur;
import services.Auth;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class MonprofileController implements Initializable {

    @FXML
    private TextField monnom;
    @FXML
    private TextField monnumero;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private TextField monprenom;
    @FXML
    private TextField monadresse;
    @FXML
    private TextField moncin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/limitless", "root", "");
            Utilisateur u =Auth.getCurrentUtilisateur();
            PreparedStatement stmt = conn.prepareStatement("SELECT nom, prenom, adresse, numero, cin FROM utilisateur WHERE id_user = ?");
            stmt.setInt(1, u.getId_user()); // Remplacez 1 par l'ID de l'utilisateur dont vous souhaitez récupérer les informations
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                monnom.setText(rs.getString("nom"));
                monprenom.setText(rs.getString("prenom"));
                monadresse.setText(rs.getString("adresse"));
                monnumero.setText(rs.getString("numero"));
                moncin.setText(rs.getString("cin"));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }    

    @FXML
    private void enregistrer(ActionEvent event) {
        
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/limitless", "root", "");
        PreparedStatement stmt = conn.prepareStatement("UPDATE utilisateur SET nom = ?, prenom = ?, adresse = ?, numero = ? WHERE id_user = ?");
        stmt.setString(1, monnom.getText());
        stmt.setString(2, monprenom.getText());
        stmt.setString(3, monadresse.getText());
        stmt.setString(4, monnumero.getText());
        Utilisateur u =Auth.getCurrentUtilisateur();
        stmt.setInt(5, u.getId_user()); // Remplacez 1 par l'ID de l'utilisateur que vous souhaitez modifier
        int result = stmt.executeUpdate();
        if (result > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Les modifications ont été enregistrées avec succès !");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Aucune modification n'a été enregistrée.");
            alert.showAndWait();
        }
        conn.close();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    }
    @FXML
    private void storebouton(ActionEvent event) {
          try {
            Parent root = FXMLLoader.load(getClass().getResource("houas.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("Ajouterr.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    

    @FXML
    private void boutonpanier(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("panier.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    @FXML
//    private void boutton(ActionEvent event) {
//          try {
//            Parent root = FXMLLoader.load(getClass().getResource("EchangeFront.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    @FXML
    private void boutonprofil(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("gerercompte.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}