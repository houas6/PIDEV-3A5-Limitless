/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.panier;
import models.utilisateur;
import services.ServicePanier;
import services.ServiceUtilisateur;
import services.*;
import  models.*;
/**
 * FXML Controller class
 *
 * @author rassa
 */
public class CommandeController implements Initializable {

    @FXML
    private RadioButton livDomicile1;
    @FXML
    private TextField adresse;
    
    ServicePanier spanier = new ServicePanier();
    panier panier ;
    ServiceUtilisateur sclient = new ServiceUtilisateur();
    utilisateur client;
    ServiceCommande scommande = new ServiceCommande();
    commande commande;
    
    
    @FXML
    private Button retour;
    @FXML
    private AnchorPane bord;
    @FXML
    private VBox vboxcommande;
    @FXML
    private RadioButton Fedx;
    @FXML
    private ToggleGroup livraison;
    @FXML
    private RadioButton DHL;
    @FXML
    private RadioButton rapideposte;
    @FXML
    private ToggleGroup paiement;
    @FXML
    private Label nomuser;
    @FXML
    private Label soustotal;
    @FXML
    private Label total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ArrayList<produit> products = spanier.getpanier(1).getProducts();// remplace 1 par client.id
        System.out.println( products);
        
        
        for (produit p : products) {
            
            
            
            
            
            
    Pane productPane = new Pane();
    productPane.setPrefSize(500, 75);
    productPane.setStyle("-fx-background-color:  #1A172A; -fx-background-radius: 10; -fx-padding: 10px;");
     Label productDimensionLabel = new Label(""+p.getNom_produit());
    productDimensionLabel.setLayoutX(20);
    productDimensionLabel.setLayoutY(10);
    productDimensionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    productDimensionLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    Label productPrixLabel = new Label(spanier.getQuantite(1, p.getId_produit()) +"     *    " + p.getPrix());
    productPrixLabel.setLayoutX(80);
    productPrixLabel.setLayoutY(20);
    productPrixLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    productPrixLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    Label producttotal = new Label(""+spanier.getQuantite(1, p.getId_produit())*p.getPrix()+" DT");
    producttotal.setLayoutX(280);
    producttotal.setLayoutY(20);
    producttotal.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    producttotal.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    
    
/*
Line line = new Line(-139.00001525878906, 1.3999786376953125, 350.0, 1.3999786376953125);
line.setStroke(Color.WHITE);
line.setStrokeWidth(0.8);
line.setLayoutX(40.0);
line.setLayoutY(78.0);

        */
Line line = new Line(-139.00001525878906, 1.3999786376953125, 350.0, 1.3999786376953125);
line.getStrokeDashArray().addAll(10.0, 5.0); // ajoute des tirets de 10 pixels et des espaces de 5 pixels
line.setStrokeWidth(0.8);
line.setStroke(Color.WHITE);
line.setLayoutX(30.0);
line.setLayoutY(50.0);
          adresse.setText(sclient.getutilisateur(1).getAdresse());
          
          
          
          nomuser.setText(sclient.getutilisateur(1).getNom());
          soustotal.setText(String.valueOf(spanier.getpanier(1).getTotal_panier()));
          total.setText(String.valueOf(spanier.getpanier(1).getTotal_panier()+14));
          
          
          
          productPane.getChildren().addAll(productDimensionLabel, line ,productPrixLabel,producttotal );
    vboxcommande.getChildren().add(productPane);
    
}
 
   vboxcommande.setSpacing(10);
        
        
        // TODO
    }    

    @FXML
    private void retour(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("panier.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
        
        
    }

    @FXML
    private void payercommande(ActionEvent event) {
      // client= sclient.getutilisateur(1);
     //  client.setAdresse(adresse.getText());
        //commande.setCl(client);
        //commande.setTotal_commande(spanier.getpanier(1).getTotal_panier()+14);
       // commande.setId_commande(0);
         commande c1= new commande(0,sclient.getutilisateur(1),spanier.getpanier(1).getTotal_panier()+14);
        scommande.ajoutercommande(c1);
        
        
        
    }
    
}
