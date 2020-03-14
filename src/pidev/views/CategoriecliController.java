/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pidev.entity.categorie;
import pidev.services.servicecategorie;
import static pidev.views.CategorieentreController.idcat;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CategoriecliController implements Initializable {
  public static String idll;
     public static String id11;
public static Integer idcat;
    public static int id15;
    @FXML
    private Circle btnClose;
    @FXML
    private Label rec;
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton Ajouter;
    @FXML
    private JFXButton afficher;
    @FXML
    private TableView<categorie> table;
    @FXML
    private TableColumn<categorie, String> cat;
    @FXML
    private TableColumn<categorie, Integer> idc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
             servicecategorie sp = new servicecategorie ();
              List<categorie> plist = sp.getAll();
            
            cat.setCellValueFactory(new PropertyValueFactory<>("nom"));
            idc.setCellValueFactory(new PropertyValueFactory<>("id"));
          ObservableList<categorie> oblist = FXCollections.observableArrayList(plist);
          table.setItems(oblist);
        table.refresh();
        } catch (SQLException ex) {
            Logger.getLogger(AffichercategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

    @FXML
    private void handleMouseEvent(MouseEvent event) throws IOException {
        
    }

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
         if (table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Selctionnez un categorie du tableau !!!");
            alert.showAndWait();
        } else {
        idc.setCellValueFactory(new PropertyValueFactory<>("id"));
        idcat=table.getSelectionModel().getSelectedItem().getId();
        
         System.out.println("bmabla***********"+idcat);
            
       
           FXMLLoader loader = new FXMLLoader();
        Ajouter.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("ajouterProduitClient.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();  }
    
    }

    @FXML
    private void afficher(ActionEvent event) {
    }
    
}
