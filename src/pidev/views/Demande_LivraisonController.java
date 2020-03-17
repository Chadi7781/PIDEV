/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.views;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
import pidev.entity.Livraison;
import pidev.entity.Magasin;
import pidev.services.LivraisonService;
import pidev.services.MagasinService;
import pidev.services.ServiceClient;



/**
 * FXML Controller class
 *
 * @author 21627
 */
public class Demande_LivraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TextField Adresse_expt;

    @FXML
    private TextField textfield;

    @FXML
    private Button button_Submit;

    @FXML
    private ComboBox<String> Comboxpoids;

    @FXML
    private RadioButton Radiobutton_oui;

    @FXML
    private RadioButton Radiobutton_non;

    @FXML
    private CheckBox CheckBox_oui;

    @FXML
    private CheckBox CheckBox_non;

    @FXML
    private ComboBox<String> CheckBox_magasin;

    @FXML
    private Button button_annuuler;

    @FXML
    private Text prix;

    @FXML
    private Text date;

    @FXML
    private HBox hbox;
    @FXML
    private Button refresh;
    
     @FXML
    private HBox hboxprix;

    @FXML
    private Label labelprix;
    
    @FXML
    private ComboBox<String> gouvernorat;
    
    @FXML
    private HBox hboxdaterecept;

    @FXML
    private Label daterecept;
      @FXML
    private Label fuck;
      @FXML
    private Label texthoraire;
       @FXML
    private Label controle;
     

   

    int status = 0;

    Dragboard db;
    Livraison l = new Livraison();
    
    File file;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       FontAwesomeIconView fw = new FontAwesomeIconView(FontAwesomeIcon.PLUS_CIRCLE);
        
        fw.setSize("5em");
        fw.setFill(Paint.valueOf("#1ed7cd"));
        
        HBox center = new HBox(fw);
        center.setAlignment(Pos.CENTER);
        
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(center);
        labelprix.setStyle("-fx-text-fill = #000000");
        
        gouvernorat.getItems().addAll("Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Le Kef","Mahdia","La Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan");
        Comboxpoids.getItems().addAll("0 < Poids < 10", "10 < Poids < 20", "20 < Poids < 30", "+30");
        
        hbox.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                mouseDragOver(event);
            }

        });

        hbox.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {

                if (status == 0) {

                    firstMouseDragDropped(event);
                    //mouseDragDropped(event);
                    status++;

                    
                } else {

                    Button confirmation = new Button("Ok");

                }
            }
        });

    }
    
    

    void addImage(Image i, HBox container) {
        VBox smallContainer = new VBox();
        ImageView imageView = new ImageView();
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        imageView.setImage(i);
        smallContainer.getChildren().add(imageView);
        container.getChildren().add(smallContainer);
        
        
	}
        
    

    private void mouseDragDropped(final DragEvent e) {

        db = e.getDragboard();

        boolean success = false;
        if (db.hasFiles()) {
            success = true;

            final File file = db.getFiles().get(0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println(file.getAbsolutePath());
                    try {

                        Image img = new Image(new FileInputStream(file.getAbsolutePath()));

                        addImage(img, hbox);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Demande_LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

        }
        e.setDropCompleted(success);
        e.consume();
    }

    private void firstMouseDragDropped(final DragEvent e) {
        hbox.getChildren().clear();
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;

            file = db.getFiles().get(0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    String absolutePath = file.getAbsolutePath();
                    
                    
                    try {

                        Image img = new Image(new FileInputStream(file.getAbsolutePath()));
                        
                        addImage(img, hbox);
                       
                     

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Demande_LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

        }
        e.setDropCompleted(success);
        e.consume();
    }
    
    

    private void mouseDragOver(final DragEvent e) {
        final Dragboard db = e.getDragboard();

        final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg");

        if (db.hasFiles()) {
            if (isAccepted) {
                hbox.setStyle("-fx-border-color: blue;"
                        + "-fx-border-width: 5;"
                        + "-fx-background-color: #C6C6C6;"
                        + "-fx-border-style: solid;");
                e.acceptTransferModes(TransferMode.COPY);
                

            }
        } else {
            e.consume();
        }

    }

    @FXML
    public void CheckBoxes(ActionEvent event) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        LocalDate dateTime = new LocalDate();
        
        
        if (CheckBox_oui.isSelected()) {
            CheckBox_magasin.setVisible(false);
            texthoraire.setVisible(false);
            fuck.setVisible(false);
            
            CheckBox_non.setSelected(false);
            //CheckBox_oui.setSelected(true);
            
            String newDateTime = dateTime.plusDays(7).toString();
            l.setDate_reception(newDateTime);
            System.out.println(l.getDate_reception());
           
            
            daterecept.setText(dateTime.toString() +" + 7 Jours" );
            
        }

        if (CheckBox_non.isSelected()) {
            CheckBox_oui.setSelected(false);
            //CheckBox_non.setSelected(true);
            CheckBox_magasin.setVisible(true);
            texthoraire.setVisible(true);
            fuck.setVisible(true);
            
            String newDateTime = dateTime.plusDays(4).toString();
            l.setDate_reception(newDateTime);
            System.out.println(l.getDate_reception());
            
            daterecept.setText(dateTime + " + 4 Jours");

        }
    }
       @FXML
    void checkradio(ActionEvent event) {
        if (Radiobutton_oui.isSelected()){
        l.setFragile("oui");}
        if(Radiobutton_non.isSelected()){
        
        l.setFragile("non");}

    }
    @FXML
    public void combobox(ActionEvent event)
    {
       int  valeur=0;
       String s1="0 < Poids < 10";
       String s2="10 < Poids < 20";
       String s3 ="20 < Poids < 30";
       String s4 ="+30";
       String selected =  Comboxpoids.getSelectionModel().getSelectedItem().toString();
       if(selected.equals(s1)){
       valeur =1;
       hboxprix.getChildren().clear();
       labelprix.setText("10000");
       hboxprix.getChildren().add(labelprix);
       l.setPoids(valeur);
       l.setPrix(Integer.parseInt(labelprix.getText()));
       
       
       }
       if(selected.equals(s2)){
           valeur=2;
           hboxprix.getChildren().clear();
           labelprix.setText("20000");
           hboxprix.getChildren().add(labelprix);
           l.setPoids(valeur);
           l.setPrix(Integer.parseInt(labelprix.getText()));
       
       }
       if(selected.equals(s3)){
           valeur=3;
           hboxprix.getChildren().clear();
           labelprix.setText("30000");
           hboxprix.getChildren().add(labelprix);
           l.setPoids(valeur);
           l.setPrix(Integer.parseInt(labelprix.getText()));
       
       
       }
       if(selected.equals(s4)){
           valeur=4;
           hboxprix.getChildren().clear();
           labelprix.setText("40000");
           hboxprix.getChildren().add(labelprix);
           l.setPoids(valeur);
           l.setPrix(Integer.parseInt(labelprix.getText()));
       }
        System.out.println("valeur" + valeur);
    }
        @FXML
    public void valider(ActionEvent event) throws IOException {
        if (Adresse_expt.getText().isEmpty()){
            controle.setText(" Tout les Champs sont obligatoires !");
        }
        else{
            ServiceClient sc = new ServiceClient();
               FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            LoginController irc = loader.getController();
            String mail = irc.username;

            int id = sc.getIdbymail(mail);
            System.out.println(id);
            l.setId_user(id);
        
        
        l.setAdresse_depart(Adresse_expt.getText());
        l.setAdresse_arrive(textfield.getText() + gouvernorat.getSelectionModel().getSelectedItem());
        l.setEtat("En Cours");
        String absolutePath = file.getAbsolutePath();
        String [] pathParts = absolutePath.split("\\\\");
                    ArrayList <String> photo = new ArrayList<>();
                            
                    
                    for (String i : pathParts){
                        photo.add(i);
                    }
                    l.setPhoto_produit(photo.get(photo.size()-1));
           FileOutputStream fileOutputStream = null;
                    try {
                    
                        fileOutputStream = new FileOutputStream("C:\\wamp64\\www\\JavaImages\\" + photo.get(photo.size()-1));

			fileOutputStream.write(Files.readAllBytes(file.toPath()));
			fileOutputStream.flush();
			fileOutputStream.close();
			System.out.println("File written successfully.");
                        
                    } catch (Exception e) {
			e.printStackTrace();
                    }finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
        System.out.println(l);
        LivraisonService ls = new LivraisonService();
        ls.ajouterLivraison(l);
         
        Alert a1 =new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("STOCK FOR SPEED");
        a1.setHeaderText("succès");
        a1.setContentText("vous pouver imprimer votre facture maintenant");
        ButtonType buttonTypeOne = new ButtonType("Imprimer");
        a1.getButtonTypes().setAll(buttonTypeOne);

       Optional<ButtonType> result = a1.showAndWait();
       if (result.get() == buttonTypeOne){
           LivraisonService.generate_qr(l.getAdresse_arrive(), l.getAdresse_depart());
           
            String FILE_NAME = "C:\\wamp64\\www\\PDF\\S4SFacture"+l.getAdresse_arrive()+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            Paragraph p = new Paragraph();
            p.add(" S4S Facture");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            Paragraph p2 = new Paragraph();
            p2.add(""); //no alignment
            document.add(p2);
            Paragraph p3 = new Paragraph();
            p3.add(""); //no alignment
            document.add(p3);
            Paragraph p4 = new Paragraph();
            p4.add(""); //no alignment
            document.add(p4);
            Paragraph p5 = new Paragraph();
            p5.add(""); //no alignment
            document.add(p5);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(20);
            f.setColor(BaseColor.BLACK);
            Font f2 = new Font();
            f2.setStyle(Font.UNDERLINE);
            f2.setSize(15);
     
            document.add(new Paragraph("Livraison Facture :", f));
            document.add(new Paragraph("Adresse D'expediteur :", f2));
            Paragraph p6 = new Paragraph();
            p6.setSpacingAfter(15);
            p6.setSpacingBefore(15);
            p6.add(l.getAdresse_depart()); //no alignment
            document.add(p6);
            document.add(new Paragraph("Adresse De destinataire :", f2));
            Paragraph p7 = new Paragraph();
             p7.setSpacingAfter(15);
            p7.setSpacingBefore(15);
            p7.add(l.getAdresse_arrive()); //no alignment
            document.add(p7);
            document.add(new Paragraph("Date de reception de colis:", f2));
             Paragraph p8 = new Paragraph();
              p8.setSpacingAfter(15);
            p8.setSpacingBefore(15);
            p8.add(l.getDate_reception()); //no alignment
            document.add(p8);
             document.add(new Paragraph("Prix de Livraison", f2));
             Paragraph p9 = new Paragraph();
              p9.setSpacingAfter(15);
            p9.setSpacingBefore(15);
            p9.add(Integer.toString(l.getPrix())); //no alignment
            document.add(p8);
            document.add(new Paragraph("Photo de produit", f2));
            com.itextpdf.text.Image image3=  com.itextpdf.text.Image.getInstance("C:/wamp64/www/JavaImages/"+l.getPhoto_produit());
            com.itextpdf.text.Image image1=  com.itextpdf.text.Image.getInstance("C://wamp64/www/QRCode/"+l.getAdresse_arrive()+".png");
            com.itextpdf.text.Image image2=  com.itextpdf.text.Image.getInstance("C:/wamp64/www/JavaImages/s4smdwra.png");
            image2.setAbsolutePosition(500f,750f);
            image3.scalePercent(15f);
            image2.scalePercent(15f);
            image3.setAbsolutePosition(0f,100f);
            
            image1.setAbsolutePosition(400f,450f);
            document.add(image1);
            document.add(image2);
            document.add(image3);
           /* Paragraph p3 = null;
            
                p3 = new Paragraph();
                p3.add(l.getAdresse_arrive());
                document.add(p3);*/
            
            document.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
          /* String FILE_NAME = "C:\\wamp64\\www\\JavaImages\\Stock_For_Speed.pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            Paragraph p = new Paragraph();
            p.add("Stock For Speed :  Facture");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            Paragraph p2 = new Paragraph();
            p2.add("Text 2"); //no alignment
            document.add(p2);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);
            document.add(new Paragraph("This is my paragraph 3", f));
            p3 = new Paragraph();
                p3.add(rs.getString("date_time"));
                document.add(p3);
           
            document.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } */
         
            /*  try {
            String qrCodeData = "www.chillyfacts.com";
            String filePath = "C:\\wamp64\\www\\JavaImages\\image.png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }*/
            
           
         Parent historique_page = FXMLLoader.load(getClass().getResource("AfficherClient_livraison.fxml"));
         Scene historique_scene = new Scene(historique_page);
         Stage demande_livraison = (Stage) ((Node) event.getSource()).getScene().getWindow();
         demande_livraison.setScene(historique_scene);
         demande_livraison.show();
         
       }
        @FXML
     public void annuler(ActionEvent event) throws IOException{
         
         Alert alert = new Alert(AlertType.ERROR);
         alert.setTitle("STOCK FOR SPEED");
         alert.setHeaderText("");
        alert.setContentText("voulez vous vraiment quitter la page?");

        ButtonType buttonTypeOne = new ButtonType("Confirmer");
        ButtonType buttonTypetwo = new ButtonType("Annuler");
        alert.getButtonTypes().setAll(buttonTypeOne,buttonTypetwo);

       Optional<ButtonType> result = alert.showAndWait();
       if (result.get() == buttonTypeOne){
        
       Parent annuler = FXMLLoader.load(getClass().getResource("AfficherClient_Livraison.fxml"));
            Scene scene = new Scene(annuler);
            Stage Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage.setScene(scene);
            Stage.show();
        }  else if
           (result.get()== buttonTypetwo) {
    // ... user chose "Two"
      } 
     }
     
     @FXML
    void onReni(ActionEvent event) {
        status = 0;
        
        hbox.getChildren().clear();
        
        
        FontAwesomeIconView fw = new FontAwesomeIconView(FontAwesomeIcon.PLUS_CIRCLE);
        
        fw.setSize("5em");
        fw.setFill(Paint.valueOf("#1ed7cd"));
        
        HBox center = new HBox(fw);
        center.setAlignment(Pos.CENTER);
        
        hbox.setAlignment(Pos.CENTER);
        
          
        
        
        hbox.getChildren().add(center);
        
        
    }
    @FXML
    void OngouvernoratSelected(ActionEvent event) {
        
        CheckBox_magasin.getItems().clear();
        
        ArrayList <String> noms = new ArrayList<>();
        ArrayList <String> horaire = new ArrayList<>();
        
        MagasinService ms = new MagasinService();
        
        String gouvrnorat  =  gouvernorat.getSelectionModel().getSelectedItem().toString();
        
        
        ArrayList <Magasin> pointDeCollecte = ms.afficherMagasinParGouvernorat(gouvrnorat);
        
        System.out.println(pointDeCollecte);
        
        for (Magasin g : pointDeCollecte){
             System.out.println(g);
            noms.add(g.getNom());
            horaire.add(g.getHoraire_travail());
        
        }
        
        CheckBox_magasin.getItems().addAll(noms);
        CheckBox_magasin.setValue(noms.get(0));
        fuck.setText(horaire.get(0));
        pointDeCollecte.clear();
        noms.clear();
        
        
        
        

    }
    
    @FXML
    void OnMagasinSelected(ActionEvent event) {
        MagasinService ms = new MagasinService();
        
        ArrayList <Integer> id = ms.afficherIDMagasin(CheckBox_magasin.getSelectionModel().getSelectedItem());
        l.setId_magasin(id.get(0));
        //String horaire = ms.afficherHoraireMagasin(id);
        
            

    }
         

    }
    
        

        
        
    
    
    
