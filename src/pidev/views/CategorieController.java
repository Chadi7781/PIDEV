/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.gluonhq.charm.glisten.control.TextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entity.categorie;
import pidev.services.serviceProduit1;
import pidev.services.servicecategorie;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CategorieController implements Initializable {

    @FXML
    private ImageView Photo_Input;
    @FXML
    private Button button_Submit;
    @FXML
    private Button Bt_Dashboard;
    @FXML
    private Button Bt_Emp;
    @FXML
    private Button Bt_Stock;
    @FXML
    private Button Bt_Stock1;
    @FXML
    private Button Bt_Stock11;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXButton image;
    @FXML
    private ImageView img;
     File file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void gotoDashbord(ActionEvent event) {
    }

    @FXML
    private void gotoEmploye(ActionEvent event) {
    }

    @FXML
    private void gotoStock(ActionEvent event) {
    }

    @FXML
    private void gotoDepot(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        categorie p = new categorie();
        p.setNom(nom.getText());
         p.setPht(file.toURI().toString());
        servicecategorie sp = new servicecategorie ();
         sp.ajouter(p);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setHeaderText("Succes");
        alert.showAndWait();
          Parent root = FXMLLoader.load(getClass().getResource("affichercategorie.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
       
    }

    @FXML
    private void image(ActionEvent event) {
        FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select Image");
        fileChooserr.setInitialDirectory(new File("C:"));
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        file = fileChooserr.showOpenDialog(img.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }
    
}
