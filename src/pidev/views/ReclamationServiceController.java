
package pidev.views;

import animatefx.animation.FadeIn;
import animatefx.animation.ZoomIn;
import com.gluonhq.charm.glisten.control.CardPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;import javafx.util.Duration;

import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;
import org.controlsfx.control.Rating;
import pidev.entity.Reclamation;
import pidev.entity.Vehicule;
import pidev.services.IReclamationService;
import pidev.services.ReclamationService;
import pidev.services.ServiceClient;
import pidev.services.iServiceClient;
import static pidev.views.LoginController.motpass;
import static pidev.views.LoginController.username;

/**
 *
 * @author PC
 */
public class ReclamationServiceController extends Application  implements Initializable  {
    
    private Label label;
    Scene scene;
    private JFXButton lien_rec;
    @FXML
    private ImageView btnBack;
    
    @FXML
    private Pane pnlDernierRec;
    @FXML
    private Pane pnlBack;
    @FXML
    private Circle btnClose;
   
    @FXML
    private JFXButton btnDReclamation;
    @FXML
    private BorderPane border_pane;
    @FXML
    private StackPane stackPane;
    @FXML
    private JFXButton btnEnvoyer;
    @FXML
    private JFXTextField txtObjet;
    @FXML
    private JFXTextArea txtDescription;
    
    
    String o;
    String desc;
     Stage stage ;
    Reclamation reclamation;
    @FXML
    private JFXButton btnAnnuler;
    private JFXButton iconUser;
    @FXML
    private Label rec1;
    @FXML
    private JFXButton txt_btn_nom;
    
     int id;
     String photo;
     //Geneare from tableView
       private  JFXButton btn;
        TableColumn<Reclamation, Void> colBtn ;



    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, String> col_objet;
    @FXML
    private TableColumn<Reclamation, String> col_description;

    ObservableList<Reclamation>obList ;
    @FXML
    private Pane pnlModif;
    @FXML
    private JFXButton btnModifierValider;
    @FXML
    private JFXButton btnModifierAnnuler;
    @FXML
    private TextArea txt_mod_desc       ;
    @FXML
    private TextField tx_mod_objet;
    @FXML
    private Rectangle image_profile;
    
    Reclamation reec=new Reclamation();
    private ImageView btnBack2;
    @FXML
    private JFXTextField txt_filter;

    List list_reclamation_current = new ArrayList<>();

    
    //
    ReclamationService reclamationService = new ReclamationService();
    //
    @FXML
    private Label txt_lb_nbr_rec;
    @FXML
    private ImageView btnBackProfile;
    @FXML
    private Pane pnlProfile;
    @FXML
    private Circle circle_etat;
    @FXML
    private Label txt_etat;
    @FXML
    private Pane pnlFeedback;
    @FXML
    private Label rec2;
    @FXML
    private Label labelObjet1;
    @FXML
    private Label labelDescription1;
    @FXML
    private JFXButton userIcon1;
    private JFXButton feedback;
    
    LoginController irc;

        @FXML
    private ImageView btnBackRecl;
    @FXML
    private JFXButton btnFeedback;
    @FXML
    private Label rec;
    @FXML
    private JFXButton userIcon;
    @FXML
    private Rating rating_feedbcak;
    @FXML
    private JFXCheckBox check_box_trait;
    private JFXButton btnReclamation;
    private JFXCheckBox check_box_tous;
    @FXML
    private JFXButton btnDash;
    @FXML
    private JFXButton btnAffiche;
    @FXML
    private JFXButton notif;
    @FXML
    private Pane pnlSlider;
    @FXML
    private ImageView slide3;
    @FXML
    private ImageView slide2;
    @FXML
    private ImageView slide1;
    @FXML
    private JFXButton btnPrevious;
    @FXML
    private Label lblPageNumber;
    @FXML
    private JFXButton btnNext;
    @FXML
    private Hyperlink btn_feed;
    @FXML
    private Hyperlink btn_rec;
    @FXML
    private Label rec21;
    
     String mail;
    // Max number of slider
    private static final byte NUMBER_OF_SLIDE = 3;
    
