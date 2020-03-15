/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.entity.Vehicule;
import pidev.services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class AfficherVehiculeController implements Initializable {

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
    private TableView<Vehicule> listvehicule;

    @FXML
    private TableColumn<Vehicule, String> type;
    @FXML
    private TableColumn<Vehicule, String> puissance;
    @FXML
    private TableColumn<Vehicule, String> marque;

    @FXML
    private TableColumn<Vehicule, String> etat;

    @FXML
    private TableColumn<Vehicule, String> kilometrages;
    @FXML
    private TableColumn<Vehicule, String> matricule;
    @FXML
    private JFXButton Maintenir;

    public static String mat = "";
    public static String typ;
    public static String puiss;
    public static String marq;
    public static String kilo;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VehiculeService vs = new VehiculeService();
        List<Vehicule> plist = vs.findAllVehiculeadmin();
        System.out.println("kkk" + plist);
        matricule.setCellValueFactory(new PropertyValueFactory<>("mat"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        puissance.setCellValueFactory(new PropertyValueFactory<>("puissance"));
        marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        kilometrages.setCellValueFactory(new PropertyValueFactory<>("mar"));

        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));

        //etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        ObservableList< Vehicule> oblist = FXCollections.observableArrayList(plist);
        listvehicule.setItems(oblist);
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
    private void Ajouter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjouterVehicule.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Maintenir(ActionEvent event) throws IOException {

        VehiculeService vs = new VehiculeService();
        if (listvehicule.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Selctionnez une vehicule !!!");
            alert.showAndWait();
        } else {

            mat = listvehicule.getSelectionModel().getSelectedItem().getMat();

            Parent root = FXMLLoader.load(getClass().getResource("MaintenanceVehicule.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
}
