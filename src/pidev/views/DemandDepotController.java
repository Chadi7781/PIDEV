/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pidev.entity.Depot;
import pidev.services.ServiceClient;
import pidev.services.ServiceDepot;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class DemandDepotController implements Initializable {

    @FXML
    private Circle btnClose;
    @FXML
    private Label rec;
    @FXML
    private JFXButton valider;
    @FXML
    private JFXButton annuler;
    @FXML
    private TableColumn<Depot, String> adresse;
    @FXML
    private TableColumn<Depot, Integer> surface;
    @FXML
    private TableColumn<Depot, Integer> prix;
    @FXML
    private TableView<Depot> depot;
    @FXML
    private TableColumn<Depot, Integer> iddepot;
    @FXML
    private JFXButton valider1;
    @FXML
    private JFXButton valider2;
    @FXML
    private JFXButton back;
    public static String adrs = "";
    public static Integer pri;
    public static Integer surfac;
    public static Integer idde;
    @FXML
    private TableColumn<Depot, String> datedebut;
    @FXML
    private TableColumn<Depot, String> datefin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valider2.setDisable(true);
        ServiceDepot sd = new ServiceDepot();
        List<Depot> plist = sd.findAllDepots();
        System.out.println(plist);
        iddepot.setCellValueFactory(new PropertyValueFactory<>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("pays"));
        surface.setCellValueFactory(new PropertyValueFactory<>("surface"));
        datedebut.setVisible(false);
        datefin.setVisible(false);
        //etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        ObservableList<Depot> oblist = FXCollections.observableArrayList(plist);
        depot.setItems(oblist);
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void valider(ActionEvent event) throws IOException {
        ServiceDepot sd = new ServiceDepot();
        ServiceClient sc = new ServiceClient();
        if (depot.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Selctionnez un depot !!!");
            alert.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            LoginController irc = loader.getController();
            String mail = irc.username;

            adrs = depot.getSelectionModel().getSelectedItem().getPays();
            surfac = depot.getSelectionModel().getSelectedItem().getSurface();
            idde = depot.getSelectionModel().getSelectedItem().getId();
            pri = depot.getSelectionModel().getSelectedItem().getPrix();
            FXMLLoader loaderr = new FXMLLoader();
            rec.getScene().getWindow().hide();
            Stage prStage = new Stage();
            loaderr.setLocation(getClass().getResource("LouerDepot.fxml"));
            Parent roots = loaderr.load();
            Scene scene = new Scene(roots);
            prStage.setScene(scene);
            prStage.setResizable(false);

            prStage.show();

        }
        //////////////////////////////

    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
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

    @FXML
    private void mesdepots(ActionEvent event) {
        datedebut.setVisible(true);
        datefin.setVisible(true);
        valider2.setDisable(false);
        valider.setDisable(true);
        ServiceDepot sd = new ServiceDepot();
        ServiceClient sc = new ServiceClient();
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            LoginController irc = loader.getController();
            String mail = irc.username;

            int id = sc.getIdbymail(mail);
            List<Depot> plist = new ArrayList<>();
            List<Integer> plistx = sd.getAllDepotForEntreprise(id);

            for (int i : plistx) {
                Depot d = new Depot();
                d.setId(i);
                d.setPays(sd.getAdresseDepotbyId(i));
                d.setSurface(sd.getSurfaceDepotbyId(i));
                d.setPrix(sd.getPrixDepotbyId(i));
                d.setDatedebut(sd.getDateDebutDepotbyId(i));
                d.setDatefin(sd.getDateFinDepotbyId(i));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = d.getDatefin();
                Date aujourdhui = new Date();
                Date datefi = sdf.parse(date2);
                if (aujourdhui.compareTo(datefi) < 0) {

                    plist.add(d);
                } else {
                    sd.SetDepotDispo(d.getId());
                }
            }
            iddepot.setCellValueFactory(new PropertyValueFactory<>("id"));
            prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            adresse.setCellValueFactory(new PropertyValueFactory<>("pays"));
            surface.setCellValueFactory(new PropertyValueFactory<>("surface"));
            datedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
            datefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
            ObservableList<Depot> oblist = FXCollections.observableArrayList(plist);
            depot.setItems(oblist);
            depot.refresh();
        } catch (IOException ex) {
            Logger.getLogger(DemandDepotController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DemandDepotController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void louer(ActionEvent event) {
        datedebut.setVisible(false);
        datefin.setVisible(false);
        valider.setDisable(false);
        ServiceDepot sd = new ServiceDepot();
        List<Depot> plist = sd.findAllDepots();
        System.out.println(plist);
        iddepot.setCellValueFactory(new PropertyValueFactory<>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("pays"));
        surface.setCellValueFactory(new PropertyValueFactory<>("surface"));

        //etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        ObservableList<Depot> oblist = FXCollections.observableArrayList(plist);
        depot.setItems(oblist);
        depot.refresh();
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
