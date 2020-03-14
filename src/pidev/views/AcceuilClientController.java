/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.services.ServiceClient;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class AcceuilClientController implements Initializable {

    @FXML
    private AnchorPane creer;
    @FXML
    private ImageView img;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label mail1;
    @FXML
    private Label telephone;
    @FXML
    private Label role;
    @FXML
    private Label datenais;
    @FXML
    private JFXButton logos;
    @FXML
    private JFXButton edit;
    @FXML
    private JFXButton apresVentes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceClient su = new ServiceClient();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            LoginController irc = loader.getController();
            String mail = irc.username;
            String mdp = irc.motpass;
         //   System.out.println(mail);
            nom.setText(su.getNombyId(su.getIdbymail(mail)));
            prenom.setText(su.getPrenombyId(su.getIdbymail(mail)));
            datenais.setText(su.getDatebyId(su.getIdbymail(mail)));
            mail1.setText(su.getMailbyId(su.getIdbymail(mail)));
            telephone.setText(su.getTelbyId(su.getIdbymail(mail)));
            File file = new File(su.getPhotobyId(su.getIdbymail(mail)));
            Image image = new Image(file.toString());
            System.out.println(file.toURI().toString());
            img.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @FXML
    private void logoutt(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        LoginController irc = loader.getController();
        irc.t1.setText(irc.username);
     //   irc.t2.setText(irc.motpass);
        prStage.show();
    }

    @FXML
    private void editer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("EditerProfil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
      
       
        prStage.show();
    }


    @FXML
    private void boutique(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Vitrine.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    @FXML
    private void gererproduit(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Gerre_vente1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
      
       
        prStage.show();
    }

    @FXML
    private void gererlivraison(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherClient_livraison.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
    
    
  private double xOffset = 0;
        private double yOffset = 0;
    @FXML
    private void handleActionRecFeed(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("ajout_reclamation.fxml"));
              Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getScreenY();
        }));
        
        root.setOnMouseDragged((MouseEvent event1)->{
            stage.setX(event1.getSceneX() - xOffset);
            stage.setY(event1.getSceneY() - yOffset);

        });
        
                stage.setScene(scene);
                new animatefx.animation.ZoomIn(root).play();

        stage.show();
            
        }
   


}
