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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pidev.entity.Vehicule;
import pidev.services.ServiceClient;
import pidev.services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class MesVehiculeController implements Initializable {

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
    private TableColumn<Vehicule, String> prix;

    @FXML
    private TableColumn<Vehicule, String> dated;
    @FXML
    private TableColumn<Vehicule, String> datef;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceClient sc = new ServiceClient();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));

            Parent root = loader.load();

            LoginController irc = loader.getController();
            String mail = irc.username;

            int id = sc.getIdbymail(mail);
            VehiculeService vs = new VehiculeService();
            List<Vehicule> plist = new ArrayList<>();
            List<String> plistx = vs.findAllVehiculeforentreprise(id);

            for (String i : plistx) {
                Vehicule v = new Vehicule();
                v.setMat(i);
                v.setType(vs.getTypebymat(i));
                v.setPuissance(vs.getPuissbymat(i));
                v.setMarque(vs.getMarqbymat(i));
                v.setNbPlaces(vs.getnbPlacesbymat(i));
                v.setPrix(vs.getprixbymat(i));
                v.setDated(vs.getDateDebut(i));
                v.setDatef(vs.getDateFin(i));
                plist.add(v);
            }

            matricule.setCellValueFactory(new PropertyValueFactory<>("mat"));
            type.setCellValueFactory(new PropertyValueFactory<>("type"));
            puissance.setCellValueFactory(new PropertyValueFactory<>("puissance"));
            marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
            nbplaces.setCellValueFactory(new PropertyValueFactory<>("nbPlaces"));
            prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            dated.setCellValueFactory(new PropertyValueFactory<>("dated"));
            datef.setCellValueFactory(new PropertyValueFactory<>("datef"));
            ObservableList<Vehicule> oblist = FXCollections.observableArrayList(plist);
            listvehicule.setItems(oblist);
        } catch (IOException ex) {
            Logger.getLogger(MesVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader();
        rec.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("LouerVehicule.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);

        prStage.show();
    }

}
