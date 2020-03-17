/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import pidev.entity.Livraison;
import pidev.entity.Magasin;
import pidev.services.LivraisonService;
import pidev.services.ServiceClient;
import static pidev.views.LoginController.motpass;
import static pidev.views.LoginController.username;


/**
 * FXML Controller class
 *
 * @author 21627
 */

public class AfficherClient_livraisonController implements Initializable {
       @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TableView<Livraison> afficherClient;

    @FXML
    private TableColumn<Livraison, String> date_reception;

    @FXML
    private TableColumn<Livraison, String> etat;
       @FXML
    private TableColumn<Livraison, Integer> reference;

    @FXML
    private TableColumn<Livraison, ImageView> photo_produit;
      @FXML
    private TableColumn<Livraison, String> adresse_depart;
      @FXML
    private TableColumn<Livraison, Integer> magasin;

   

    @FXML
    private TableColumn<Livraison, Integer> prix;

    @FXML
    private TableColumn<Livraison, String> adresse_arrive;

    @FXML
    private TableColumn<Livraison, Integer> poids;

       @FXML
    private Label label_adresse_expediteur;

    @FXML
    private Label label_adresse_destinataire;

    @FXML
    private Label label_fragile;

    @FXML
    private Label label_poids;

    
      @FXML
    private ImageView image_photo;
      @FXML
    private Label label_prix;
      @FXML
    private Button btnsupprimer;
      @FXML
    private Button btnModififer;


      
    
    
    Magasin m =new Magasin();
    LivraisonService ls = new LivraisonService();
    Livraison l =new Livraison();
     public static Livraison ab;
    


  @FXML
    void supprimer(ActionEvent event) {
        
           delete();
  
        
       afficherClient.getItems().removeAll(afficherClient.getSelectionModel().getSelectedItem());
       System.out.println( afficherClient);
      

    
    }
    
  public void delete()
  {
        LivraisonService smg = new LivraisonService();
        smg.SupprimerLivraison(afficherClient.getSelectionModel().getSelectedItem().getId_livraison());
          System.out.println(afficherClient.getSelectionModel().getSelectedItem().getId_livraison());
  }
   
  @FXML
    void AfficherInfo(MouseEvent event) throws FileNotFoundException {
        Livraison l = afficherClient.getSelectionModel().getSelectedItem();
        label_adresse_expediteur.setText(l.getAdresse_depart());
        label_adresse_destinataire.setText(l.getAdresse_arrive());
        image_photo.setImage(new Image(new FileInputStream("C:\\wamp64\\www\\JavaImages\\"+l.getPhoto_produit())));
        label_prix.setText(String.valueOf(l.getPrix()));
        label_fragile.setText(l.getFragile());
        int poids=l.getPoids();
        if (poids ==1){
            label_poids.setText("0 < Poids < 10");}
            else if (poids==2){
            label_poids.setText("10 < Poids < 20");}
            else if (poids==3){
            label_poids.setText("20 < Poids < 30");
            }else {
            label_poids.setText("+30");    
            
            
        }
        if (l.getEtat().equals("Confirmer")){
        btnsupprimer.setVisible(false);
        btnModififer.setVisible(false);}
        int idMagasin = l.getId_magasin();
        
        //label_point_collecte.setText(value);
        
        
        
        
        System.out.println(l);

    }
       
        
        

    


    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            
    //void ChargementLivraison(){
        
        
        
        /*ObservableList<Livraison> Oliste_livraison = FXCollections.observableArrayList();
        
        
        for (int i = 0; i < ls.afficherLivraison().size(); i++ ){
        
        Oliste_livraison.add(ls.afficherLivraison().get(i));
        }*/
         ServiceClient sc = new ServiceClient();
               FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
           try {
               Parent root = loader.load();
                LoginController irc = loader.getController();
            String mail = irc.username;

            int id = sc.getIdbymail(mail);
            System.out.println(id);
       
        
        ObservableList<Livraison> obs = FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraison(id)));
        afficherClient.setItems(obs);
        reference.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
        date_reception.setCellValueFactory(new PropertyValueFactory<>("date_reception"));
        
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        photo_produit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Livraison, ImageView>, ObservableValue<ImageView>>() {
            @Override
            public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<Livraison, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImgview());
            }
        });
        ObservableList<Livraison> abc = FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraison(id)));
        afficherClient.setItems(abc);
        ObservableList<Livraison> data =FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraison(id)));
        data=FXCollections.observableArrayList(obs);
           } catch (IOException ex) {
               Logger.getLogger(AfficherClient_livraisonController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       
        
          
        
        


        
   }
     @FXML
    void demande_livraison(ActionEvent event) throws IOException {
     Parent blah = FXMLLoader.load(getClass().getResource("Demande_Livraison.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
    }
@FXML
    void modifier(ActionEvent event) throws IOException {
        
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("STOCK FOR SPEED");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner une Livraison");
            alert.show();
        
    }


    

    @FXML
    private void AfficherInfo(KeyEvent event) {
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
          ServiceClient sc = new ServiceClient();
        
            String role = sc.getRolebyId(sc.getIdbymail(username));

            if (role.equals("client")) {
                Parent root = FXMLLoader.load(getClass().getResource("AccueilClient.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();

                
            } else if(role.equals("societe")){
              
                Parent root = FXMLLoader.load(getClass().getResource("AccueilEntreprise.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
        }}

    
      /* ChargementLivraison();
        
        
    }  
    
    void ChargementLivraison(){
        
        LivraisonService mng = new LivraisonService();
        ArrayList <Livraison> clients = mng.afficherLivraisonAdmin();
         
        
        ObservableList<Livraison> Oliste_annonce = FXCollections.observableArrayList();
        
        
       for (int i = 0; i < clients.size(); i++ ){
           System.out.println(clients.get(i));
           Oliste_annonce.add(clients.get(i));
       }

            

        date_reception.setCellValueFactory(new PropertyValueFactory<>("date_reception"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
      

        //afficherClient.setItems(Oliste_annonce);
        //System.out.println(Oliste_annonce);    
        */   
   