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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pidev.services.ServiceClient;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class NewPasswordController implements Initializable {

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
    private JFXTextField cd;
    @FXML
    private JFXButton Envoyer;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton back;
    public static String mail="a";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void Envoyer(ActionEvent event) throws IOException {
        if(cd.getText().isEmpty())
        {  Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Champs vide !!!");
            alert.showAndWait();
        }
        else
        { String newPass = cd.getText();
        ServiceClient sc = new ServiceClient();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        LoginController ircc = loader.getController();
        mail=ircc.username;
        int id = sc.getIdbymail(ircc.username);
       
        sc.setNewMotPass(id, newPass);
        FXMLLoader loaderr = new FXMLLoader();
        cd.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loaderr.setLocation(getClass().getResource("login.fxml"));
        Parent root = loaderr.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);

        prStage.show();
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
            rec.getScene().getWindow().hide();
            Stage prStage = new Stage();
            loader.setLocation(getClass().getResource("Motpasseoublie.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            prStage.setResizable(false);
            prStage.show();
    }

}
