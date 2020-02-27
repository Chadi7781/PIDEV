

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import pidev.entity.Commande;
import pidev.entity.LignePanier;
import pidev.entity.Produit;
import pidev.entity.Produit_Commande;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import pidev.services.CommandeService;
import pidev.services.ProduitCommandeService;
import pidev.services.ServiceClient;
import static pidev.views.LoginController.motpass;
import static pidev.views.LoginController.username;
/**
 * FXML Controller class
 *
 * @author amall
 */
public class PanierController implements Initializable {
 @FXML
 private TableView tabpanier;
 @FXML
 private Pane retour;
 @FXML
 private Pane history;
 @FXML
 private Button valider;

 @FXML
 private Label prix_total;

 @FXML
 private TextField adresse;
 /*@FXML
 private TableColumn<Produit_Commande,String> col_nom;
 @FXML
 private TableColumn<Produit_Commande,String> col_prix;
 @FXML
 private TableColumn<Produit_Commande,String> col_quantite;
 */
 /**
  * Initializes the controller class.
  * @param url
  * @param rb
  * @throws java.sql.SQLException
  */

 Set < LignePanier > spanier = new HashSet < LignePanier > ();

 @Override
 public void initialize(URL url, ResourceBundle rb) {

 }
 public void render(Set < LignePanier > sp) {
  spanier.addAll(sp);
  System.out.println("spanier = " + spanier.toString());

 

  List < LignePanier > lst = new ArrayList < LignePanier > (spanier);
  System.out.println("lst = " + lst.toString());

  final ObservableList < LignePanier > data = FXCollections.observableArrayList(lst);
  //TableColumn< Ligne_Panier, String> column1 = new TableColumn<>("Id produit");
  //column1.setCellValueFactory(new PropertyValueFactory<>("id_pro"));

  if (data.isEmpty()){
            valider.setDisable(true);
        }
  
  computeTotal(data);
  valider.setOnAction((ActionEvent) -> {
    if(adresse.getText().trim().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
              
                alert.setTitle("Adresse invalide");
                 alert.setHeaderText("Adresse invalide");
                alert.setContentText("Veuillez saisir une adresse valide");
                 alert.showAndWait();

    }
    else{
   //computeTotal(data);
   //sendMessage("commande validee ",0);

   //ajouter commande
   //int userId = 16;
   ServiceClient sc = new ServiceClient();
   int userId=sc.getIdbymail(username);
   CommandeService cs = new CommandeService();
   Commande c = new Commande(userId, adresse.getText());
   c.setPrix_total(10);
   cs.ajouterCommande(c);


   //ajouter lignes commandes
   ProduitCommandeService pcs = new ProduitCommandeService();
   data.forEach((d) -> {
    Produit_Commande pc = new Produit_Commande(
     d.getId_pro(),
     c.getId_commande(),
     d.getQuantite()
    );

    pcs.ajouterProdCmd(pc);

   });
   sendMessage("Votre commande est confirmee pour la somme de "+ prix_total.getText() +" DT.   Merci de votre confiance!   ", userId);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
              
                alert.setTitle("Succès");
                 alert.setHeaderText("Succès");
                alert.setContentText("Commande validée avec succès");
                 alert.showAndWait();
   data.clear();
   computeTotal(data);
   valider.setDisable(true);
  }});


  //System.out.println("data = " + data.toString());

  TableColumn < LignePanier, String > column1 = new TableColumn < > ("Nom produit");
  column1.setCellValueFactory(new PropertyValueFactory < > ("libelle"));


  TableColumn < LignePanier, Integer > column2 = new TableColumn < > ("Prix unitaire");
  column2.setCellValueFactory(new PropertyValueFactory < > ("prix"));

  TableColumn < LignePanier, Integer > column3 = new TableColumn < > ("Quantité");
  column3.setCellValueFactory(new PropertyValueFactory < > ("quantite"));


  column3.setCellFactory(TextFieldTableCell. < LignePanier, Integer > forTableColumn(new IntegerStringConverter()));

  column3.setOnEditCommit((TableColumn.CellEditEvent < LignePanier, Integer > t) -> {
   (t.getTableView().getItems().get(
    t.getTablePosition().getRow())).setQuantite(t.getNewValue());
   if (t.getNewValue() == 0) {
    System.out.println("updated value = 0");
    t.getTableView().getItems().remove(t.getTablePosition().getRow());
   }
   if (data.isEmpty()){
    valider.setDisable(true);
}
   computeTotal(data);
  });
tabpanier.setEditable(true);
        tabpanier.setItems(data);
        column1.setPrefWidth(342);        
        column2.setPrefWidth(138);
        column3.setPrefWidth(130);
        tabpanier.getColumns().addAll(column1, column2, column3);
        System.out.println("spanier outside1 = " +spanier.toString());


  retour.setOnMouseClicked((ActionEvent) -> {
   try {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("Vitrine.fxml"));
    Parent root_vitrine = loader.load();
    VitrineController vc = loader.getController();
    spanier = new HashSet < LignePanier > (data);
    vc.pass(spanier);
    retour.getScene().setRoot(root_vitrine);


   } catch (IOException e) {
    e.printStackTrace();
   }
  });
history.setOnMouseClicked((ActionEvent) -> {
  try {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("Historique.fxml"));
    Parent root_historique = loader.load();
    HistoriqueController hc = loader.getController();
    spanier = new HashSet < LignePanier > (data);
    hc.pass(spanier);
    history.getScene().setRoot(root_historique);


   } catch (IOException e) {
    e.printStackTrace();
   }
  });
 }


 public void sendMessage(String message, int usedId) {
 ServiceClient sc = new ServiceClient();
  String telephone = "+216" + String.valueOf(sc.getTelbyId(usedId));
  NexmoClient client = NexmoClient.builder()
   .apiKey("40553437")
   .apiSecret("lahaz6NIU4VhkhcA")
   .build();

  SmsSubmissionResponse responses = client.getSmsClient()
   .submitMessage(new TextMessage(
    "S4S",
    telephone,
    message
   ));
  for (SmsSubmissionResponseMessage response: responses.getMessages()) {
   System.out.println(response);
  }
 }

 public void computeTotal(ObservableList < LignePanier > data) {
  if (data.isEmpty()) {
   prix_total.setText(String.valueOf(0));
  }
  double tprix = data.stream().mapToDouble(d -> d.getPrix() * d.getQuantite()).sum();
  prix_total.setText(String.valueOf(tprix));

 }
}
