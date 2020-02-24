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
public class MotpasseoublieController implements Initializable {

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
    private JFXButton Envoyer;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton back;
    @FXML
    private JFXTextField cd;
    public int code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("login.fxml"));
            LoginController ircc = loader.getController();

            code = ircc.codem;

        } catch (Exception ex) {
            Logger.getLogger(MotpasseoublieController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void Envoyer(ActionEvent event) throws IOException {
        
        int codex = Integer.parseInt(cd.getText());
        ServiceClient sc = new ServiceClient();
        String x="x";
        if (cd.getText().toString().equals(x))
        {Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!Veuillez taper le code de Verification !!!");
            alert.showAndWait();
        }
        
        else if (code == codex) {
            
            FXMLLoader loader = new FXMLLoader();
            rec.getScene().getWindow().hide();
            Stage prStage = new Stage();
            loader.setLocation(getClass().getResource("NewPassword.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            prStage.setResizable(false);
            prStage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Code incorrecte !!!");
            alert.showAndWait();
        
    }}

    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
            rec.getScene().getWindow().hide();
            Stage prStage = new Stage();
            loader.setLocation(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            prStage.setResizable(false);
            prStage.show();
    }

}
