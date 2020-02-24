/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class CreerCompteController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button entreprise;
    @FXML
    private Button client;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void inscritclient(ActionEvent event) throws IOException {
        
     FXMLLoader loader = new FXMLLoader();
                label.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("InscriptionClient.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void inscritentreprise(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
                label.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("InscriptionEntreprise.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
                label.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

  
}
