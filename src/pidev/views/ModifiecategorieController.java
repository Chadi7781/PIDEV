/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entity.Produit;
import pidev.entity.categorie;
import pidev.services.serviceProduit1;
import pidev.services.servicecategorie;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifiecategorieController implements Initializable {

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
    private JFXButton image;
    @FXML
    private ImageView img;
    @FXML
    private JFXTextField nom;
 File file;
  String imagexx;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            FXMLLoader loader = new FXMLLoader();
            categorie p = new categorie();
            loader.setLocation(getClass().getResource("affichercategorie.fxml"));
            Stage prStage = new Stage();
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            
            AffichercategorieController irc = loader.getController();
            
            servicecategorie sp = new servicecategorie ();
            
            int id = Integer.parseInt(irc.idxx);
            System.out.println(id);
            nom.setText(sp.getnom(id));
         
            File filex = new File(sp.getPhotobyId(id));
            Image image = new Image(filex.toString());
            System.out.println(filex.toURI().toString());
            img.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
      
    }   catch (SQLException ex) {
            Logger.getLogger(ModifiecategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }  }  

    @FXML
    private void ajouter(ActionEvent event) throws IOException, SQLException {
         FXMLLoader loader = new FXMLLoader();
         
            loader.setLocation(getClass().getResource("affichercategorie.fxml"));
            Stage prStage = new Stage();
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            

            AffichercategorieController irc = loader.getController();
            servicecategorie sp = new servicecategorie();
           
            int idl = Integer.parseInt(irc.idxx);
           System.out.println("llllllllllllllllll"+idl);
           categorie p = new categorie();
       
       nom.setText(sp.getnom(idl));
       
       
    p.setPht(file.toURI().toString());
       
        sp.modifier(p,idl);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
   alert.setHeaderText("!!! Modification effectuer avec suucces !!!");
   alert.setContentText("succes");
   alert.showAndWait();
        
        button_Submit.getScene().getWindow().hide();  
              
                loader.setLocation(getClass().getResource("affichercategorie.fxml"));
                
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
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
    private void image(ActionEvent event) {
            categorie p = new categorie();
          FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select PDF files");
        fileChooserr.setInitialDirectory(new File("C:"));
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        
        file = fileChooserr.showOpenDialog(img.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        
        img.setImage(image);
        
       servicecategorie sp = new servicecategorie ();
        imagexx = file.toURI().toString();
        p.setPht(imagexx);
       
    }
    
}
