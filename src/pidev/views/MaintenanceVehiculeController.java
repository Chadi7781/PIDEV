/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.entity.Maintenance;
import pidev.services.ServiceMaintenance;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class MaintenanceVehiculeController implements Initializable {

    @FXML
    private Button Bt_Dashboard2;
    @FXML
    private Button Bt_Emp2;
    @FXML
    private Button Bt_Stock2;
    @FXML
    private Button Bt_Stock21;
    @FXML
    private Button livraison;
    @FXML
    private Button btn_Rec_Feed;
    @FXML
    private Button Gestion_vehicule;
    @FXML
    private Button Bt_Dashboard21;
    @FXML
    private JFXButton Ajouter;
    @FXML
    private TextField matricule;
    @FXML
    private TextField nature;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXButton Annuler;
    @FXML
    private TextField cout;
    @FXML
    private JFXTextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherVehicule.fxml"));
        AfficherVehiculeController irc = loader.getController();

        matricule.setText(irc.mat);

        //     id = irc.idde;
    }

    @FXML
    void gotoEmploye(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GererEmp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotoDepot(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("geredepo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void gotoStock(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void livraison(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherAdmin_Livraison.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleActionButtonRecFeed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu_admin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        new animatefx.animation.ZoomIn(root).play();
    }

    @FXML
    private void Gestion_vehicule(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherVehicule.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        new animatefx.animation.ZoomIn(root).play();
    }

    @FXML
    private void categorie(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("affichercategorie.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Ajouter(ActionEvent event) {

        Maintenance m = new Maintenance();
        m.setMatricule(matricule.getText());
        m.setNature(nature.getText());
        m.setDate(date.getValue().toString());
        m.setCout(cout.getText());
        m.setDescription(description.getText());

        ServiceMaintenance ms = new ServiceMaintenance();
        ms.ajouterMaintenance(m);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Ajout avec succes !!!");
        alert.showAndWait();
    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AfficherVehicule.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

}
