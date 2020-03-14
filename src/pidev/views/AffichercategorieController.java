/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.entity.Produit;
import pidev.entity.categorie;
import pidev.services.serviceProduit1;
import pidev.services.servicecategorie;
import static pidev.views.MenuController.idxx;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AffichercategorieController implements Initializable {

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
public static   String idxx;
   List<categorie> array= new ArrayList<>();
    private ComboBox<categorie> cat;
    @FXML
    private TableView<categorie> table;
    @FXML
    private TableColumn<categorie,String> libb;
    @FXML
    private TableColumn<categorie,Integer> id;
      ObservableList<categorie>observableList;
    @FXML
    private Button mod;
    @FXML
    private TableColumn<categorie,Integer> idcat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
             servicecategorie sp = new servicecategorie ();
            observableList= sp.getAll();
           libb.setCellValueFactory(new PropertyValueFactory<>("nom"));
           table.setItems(observableList);
        table.refresh();
        } catch (SQLException ex) {
            Logger.getLogger(AffichercategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("categorie.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
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
    private void supp(ActionEvent event) throws IOException {
         servicecategorie sp = new servicecategorie ();
         sp.supprimer(table.getSelectionModel().getSelectedItem().getId());
      
        table.refresh();
          Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText("!!! Suppression effectuer avec suucces !!!");
        alert.setContentText("succes");
        alert.showAndWait();
         Parent root = FXMLLoader.load(getClass().getResource("categorie.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
       
    }

    @FXML
    private void mod(ActionEvent event) throws IOException {
         if (table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Selctionnez un evenement du tableau !!!");
            alert.showAndWait();
        } else {
             
         idxx=table.getSelectionModel().getSelectedItem().getId().toString();
               
        FXMLLoader loader = new FXMLLoader();
       mod.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("modifiecategorie.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
                
    }}
    }
    

