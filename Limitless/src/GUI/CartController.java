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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<product> products = spanier.getpanier(1).getProducts();
        System.out.println( products);
        
        
         for (product p : products) {
        Pane productPane = new Pane();
        productPane.setMinHeight(75);
        productPane.setStyle("-fx-background-color: #f2d590; -fx-background-radius: 10; -fx-padding: 10px;");
        
        Label productRefLabel = new Label("Ref: " + p.getId_product());
        productRefLabel.setLayoutX(50);
        productRefLabel.setLayoutY(10);
        productRefLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        Label productDimensionLabel = new Label("Nom: " + p.getName_product());
        productDimensionLabel.setLayoutX(50);
        productDimensionLabel.setLayoutY(30);
        productDimensionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        Label productPrixLabel = new Label("Prix: " + p.getPrice_product());
        productPrixLabel.setLayoutX(50);
        productPrixLabel.setLayoutY(50);
        productPrixLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        productPane.getChildren().addAll(productRefLabel, productDimensionLabel, productPrixLabel);
        vboxpanier.getChildren().add(productPane);
    }
         // Set margin between labels
    vboxpanier.setSpacing(8);
        
        
        
        
        
        
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
    
}
