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
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
public class LouerDepotController implements Initializable {

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
    private JFXDatePicker date;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton back;
    @FXML
    private JFXDatePicker date1;
    @FXML
    private JFXTextField adrss;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField surface;
    public int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DemandDepot.fxml"));
        DemandDepotController irc = loader.getController();
        
        adrss.setText(irc.adrs);
        prix.setText(irc.pri.toString());
        surface.setText(irc.surfac.toString());
        id = irc.idde;
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void Louer(ActionEvent event) throws IOException {
     
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            LoginController irc = loader.getController();
            String mail = irc.username;
        LocalDate d = date.getValue();
         LocalDate d1 = date1.getValue();
          if (d1.compareTo(d) < 0) {

         ServiceDepot sd = new ServiceDepot();
         ServiceClient sc = new ServiceClient();
         sd.LouerDepot(id, sc.getIdbymail(mail), d1.toString(), d.toString());
         
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes");
            alert.setHeaderText(null);
            alert.setContentText("!!! Vous avez bien loué ce depot !!!");
            alert.showAndWait();
            
          FXMLLoader loaderr = new FXMLLoader();
        rec.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loaderr.setLocation(getClass().getResource("DemandDepot.fxml"));
        Parent root = loaderr.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);

        prStage.show();
                } else {
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
                adrss.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("AccueilEntreprise.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
                adrss.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("DemandDepot.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

}
