package pidev.views;

import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.P;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import pidev.entity.Depot;
import pidev.entity.Produit;
import pidev.entity.Reclamation;
import pidev.services.ServiceClient;
import pidev.services.serviceProduit1;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MenuController implements Initializable {

    @FXML
    private Circle btnClose;
    @FXML
    private TableView<Produit> table;
    
    
    private TableColumn<Produit, String> categorie;
    @FXML
    private TableColumn<Produit, Double> prix;
    @FXML
    private TableColumn<Produit,String> etat;
    
    ObservableList<Produit>observableList;
    @FXML
    private TableColumn<Produit, String> libb;
    @FXML
    private TableColumn<Produit, Integer> qt;
    @FXML
    private TableColumn<Produit, Integer> idprod;
    public static String idxx;
    @FXML
    private TableColumn<Produit, String> Adresse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         FXMLLoader loader = new FXMLLoader();
           
            Stage prStage = new Stage();
            Parent root;
         loader.setLocation(getClass().getResource("login.fxml"));
            LoginController ircc = loader.getController();
            String mail = ircc.username;
            ServiceClient sc = new ServiceClient();
            int idc = sc.getIdbymail(mail);
            // root = loader.load();
            
            //  Scene scene = new Scene(root);
            //prStage.setScene(scene);
           
        
        serviceProduit1 produit = new serviceProduit1();
        try {
            observableList = produit.afficher(idc);
      
        libb.setCellValueFactory(new PropertyValueFactory<>("nom_pd"));
        qt.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        idprod.setCellValueFactory(new PropertyValueFactory<>("id_pro"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
     // Adresse.setCellValueFactory(new PropertyValueFactory<>("ADR"));
        table.setItems(observableList);
        table.refresh();
          } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
      
    @FXML
    private void handleMouseEvent(MouseEvent event) {
  


        
        
    }
   

      

    @FXML
    private void modif(ActionEvent event) throws IOException {
          if (table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Selctionnez un evenement du tableau !!!");
            alert.showAndWait();
        } else {
             
         idxx=table.getSelectionModel().getSelectedItem().getId_pro().toString();
               
        FXMLLoader loader = new FXMLLoader();
        btnClose.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("ModificationProduitClient.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
                
    }}

    @FXML
    private void supp(ActionEvent event) throws IOException {
        serviceProduit1 sp = new serviceProduit1();
        sp.supprimer(table.getSelectionModel().getSelectedItem().getId_pro());
        table.refresh();
          Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
   alert.setHeaderText("!!! Suppression effectuer avec suucces !!!");
   alert.setContentText("succes");
   alert.showAndWait();
         FXMLLoader loader = new FXMLLoader();
       btnClose.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Menu.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        btnClose.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Gerre_vente.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void acheter(ActionEvent event) {
        
       Notifications notificationBuilder = Notifications.create()
               .title("Notification").text("le produit a ete vendu")
               .graphic(null)
               .hideAfter(Duration.seconds(5))
               .position(Pos.BOTTOM_RIGHT)
               .onAction(new EventHandler<ActionEvent>()
               { 
                   @Override
               public void handle (ActionEvent event){
               System.out.println("clicke on notification");
               }
               }
               
               );
       notificationBuilder.showConfirm();
    }
      
    
}
