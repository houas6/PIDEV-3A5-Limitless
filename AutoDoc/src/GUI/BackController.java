/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import services.*;
import models.*;

/**
 * FXML Controller class
 *
 * @author rassa
 */
public class BackController implements Initializable {

    @FXML
    private AnchorPane bord;
    @FXML
    private Label nomuser;
    @FXML
    private VBox vbox1;
    ServiceCommande sc= new ServiceCommande();
    commande c;
    Utilisateur u=Auth.getCurrentUtilisateur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         List<commande> commande = sc.afficherCommands();// remplace 1 par client.id
        System.out.println(commande);
          for (commande c : commande)
          {
              
          
        
        Pane paneback = new Pane();
paneback.setPrefSize(800.0, 61.0);
paneback.setStyle("-fx-background-color: #708C98;");
 
Label label1 = new Label(c.getId_commande()+"");
label1.setTextFill(Paint.valueOf("#f8f8f8"));
label1.setFont(Font.font("System Bold", 18.0));
label1.setLayoutX(30.0);
label1.setLayoutY(15.0);
 
Label label2 = new Label(c.getCl().getId_user()+"");
label2.setTextFill(Paint.valueOf("#f8f8f8"));
label2.setFont(Font.font("System Bold", 18.0));
label2.setLayoutX(89.0);
label2.setLayoutY(15.0);
 
Label label3 = new Label(c.getCl().getNom()+"");
label3.setTextFill(Paint.valueOf("#f8f8f8"));
label3.setFont(Font.font("System Bold", 18.0));
label3.setLayoutX(185.0);
label3.setLayoutY(15.0);
 
Label label4 = new Label(c.getCl().getPrenom());
label4.setTextFill(Paint.valueOf("#f8f8f8"));
label4.setFont(Font.font("System Bold", 18.0));
label4.setLayoutX(296.0);
label4.setLayoutY(15.0);
 
Label label5 = new Label(c.getCl().getAdresse());
label5.setTextFill(Paint.valueOf("#f8f8f8"));
label5.setFont(Font.font("System Bold", 18.0));
label5.setLayoutX(416.0);
label5.setLayoutY(15.0);
 
Label label6 = new Label(c.getTotal_commande()+"");
label6.setTextFill(Paint.valueOf("#f8f8f8"));
label6.setFont(Font.font("System Bold", 18.0));
label6.setLayoutX(536.0);
label6.setLayoutY(15.0);
 
Label label7 = new Label(c.getStatus());
label7.setTextFill(Paint.valueOf("#f8f8f8"));
label7.setFont(Font.font("System Bold", 18.0));
label7.setLayoutX(618.0);
label7.setLayoutY(15.0);
 
ImageView imageView1 = new ImageView();
imageView1.setImage(new Image(getClass().getResourceAsStream("../resources/trash.png")));
imageView1.setFitWidth(26.0);
imageView1.setFitHeight(27.0);
imageView1.setLayoutX(751.0);
imageView1.setLayoutY(15.0);
imageView1.setPreserveRatio(true);
imageView1.setPickOnBounds(true);
 imageView1.setOnMouseClicked(event -> {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Confirmation de suppression");
alert.setHeaderText("Voulez-vous vraiment supprimer cette commande ?");
alert.setContentText("Cliquez sur OK pour confirmer.");

Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    Pane parent = (Pane) paneback.getParent();
    sc.supprimercommande(c.getId_commande());
    parent.getChildren().remove(paneback);
   
}    
    
    
});
ImageView imageView2 = new ImageView();
imageView2.setImage(new Image(getClass().getResourceAsStream("../resources/icons8_Play_48px.png")));
imageView2.setFitWidth(24.0);
imageView2.setFitHeight(20.0);
imageView2.setLayoutX(719.0);
imageView2.setLayoutY(15.0);
imageView2.setPreserveRatio(true);
imageView2.setPickOnBounds(true);

ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("NonPaye", "Paye"));
choiceBox.getSelectionModel().select(c.getStatus());
choiceBox.setLayoutX(610.0);
choiceBox.setLayoutY(15.0);
choiceBox.setPrefHeight(25.0);
choiceBox.setPrefWidth(90.0);

 imageView2.setOnMouseClicked(event -> {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Confirmation la modifiacation ?");
alert.setHeaderText("Voulez-vous vraiment modifier cette commande ?");
alert.setContentText("Cliquez sur OK pour confirmer.");

Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    Pane parent = (Pane) paneback.getParent();
    sc.modifierCommand(new commande(c.getId_commande(), choiceBox.getValue()));
    nomuser.setText(u.getNom());
   
}    
    
    
});
 
paneback.getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, imageView1, imageView2,choiceBox);

    vbox1.getChildren().add(paneback);
}
          
           vbox1.setSpacing(1);
        // TODO
    }    
    
}
