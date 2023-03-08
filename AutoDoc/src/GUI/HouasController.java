/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.Produit;
import models.Utilisateur;
import models.panier;
import services.Auth;
import services.CRUDProduit;
import services.ServicePanier;

/**
 * FXML Controller class
 *
 * @author rassa
 */
public class HouasController implements Initializable {

    @FXML
    private AnchorPane bord;
    @FXML
    private Label Nomclient;
    @FXML
    private VBox vboxpanier;
Utilisateur u= Auth.getCurrentUtilisateur();
    @FXML
    private Button storebouton;
    @FXML
    private Button boutonrec;
    @FXML
    private Button fxpanier;
    @FXML
    private ImageView fxmonprofile1;
    @FXML
    private Button profilebou;
    @FXML
    private Button fxprofil;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CRUDProduit cr= new CRUDProduit();
    List<Produit> li = cr.afficherproduit1(u.getId_user());
       for (Produit p : li) {
    Pane productPane = new Pane();
    productPane.setPrefSize(450, 80);
    productPane.setStyle("-fx-background-color: linear-gradient(#ff0000, #530101); -fx-background-radius: 10; -fx-padding: 10px;");
 
   /* Label productRefLabel = new Label("ID: " + p.getId_produit());
    productRefLabel.setLayoutX(10);
    productRefLabel.setLayoutY(10);
    productRefLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
    productRefLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");*/

 ImageView imageView = new ImageView();
        imageView.setImage(new Image(new ByteArrayInputStream(p.getImage())));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        
        
        
        
         Label nameLabel = new Label(p.getNom_produit());
         nameLabel.setLayoutX(120);
    nameLabel.setLayoutY(10);
    nameLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    nameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    
    
    
    Label priceLabel = new Label("Prix: " + p.getPrix());
    priceLabel.setLayoutX(240);
    priceLabel.setLayoutY(10);
    priceLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    priceLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    
    
    
     Label descriptionLabel = new Label(p.getDescription());
     descriptionLabel.setLayoutX(120);
    descriptionLabel.setLayoutY(30);
    descriptionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
     descriptionLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    
 Button echanger = new Button("Echanger");
    echanger.setLayoutX(400);
    echanger.setLayoutY(5);
    echanger.setOnAction(event -> {
    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajoutere.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
                 AjoutereController controller = loader.getController();
                 controller.setId_p(p.getId_produit());
                 System.out.println("aaaa"+p.getId_produit());

           }
        catch(IOException ex){
            System.out.println(ex);
        }
        
    
});
    
    
    Button Ajouter = new Button("Ajouter");
    Ajouter.setLayoutX(400);
    Ajouter.setLayoutY(40);
    Ajouter.setOnAction(event -> {
        panier pan2= new panier(u.getId_user());
    ServicePanier serv3 = new ServicePanier();
 
   serv3.ajouterPanier(pan2, p.getId_produit()); 
    
        
    
});
    




 
    productPane.getChildren().addAll(descriptionLabel,priceLabel,nameLabel, echanger,Ajouter,imageView);
    vboxpanier.getChildren().add(productPane);
    
}
       vboxpanier.setSpacing(20);
       Nomclient.setText(u.getNom());
        // TODO
    }    

//    private void panierboutton(ActionEvent event) {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("panier.fxml"));
//        try{
//            Parent root = loader.load();
//            bord.getChildren().setAll(root);
//           
//           }
//        catch(IOException ex){
//            System.out.println(ex);
//        }
//    }


    @FXML
    private void storebouton(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("houas.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void boutonrec(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajouterr.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    

    @FXML
    private void boutonpanier(ActionEvent event) {
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
    private void boutton(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("EchangeFront.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void boutonprofil(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gerercompte.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
    }


}
