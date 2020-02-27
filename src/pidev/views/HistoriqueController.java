
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import pidev.entity.Commande;
import pidev.entity.LignePanier;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import pidev.services.CommandeService;
import pidev.services.ServiceClient;
import static pidev.views.LoginController.motpass;
import static pidev.views.LoginController.username;

/**
 * FXML Controller class
 *
 * @author amall
 */
public class HistoriqueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
private TableView tabhistorique;
@FXML
private Pane retour;

Set<LignePanier> spanier = new HashSet<LignePanier>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
          retour.setOnMouseClicked((ActionEvent) -> {
            try {               
                                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("panier.fxml")); 
                Parent root_panier = loader.load();
                PanierController pc = loader.getController();
                pc.render(spanier);
                retour.getScene().setRoot(root_panier);
                
                
            } catch (IOException e) {
            e.printStackTrace();
        }
        });
}
    private void afficher() throws IOException,SQLException{

        CommandeService sc= new CommandeService();
        ServiceClient sec = new ServiceClient();
        int userId=sec.getIdbymail(username);
        List<Commande> lst = sc.afficherCommande(userId);
        /*List<Commande> lst = new ArrayList(
                
        Arrays.asList(new Commande(0,new Date(),"test0",500.0),
        new Commande(1,new Date(),"test1",500.0),
        new Commande(2,new Date(),"test2",500.0),
        new Commande(3,new Date(),"test3",500.0))
        );*/
       final ObservableList<Commande> obsr =FXCollections.observableArrayList(lst);
        
            System.out.println(obsr.toString());
            TableColumn< Commande, Integer> column1 = new TableColumn<>("Id commande");
            column1.setCellValueFactory(new PropertyValueFactory<>("id_commande"));
            TableColumn<Commande, Date> column2 = new TableColumn<>("Date");
            column2.setCellValueFactory(new PropertyValueFactory<>("date"));
            TableColumn<Commande, String> column3 = new TableColumn<>("Adresse de destination");
            column3.setCellValueFactory(new PropertyValueFactory<>("adresse_dest"));
            TableColumn<Commande, Double> column4 = new TableColumn<>("Prix total");
            column4.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
            tabhistorique.setItems(obsr);
            
            
            column1.setPrefWidth(131.0);
            column2.setPrefWidth(225.0);
            column3.setPrefWidth(284.0);
            column4.setPrefWidth(95.0);
            tabhistorique.getColumns().addAll(column1, column2, column3, column4);
            
     }
  
       public void pass(Set<LignePanier> sp){
        //System.out.println("PanierController = " + sp.toString());
        spanier.addAll(sp);
        System.out.println(spanier.toString());
    } 


    


}
