/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.gui;

import edu.Gestion_Echange.entites.Echanges;
import edu.Gestion_Echange.services.CRUDEchange;
import edu.Gestion_Echange.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class ModifierechangeController implements Initializable {

    @FXML
    private TextField fxid;
    @FXML
    private TextField fxpe;
    @FXML
    private ComboBox<Integer> fxpo;
    @FXML
    private TextArea fxcomm;
    @FXML
    private ComboBox<String> fxstatut;
    @FXML
    private Button fxmodifierechange;
    @FXML
    private Button rliste;
    //
    private Echanges echange;
    /**
     * Initializes the controller class.
     */
     public void setEchange(Echanges echange) {
    this.echange = echange;
    System.out.println("le set est" + echange);      
    fxid.setText(String.valueOf(echange.getId_echange()));
    fxpe.setText(String.valueOf(echange.getProduit_echange()));
    fxpo.setValue(echange.getProduit_offert());
    fxcomm.setText(echange.getCommentaire());
    fxstatut.setValue(echange.getStatut());
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String choice1 = new String("confirmé");
        String choice2 = new String("annuler");
        fxstatut.getItems().addAll(choice1, choice2);
      
      //combo box modifier 
       Connection conn = MyConnection.getInstance().getConnection();
        String sql = "SELECT id_produit FROM produit WHERE id_user = 15";
        List<Integer> produits = new ArrayList<>();
           try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produits.add(rs.getInt("id_produit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         ObservableList<Integer> observableList = FXCollections.observableList(produits);
        // fxpo.setItems(observableList);

    }    
    
     private void redirectToList(){
                Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
            Scene c=new Scene(root);
            

            Stage stage=(Stage)fxmodifierechange.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(ModifierechangeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void modifierechange(ActionEvent event) {
       if(!fxid.getText().equals("")&& !fxpe.getText().equals("") && !fxpo.getValue().equals("")  && !fxstatut.getValue().equals("") && !fxcomm.getText().equals("")  ){
        CRUDEchange ce = new CRUDEchange();
        int id_echange= Integer.parseInt(fxid.getText());
        int produit_echange= Integer.parseInt(fxpe.getText());
        int produit_offert= fxpo.getValue();
        String statut=fxstatut.getValue();
        String commentaire=fxcomm.getText();
        
        Echanges e= new Echanges(id_echange,produit_echange,produit_offert,statut,commentaire);  
   ce.modifierechange(e);
        String tilte;
            String message;
            tray.notification.TrayNotification tray = new tray.notification.TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
         
                tilte = "modification réussi";
                message = "modification ajoutée";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                
                    tray.showAndDismiss(Duration.millis(30000));
  
        this.redirectToList();}
   else{
           String tilte;
            String message;
            tray.notification.TrayNotification tray = new tray.notification.TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
          //  (new Alert(Alert.AlertType.CONFIRMATION, "modification effectué avec success", new ButtonType[]{ButtonType.OK})).show();
                tilte = "modification non réussi";
                message = "modification non ajoutée";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                
                    tray.showAndDismiss(Duration.millis(30000));
   }
    }

    @FXML
    private void rlist(MouseEvent event) {
        this.redirectToList();
    }
}
