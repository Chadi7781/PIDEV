package pidev.views;

import pidev.entity.LignePanier;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import pidev.services.serviceProduit1;
import pidev.entity.Produit;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pidev.services.ServiceClient;
import static pidev.views.LoginController.motpass;
import static pidev.views.LoginController.username;
    
public class VitrineController implements Initializable {
      // ObservableList<String> listcategorie = FXCollections.observableArrayList("Tout","informatique","immobilier","vetements","autre");
     //ObservableList<String> listtri = FXCollections.observableArrayList("A-Z","Z-A","Prix ascendant","Prix descendant");
    @FXML
    private Pane panier;
    @FXML
    private Pane retour;
    @FXML
    private ComboBox lstcategorie;
    @FXML
    private ComboBox lsttri;
    @FXML
    private TextField searchbar;
    @FXML
    private ScrollPane scrlpane;
    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView photo_produit;
    @FXML
    private AnchorPane content;
    @FXML
    private Button ok_btn;
    @FXML 
    private Label errmsg;
    @FXML
    private Pane favorite;
    @FXML
  /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.sql.SQLException
     */
    
    Set<LignePanier> spanier = new HashSet<LignePanier>();


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
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    /*searchbar.setOnKeyTyped((e)->{
                            errmsg.setText("");

    if (!searchbar.getText().matches("^[a-zA-Z0-9 ]*$")) {
                    // set the textField empty
                    searchbar.setText("");
                    errmsg.setText("veuillez saisir des lettres ou des nombres");
                }
    
    });*/
    

            panier.setOnMouseClicked((ActionEvent) -> {
            try {               
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("panier.fxml")); 
                //Parent root_panier = FXMLLoader.load(getClass().getResource("panier.fxml"));
                Parent root_panier = loader.load();
                PanierController pc = loader.getController();
                pc.render(spanier);
                panier.getScene().setRoot(root_panier);
                

            } catch (IOException e) {
            e.printStackTrace();
        }
        });
                 favorite.setOnMouseClicked((ActionEvent) -> {
            try {               
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("favorite.fxml")); 
                Parent root_favorite = loader.load();
                FavoriteController pc = loader.getController();
                favorite.getScene().setRoot(root_favorite);
                

            } catch (IOException e) {
            e.printStackTrace();
        }
        });
       
        
       
        try {
               
           serviceProduit1 ps= new serviceProduit1();
            ArrayList<Produit> initial_search_result;
            initial_search_result = (ArrayList<Produit>)ps.search("","Tout","A-Z");
            //Produit p = new Produit("produit test", "src/gui/img/produit_test.jpg", 150.5, " description produit test", "category test"); 
            //List<Produit> initial_search_result  = Collections.nCopies(7, p);

            //initial_search_result = Collections.nCopies(7, p);
            afficherGridPane(initial_search_result);
            //System.out.print(ps.search(entry,categorie,ordre));
        }catch (Exception ex) {
            Logger.getLogger(VitrineController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        scrlpane.setContent(gridPane);
        scrlpane.setFitToWidth(true);
        //scrlpane.setPrefSize(100, 200);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        lstcategorie.getItems().addAll(
        "Tout",
        "Informatique",
        "Immobilier",
        "Vetements",
        "Autre"
        );
        lstcategorie.setValue("Tout");
        lsttri.getItems().addAll(
        "A-Z",
        "Z-A",
        "Prix ascendant",
        "Prix descendant"
        );
        lsttri.setValue("A-Z");
    
        ok_btn.setOnAction((ActionEvent) -> {
            String entry=searchbar.getText().trim();
            System.out.println(entry);
            String categorie=(String) lstcategorie.getValue();
            System.out.println(categorie);
            String ordre=(String) lsttri.getValue();
            System.out.println(ordre);
            serviceProduit1 ps= new serviceProduit1();
            try {
                List<Produit> search_result;
                search_result = (ArrayList<Produit>)ps.search(entry,categorie,ordre);
                //Produit p = new Produit("produit new", "src/gui/img/produit_test.jpg", 150.5, " description produit test", "category test"); 
                //int randomNum = ThreadLocalRandom.current().nextInt(3, 10 + 1);
                //List<Produit> search_result  = Collections.nCopies(randomNum, p);
                afficherGridPane(search_result);
                //System.out.print(ps.search(entry,categorie,ordre));
            }catch (Exception ex) {
                Logger.getLogger(VitrineController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    
        
        
        //List<Produit> panier = new ArrayList<>();
        

        
        //Produit p = new Produit("produit test", "src/gui/img/produit_test.jpg", 150.5, " description produit test", "category test"); 
        //List<Produit> produits_test  = Collections.nCopies(7, p);
        //System.out.println(produits_test.toString());

        
              
//search(entry, categorie, ordre);
        
    }
    
    public void afficherGridPane(List<Produit> l){
        gridPane.getChildren().clear();

        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            
            FileInputStream input;
            Image image;
            ImageView imageView;
             
            int size = l.size();    
            int ncol = 4;
            int nrow = 1+ (size / ncol);
            System.out.println("ncol: "+ ncol);
            System.out.println("nrow: "+ nrow);
        
            int k = 0;
            for (int i = 0; i < nrow; i++) {
                // Each column
                for (int j = 0; j < ncol; j++) {
                    //get image
                    input = new FileInputStream(l.get(k).getPhoto());
                    image = new Image(input);
                    imageView = new ImageView(image);
                    String sname="libellé: ";
                    String sprix="prix: ";
                    Label pname = new Label(sname+l.get(k).getNom_pd());
                    Label pprix = new Label(sprix+String.valueOf(l.get(k).getPrix()));
                    Button button = new Button("Ajouter au panier");
                    Button button2 = new Button("⋆");

                  
                    button.setOnAction(( ActionEvent ) ->
                        {
                            Produit pretrived = (Produit) button.getParent().getUserData();
                            LignePanier lpn = new LignePanier(pretrived.getId_pro(),pretrived.getNom_pd(),pretrived.getPrix());
                            spanier.add(lpn);
                            
                            System.out.println("button clicked = " + pretrived.toString());
                            System.out.println("Panier = " + spanier.toString());
                        } 
                    );
                
                    // group all the previous components in a Vbox 
                    VBox element = new VBox();
                    Produit pset = new Produit(l.get(k));
                    element.setUserData(pset);
                    element.getChildren().addAll(imageView, pname, pprix, button, button2);
                    element.setOnMouseClicked(( ActionEvent ) ->
                        {
                            Produit pretrived = (Produit) element.getUserData();
                            System.out.println("VBox clicked = " + pretrived.toString());
                        } 
                    );
                    
                    gridPane.add(element, j, i);
                    k++;
                    if (k == size){
                        break;
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    
    }
    
    public void pass(Set<LignePanier> sp){
        //System.out.println("PanierController = " + sp.toString());
        spanier.addAll(sp);
        System.out.println(spanier.toString());
    } 
}