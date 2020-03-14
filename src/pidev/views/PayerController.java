/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pidev.services.ServicePaiement;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PayerController implements Initializable {

    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXTextField moisexp;
    @FXML
    private JFXTextField anneexp;
    @FXML
    private JFXTextField Numcarte;
    @FXML
    private JFXTextField cvccode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void payer(ActionEvent event) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException, IOException {
         ServicePaiement p = new ServicePaiement();
        p.payer("4242424242424242", 12, 18, "458", 1000, "testpaimenet");
         FXMLLoader loader = new FXMLLoader();
     
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("afficherprocl.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
         
    }
    
}
