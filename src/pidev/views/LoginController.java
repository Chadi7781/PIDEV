/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import pidev.services.ServiceClient;
import pidev.utils.css.SendMail;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane login;
    @FXML
    public JFXTextField t1;
    @FXML
    public JFXPasswordField t2;
    @FXML
    private JFXButton b1;
    @FXML
    private Label label;
    @FXML
    private JFXButton b11;
    public static String username;
    public static String motpass;
    public static int  codem;

    /**
     * Initializes the controller class.
     */

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
     
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("NewPassword.fxml"));
        NewPasswordController ircc = loader.getController();
        String s="a";
        if (!ircc.mail.equals(s)){
            t1.setText(ircc.mail);
        }
        
    }

    @FXML
    private void SeConnecter(ActionEvent event) throws IOException {
        username = t1.getText();
        motpass = t2.getText();
        ServiceClient sc = new ServiceClient();
        if (sc.login(username, motpass)) {
            String role = sc.getRolebyId(sc.getIdbymail(username));

            if (role.equals("client")) {

                FXMLLoader loader = new FXMLLoader();
                label.getScene().getWindow().hide();
                Stage prStage = new Stage();
                loader.setLocation(getClass().getResource("AccueilClient.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
            } else if(role.equals("societe")){
                FXMLLoader loader = new FXMLLoader();
                label.getScene().getWindow().hide();
                Stage prStage = new Stage();
                loader.setLocation(getClass().getResource("AccueilEntreprise.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
            }  else if (role.equals("Admin")){
                 FXMLLoader loader = new FXMLLoader();
                label.getScene().getWindow().hide();
                Stage prStage = new Stage();
              loader.setLocation(getClass().getResource("Dashboard.fxml"));
         //        loader.setLocation(getClass().getResource("AjouterEmp.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
            }
        }  else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Verifiez Vos Coordonnees !!!");
            alert.showAndWait();
        }
    }
  
    @FXML
    private void MotpassOubliee(ActionEvent event) throws MessagingException, IOException {
        username = t1.getText();
        ServiceClient sc = new ServiceClient();
   		
        Random r = new Random ();
      codem =r.nextInt(9999-1000+1);
                System.out.println(codem);
                //sc.setCodepass(sc.getIdbymail(t1.getText()), codem);

        //System.out.println(sc.getPassbyId(sc.getIdbymail(t1.getText())));
        if(isValidEmailAddress(t1.getText())){
   //     SendMail.send(t1.getText(), sc.getPassbyId(sc.getIdbymail(t1.getText())));
   SendMail.send(t1.getText(), codem);
          FXMLLoader loader = new FXMLLoader();
        label.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Motpasseoublie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();}
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Adresse Email Non Valide !!!");
            alert.showAndWait();
        }
       
    }
   

   

    @FXML
    private void inscription(MouseEvent event) {
    }

    @FXML
    private void Sinscrire(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        label.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("CreerCompte.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    @FXML
    private void exit(MouseEvent event) {
    }

   
}
