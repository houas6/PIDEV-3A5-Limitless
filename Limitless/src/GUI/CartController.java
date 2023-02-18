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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author rassa
 */
public class CartController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Hyperlink cartButton;
    @FXML
    private VBox vboxpanier;
    
    
    
    ServicePanier spanier = new ServicePanier();
    panier panier ;
    ServiceClient sclient = new ServiceClient();
    client client;
    
 
    @FXML
    private Button checkout1;
    @FXML
    private Button quantiteplus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       ArrayList<product> products = spanier.getpanier(1).getProducts();// remplace 1 par client.id
        System.out.println( products);
     
     
     
     
     for (product p : products) {
    Pane productPane = new Pane();
    productPane.setPrefSize(500, 75);
    productPane.setStyle("-fx-background-color: #f2d590; -fx-background-radius: 10; -fx-padding: 10px;");
 
    Label productRefLabel = new Label("ID: " + p.getId_product());
    productRefLabel.setLayoutX(10);
    productRefLabel.setLayoutY(10);
    productRefLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
 
    Label productDimensionLabel = new Label("Nom: " + p.getName_product());
    productDimensionLabel.setLayoutX(120);
    productDimensionLabel.setLayoutY(10);
    productDimensionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
 
    Label productPrixLabel = new Label("Prix: " + p.getPrice_product());
    productPrixLabel.setLayoutX(240);
    productPrixLabel.setLayoutY(10);
    productPrixLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
 
    Label productQuantiteLabel = new Label("Quantité: " + spanier.getQuantite(1, p.getId_product()));// remplace 1 par client.id
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
    int oldQuantity = spanier.getQuantite(1, p.getId_product());
    spanier.incrementQuantite(spanier.getpanier(1), p.getId_product());
    int newQuantity = spanier.getQuantite(1, p.getId_product());
    if (newQuantity > oldQuantity) {
        productQuantiteLabel.setText("Quantité: " + newQuantity);
    }
});

Button decrementButton = new Button("-");
decrementButton.setLayoutX(350);
decrementButton.setLayoutY(40);
decrementButton.setOnAction(event -> {
    int oldQuantity = spanier.getQuantite(1, p.getId_product());
    if (oldQuantity > 1) {
        spanier.decrementQuantite(spanier.getpanier(1), p.getId_product());
        int newQuantity = spanier.getQuantite(1, p.getId_product());
        if (newQuantity < oldQuantity) {
            productQuantiteLabel.setText("Quantité: " + newQuantity);
        }
    }
});
 
 
    productPane.getChildren().addAll(productRefLabel, productDimensionLabel, productPrixLabel, productQuantiteLabel, incrementButton, decrementButton);
    vboxpanier.getChildren().add(productPane);
}
 
vboxpanier.setSpacing(10);
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
        
        
        // TODO
    }    

    @FXML
    private void showHelp(ActionEvent event) {
    }

    @FXML
    private void proccessLogout(ActionEvent event) {
    }

    @FXML
    private void gotoStore(ActionEvent event) {
    }

    @FXML
    private void gotoLibrary(ActionEvent event) {
    }

    @FXML
    private void gotoAccount(ActionEvent event) {
    }

    @FXML
    private void showCart(ActionEvent event) {
    }

    @FXML
    private void quantiteplus(ActionEvent event) {
    }
    
}
