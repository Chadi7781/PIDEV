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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entity.Produit;
import pidev.services.ServiceClient;
import pidev.services.serviceProduit1;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjouterProduitClientController implements Initializable {

    @FXML
    private JFXTextField libelle;
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
    private JFXButton btnClose;
    @FXML
    private ImageView btn_close;
    @FXML
    private ImageView img;
 File file;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void libelle(ActionEvent event) {
    }

    @FXML
    private void description(ActionEvent event) {
    }

    @FXML
    private void dte(ActionEvent event) {
    }

    @FXML
    private void prix(ActionEvent event) {
    }

    @FXML
    private void poids(ActionEvent event) {
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

    @FXML
    private void validerprod(ActionEvent event) {
     if ( libelle.getText().isEmpty())
        {    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
        } else 
        if ( desc.getText().isEmpty())
        {    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
        } else 
    if ( qte.getText().isEmpty())
        {    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
             } else 
    if ( prix.getText().isEmpty())
        {    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
            
            
        }
         else  if ( poids.getText().isEmpty())
        {    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
               
         }else {
            
         FXMLLoader loader = new FXMLLoader();
           
            
            loader.setLocation(getClass().getResource("login.fxml"));
            LoginController ircc = loader.getController();
            String mail = ircc.username;
            ServiceClient sc = new ServiceClient();
            int idc = sc.getIdbymail(mail);
            // root = loader.load();
            
            //  Scene scene = new Scene(root);
            //prStage.setScene(scene);
           loader.setLocation(getClass().getResource("categoriecli.fxml"));
            Stage prStage = new Stage();
            Parent root = null;
             CategoriecliController irc =loader.getController();
               Integer id = Integer.parseInt(irc.id11);
            
            Produit p = new Produit();
            p.setPoids(Integer.valueOf(poids.getText()));
            p.setPrix(Integer.valueOf(prix.getText()));
            p.setDescription(desc.getText());
            // p.setCategorie(categorie.getValue());
            p.setPhoto(file.toURI().toString());
            p.setNom_pd(libelle.getText());
            p.setQuantite(Integer.valueOf(qte.getText()));
            serviceProduit1 sp = new serviceProduit1();
            
            sp.ajouter1(p,idc,id);
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
           
            alert.setHeaderText("Succes");
            alert.showAndWait();
              loader.setLocation(getClass().getResource("Gerre_vente1.fxml"));
              
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
 }}

    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        btnClose.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Gerre_vente1.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void handleReturn(MouseEvent event) {
          try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gerre_vente1.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    
}
