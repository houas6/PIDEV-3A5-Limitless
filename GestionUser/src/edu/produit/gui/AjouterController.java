/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.gui;

import edu.produit.entites.Produit;
import edu.produit.services.CRUDProduit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField fxnomproduit;
    @FXML
    private TextField fxprix;
    @FXML
    private TextField fxdescription;
    @FXML
    private Button fxajout;
    @FXML
    private TextField idproduit;
    
    @FXML
    private Button fxcompte;
    
    
    @FXML
    private TableView<Produit> table_produit;
    @FXML
    private TableColumn<Produit,Integer> fxxidproduit;
    @FXML
    private TableColumn<Produit, String> fxxnomproduit;
    @FXML
    private TableColumn<Produit, Float> fxxprix;
    @FXML
    private TableColumn<Produit, String> fxxdescription;
    @FXML
    private Button modifier;
    private CRUDProduit cr=new CRUDProduit();
    Produit P;
    @FXML
    private Button refreshlisteproduit;
    @FXML
    private TableColumn<Produit, Integer> fxxiduser;
    @FXML
    private TextField fxiduser;
    @FXML
    private ImageView fximage;
    @FXML
    private Button chooseimage;
    @FXML
    private TableColumn<Produit, byte[]> fxximage1;
    
    
    /*public void setID_produit(String message)
       {
       this.fxxidproduit.setText(message);
       }
    public void setNom_produit(String message)
       {
       this.fxxnomproduit.setText(message);
       }
       public void setPrix(String message)
       {
       this.fxxprix.setText(message);
       }
       public void setDescription(String message)
       {
       this.fxxdescription.setText(message);
       }*/

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fxxidproduit.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        fxxnomproduit.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
        fxxprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        fxxdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
         fxxiduser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
       fxximage1.setCellFactory(column -> {
    TableCell<Produit, byte[]> cell = new TableCell<Produit, byte[]>() {
        private final ImageView imageView = new ImageView();

        @Override
        protected void updateItem(byte[] item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                imageView.setImage(null);
            } else {
                Image image = new Image(new ByteArrayInputStream(item));
                imageView.setImage(image);
            }

            setGraphic(imageView);
        }
    };

    return cell;
});
       populateTable();
         
         
         for (Produit Pe : cr.afficherproduit()) {
            table_produit.getItems().add(Pe);
        }
    }    
    
    
    
    /*@FXML
    private void Ajouterproduit(ActionEvent event) {
    String nom_produit=fxnomproduit.getText();
    String prixStr = fxprix.getText();
    String description= fxdescription.getText();
    String id_userStr = fxiduser.getText();

        if (nom_produit.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Nom produit doit etre saisi");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (prixStr.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Prix doit etre saisi");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (description.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Description doit etre saisi");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (id_userStr.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("ID utilisateur doit etre saisi");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            try {
                float prix = Float.parseFloat(prixStr);
                int id_user = Integer.parseInt(id_userStr);

                Produit p1 = new Produit(nom_produit, prix, description, id_user);
                CRUDProduit cr = new CRUDProduit();
                cr.ajouterproduit(p1);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Produit inséré avec succès!");
                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Prix et ID utilisateur doivent etre des nombres");
                alert.setTitle("Probleme");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }
}*/
@FXML
private void Ajouterproduit(ActionEvent event) {
    String nom_produit=fxnomproduit.getText();
    String prixStr = fxprix.getText();
    String description= fxdescription.getText();
    String id_userStr = fxiduser.getText();

    if (nom_produit.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Nom produit doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();
    } else if (prixStr.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Prix doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();
    } else if (description.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Description doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();
    } else if (id_userStr.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("ID utilisateur doit etre saisi");
        alert.setTitle("Probleme");
        alert.setHeaderText(null);
        alert.showAndWait();
    } else {
        try {
            float prix = Float.parseFloat(prixStr);
            int id_user = Integer.parseInt(id_userStr);

            // Open a file chooser to let the user select an image file
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choisir une image");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
            );
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                // Read the bytes of the selected image file
                byte[] imageBytes = Files.readAllBytes(selectedFile.toPath());

                Produit p1 = new Produit(nom_produit, prix, description, id_user, imageBytes);
                CRUDProduit cr = new CRUDProduit();
                cr.ajouterproduit(p1);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Produit inséré avec succès!");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Prix et ID utilisateur doivent etre des nombres");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de la lecture de l'image sélectionnée");
            alert.showAndWait();
        }
    }
}
        
    
    public void start (){
        try {
        FXMLLoader loader=FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        Parent root = loader.load();
        //root=FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    

    @FXML
    private void supprimer(ActionEvent event) {
        CRUDProduit cr=new CRUDProduit();
        Produit P =new Produit();
        int id_produit = cr.getid(Integer.parseInt(idproduit.getText())) ; 
        P.setId_produit(id_produit);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation de Suppression !");
        alert.setContentText("Voulez-Vous Vraiment Supprimer");
        
        Optional<ButtonType> btn = alert.showAndWait();
        if(btn.get() == ButtonType.OK){
            cr.supprimerproduit(id_produit);
            
                }
    }
        private void redirectToPage(){
            Parent root;
            try {
           
            root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
            Scene c=new Scene(root);
             Stage stage=(Stage)modifier.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        private void redirectToPage2(){
            Parent root;
            try {
            
            
           
            root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)refreshlisteproduit.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
    }

    @FXML
    private void modifierproduit(MouseEvent event) {
        this.redirectToPage();
        
    }

    @FXML
    private void refresh(MouseEvent event) {
        this.redirectToPage2();
    }

    

    @FXML
    private void chooseimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
        Image image = new Image(selectedFile.toURI().toString());
        fximage.setImage(image);
    }
    }
    
    public void populateTable(){
        CRUDProduit cr= new CRUDProduit();
        
        List<Produit> li =cr.afficherproduit();
        ObservableList<Produit> data = FXCollections.observableArrayList(li);
                  

        
          
        fxxidproduit.setCellValueFactory(
                new PropertyValueFactory<>("id_produit"));
        fxxnomproduit.setCellValueFactory(
                new PropertyValueFactory<>("nom_produit"));
 
       
        fxxprix.setCellValueFactory(
                new PropertyValueFactory<>("prix"));
       fxxdescription.setCellValueFactory(  
                new PropertyValueFactory<>("description")) ; 
        
        fxxiduser.setCellValueFactory(
                new PropertyValueFactory<>("id_user"));
        fxximage1.setCellValueFactory(
                new PropertyValueFactory<>("image"));
        table_produit.setItems(data);
    }
    @FXML
    private void gerercompte(ActionEvent event) {
     try {
        Parent root = FXMLLoader.load(getClass().getResource("changermotdepasse.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    }
}
   
    
    