    private byte currentSlide = 1;
    @FXML
    private JFXButton btnMenu;
    @FXML
    private AnchorPane anchor;

    
    @FXML
    private void handleMouseEvent(MouseEvent event) {
        if(event.getSource() == btnClose) {
            System.exit(0);
        }
        else if(event.getSource().equals(btnBackProfile)) {
            new FadeIn(pnlDernierRec).play();
            pnlDernierRec.toFront();
        }   
        else if (event.getSource().equals(btnBack2)) {
                new FadeIn(pnlDernierRec).play();
            pnlDernierRec.toFront();
        }
        else if(event.getSource().equals(btnBackRecl)) {
            new FadeIn(pnlBack).play();
            pnlBack.toFront();        
        }
        else if(event.getSource().equals(btnBack)){
              new FadeIn(pnlDernierRec).play();
            pnlDernierRec.toFront();  
        }
        
        
       
        
    }
   
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
             o=txtObjet.getText().toString();

          desc = txtDescription.getText().toString();

          if(event.getSource().equals(btnDReclamation)  ) {
            
            new ZoomIn(pnlBack).play();
            pnlBack.toFront();
            obList   = reclamationService.getAllReclamation();

            table.refresh();
            obList.clear();

            obList   = reclamationService.getAllReclamation();
             col_objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
               col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
            table.setItems(obList);
              System.out.println("here we = "+obList);

            



            addButtonToTable();

            System.out.println("Filter");
              filter();

             


        }
      
        else if(event.getSource().equals(btnEnvoyer)) {
               
           
              ServiceClient iClient = new ServiceClient();
              int idUser =iClient.getIdbymail(mail);
              String photo =iClient.getPhotobyId(idUser);
            System.out.println("user name ="+mail);
            System.out.println("id user = "+idUser);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());         

                         reclamation = new Reclamation(o,desc,date,idUser);

             ReclamationService service=new ReclamationService();

