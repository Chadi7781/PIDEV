/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;


import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import pidev.entity.Magasin;
import pidev.services.MagasinService;


/**
 * FXML Controller class
 *
 * @author 21627
 */
public class Gerer_magasinController implements Initializable {
    @FXML
    private TextField textfieldMag;

    @FXML
    private ComboBox<String> ComboboxGovernat;

    @FXML
    private TextField textfieldHoraire;

    @FXML
    private TextField textfieldlog;

    @FXML
    private TextField textfieldlat;

    @FXML
    private Button buttonAjouter;

    

    @FXML
    private Button buttonEnregistrer;

    @FXML
    private TableColumn<Magasin, String> ColumnMagasin;

    @FXML
    private TableColumn<Magasin, String> ColumnGovernat;

    @FXML
    private TableColumn<Magasin, String> ColumnHoraire;

    @FXML
    private TableColumn<Magasin, Integer> columnLog;

    @FXML
    private TableColumn<Magasin, Integer> columnlat;
    @FXML
    private TableView<Magasin> MagasinTable;
    Magasin M = new Magasin();
    MagasinService Ms = new MagasinService();



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboboxGovernat.getItems().addAll("Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Le Kef","Mahdia","La Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan");
         ObservableList<Magasin> obs = FXCollections.observableArrayList(Ms.afficherMagasin());
        MagasinTable.setItems(obs);
        ColumnMagasin.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColumnGovernat.setCellValueFactory(new PropertyValueFactory<>("pays"));
        ColumnHoraire.setCellValueFactory(new PropertyValueFactory<>("horaire_travail"));
        columnLog.setCellValueFactory(new PropertyValueFactory<>("log"));
        
        columnlat.setCellValueFactory(new PropertyValueFactory<>("lat"));
       
    }
    
    public void refreshTable(){
        
        ObservableList<Magasin> obs = FXCollections.observableArrayList(Ms.afficherMagasin());
        MagasinTable.setItems(obs);
        ColumnMagasin.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColumnGovernat.setCellValueFactory(new PropertyValueFactory<>("pays"));
        ColumnHoraire.setCellValueFactory(new PropertyValueFactory<>("horaire_travail"));
        columnLog.setCellValueFactory(new PropertyValueFactory<>("log"));
        
        columnlat.setCellValueFactory(new PropertyValueFactory<>("lat"));
       
       
        
    }
   @FXML
    void EnregistrerMagasin(ActionEvent event) {
        M.setNom(textfieldMag.getText());
        M.setPays(ComboboxGovernat.getSelectionModel().getSelectedItem());
        M.setHoraire_travail(textfieldHoraire.getText());
        M.setLog(Integer.parseInt(textfieldlog.getText()));
        M.setLat(Integer.parseInt(textfieldlat.getText()));
        MagasinService Ms = new MagasinService();
        Ms.ajouterMagasin(M);
        textfieldMag.setText("");
        textfieldHoraire.setText("");
        textfieldlog.setText("");
        textfieldlat.setText("");
        ComboboxGovernat.getSelectionModel().select(-1);
        refreshTable();

    }    
    @FXML
    void supprimer(ActionEvent event) {
        
           delete();
  
        
       MagasinTable.getItems().removeAll(MagasinTable.getSelectionModel().getSelectedItem());
       System.out.println( MagasinTable);
       textfieldMag.setText("");
        textfieldHoraire.setText("");
        textfieldlog.setText("");
        textfieldlat.setText("");
        ComboboxGovernat.getSelectionModel().select(-1);
      

    
    }
  public void delete()
  {
        MagasinService Ms = new MagasinService();
        Ms.SupprimerMagasin(MagasinTable.getSelectionModel().getSelectedItem().getId_magasin());
          System.out.println(MagasinTable.getSelectionModel().getSelectedItem().getId_magasin());
  }
  
   @FXML
    void RetourAction(ActionEvent event) throws IOException {
         Parent blah = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        

    }
     @FXML
    void ModifierMagasin(MouseEvent event) {
        Magasin M = MagasinTable.getSelectionModel().getSelectedItem();
        textfieldMag.setText(M.getNom());
        ComboboxGovernat.getSelectionModel().select(M.getPays());
        textfieldHoraire.setText(M.getHoraire_travail());
        textfieldlog.setText(String.valueOf(M.getLog()));
        textfieldlat.setText(String.valueOf(M.getLat()));
    }
    @FXML
    void buttonModifier(ActionEvent event) {
         M.setNom(textfieldMag.getText());
        M.setPays(ComboboxGovernat.getSelectionModel().getSelectedItem());
        M.setHoraire_travail(textfieldHoraire.getText());
        M.setLog(Integer.parseInt(textfieldlog.getText()));
        M.setLat(Integer.parseInt(textfieldlat.getText()));
        M.setId_magasin(MagasinTable.getSelectionModel().getSelectedItem().getId_magasin());
        MagasinService Ms = new MagasinService();
        Ms.ModifierMagasin(M);
        System.out.println(M);
        textfieldMag.setText("");
        textfieldHoraire.setText("");
        textfieldlog.setText("");
        textfieldlat.setText("");
        ComboboxGovernat.getSelectionModel().select(-1);
        refreshTable();
        

    }
    
}
