/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.gui;

import edu.Gestion_Echange.entites.Echanges;
import edu.Gestion_Echange.services.CRUDEchange;
import java.io.IOException;
import java.net.URL;
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
    private TextField fxpo;
    @FXML
    private TextArea fxcomm;
    @FXML
    private ComboBox<String> fxstatut;
    @FXML
    private Button fxmodifierechange;
    @FXML
    private Button rliste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String choice1 = new String("confirmé");
        String choice2 = new String("annuler");
      fxstatut.getItems().addAll(choice1, choice2);
     
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
       if(!fxid.getText().equals("")&& !fxpe.getText().equals("") && !fxpo.getText().equals("")  && !fxstatut.getValue().equals("") && !fxcomm.getText().equals("")  ){
        CRUDEchange ce = new CRUDEchange();
        int id_echange= Integer.parseInt(fxid.getText());
        int produit_echange= Integer.parseInt(fxpe.getText());
        int produit_offert= Integer.parseInt(fxpo.getText());
        String statut=fxstatut.getValue();
        String commentaire=fxcomm.getText();
        
        Echanges e= new Echanges(id_echange,produit_echange,produit_offert,statut,commentaire);
     //  Candidature c=new Candidature(cmp.getIdCandidature(),Nom.getText(),Prenom.getText(),Date.valueOf(DateNaissance.getValue()),Adresse.getText(),Email.getText(),chemin,etat.getValue(),data,Integer.parseInt(NumTel.getText()));
       
          
      
   ce.modifierechange(e);
   /*   
        if(etat.getValue().equals("Accepter")){
            icr1.sms(c);
        }
*/
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setContentText("echange modifié!");
    alert.show();
        this.redirectToList();}
   else{
       Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("ERROR");
    alert.setContentText("Verifier les champs!");
    alert.show();
   }
    }

    @FXML
    private void rlist(MouseEvent event) {
        this.redirectToList();
    }
    
}