            if(txtObjet.getText().equals("") && txtDescription.getText().equals("") ) {
              Alert alertError = new Alert(AlertType.INFORMATION);
              alertError.setTitle("Champs manquants");
              alertError.setHeaderText("Objet ou Description sont vide");
              alertError.showAndWait();
            }
            else{ 
                service.ajouterReclamation(reclamation);
                              Alert alertError = new Alert(AlertType.INFORMATION);
              alertError.setTitle("Sucess");
              alertError.setContentText("Réclamation envoyer Avec sucess");
              alertError.showAndWait();
            }
         
        }
         else if(event.getSource().equals(btnAnnuler)) {
            txtDescription.setText(" ");
            txtObjet.setText(" ");
         }
         else if(event.getSource().equals(feedback)) {
              System.out.println("clic");
            new ZoomIn(pnlFeedback).play();
            pnlFeedback.toFront();
         }
         else if(event.getSource().equals(btnDash)) {
              System.out.println("clic");
            new ZoomIn(pnlSlider).play();
            pnlSlider.toFront();
         }
        else if(event.getSource().equals(btnAffiche)) {
              System.out.println("clic");
            new ZoomIn(pnlDernierRec).play();
            pnlDernierRec.toFront();
         }
          else if(event.getSource().equals(btnFeedback)) {
              System.out.println("clic");
            new ZoomIn(pnlFeedback).play();
            pnlFeedback.toFront();
         }
        
         else  {
            //image circle
            ServiceClient iClient = new ServiceClient();
              int idUser =iClient.getIdbymail(mail);
               photo =iClient.getPhotobyId(idUser);
               File file = new File(iClient.getPhotobyId(idUser));
            Image image = new Image(file.toString());
            System.out.println(file.toURI().toString());
            image_profile.setFill(new ImagePattern(image));
            new ZoomIn(pnlProfile).play();
            pnlProfile.toFront();
            txt_btn_nom.setText(mail);
            txt_lb_nbr_rec.setText(reclamationService.getNbrReclamation()+" reclamations");
            
             
    }
          if(event.getSource().equals(btnReclamation)) {
              new ZoomIn(pnlDernierRec).play();
            pnlDernierRec.toFront();
          }
    }
  
    ServiceClient iClient;
    int idUser;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        try {
             iClient = new ServiceClient();
               idUser =iClient.getIdbymail(mail);
               photo =iClient.getPhotobyId(idUser);
            Parent root = loader.load();
                        irc = loader.getController();
                        mail = irc.username;
            String mdp = irc.motpass;
            

        } catch (IOException ex) {
            Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
            

//                pnlBack.setVisible(false);
          btnPrevious.setOnAction(e-> {
            if(currentSlide == 1) {
                return;
            }
            previousSlide(--currentSlide);
        });
        
        btnNext.setOnAction(e-> {
            if(currentSlide == NUMBER_OF_SLIDE) {
                return;
            }
            nextSlide(++currentSlide);
        });
       colBtn=new TableColumn<>("Action");
                     table.getColumns().add(colBtn);
    }
    
   
    
    public void refreshTable() {
       
    }
        public void showReclamations() {
            
        }
        //***************
               
      public void addButtonToTable() {
           


        Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>> cellFactory = new Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>>() {
            @Override
            public TableCell<Reclamation, Void> call(final TableColumn<Reclamation, Void> param) {

                final TableCell<Reclamation, Void> cell = new TableCell<Reclamation, Void>() {


                    { 

                        btn = new JFXButton("Modifier");

                        btn.setOnAction((ActionEvent event) -> {
                            
                             
                              new ZoomIn(pnlModif).play();
                              pnlModif.toFront();
                              reclamation = table.getSelectionModel().getSelectedItem();
                              
                             if(reclamation.getEtat()==1) {
                           //Show notifi
   Notifications notificationBuild = Notifications.create()
                                      .title("Traitement Reclamation")
                                      .text("Admin a approuvé cette reclamation :) :) ")
                                      .graphic(null)
                                      .hideAfter(Duration.seconds(5))
                                      .position(Pos.CENTER)
                                      .onAction(new EventHandler<ActionEvent>() {
                                  @Override
                                  public void handle(ActionEvent event) {
                                      
                                  }
                                  
                              });
                              notificationBuild.show();
                                      
                                      

                              txt_etat.setText("Traité");
                                circle_etat.setFill(Color.GREEN);
                                tx_mod_objet.setVisible(false);
                                txt_mod_desc.setVisible(false);
                            // showConfirmation();
                             }
                             else {
                                 
                               
                                  txt_etat.setText("en cours...");
                                circle_etat.setFill(Color.RED);
                                tx_mod_objet.setVisible(true);
                                txt_mod_desc.setVisible(true);
                                  tx_mod_objet.setText(reclamation.getObjet());
                                 txt_mod_desc.setText(reclamation.getDescription());
                             }
                             


                              
                                                                
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;    
            }
        };

        colBtn.setCellFactory(cellFactory);


        
        
        
   
      }

      


    @Override
    public void start(Stage stage) throws Exception {
        //TableView
       // tableview = new TableView();
       ReclamationService reclamationService= new  ReclamationService();
     //  obList= reclamationService.getAllSansJoinReclamation();
       table.setItems(obList);
       
        //Main Scene
       // Scene scene = new Scene(tableview);        

        //stage.setScene(scene);x²x²xx
        //stage.show();
      }

    
    @FXML
    private void handleButtonValidateAction(ActionEvent event) {
        reclamation.setObjet(tx_mod_objet.getText());
        reclamation.setDescription(txt_mod_desc.getText());
        
        
        
        ReclamationService reclamationService = new ReclamationService();
        reclamationService.modifierReclamation(reclamation);
        table.refresh();
        
        System.out.println("updated"); 
            new ZoomIn(pnlBack).play();
            pnlBack.toFront();
        
    }


    //Metier Relation
    public void filter() {  
        FilteredList<Reclamation> filteredList = new FilteredList<>(obList,b->true);
        
        txt_filter.textProperty().addListener((observable,oldValue,newValue) ->{
                    
        if(txt_filter.getText().isEmpty()) {
            //Reload button
            addButtonToTable();
            
        
        }
            filteredList.setPredicate(reclamation-> {
                if(newValue == null || newValue.isEmpty()) {
                                       btn=new JFXButton("Modifier");

                    return true;
                }
                
                //
                String lowerCaseFilter =newValue.toLowerCase();
                
                if(reclamation.getObjet().toLowerCase().indexOf(lowerCaseFilter)!=-1 ) {

                    return true;
                }
                else if(reclamation.getDescription().toLowerCase().indexOf(lowerCaseFilter)!=-1) {

                    return true;
                }
               
               
                else{
                                        
                    btn = new JFXButton("Modifier");
                    return false;
                }

            });
            
        });

        
        SortedList<Reclamation> sortedData= new SortedList<>(filteredList);
        
        sortedData.comparatorProperty().bind(table.comparatorProperty());


        table.setItems(sortedData);
        
        

    }
    
    //trie
    public void sort() {
        col_objet.setSortType(TableColumn.SortType.ASCENDING);
        table.setItems(obList);
        table.getColumns().addAll(col_objet, col_description, colBtn);
        table.getSortOrder().add(col_objet);
    }
   
    
    //Altert 
       
    private void showConfirmation() {
        
 
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Reclamation...");
      alert.setHeaderText("La reclamation est deja traité par l'admin");
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
      
 
     
   }

    @FXML
    private void handleButtonActionFeedback(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("feedback.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

                        stage.setScene(scene);
                new animatefx.animation.ZoomIn(root).play();

        stage.show();
    }
    
    public void afficherReclamationTraiter(Reclamation rec) {}
  

    @FXML
    private void checkBox1(ActionEvent event) {
         if(check_box_trait.isSelected()) {
            System.out.println("checked");
                       obList.clear();

           obList= reclamationService.getReclamationByEtatTraite();
           table.setItems(obList);
           addButtonToTable();
           //check_box_non_trait.setSelected(false);
           return;
        }
         if(!check_box_trait.isSelected()) {
          
            System.out.println("checked");
           obList.clear();
           obList= reclamationService.getAllReclamation();
           table.setItems(obList);
           addButtonToTable();
           //check_box_non_trait.setSelected(false);
           return; 
        }
      

    }
        
        //slide
    
    
    
    private void nextSlide(byte indexOfSlide) {
        lblPageNumber.setText(indexOfSlide + lblPageNumber.getText().substring(1));
        switch (indexOfSlide) {
            case 2:
                slide2.setVisible(true);
                TranslateTransition tt1 = new TranslateTransition(Duration.millis(800));
                tt1.setNode(slide1);
                tt1.setFromX(0.0);
                tt1.setToX(-384.0);
                tt1.setAutoReverse(false);
                tt1.play();
                
                tt1.setOnFinished(e -> {
                    slide1.setVisible(false);
                });
                btnPrevious.setId("btn2");
                btnNext.setId("btn2");
                break;
            case 3:
                slide3.setVisible(true);
                TranslateTransition tt2 = new TranslateTransition(Duration.millis(800));
                tt2.setNode(slide2);
                tt2.setFromX(0.0);
                tt2.setToX(-384.0);
                tt2.setAutoReverse(false);
                tt2.play();
                
                tt2.setOnFinished(e -> {
                    slide2.setVisible(false);
                });
                btnPrevious.setId("btn3");
                btnNext.setId("btn3");
                break;
                
        }
    }
    
    private void previousSlide(byte indexOfSlide) {
        lblPageNumber.setText(indexOfSlide + lblPageNumber.getText().substring(1));
        switch (indexOfSlide) {
            case 1:
                slide1.setVisible(true);
                TranslateTransition tt1 = new TranslateTransition(Duration.millis(800));
                tt1.setNode(slide1);
                tt1.setFromX(-384.0);
                tt1.setToX(0.0);
                tt1.setAutoReverse(false);
                tt1.play();
                
                tt1.setOnFinished(e -> {
                    slide2.setVisible(false);
                    btnPrevious.setId("btn1");
                    btnNext.setId("btn1");
                });
                break;
            case 2:
                slide2.setVisible(true);
                TranslateTransition tt2 = new TranslateTransition(Duration.millis(800));
                tt2.setNode(slide2);
                tt2.setFromX(-384.0);
                tt2.setToX(0.0);
                tt2.setAutoReverse(false);
                tt2.play();
                
                tt2.setOnFinished(e -> {
                    slide3.setVisible(false);
                    btnPrevious.setId("btn2");
                    btnNext.setId("btn2");
                });
                break;
        }
    }

    @FXML
    private void gotoMenu(ActionEvent event) {
        try {
                        idUser =iClient.getIdbymail(mail);

        
            ServiceClient sc = new ServiceClient();
            String role = sc.getRolebyId(idUser);
            
         if (role.equals("client")) {

                FXMLLoader loader = new FXMLLoader();
                anchor.getScene().getWindow().hide();
                Stage prStage = new Stage();
                loader.setLocation(getClass().getResource("AccueilClient.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
            } else if(role.equals("societe")){
                FXMLLoader loader = new FXMLLoader();
                anchor.getScene().getWindow().hide();
                Stage prStage = new Stage();
                loader.setLocation(getClass().getResource("AccueilEntreprise.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
            }
            

        } catch (IOException ex) {
            Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    

 
}
/*String imagexx;
     File file;
    @FXML
    private void image(ActionEvent event) {
        Reclamation r = new Reclamation();
         FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select PDF files");
        fileChooserr.setInitialDirectory(new File("C:"));
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", ".jpg", ".png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        file = fileChooserr.showOpenDialog(img.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
        reclamationService   = new ReclamationService();
        imagexx = file.toURI().toString();
         p.setPhoto(imagexx);
    }



String imagexx;
     File file;
*/





}
      






