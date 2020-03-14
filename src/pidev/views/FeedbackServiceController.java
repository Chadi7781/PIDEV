/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import animatefx.animation.FadeIn;
import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
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
import org.controlsfx.control.Rating;
import pidev.entity.Feedback;
import pidev.entity.Reclamation;
import pidev.entity.Vehicule;
import pidev.services.FeedbackService;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class FeedbackServiceController extends Application  implements Initializable  {

    @FXML
    private BorderPane border_pane;
    @FXML
    private Circle btnClose;
    @FXML
    private StackPane stackPane;
    @FXML
    private Label rec2;
    @FXML
    private JFXTextArea txt_desc_feed;
    @FXML
    private Rating rating_feedback;
    @FXML
    private ImageView btnBackFeedback;
    private JFXButton btnEnvoyer;
    
    private FeedbackService feedbackService = new FeedbackService();
    private Feedback feedback = new Feedback();
    @FXML
    private JFXButton btnEnvoyerFeedback;

    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("ajout_reclamation.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

                        stage.setScene(scene);
                new animatefx.animation.ZoomIn(root).play();

        
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
       int rating=(int)rating_feedback.getRating();
       String textFeedDesc = txt_desc_feed.getText();
       

        if(event.getSource().equals(btnEnvoyerFeedback)) {
                System.out.println("number of stars is ="+rating);
                
                feedback = new Feedback(textFeedDesc,rating);

            if(txt_desc_feed.getText().equals("")  ) {
                Alert alertError = new Alert(AlertType.ERROR);
                alertError.setTitle("Champs manquants");
                alertError.setHeaderText("Description doit etre non vide");
                alertError.showAndWait();
            }
            else {
                feedbackService.ajouterFeedback(feedback);
                Alert alertConfirm = new Alert(AlertType.INFORMATION);
                alertConfirm.setTitle("Success");
                alertConfirm.setHeaderText("Données ajoutées avec success");
                alertConfirm.showAndWait();
                
                System.out.println("feedback ajouté avec success");
            }
        }
            
           
        
      
    }
    

  
    
    

}

