/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author amall
 */
public class FavoriteController implements Initializable {
 @FXML
private Pane retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         retour.setOnMouseClicked((ActionEvent) -> {
   try {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("Vitrine.fxml"));
    Parent root_vitrine = loader.load();
    VitrineController vc = loader.getController();
    retour.getScene().setRoot(root_vitrine);


   } catch (IOException e) {
    e.printStackTrace();
   }
  });
        // TODO
    }    
    
}
