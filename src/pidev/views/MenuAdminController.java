/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import animatefx.animation.FadeIn;
import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import pidev.entity.Feedback;
import pidev.entity.Reclamation;
import pidev.entity.Vehicule;
import pidev.services.FeedbackService;
import pidev.services.ReclamationService;
import pidev.services.VehiculeService;
import pidev.utils.css.ZoomManager;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class MenuAdminController extends Application  implements Initializable  {

    @FXML
    private Circle btnClose;
    @FXML
    private StackPane stackPane;
    private JFXButton btn_stat;
    @FXML
    private JFXButton btn_vehicule;
    @FXML
    private BorderPane border_pane_admin;
    @FXML
    private Pane pnlVehicule;
    @FXML
    private JFXTextField txt_mat;
    @FXML
    private JFXTextField txt_marque;
    @FXML
    private JFXRadioButton radio_dispo;
    @FXML
    private JFXRadioButton radio_non_dispo;
    @FXML
    private JFXButton btn_add_v;
    
        ObservableList<Vehicule>obList ;

              Reclamation reclamation = new Reclamation();

     Vehicule vehicule = new Vehicule();

     private  JFXButton btn;
     private JFXButton btnSupprimer;
     private JFXToggleButton btnTraiter;
        TableColumn<Vehicule, Void> colBtn ;
        TableColumn<Vehicule, Void> colSuppBtn ;
        TableColumn<Reclamation, Void> colTraiterBtn ;
    

    @FXML
    private TableView<Vehicule> table;
   
    private JFXTextField txt_filter;
    @FXML
    private TableColumn<Vehicule, String> col_type;
    @FXML
    private TableColumn<Vehicule, String> col_etat;
    
      List list_vehicule_current = new ArrayList<>();

    
    //
    VehiculeService vehiculeService = new VehiculeService();
    ReclamationService reclamationService = new ReclamationService();
    
    //
    private Pane pnl_modif_v;
    private TextField tx_mod_objet;
    private TextArea txt_mod_desc;
    @FXML
    private Pane pnl_liste_v;
    @FXML
    private JFXButton btn_liste_vehicule;
    @FXML
    private Pane pnlModif;
    @FXML
    private JFXButton btnModifierValider;
    @FXML
    private JFXButton btnModifierAnnuler;
    @FXML
    private ImageView btnBackListV;
    private Label label;
    @FXML
    private ImageView btnBack;
    @FXML
    private TableColumn<?, ?> col_objet;
    @FXML
    private TableColumn<?, ?> col_description;
    @FXML
    private JFXTextField txt_filter1;
    @FXML
    private Pane pnl_liste_reclamations;
    @FXML
    private JFXButton btn_cons_rec;
    @FXML
    private TableView<Reclamation> table_consulter_rec;
    
        ObservableList<Reclamation>obListRec ;
        ObservableList<Feedback>obListFeed;

    private Pane pnlStat;
    @FXML
    private TableColumn<?, ?> col_user_email;
    @FXML
    private JFXButton btn_cons_feed;
    @FXML
    private TextField tx_mod_mat;
    @FXML
    private TextArea txt_mod_marque;
    @FXML
    private ImageView btnBack1;
    @FXML
    private TableView<Feedback> table_consulter_feed;
    @FXML
    private TableColumn<Feedback, String> col_desc_feed;
    @FXML
    private TableColumn<Feedback, String> col_note_feed;
    @FXML
    private TableColumn<Feedback, String> col_user_email_feed;
    @FXML
    private JFXTextField txt_filter11;
    @FXML
    private Pane pnl_liste_feedback;
    
    FeedbackService feedbackService = new FeedbackService();
    @FXML
    private Label rec2;
    @FXML
    private ImageView btnBack2;
    @FXML
    private JFXTextField txt_filter_v;
    @FXML
    private JFXButton btn_dash;
    @FXML
    private Pane pnlDash;
    @FXML
    private Hyperlink btn_feed;
    @FXML
    private Hyperlink line_sta;
    private Hyperlink nbr_rec;
    @FXML
    private Hyperlink btn_rec;
    @FXML
    private JFXComboBox<String> governorat;
 
    



    



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              
        
       colBtn=new TableColumn<>("Modifier");
       table.getColumns().add(colBtn);
       colTraiterBtn=new TableColumn<>("Traiter");
       table_consulter_rec.getColumns().add(colTraiterBtn);
       colSuppBtn = new TableColumn<>("Supprimer");
       table.getColumns().add(colSuppBtn);     
                     
                    btn_feed.setText(String.valueOf(feedbackService.getNbrFeedback())+" Feedback");
       btn_rec.setText(String.valueOf(reclamationService.getNbrReclamation())+" Reclamation");


                     
        

                       //TableView
       // tableview = new TableView();
       vehiculeService = new VehiculeService();
       obList= vehiculeService.getVehicule();
       table.setItems(obList);
       
        //Main Scene
       // Scene scene = new Scene(tableview);        

        //stage.setScene(scene);x²x²xx
        //stage.show();
        

        
    }    


    @FXML
    private void HandleActionStatistique(ActionEvent event) {
        
            pnl_liste_reclamations.setVisible(false);
           pnl_liste_feedback.setVisible(false);
             pnlModif.setVisible(false);
             pnl_liste_v.setVisible(false);
            pnlVehicule.setVisible(false);
            pnlDash.setVisible(false);
          
       
            
            
         NumberAxis xAxis = new NumberAxis();
     CategoryAxis yAxis = new CategoryAxis();
 
     Statement statement = null;
     int i=1;
     int j=2;
  XYChart.Data<String, Number> data =  new XYChart.Data<String, Number>();
  Pane pane=new Pane();
  pane.setPrefSize(600, 500);
  BarChart<String,Number> bchart=new BarChart<String,Number>(yAxis, xAxis);
  bchart.setPrefSize(550, 450);
  bchart.setTitle("Traitement");
     xAxis.setLabel("Values");
     xAxis.setTickLabelRotation(45);
     yAxis.setTickLabelRotation(45);
     yAxis.setLabel("Menus");
     XYChart.Series series1 = new XYChart.Series();
        //
          



      
         series1.setName("Nombre des reclamations et des feedbacks");
         
         FeedbackService feedbackService= new FeedbackService();
         ReclamationService reclamationService = new ReclamationService();
         double totale =reclamationService.getNbrReclamation()+feedbackService.getNbrFeedback();
         series1.getData().add(new XYChart.Data("feedback",(feedbackService.getNbrFeedback()/totale)*100));
         series1.getData().add(new XYChart.Data("Reclamation",(reclamationService.getNbrReclamation()/totale)*100));

         //DecimalFormat df = new DecimalFormat("0.00");
        //Moyenne_Age_Input.setText(String.valueOf(df.format(econtroleemploye.getMoyenneAge()/totale)));S
  
        System.out.println("reclamation nombre==>"+reclamationService.getNbrReclamation());
            System.out.println("feedback nombre==>"+feedbackService.getNbrFeedback());
    

        
     bchart.getData().add(series1);
     pane.getChildren().add(bchart);    
    
    
	stackPane.getChildren().add(bchart);
	
	new ZoomManager(stackPane, bchart,series1 );
        
        
            
 

        
    }
             String governoratSelected="";


    @FXML
    private void HandleActionButtonAjout(ActionEvent event) {
         int matricule=Integer.valueOf(txt_mat.getText().length());
         
         String marque = txt_marque.getText().toString();
         String etat ="";
          governorat.setOnAction((ActionEvent ev) -> {
            governoratSelected = 
                governorat.getSelectionModel().getSelectedItem().toString();   
              System.out.println(governoratSelected);
        });
         
         if(radio_dispo.isSelected()) {
             etat = radio_dispo.getText();
         }
         
         if(radio_non_dispo.isSelected()) {
             etat = radio_non_dispo.getText();
         }
         //Ajouter vehicule
          if(event.getSource().equals(btn_add_v)) {
                     
              
              if(txt_marque.getText().equals("") && txt_mat.getText().equals("") ) {
              Alert alertError = new Alert(AlertType.INFORMATION);
              alertError.setTitle("Champs manquants");
              alertError.setHeaderText("Les champs doivent etre non vides");
              alertError.showAndWait();
              }
              else {
                    vehicule = new Vehicule(matricule,marque,etat,governoratSelected);
                     vehiculeService=new VehiculeService();
                     vehiculeService.ajouterVehicule(vehicule);
                     System.out.println("add");
                            System.out.println("interface vehicule");

                }
          }

        
             //fin ajout vehicule
             
        
    }

    @FXML
    private void HandleActionButtonAffiche(Event event) {
        if(event.getSource().equals(btn_liste_vehicule)) {
   
            pnl_liste_v.setVisible(true);
            new ZoomIn(pnl_liste_v).play();
            pnl_liste_v.toFront();
            System.out.println("filter");
      filterVehicule();


            afficherVehicules();

            addButtonModifToTable();
            
       
            addButtonDeleteToTable();
        }
        else if(event.getSource().equals(btn_cons_rec)) {
            System.out.println("hey");
                        pnl_liste_reclamations.setVisible(true);

            new ZoomIn(pnl_liste_reclamations).play();
            pnl_liste_reclamations.toFront();
             afficherReclamation();
             addButtonTraiterToTable();
        }
        else if(event.getSource().equals(btn_cons_feed)) {
            pnl_liste_feedback.setVisible(true);
                 new ZoomIn(pnl_liste_feedback).play();
                 
            pnl_liste_feedback.toFront();
             afficherFeedback();
             addButtonTraiterToTable();
            
        }
        if(event.getSource().equals(btn_dash)) { 
            pnlDash.setVisible(true);
              new ZoomIn(pnlDash).play();
            pnlDash.toFront();
            
        }
        if(event.getSource().equals(btn_vehicule)) {
           governorat.getItems().addAll("Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Le Kef","Mahdia","La Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan");

            pnlVehicule.setVisible(true);
            new ZoomIn(pnlVehicule).play();
            pnlVehicule.toFront();
           

            
        }

    }
    
     public void afficherFeedback() {
        obListFeed = feedbackService.getAllFeedback();

            table_consulter_feed.refresh();
            obListFeed.clear();

            obListFeed   = feedbackService.getAllFeedback();
             col_desc_feed.setCellValueFactory(new PropertyValueFactory<>("description"));
               col_note_feed.setCellValueFactory(new PropertyValueFactory<>("note"));
               col_user_email_feed.setCellValueFactory(new PropertyValueFactory<>("email"));

        
               System.out.println("table contain ="+obListFeed);
            table_consulter_feed.setItems(obListFeed);
              System.out.println("here we = "+obListFeed);

            



    }
    
    

    public void afficherReclamation() {
        obListRec = reclamationService.getAllReclamation();

            table.refresh();
            obListRec.clear();

            obListRec   = reclamationService.getAllReclamation();
             col_objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
               col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
              // col_id_rec.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
               col_user_email.setCellValueFactory(new PropertyValueFactory<>("email"));

               System.out.println("table contain ="+obListRec);
            table_consulter_rec.setItems(obListRec);
              System.out.println("here we = "+obListRec);

            



    }
    public void afficherVehicules() {
        
            obList   = vehiculeService.getVehicule();

            table.refresh();
            obList.clear();

            obList   = vehiculeService.getVehicule();
             col_type.setCellValueFactory(new PropertyValueFactory<>("marque"));
               col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            table.setItems(obList);
              System.out.println("here we = "+obList);
    }
      public void addButtonModifToTable() {
           


        Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>> cellFactory = new Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>>() {
            @Override
            public TableCell<Vehicule, Void> call(final TableColumn<Vehicule, Void> param) {

                final TableCell<Vehicule, Void> cell = new TableCell<Vehicule, Void>() {


                    { 

                        btn = new JFXButton("Modifier");

                        btn.setOnAction((ActionEvent event) -> {
                            
                             
                              new ZoomIn(pnlModif).play();
                              pnlModif.toFront();
                              vehicule = table.getSelectionModel().getSelectedItem();
                              txt_mat.setText(String.valueOf(vehicule.getMat()));
                              txt_marque.setText(vehicule.getMarque());
                              if(radio_dispo.isSelected() && !radio_non_dispo.isSelected()) {
                                  radio_dispo.getText();
                              }
                              else radio_non_dispo.getText();
                              

                              
                                                                
                            
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
      
         public void addButtonDeleteToTable() {
              


        Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>> cellFactory = new Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>>() {
            @Override
            public TableCell<Vehicule, Void> call(final TableColumn<Vehicule, Void> param) {

                final TableCell<Vehicule, Void> cell = new TableCell<Vehicule, Void>() {


                    { 

                        btnSupprimer = new JFXButton("Supprimer");
                        btnSupprimer.setOnAction((ActionEvent event) -> {
                            
                             
                              vehicule = table.getSelectionModel().getSelectedItem();
                              showConfirmation(vehicule);
                              
                        });

                   
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnSupprimer);
                        }
                    }
                };
                return cell;    
            }
        };

        colSuppBtn.setCellFactory(cellFactory);


        
        
        
   
      }
         
      public void addButtonTraiterToTable() {
        Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>> cellFactory = new Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>>() {
            @Override
            public TableCell<Reclamation, Void> call(final TableColumn<Reclamation, Void> param) {

                final TableCell<Reclamation, Void> cell = new TableCell<Reclamation, Void>() {


                    { 

                        btnTraiter = new JFXToggleButton();

                        btnTraiter.selectedProperty().addListener(((observable, oldValue, newValue) -> {
                            if(newValue==true){
                              reclamation = table_consulter_rec.getSelectionModel().getSelectedItem();
                                      reclamation.setEtat(1);
                                      
                                      
                                      //Send notification
                              Notifications notificationBuild = Notifications.create()
                                      .title("Traitement Reclamation")
                                      .text("Traitement de reclamation est envoyé au client avec succes")
                                      .graphic(null)
                                      .hideAfter(Duration.seconds(5))
                                      .position(Pos.CENTER)
                                      .onAction(new EventHandler<ActionEvent>() {
                                  @Override
                                  public void handle(ActionEvent event) {
                                      System.out.println("click here");
                                  }
                                  
                              });
                              notificationBuild.show();
                                      
                                      

                            reclamationService.traiterReclamation(reclamation);
                            System.out.println(reclamation.getId());
                            }
                                                   
                        
                            }));
                         
                              
                                                                
                            
                     
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnTraiter);
                        }
                    }
                };
                return cell;    
            }
        };

        colTraiterBtn.setCellFactory(cellFactory);


        
        
        
   
      }
      


      
    private void HandleActionVehicule(ActionEvent event) {
        if(event.getSource().equals(btn_vehicule)) {
              new ZoomIn(pnlVehicule).play();
            pnlVehicule.toFront();
            pnlModif.setVisible(false);
            pnl_liste_v.setVisible(false);
        
            
        }
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
          btn_feed.setText(String.valueOf(feedbackService.getNbrFeedback())+" Feedback");
       btn_rec.setText(String.valueOf(reclamationService.getNbrReclamation())+ "Réclamation");

        vehiculeService= new  VehiculeService();
       obList= vehiculeService.getVehicule();
       table.setItems(obList);  
       
       reclamationService = new ReclamationService();
       obListRec =reclamationService.getAllReclamation();
       table_consulter_rec.setItems(obListRec);
       
     
    }

    @FXML
    private void handleButtonValidateAction(ActionEvent event) {
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
          if(event.getSource() == btnClose) {
            System.exit(0);
        }
        else if(event.getSource().equals(btnBackListV)) {
            new FadeIn(pnl_liste_v).play();
            pnl_liste_v.toFront();
        }   
     
        
    }
    
    private void showConfirmation(Vehicule vehicule) {
        
 
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Suppression");
      alert.setHeaderText("Voullez vous vraiment supprimer??");
      alert.setContentText("La vehicule est tres efficace");
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.label.setText("pas selection!");
      } else if (option.get() == ButtonType.OK) {
          vehiculeService.supprimerVehicule(vehicule);
          obList.clear();
          vehiculeService.getVehicule();
      } else if (option.get() == ButtonType.CANCEL) {
         this.label.setText("Exit!");
      } else {
         this.label.setText("-");
      }
   }


  //Metier Relation
    public void filterVehicule() {  
        FilteredList<Vehicule> filteredList = new FilteredList<>(obList,b->true);
        
        txt_filter_v.textProperty().addListener((observable,oldValue,newValue) ->{
                    System.out.println("hey is filter");
        if(txt_filter_v.getText().isEmpty()) {
            //Reload button
            addButtonDeleteToTable();
            addButtonModifToTable();
        
        }
            filteredList.setPredicate(vehicule-> {
                if(newValue == null || newValue.isEmpty()) {
                                       btnSupprimer=new JFXButton("Supprimer");
                                      JFXButton btnModifier = new JFXButton("Modifier");

                    return true;
                }
                
                //
                String lowerCaseFilter =newValue.toLowerCase();
                
                if(String.valueOf(vehicule.getMat()).toLowerCase().indexOf(lowerCaseFilter)!=-1 ) {

                    return true;
                }
                else if(vehicule.getMarque().toLowerCase().indexOf(lowerCaseFilter)!=-1) {

                    return true;
                }
               
               
                else{
                                        
                      btnSupprimer=new JFXButton("Supprimer");
                      JFXButton btnModifier = new JFXButton("Modifier");
                    return false;
                }

            });
            
        });

        
        SortedList<Vehicule> sortedData= new SortedList<>(filteredList);
        
        sortedData.comparatorProperty().bind(table.comparatorProperty());


        table.setItems(sortedData);
        
        

    }
    
    
      //Metier Relation
    public void filterReclamationClient() {  
        FilteredList<Reclamation> filteredList = new FilteredList<>(obListRec,b->true);
        
        txt_filter.textProperty().addListener((observable,oldValue,newValue) ->{
                    
        if(txt_filter.getText().isEmpty()) {
            //Reload button
            addButtonTraiterToTable();
            
            
        
        }
            filteredList.setPredicate(reclamation-> {
                if(newValue == null || newValue.isEmpty()) {
                                       btnTraiter=new JFXToggleButton();

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
                                        
                                       btnTraiter=new JFXToggleButton();
                    return false;
                }

            });
            
        });

        
        SortedList<Reclamation> sortedData= new SortedList<>(filteredList);
        
        sortedData.comparatorProperty().bind(table_consulter_rec.comparatorProperty());


        table_consulter_rec.setItems(sortedData);
        
        

    }
    


    
 
}

