
package pidev.views;

import com.gluonhq.charm.glisten.control.TextField;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pidev.entity.Produit;

public class Stock {

    private Circle btnClose1;

    @FXML
    private Button Bt_Dashboard1;

    @FXML
    private Button Bt_Emp1;

    @FXML
    private Button Bt_Stock1;

    @FXML
    private TableView<Produit> Tableau;

    @FXML
    private TableColumn<Produit, String> Libellé;

    @FXML
    private TableColumn<Produit, Integer> Poid;

    @FXML
    private TableColumn<Produit, String> Etat;

    @FXML
    private TableColumn<Produit, String> Catégorie;

    @FXML
    private TableColumn<Produit, Integer> Dépot;

    @FXML
    private TextField RechercherPdt;
    
    @FXML
    private Text alertSeatch;

    @FXML
    private Button bt_Rech;
    ObservableList<Produit> prds = FXCollections.observableArrayList();
    ControleProduit controle = new ControleProduit();
    @FXML
    private Button Bt_Stock11;

    @FXML
    void SearchEmployer(ActionEvent event) {
            Produit p = new Produit();
            p.setNom_pd(RechercherPdt.getText().toString().toLowerCase());
            if (!controle.ControleNOM(p)){
                alertSeatch.setText("Nom invalide");
            }
            	prds.clear();
		List<Produit> listemps = controle.AfficheToutProduitParLIB(p);
		if (listemps != null ) {
                    if (!listemps.isEmpty()) {
		    for (int i = 0; i < listemps.size(); i++) {
			prds.add(listemps.get(i));
                    }
                    }
                    Tableau.setItems(prds);
		}

    }

    @FXML
    void gotoEmploye(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("GererEmp.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    }

    @FXML
    void gotoStock(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    }

    @FXML
    void gotodashbord(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    }
    
        @FXML
    void gotoDepot(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("geredepo.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    void handleMouseEvent(MouseEvent event) {

    }

    void initialize() {
        assert btnClose1 != null : "fx:id=\"btnClose1\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Bt_Dashboard1 != null : "fx:id=\"Bt_Dashboard1\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Bt_Emp1 != null : "fx:id=\"Bt_Emp1\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Bt_Stock1 != null : "fx:id=\"Bt_Stock1\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Tableau != null : "fx:id=\"Tableau\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Libellé != null : "fx:id=\"Libellé\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Poid != null : "fx:id=\"Poid\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Etat != null : "fx:id=\"Etat\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Catégorie != null : "fx:id=\"Catégorie\" was not injected: check your FXML file 'Stock.fxml'.";
        assert Dépot != null : "fx:id=\"Dépot\" was not injected: check your FXML file 'Stock.fxml'.";
        assert RechercherPdt != null : "fx:id=\"RechercherPdt\" was not injected: check your FXML file 'Stock.fxml'.";
        assert bt_Rech != null : "fx:id=\"bt_Rech\" was not injected: check your FXML file 'Stock.fxml'.";
	List<Produit> listemps = controle.AfficheToutProduit();
		if (!listemps.isEmpty()) {
			for (int i = 0; i < listemps.size(); i++) {
				prds.add(listemps.get(i));
			}
		}
		Libellé.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom_pd"));
		Poid.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("poids"));
		Etat.setCellValueFactory(new PropertyValueFactory<Produit, String>("Etat"));
		Catégorie.setCellValueFactory(new PropertyValueFactory<Produit, String>("categorie"));
		Dépot.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id_depot"));
		Tableau.setItems(prds);
    }

    @FXML
    private void Livraison(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("AfficherAdmin_Livraison.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
}
