/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.panier;
import models.*;
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
    Utilisateur client;
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
    Utilisateur u= Auth.getCurrentUtilisateur();
    int id=u.getId_user();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ArrayList<Produit> products = spanier.getpanier(u.getId_user()).getProducts();// remplace 1 par client.id
        System.out.println( products);
        
        
        for (Produit p : products) {
            
            
            
            
            
            
    Pane productPane = new Pane();
    productPane.setPrefSize(500, 75);
    productPane.setStyle("-fx-background-color:  #1A172A; -fx-background-radius: 10; -fx-padding: 10px;");
     Label productDimensionLabel = new Label(""+p.getNom_produit());
    productDimensionLabel.setLayoutX(20);
    productDimensionLabel.setLayoutY(10);
    productDimensionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    productDimensionLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    Label productPrixLabel = new Label(spanier.getQuantite(u.getId_user(), p.getId_produit()) +"     *    " + p.getPrix());
    productPrixLabel.setLayoutX(80);
    productPrixLabel.setLayoutY(20);
    productPrixLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    productPrixLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #ffffff;");
    
    Label producttotal = new Label(""+spanier.getQuantite(u.getId_user(), p.getId_produit())*p.getPrix()+" DT");
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
          adresse.setText(sclient.getutilisateur(u.getId_user()).getAdresse());
          
          
          
          nomuser.setText(sclient.getutilisateur(u.getId_user()).getNom());
          soustotal.setText(String.valueOf(spanier.getpanier(u.getId_user()).getTotal_panier()));
          total.setText(String.valueOf(spanier.getpanier(u.getId_user()).getTotal_panier()+14));
          
          
          
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
    private void payercommande(ActionEvent event) throws FileNotFoundException, DocumentException {
      client= sclient.getutilisateur(u.getId_user());
     client.setAdresse(adresse.getText());
        //commande.setCl(client);
        //commande.setTotal_commande(spanier.getpanier(1).getTotal_panier()+14);
       // commande.setId_commande(0);
         commande c1= new commande(0,client,spanier.getpanier(u.getId_user()).getTotal_panier()+14);
        scommande.ajoutercommande(c1);
        genererTicketAchatPDF(spanier, bord.getScene().getWindow());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
        try{
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) bord.getScene().getWindow();
    stage.setTitle("Custom Title"); // Set the window title
    stage.setScene(scene);
    stage.setWidth(600); // Set the width of the new window
    stage.setHeight(400); // Set the height of the new window
    stage.show();
           
            
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
        
     
     
     
     
  
     
        
    }
    public  void genererTicketAchatPDF(ServicePanier spanier, Window parentWindow) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Enregistrer les données");
    File selectedFile = fileChooser.showSaveDialog(parentWindow);
 
    if (selectedFile != null) {
        try {
            // Créer un document PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
            document.open();
 
            // Ajouter les éléments de l'interface utilisateur pour le ticket d'achat
            com.itextpdf.text.Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Ticket d'achat", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10f);
            document.add(title);
 
            com.itextpdf.text.Font regularFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph date = new Paragraph("Date: " + LocalDate.now().toString(), regularFont);
            date.setAlignment(Element.ALIGN_LEFT);
            date.setSpacingAfter(10f);
            document.add(date);
 
            Paragraph produits = new Paragraph("Produits:", regularFont);
            produits.setAlignment(Element.ALIGN_LEFT);
            produits.setSpacingAfter(10f);
            document.add(produits);
 
            ArrayList<Produit> products = spanier.getpanier(u.getId_user()).getProducts();
            PdfPTable table = new PdfPTable(3); // 3 colonnes pour Nom, Prix et Quantité
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
 
            // En-tête de table
            table.addCell(new PdfPCell(new Phrase("Nom", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Prix", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Quantité", regularFont)));
            
 
            // Contenu de table
            for (Produit p : products) {
                int q = spanier.getQuantite(u.getId_user(), p.getId_produit());
                table.addCell(new PdfPCell(new Phrase(p.getNom_produit(), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(p.getPrix()), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(q), regularFont)));
            }
            document.add(table);
 
            document.close();
        } catch (IOException | DocumentException ex) {
            System.err.println("Erreur lors de l'écriture dans le fichier: " + ex.getMessage());
        }
    } else {
        System.out.println("La sélection de fichier a été annulée");
    }
}
}
