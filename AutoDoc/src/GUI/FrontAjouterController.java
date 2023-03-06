/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import services.*;
import models.*;
import GUI.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.*;
import services.*;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FrontAjouterController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private VBox vboxpanier;
    @FXML
    private Button checkout1;
    @FXML
    private Hyperlink cartButton;
    @FXML
    private GridPane productgridpane;
    @FXML
    private Button Ajouterproduit;
  Utilisateur u= Auth.getCurrentUtilisateur();

    /**
     * Initializes the controller class.
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
    CRUDProduit cr= new CRUDProduit();
    List<Produit> li = cr.afficherproduit();

    // Create a counter for the row and column indices of the gridpane
    int row = 0;
    int col = 0;

    // Iterate through the list of products
    for (Produit p : li) {
        // Create an ImageView to display the product image
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(new ByteArrayInputStream(p.getImage())));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Create a Label to display the product name
        Label nameLabel = new Label(p.getNom_produit());

        // Create a Label to display the product price
        Label priceLabel = new Label("Prix: " + p.getPrix());

        // Create a Label to display the product description
        Label descriptionLabel = new Label(p.getDescription());
         Button echanger = new Button("Echanger");
    echanger.setLayoutX(400);
    echanger.setLayoutY(40);
    echanger.setOnAction(event -> {
    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajoutere.fxml"));
        try{
            Parent root = loader.load();
            mainBorderPane.getChildren().setAll(root);
           
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
         
        // Add the ImageView and Labels to the gridpane
        productgridpane.add(imageView, col, row);
        productgridpane.add(nameLabel, col, row+1);
        productgridpane.add(descriptionLabel, col, row+2);
        productgridpane.add(priceLabel, col, row+3);
        productgridpane.add(echanger, col, row+4);
        productgridpane.add(Ajouter, col, row+5);
        

        // Increment the column index
        col++;

        // If we've added three products in a row, move to the next row and reset the column index
        if (col > 2) {
            col = 0;
            row += 4;
        }
    }
}
    
    @FXML
    private void proccessLogout(ActionEvent event) {
    }

    @FXML
    private void showHelp(ActionEvent event) {
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
    private void redirectToPage6(){
            Parent root;
            try {
            
            
           
            root = FXMLLoader.load(getClass().getResource("AjouterPFront.fxml"));
            Scene c=new Scene(root,800,600);
            Stage stage=(Stage)Ajouterproduit.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
    }
    @FXML
    private void Ajouterunproduit(ActionEvent event) {
        this.redirectToPage6();
    }

    
}
