/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author rassa
 */
public class CommandeController implements Initializable {

    @FXML
    private VBox vbox1;
    @FXML
    private RadioButton livArtziiNow;
    @FXML
    private ToggleGroup modeLivraison;
    @FXML
    private RadioButton livDomicile;
    @FXML
    private RadioButton livArtziiNow1;
    @FXML
    private ToggleGroup modeLivraison1;
    @FXML
    private RadioButton livDomicile1;
    @FXML
    private ToggleGroup modeLivraison2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
