/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hasse
 */
public class DetailController implements Initializable {

    @FXML
    private Button fxsave;
    @FXML
    private TextField fxxnom;
    @FXML
    private TextField fxxprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

       public void setNom(String message)
       {
       this.fxxnom.setText(message);
       }
       public void setPrenom(String message)
       {
       this.fxxprenom.setText(message);
       }
    @FXML
    private void save(ActionEvent event) {
    }
    
}
