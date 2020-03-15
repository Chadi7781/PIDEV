/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pidev.services.ServiceClient;
import pidev.services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class ConfirmerLocationVoitureController implements Initializable {

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
    private JFXButton louer;
    @FXML
    private JFXButton annuler;
    @FXML

    private JFXDatePicker date1;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField matr;
    @FXML
    private JFXTextField prixxx;
    @FXML
    private JFXTextField marqq;
    static String matrr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LouerVehicule.fxml"));
        LouerVehiculeController irc = loader.getController();

        matr.setText(irc.mat);
        marqq.setText(irc.marq);
        prixxx.setText(irc.pri);
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void Louer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LouerVehicule.fxml"));
        LouerVehiculeController irc = loader.getController();

        matrr = irc.mat;

        System.out.println(matrr);
        FXMLLoader loaderr = new FXMLLoader(getClass().getResource("login.fxml"));
        LoginController ir = loaderr.getController();
        String mail = ir.username;

        LocalDate d = date.getValue();
        LocalDate d1 = date1.getValue();

        if (d1.compareTo(d) < 0) {
            VehiculeService vs = new VehiculeService();
            ServiceClient sc = new ServiceClient();
            
        vs.LouerVehicule(matrr, sc.getIdbymail(mail),d.toString(), d1.toString());
          Parent root = FXMLLoader.load(getClass().getResource("MesVehicule.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Date debut location doit etre < a date fin location !!!");
            alert.showAndWait();
                }
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
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
