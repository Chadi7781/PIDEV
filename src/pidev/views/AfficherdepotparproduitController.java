/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pidev.entity.Produit;
import pidev.services.ServiceClient;
import pidev.services.serviceProduit1;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AfficherdepotparproduitController implements Initializable {

    @FXML
    private Circle btnClose;
    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit,String> libb;
    @FXML
    private TableColumn<Produit,Integer> prix;
    @FXML
    private TableColumn<Produit,String> etat;
    @FXML
    private TableColumn<Produit, Integer> qt;
    @FXML
    private TableColumn<Produit, Integer> idprod;
      ObservableList<Produit>observableList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DemandDepotController.fxml"));
        Stage prStage = new Stage();
        Parent root;
        DemandDepotController irc =loader.getController();
        Integer id = Integer.parseInt(irc.id11);
        loader.setLocation(getClass().getResource("login.fxml"));
        LoginController ircc = loader.getController();
        String mail = ircc.username;
        ServiceClient sc = new ServiceClient();
        int idc = sc.getIdbymail(mail);
        // root = loader.load();
        
        //  Scene scene = new Scene(root);
        //prStage.setScene(scene);
        serviceProduit1 sp = new serviceProduit1();
        
           observableList= sp.getAll(idc,id);
        
        libb.setCellValueFactory(new PropertyValueFactory<>("nom_pd"));
        qt.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        idprod.setCellValueFactory(new PropertyValueFactory<>("id_pro"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        // Adresse.setCellValueFactory(new PropertyValueFactory<>("ADR"));
        table.setItems(observableList);
        table.refresh();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherdepotparproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void modif(ActionEvent event) {
    }

    @FXML
    private void supp(ActionEvent event) {
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
    }
    
}
