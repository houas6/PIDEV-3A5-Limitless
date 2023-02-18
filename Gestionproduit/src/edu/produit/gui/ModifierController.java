/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import edu.produit.entites.Produit;
import edu.produit.services.CRUDProduit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField fxnomproduit1;
    @FXML
    private TextField fxprix1;
    @FXML
    private TextField fxdescription1;
    @FXML
    private Button modifier;
    @FXML
    private TextField fxidproduit1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
        CRUDProduit cr = new CRUDProduit(); 
           int id_produit = cr.getid(Integer.parseInt(fxidproduit1.getText())) ;  
            
        Produit p = new Produit( id_produit, fxnomproduit1.getText(),Integer.parseInt(fxprix1.getText()),  fxdescription1.getText());
        

        cr.modifierproduit(p);
        
        fxnomproduit1.clear(); 
         fxprix1.clear() ; 
         fxdescription1.clear(); 
         
        
        
        /*Notifications notificationBuilder = Notifications.create()
                                                     .title("produit modifier")
                                                     .graphic(null)
                                                     .hideAfter(javafx.util.Duration.seconds(5) )
                                                      .position(Pos.TOP_LEFT) ;
         notificationBuilder.show(); */
    }
    
}
