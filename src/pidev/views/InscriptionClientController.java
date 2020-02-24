/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entity.Utilisateur;
import pidev.services.ServiceClient;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class InscriptionClientController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXPasswordField motdepasse;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField numtel;
    @FXML
    private JFXDatePicker datedenaissance;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton inscrire;
    @FXML
    private JFXButton choisirimg;
    File file;
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
    private void ajouter(ActionEvent event) throws IOException {
        if(nom.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre nom !!!");
        alert.showAndWait();}
        else if (prenom.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre prennom !!!");
        alert.showAndWait();}
        else if (motdepasse.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre mot de passe !!!");
        alert.showAndWait();}
        else if (mail.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre e-mail !!!");
        alert.showAndWait();}
        else if (numtel.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre numéro telephonique !!!");
        alert.showAndWait();}
        else
        {  Utilisateur u = new Utilisateur();
        u.setUsername(nom.getText());
        u.setPrenom(prenom.getText());
        u.setPassword(motdepasse.getText());
        u.setEmail(mail.getText());
        u.setTelephone(numtel.getText());
       u.setDate_naissance(datedenaissance.getValue().toString());
      u.setPhoto(file.toURI().toString());
        ServiceClient sc = new ServiceClient();
        sc.ajouterClient(u);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Inscription Avec Success !!!");
        alert.showAndWait();

        FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();}
    }

    @FXML
    private void choisirimage(ActionEvent event) {

        FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select Image");
        fileChooserr.setInitialDirectory(new File("C:"));
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        file = fileChooserr.showOpenDialog(img.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
  
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }
}
