/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import models.*;
import services.*;
import BD.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class AjoutereController implements Initializable {

    @FXML
    private TextField fxproduitechange;
    @FXML
    private TextField fxstatut;
    @FXML
    private TextArea fxcommentaire;
    @FXML
    private Button fxajout;
    @FXML
    private Button rliste;
    @FXML
    private ComboBox<Integer> cmbxpof;
    private int id_p;

    public void setId_p(int id_p) {
        this.id_p = id_p;
        fxproduitechange.setText(String.valueOf(id_p));
       
    }
    
    Utilisateur u=Auth.getCurrentUtilisateur();
     
       ServiceUtilisateur u1 = new ServiceUtilisateur();
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //ajout des produit du l'utilisateur dans le combo box
       
      
        Connection conn = MyConnection.getInstance().getConnection();
        String sql = "SELECT id_produit FROM produit WHERE id_user =" +u.getId_user()+"";
        List<Integer> produits = new ArrayList<>();
        System.out.println("aaa a"+id_p);
           try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produits.add(rs.getInt("id_produit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         ObservableList<Integer> observableList = FXCollections.observableList(produits);
         cmbxpof.setItems(observableList);
         
         
        // TODO
    }    
 @FXML
    private void dmechange(ActionEvent event) throws Exception {     
       CRUDEchange ce = new CRUDEchange();
        String produit_echangestr= fxproduitechange.getText();
        String  produit_offertstr=Integer.toString(cmbxpof.getValue()) ;

           
        String statut=fxstatut.getText();
        String commentaire=fxcommentaire.getText();
          if (produit_echangestr.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("produit à echanger doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();
    } else if (produit_offertstr.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Produit offert doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();  
    }
          else if (commentaire.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("commentaire doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();  
    }
          else {
        try {
            int produit_echange= Integer.parseInt(fxproduitechange.getText());
       int produit_offert=cmbxpof.getValue();
             Echanges e1= new Echanges(produit_echange,produit_offert,statut,commentaire);
             ce.ajouterechange(e1);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
               alert.setContentText("ajout!");
                alert.show();
                MailSender3.sendMail(u1.getutilisateur(u.getId_user()));
                 this.redirectToList();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Produit à echanger et produit offert  doivent etre des nombres");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }    
         // fxproduitechange.setText(String.valueOf(id_p));
     }


    
        private void redirectToList(){
            Parent root;
            try {
            
            root = FXMLLoader.load(getClass().getResource("FrontAjouter.fxml"));
            Scene c=new Scene(root);
             Stage stage=(Stage)fxajout.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjoutereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rlist(MouseEvent event) {
        this.redirectToList();
    }

   

   
   
    
}
