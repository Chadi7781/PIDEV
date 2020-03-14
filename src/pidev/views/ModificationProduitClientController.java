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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entity.Produit;
import pidev.services.serviceProduit1;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModificationProduitClientController implements Initializable {

    @FXML
    private JFXTextField libb;
    @FXML
    private JFXTextField desc;
    @FXML
    private JFXTextField qte;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField poids;
    @FXML
    private JFXButton image;
    @FXML
    private JFXButton valider;
    @FXML
    private ImageView back;
    @FXML
    private JFXButton btn;
    @FXML
    private ImageView img;
 String imagexx;
     File file;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("afficherprocl.fxml"));
            Stage prStage = new Stage();
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            AfficherproclController irc = loader.getController();
            serviceProduit1 sp = new serviceProduit1();
            int id = Integer.parseInt(irc.idxx);
            System.out.println(id);
            libb.setText(sp.getLibellebyId(id));
            desc.setText(sp.getDescbyId(id));
            poids.setText(sp.getPoidsbyId(id).toString());
            prix.setText(sp.getPrixbyId(id).toString());
            qte.setText(sp.getQtegobyId(id).toString());
               File filex = new File(sp.getPhotobyId(id));
            Image image = new Image(filex.toString());
            System.out.println(filex.toURI().toString());
            img.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModificationProduitClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void image(ActionEvent event) {
            Produit p = new Produit();
          FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select PDF files");
        fileChooserr.setInitialDirectory(new File("C:"));
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        file = fileChooserr.showOpenDialog(img.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
        serviceProduit1 sp = new serviceProduit1();
        imagexx = file.toURI().toString();
         p.setPhoto(imagexx);
    }

    @FXML
    private void validerprod(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("afficherprocl.fxml"));
            Stage prStage = new Stage();
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            

            AfficherproclController irc = loader.getController();
            serviceProduit1 sp = new serviceProduit1();
           
            int idl = Integer.parseInt(irc.idxx);
           System.out.println("llllllllllllllllll"+idl);
        Produit p =new Produit();
        p.setNom_pd(libb.getText());
        p.setDescription(desc.getText());
    
        p.setPoids(Integer.parseInt(poids.getText()));
        p.setPrix(Integer.parseInt(prix.getText()));
        p.setQuantite(Integer.parseInt(qte.getText()));
        p.setPhoto(file.toURI().toString());
        sp.modifier(p,idl);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
   alert.setHeaderText("!!! Modification effectuer avec suucces !!!");
   alert.setContentText("succes");
   alert.showAndWait();
        
        valider.getScene().getWindow().hide();  
              
                loader.setLocation(getClass().getResource("Gerre_vente1.fxml"));
                
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void retour(ActionEvent event) {
    }
    
}
