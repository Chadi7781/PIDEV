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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import pidev.entity.Livraison;
import pidev.entity.Utilisateur;
import pidev.services.LivraisonService;
import pidev.services.LivreurService;


/**
 * FXML Controller class
 *
 * @author 21627
 */
public class TraiterLivraisonAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label expAdmin;

    @FXML
    private Label expdestinatatire;

    @FXML
    private Label poidsAdmin;

    @FXML
    private Label fragileAdmin;

    @FXML
    private Label prixadmin;

    @FXML
    private Label adminDate;

     @FXML
    private ImageView Adminphoto;
     @FXML
    private CheckBox confirmerbox;
     private Livraison SelectedLivraison;
     @FXML
    private ComboBox<String> checkgovernat;
     @FXML
    private ComboBox<String> nomLivreur;
       @FXML
    private Label dispo;
      


    @FXML
    private Label etatAdmin;

    @FXML
    private TableView<Livraison> tableviewAdmin;
     @FXML
    private TableColumn<Livraison, Integer> refAdmin;
     LivraisonService ls = new LivraisonService();


    /* @FXML
    void Adminref(MouseEvent event) throws FileNotFoundException {
         Livraison l = tableviewAdmin.getSelectionModel().getSelectedItem();
        expAdmin.setText(l.getAdresse_depart());
        expdestinatatire.setText(l.getAdresse_arrive());
        Adminphoto.setImage(new Image(new FileInputStream("C:\\wamp64\\www\\JavaImages\\"+l.getPhoto_produit())));
        prixadmin.setText(String.valueOf(l.getPrix()));
        fragileAdmin.setText(l.getFragile());
        adminDate.setText(l.getDate_reception());
        etatAdmin.setText(l.getEtat());
        
        int poids=l.getPoids();
        if (poids ==1){
            poidsAdmin.setText("0 < Poids < 10");}
            else if (poids==2){
            poidsAdmin.setText("10 < Poids < 20");}
            else if (poids==3){
            poidsAdmin.setText("20 < Poids < 30");
            }else {
            poidsAdmin.setText("+30");    
            
            
            }}*/
    public void initData(Livraison livraison) throws FileNotFoundException{
        SelectedLivraison =livraison;
        expAdmin.setText(SelectedLivraison.getAdresse_depart());
        expdestinatatire.setText(SelectedLivraison.getAdresse_arrive());
        Adminphoto.setImage(new Image(new FileInputStream("C:\\wamp\\www\\JavaImages\\"+SelectedLivraison.getPhoto_produit())));
        prixadmin.setText(String.valueOf(SelectedLivraison.getPrix()));
        fragileAdmin.setText(SelectedLivraison.getFragile());
        adminDate.setText(SelectedLivraison.getDate_reception());
        etatAdmin.setText(SelectedLivraison.getEtat());
        
        int poids=SelectedLivraison.getPoids();
        if (poids ==1){
            poidsAdmin.setText("0 < Poids < 10");}
            else if (poids==2){
            poidsAdmin.setText("10 < Poids < 20");}
            else if (poids==3){
            poidsAdmin.setText("20 < Poids < 30");
            }else {
            poidsAdmin.setText("+30");    
            
            
        
    }}
    @FXML
    void OngovernatSelect(ActionEvent event) {
        nomLivreur.getItems().clear();
        
        ArrayList <String> disponible = new ArrayList<>();
        ArrayList <String> nom = new ArrayList<>();
        
        LivreurService ms = new LivreurService();
        
        String gouvrnorat;
        gouvrnorat = checkgovernat.getSelectionModel().getSelectedItem().toString();
        
        
        ArrayList <Utilisateur> livreur = ms.afficherLivreurParGouvernorat(gouvrnorat);
        
        System.out.println(livreur);
        
        for (Utilisateur g : livreur){
             System.out.println(g);
            nom.add(g.getUsername());
            disponible.add(g.getDisponible());
        
        }
        
        nomLivreur.getItems().addAll(nom);
        nomLivreur.setValue(nom.get(0));
        dispo.setText(disponible.get(0));
        livreur.clear();
        nom.clear();

    }
        @FXML
    void confirmeretat(ActionEvent event) throws SQLException, IOException {
        // Livraison l = tableviewAdmin.getSelectionModel().getSelectedItem();
    
      
           String EtatConfirmer="Confirmer";
           LivraisonService sa=new LivraisonService();
         
      
        SelectedLivraison.setEtat(EtatConfirmer);
       
       
           
               sa.update(SelectedLivraison,SelectedLivraison.getId_livraison());
                Parent blah = FXMLLoader.load(getClass().getResource("AfficherAdmin_Livraison.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
                     
               

    
       }
    @FXML
    void rejeterAction(ActionEvent event) throws SQLException, IOException {
        
                Parent blah = FXMLLoader.load(getClass().getResource("AfficherAdmin_Livraison.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
                     
               

    
       }
            

    
        

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* ObservableList<Livraison> obs = FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraisonClient()));
        tableviewAdmin.setItems(obs);
        refAdmin.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
        
        ObservableList<Livraison> abc = FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraisonClient()));
        tableviewAdmin.setItems(abc);
        ObservableList<Livraison> data =FXCollections.observableArrayList(Livraison.generateImageViews(ls.afficherLivraisonClient()));
        data=FXCollections.observableArrayList(obs);*/
        // TODO
       // AffectationLivreur.getItems().addAll("Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Le Kef","Mahdia","La Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan");
    }    
    
}
