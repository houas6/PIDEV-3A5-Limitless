/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import services.*;
import models.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    utilisateur client;
    @FXML
    private Label total;
    @FXML
    private Label Nomclient;
    @FXML
    private Label Nomclient1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<produit> products = spanier.getpanier(1).getProducts();// remplace 1 par client.id
        System.out.println( products);
     
     
     
     
     for (produit p : products) {
    Pane productPane = new Pane();
    productPane.setPrefSize(500, 75);
    productPane.setStyle("-fx-background-color: linear-gradient(#ff0000, #530101); -fx-background-radius: 10; -fx-padding: 10px;");
 
    Label productRefLabel = new Label("ID: " + p.getId_produit());
    productRefLabel.setLayoutX(10);
    productRefLabel.setLayoutY(10);
    productRefLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
 
    Label productDimensionLabel = new Label("Nom: " + p.getNom_produit());
    productDimensionLabel.setLayoutX(120);
    productDimensionLabel.setLayoutY(10);
    productDimensionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
 
    Label productPrixLabel = new Label("Prix: " + p.getPrix());
    productPrixLabel.setLayoutX(240);
    productPrixLabel.setLayoutY(10);
    productPrixLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
 
    Label productQuantiteLabel = new Label("Quantité: " + spanier.getQuantite(1, p.getId_produit()));// remplace 1 par client.id
    productQuantiteLabel.setLayoutX(360);
    productQuantiteLabel.setLayoutY(10);
    productQuantiteLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
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
    spanier.incrementQuantite(spanier.getpanier(1), p.getId_produit());
    int newQuantity = spanier.getQuantite(1, p.getId_produit());
    if (newQuantity > oldQuantity) {
        productQuantiteLabel.setText("Quantité: " + newQuantity);
    }
    total.setText(String.valueOf(spanier.getpanier(1).getTotal_panier()));
});

Button decrementButton = new Button("-");
decrementButton.setLayoutX(350);
decrementButton.setLayoutY(40);
decrementButton.setOnAction(event -> {
    int oldQuantity = spanier.getQuantite(1, p.getId_produit());
    if (oldQuantity > 1) {
        spanier.decrementQuantite(spanier.getpanier(1), p.getId_produit());
        int newQuantity = spanier.getQuantite(1, p.getId_produit());
        if (newQuantity < oldQuantity) {
            productQuantiteLabel.setText("Quantité: " + newQuantity);
        }
        total.setText(String.valueOf(spanier.getpanier(1).getTotal_panier()));
    }
});
 total.setText(String.valueOf(spanier.getpanier(1).getTotal_panier()));
ImageView supprimerImageView = new ImageView();
supprimerImageView.setFitHeight(26);
supprimerImageView.setFitWidth(35);
supprimerImageView.setLayoutX(450);
supprimerImageView.setLayoutY(12);
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
    total.setText(String.valueOf(spanier.getpanier(1).getTotal_panier()));
}    
    
    
});
Nomclient.setText(sclient.getutilisateur(1).getNom());
Nomclient1.setText(sclient.getutilisateur(1).getNom());


/*Button deleteButton = new Button();
    deleteButton.setGraphic(new ImageView(new javafx.scene.image.Image("ic_delete_black_18dp_1x")));
    deleteButton.setLayoutX(450);
    deleteButton.setLayoutY(10);
    deleteButton.setOnAction(event -> {
        int id_user = 1; // Remplacez 1 par client.id
        int id_produit = p.getId_produit();
        spanier.supprimerproduitpannier(1, id_produit);
        vboxpanier.getChildren().remove(productPane);
    });*/

 
    productPane.getChildren().addAll(productRefLabel, productDimensionLabel, productPrixLabel, productQuantiteLabel, incrementButton, decrementButton , supprimerImageView );
    vboxpanier.getChildren().add(productPane);
    
}
 
   vboxpanier.setSpacing(10);
     
     
     
    }    
    
}
