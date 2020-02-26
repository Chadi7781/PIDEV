/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import javafx.scene.control.Label;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pidev.entity.Livraison;
import pidev.services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author 21627
 */
public class Update_LivraisonController implements Initializable {
    /* @FXML
    private Button modifier;
     @FXML
  private Label AdresseExp;

    @FXML
    private Label AdresseDest;
    
    private Livraison SelectedLivraison;
    LivraisonService ls = new LivraisonService();
     public void initData(Livraison livraison) throws FileNotFoundException{
        SelectedLivraison =livraison;
        AdresseExp.setText(SelectedLivraison.getAdresse_depart());
        AdresseDest.setText(SelectedLivraison.getAdresse_arrive());
        
            
            
        
    }

    @FXML
    void Modifier(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherClient_livraison.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        

    }


    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
