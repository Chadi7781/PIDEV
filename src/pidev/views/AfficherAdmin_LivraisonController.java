/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import pidev.entity.Livraison;
import pidev.services.LivraisonService;
import pidev.utils.css.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author 21627
 */
public class AfficherAdmin_LivraisonController implements Initializable {
    
     @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button Bt_Dashboard;

    @FXML
    private Button Bt_Emp;

    @FXML
    private Button Bt_Stock;

    @FXML
    private Button Bt_Stock1;
    
     @FXML
    private TableView<Livraison> tableLivraison;

    @FXML
    private TableColumn<Livraison, Integer> reference;

    @FXML
    private TableColumn<Livraison, String> date_reception;

    @FXML
    private TableColumn<Livraison, ImageView> photo_produit;

    @FXML
    private TableColumn<Livraison, String> etat;
     @FXML
    private TextField searchField;
      FilteredList<Livraison> filteredData ;
    @FXML
    private Button btnRechercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          //ChargementLivraison();
        
        
    //}  
    
    //void ChargementLivraison(){
        
        LivraisonService ls = new LivraisonService();
        
        /*ObservableList<Livraison> Oliste_livraison = FXCollections.observableArrayList();
        
        
        for (int i = 0; i < ls.afficherLivraison().size(); i++ ){
        
        Oliste_livraison.add(ls.afficherLivraison().get(i));
        }*/
       
        
        ObservableList<Livraison> obs = FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraisonClient()));
        tableLivraison.setItems(obs);
        reference.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
        date_reception.setCellValueFactory(new PropertyValueFactory<>("date_reception"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        photo_produit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Livraison, ImageView>, ObservableValue<ImageView>>() {
            @Override
            public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<Livraison, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImgview());
            }
            
        });
        ObservableList<Livraison> abc = FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraisonClient()));
        tableLivraison.setItems(abc);
        ObservableList<Livraison> data =FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraisonClient()));
        data=FXCollections.observableArrayList(obs);
        filteredData= new FilteredList<>(data, e -> true);
          
        
        


        
   }
 @FXML
    void Rechercheravancès(ActionEvent event) {
     
         searchField.textProperty().addListener((observableValue,oldValue,newValue) ->{
        filteredData.setPredicate((Predicate<? super Livraison>) (Livraison user)->{
        if(newValue == null || newValue.isEmpty())
        {return true ;}
        String lowerCaseFilter =newValue.toLowerCase();
        if(String.valueOf(user.getId_livraison()).toLowerCase().contains(lowerCaseFilter))
        {return true;}
        else if(user.getDate_reception().toLowerCase().contains(lowerCaseFilter))
        {return true;}
        else if(user.getEtat().toLowerCase().contains(lowerCaseFilter))
        {return true;}
        return false ;
    });
    });
         SortedList<Livraison> sortedData = new SortedList<>(filteredData);
         sortedData.comparatorProperty().bind(tableLivraison.comparatorProperty());
         tableLivraison.setItems(sortedData);
    
       
    }
    
    @FXML 
     void TraiterDemande(ActionEvent event) throws IOException {
         
         
          if (tableLivraison.getSelectionModel().getSelectedItem() != null) {
              FXMLLoader loader= new FXMLLoader();
               loader.setLocation(getClass().getResource("TraiterLivraisonAdmin.fxml"));
                Parent blah = loader.load();
            Scene scene = new Scene(blah);
            TraiterLivraisonAdminController Controller =loader.getController();
            Controller.initData(tableLivraison.getSelectionModel().getSelectedItem());
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();

            
            
        
                   } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("STOCK FOR SPEED");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner une Livraison");
            alert.show();
        }
    }

    @FXML
    private void Dashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    @FXML
    private void Employe(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("GererEmp.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    @FXML
    private void Stock(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    @FXML
    private void Depot(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("geredepo.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
     @FXML
    void PointdeCollecte(ActionEvent event) throws IOException {
     Parent blah = FXMLLoader.load(getClass().getResource("Gerer_magasin.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
    }
}
     
     
     
     
     
    




