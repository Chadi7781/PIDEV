/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.util.SessionState;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entity.Utilisateur;
import pidev.services.ServiceClient;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class EditerProfilController implements Initializable {

    @FXML
    private BorderPane border_pane;
    @FXML
    private Circle btnClose;
    @FXML
    private StackPane stackPane;
    @FXML
    private Pane pnlDernierRec;
    @FXML
    private Label rec;
    @FXML
    private JFXButton editer;
    @FXML
    private JFXButton annuler;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField motpass;
    @FXML
    private JFXTextField numerotel;
    @FXML
    private JFXButton choisirimg;
    File file;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton Desactiver;
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
            nom.setText(su.getNombyId(su.getIdbymail(mail)));
            prenom.setText(su.getPrenombyId(su.getIdbymail(mail)));
            date.setValue(su.getDateDbyId(su.getIdbymail(mail)).toLocalDate());
            email.setText(su.getMailbyId(su.getIdbymail(mail)));
            numerotel.setText(su.getTelbyId(su.getIdbymail(mail)));
            motpass.setText(su.getPassbyId(su.getIdbymail(mail)));
            File filex = new File(su.getPhotobyId(su.getIdbymail(mail)));
            Image image = new Image(filex.toString());
            System.out.println(filex.toURI().toString());
            img.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void Editer(ActionEvent event) {

        Utilisateur c = new Utilisateur();
        c.setUsername(nom.getText());
        c.setPrenom(prenom.getText());
        c.setDate_naissance(date.getValue().toString());
        c.setEmail(email.getText());
        c.setTelephone(numerotel.getText());
        c.setPassword(motpass.getText());
        c.setPhoto(file.toURI().toString());
        ServiceClient sc = new ServiceClient();
        sc.modifierClient(c, sc.getIdbymail(email.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("!!! Modification avec success !!!");
        alert.showAndWait();

    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("AccueilClient.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    @FXML
    private void Desactiver(ActionEvent event) throws IOException {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Supprimer votre compte");
      alert.setHeaderText("Vous voulez vraiment supprimer votre compte ?");
      alert.setContentText(null);
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.Desactiver.setText("No selection!");
      } else if (option.get() == ButtonType.OK) {
       ServiceClient sc = new ServiceClient();
        sc.supprimerClient(sc.getIdbymail(email.getText()));
        Alert alerte = new Alert(Alert.AlertType.INFORMATION);
        alerte.setTitle("Alerte");
        alerte.setHeaderText(null);
        alerte.setContentText("!!! Votre compte a ete supprime !!!");
        alerte.showAndWait();
        FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
      } else if (option.get() == ButtonType.CANCEL) {
         
      } else {
         this.Desactiver.setText("-");
      }
        /*ServiceClient sc = new ServiceClient();
        sc.supprimerClient(sc.getIdbymail(email.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!! Votre compte a ete supprime !!!");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader();
        nom.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();*/
    }

    @FXML
    private void choisirimage(ActionEvent event) {
       FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select PDF files");
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
        loader.setLocation(getClass().getResource("AccueilClient.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

}
