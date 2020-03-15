/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.entity.Vehicule;
import pidev.services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class AjouterVehiculeController implements Initializable {

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
    private ComboBox<String> type;
    @FXML
    private TextField kilo;
    @FXML
    private TextField nbPlaces;
    @FXML
    private TextField marque;
    @FXML
    private ComboBox<String> puiss;
    @FXML
    private TextField prix;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> l = new ArrayList<String>();
        l.add("CUV");
        l.add("PICKUP");
        l.add("VAN");
        l.add("CAMPERVAN");
        l.add("MINI TRUCK");
        l.add("TRUCK");
        l.add("BIG TRUCK");
        ObservableList<String> oblist = FXCollections.observableArrayList(l);
        type.setItems(oblist);

        List<String> l2 = new ArrayList<String>();
        l2.add("4 CHEVAUX");
        l2.add("5 CHEVAUX");
           ObservableList<String> oblist2 = FXCollections.observableArrayList(l2);
        puiss.setItems(oblist2);
    }

    @FXML
    private void gotoEmploye(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("GererEmp.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    @FXML
    private void gotoStock(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    @FXML
    private void gotoDepot(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("geredepo.fxml"));
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
    private void Gestion_vehicule(ActionEvent event)  throws IOException {
        
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
    private void Ajouter(ActionEvent event) throws IOException {
        Vehicule v = new Vehicule();
        v.setMat(matricule.getText());
        v.setType(type.getValue());
        v.setMarque(marque.getText());
        v.setPuissance(puiss.getValue());
      v.setKilometrages(kilo.getText());
        v.setNbPlaces(nbPlaces.getText());
        v.setPrix(nbPlaces.getText());

        VehiculeService vs = new VehiculeService();
        vs.AjouterVehicule(v);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Ajout avec succes !!!");
        alert.showAndWait();
        
         Parent root = FXMLLoader.load(getClass().getResource("AfficherVehicule.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("AfficherVehicule.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }

}
