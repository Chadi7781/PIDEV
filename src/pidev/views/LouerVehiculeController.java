/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pidev.entity.Vehicule;
import pidev.services.VehiculeService;
import static pidev.views.AfficherVehiculeController.mat;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class LouerVehiculeController implements Initializable {

    @FXML
    private Label rec;
    @FXML
    private Label labelrecherch;
    @FXML
    private JFXTextField recherche;
    @FXML
    private TableView<Vehicule> listvehicule;
    @FXML
    private TableColumn<Vehicule, String> matricule;
    @FXML
    private TableColumn<Vehicule, String> type;
    @FXML
    private TableColumn<Vehicule, String> puissance;
    @FXML
    private TableColumn<Vehicule, String> marque;
    @FXML
    private TableColumn<Vehicule, String> nbplaces;

    @FXML
    private JFXButton mesvehicules;
    @FXML
    private JFXButton louer;

    public static String mat = "";
    public static String typ;
    public static String puiss;
    public static String marq;
    public static String pri;
    public static String nbp;
    @FXML
    private TableColumn<Vehicule, String> prix;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VehiculeService vs = new VehiculeService();
        List<Vehicule> plist = vs.findAllVehicule();
        System.out.println("louloulou" + plist);
        matricule.setCellValueFactory(new PropertyValueFactory<>("mat"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        puissance.setCellValueFactory(new PropertyValueFactory<>("puissance"));
        marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        nbplaces.setCellValueFactory(new PropertyValueFactory<>("nbPlaces"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));

        ObservableList< Vehicule> oblist = FXCollections.observableArrayList(plist);
        listvehicule.setItems(oblist);
    }


    @FXML
    private void mesvehicules(ActionEvent event) throws IOException {
        
        
          Parent root = FXMLLoader.load(getClass().getResource("MesVehicule.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        
    }

    @FXML
    private void louer(ActionEvent event) throws IOException {
        VehiculeService vs = new VehiculeService();
        if (listvehicule.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Selctionnez une vehicule !!!");
            alert.showAndWait();
        } else {
            mat = listvehicule.getSelectionModel().getSelectedItem().getMat();
            typ = listvehicule.getSelectionModel().getSelectedItem().getType();
            puiss = listvehicule.getSelectionModel().getSelectedItem().getPuissance();
            marq = listvehicule.getSelectionModel().getSelectedItem().getMarque();
            nbp = listvehicule.getSelectionModel().getSelectedItem().getNbPlaces();
            pri = listvehicule.getSelectionModel().getSelectedItem().getPrix();

            Parent root = FXMLLoader.load(getClass().getResource("ConfirmerLocationVoiture.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        rec.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("AccueilEntreprise.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);

        prStage.show();
    }

}
