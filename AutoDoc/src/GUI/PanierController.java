/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import services.*;
import models.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author rassa
 */
public class PanierController implements Initializable {

    @FXML
    private VBox vboxpanier ;
    
 ServicePanier spanier = new ServicePanier();
    panier panier ;
    ServiceUtilisateur sclient = new ServiceUtilisateur();
    Utilisateur client;
    @FXML
    private Label total;
    @FXML
    private Label Nomclient;
    @FXML
    private Label Nomclient1;
    @FXML
    private Button checkout;
    @FXML
    private AnchorPane bord;
    Utilisateur u=Auth.getCurrentUtilisateur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Produit> products =  spanier.getpanier(u.getId_user()).getProducts();// remplace 1 par client.id
        System.out.println( products);
      
     
     
     
     
     for (Produit p : products) {
    Pane productPane = new Pane();
    productPane.setPrefSize(500, 75);
    productPane.setStyle("-fx-background-color: linear-gradient(#ff0000, #530101); -fx-background-radius: 10; -fx-padding: 10px;");
 
   /* Label productRefLabel = new Label("ID: " + p.getId_produit());
    productRefLabel.setLayoutX(10);
    productRefLabel.setLayoutY(10);
    productRefLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
    productRefLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");*/
   ImageView imageView = new ImageView();
byte[] imageData = null;
            try {
                imageData = spanier.getProductImage(p.getId_produit()); // Make sure that imageData is not null
            } catch (SQLException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            }
if (imageData != null) {
    
    Image image = new Image(new ByteArrayInputStream(imageData));
    imageView.setImage(image);
    imageView.setFitWidth(100);
    imageView.setFitHeight(100);
    imageView.setPreserveRatio(true);
    imageView.setSmooth(true);
    imageView.setCache(true);
    
    
    // Add the ImageView to your scene graph
    // (e.g. using a Pane or a Group)
}
    
 
    Label productDimensionLabel = new Label("Nom: " + p.getNom_produit());
    productDimensionLabel.setLayoutX(120);
    productDimensionLabel.setLayoutY(10);
    productDimensionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    productDimensionLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
 
    Label productPrixLabel = new Label("Prix: " + p.getPrix());
    productPrixLabel.setLayoutX(240);
    productPrixLabel.setLayoutY(10);
    productPrixLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    productPrixLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
 
    Label productQuantiteLabel = new Label(" "+spanier.getQuantite(1, p.getId_produit()));// remplace 1 par client.id
    productQuantiteLabel.setLayoutX(375);
    productQuantiteLabel.setLayoutY(45);
    productQuantiteLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
     productQuantiteLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
 /*
    Button incrementButton = new Button("+");
    incrementButton.setLayoutX(400);
    incrementButton.setLayoutY(40);
    incrementButton.setOnAction(event -> {
        spanier.incrementQuantite(spanier.getpanier(1), p.getId_product());// remplace 1 par client.id
        productQuantiteLabel.setText("Quantité: " + spanier.getQuantite(1, p.getId_product()));// remplace 1 par client.id
    });
 
    Button decrementButton = new Button("-");
    decrementButton.setLayoutX(350);
    decrementButton.setLayoutY(40);
    decrementButton.setOnAction(event -> {
        int currentQuantity= spanier.getQuantite(1, p.getId_product());// remplace 1 par client.id
        if(currentQuantity > 1)
        {
        spanier.decrementQuantite(spanier.getpanier(1),p.getId_product());// remplace 1 par client.id
        productQuantiteLabel.setText("Quantité: " + spanier.getQuantite(1, spanier.getQuantite(1, p.getId_product())));// remplace 1 par client.id
        }
    });
 */
 
 Button incrementButton = new Button("+");
incrementButton.setLayoutX(400);
incrementButton.setLayoutY(40);
incrementButton.setOnAction(event -> {
    int oldQuantity = spanier.getQuantite(1, p.getId_produit());
    spanier.incrementQuantite(spanier.getpanier(u.getId_user()), p.getId_produit());
    int newQuantity = spanier.getQuantite(1, p.getId_produit());
    if (newQuantity > oldQuantity) {
        productQuantiteLabel.setText(" " + newQuantity);
         productQuantiteLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    }
    total.setText(String.valueOf(spanier.getpanier(u.getId_user()).getTotal_panier()));
});

Button decrementButton = new Button("-");
decrementButton.setLayoutX(350);
decrementButton.setLayoutY(40);
decrementButton.setOnAction(event -> {
    int oldQuantity = spanier.getQuantite(1, p.getId_produit());
    if (oldQuantity > 1) {
        spanier.decrementQuantite(spanier.getpanier(u.getId_user()), p.getId_produit());
        int newQuantity = spanier.getQuantite(1, p.getId_produit());
        if (newQuantity < oldQuantity) {
            productQuantiteLabel.setText(" " + newQuantity);
             productQuantiteLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
            
        }
        total.setText(String.valueOf(spanier.getpanier(u.getId_user()).getTotal_panier()));
    }
});
 total.setText(String.valueOf(spanier.getpanier(u.getId_user()).getTotal_panier()));
ImageView supprimerImageView = new ImageView();
supprimerImageView.setFitHeight(26);
supprimerImageView.setFitWidth(35);
supprimerImageView.setLayoutX(110);
supprimerImageView.setLayoutY(50);
supprimerImageView.setPickOnBounds(true);
supprimerImageView.setPreserveRatio(true);

Image supprimerImage = new Image(getClass().getResourceAsStream("../resources/trash.png"));
supprimerImageView.setImage(supprimerImage);



supprimerImageView.setOnMouseClicked(event -> {
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation de suppression");
alert.setHeaderText("Voulez-vous vraiment supprimer ce produit du panier ?");
alert.setContentText("Cliquez sur OK pour confirmer.");

Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    Pane parent = (Pane) productPane.getParent();
    spanier.supprimerproduitpannier(1, p.getId_produit());
    parent.getChildren().remove(productPane);
    total.setText(String.valueOf(spanier.getpanier(u.getId_user()).getTotal_panier()));
}    
    
    
});
Nomclient.setText(u.getNom());
Nomclient1.setText(u.getNom());
         System.out.println("aaaaa"+u.getNom());




 
    productPane.getChildren().addAll( productDimensionLabel, productPrixLabel, productQuantiteLabel, incrementButton, decrementButton , supprimerImageView ,imageView);
    vboxpanier.getChildren().add(productPane);
    
}
 Nomclient.setText(u.getNom());
Nomclient1.setText(u.getNom());

   vboxpanier.setSpacing(10);
     
     
     
    }    

    @FXML
    private void checkout(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("commande.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
        
    }
   
    
    
   
    
}
