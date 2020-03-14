/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import pidev.entity.Feedback;
import pidev.entity.Reclamation;
import pidev.entity.Utilisateur;
import pidev.utils.css.ConnexionBD;
import pidev.views.FeedbackServiceController;

/**
 *
 * @author PC
 */
public class FeedbackService  implements IFeedbackService{
        ObservableList<Feedback>obList = FXCollections.observableArrayList();
               ObservableList<Utilisateur>obListUser = FXCollections.observableArrayList();
 

    private Connection con;
    private Statement st;
    private  ResultSet rs;
    
    private LineChart<String,Date>lineChart;

    public FeedbackService() {
        con= ConnexionBD.getInstance().getConnection();
    }
    
    
    @Override
    public void ajouterFeedback(Feedback p) {
        PreparedStatement pst;
            int id=11;
            try{
                
            String sql = "INSERT INTO feedback (description,note,id)VALUES(?,?,?) ";
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getDescription());
            pst.setInt(2, p.getNote());
            pst.setInt(3,id);
            pst.executeUpdate();
    
            
            
            } catch (Exception ex) {
                Logger.getLogger(FeedbackServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
 
        //
       
    
    
           
       // showReclamations();
    public ObservableList<Feedback> getAllFeedback(){
List<Reclamation> array= new ArrayList<>();
        ResultSet rs;//   obList.clear();
        String sql ="select * from feedback  F "
                + "JOIN fos_user FU ON FU.id=F.id";

         try {
           
	    PreparedStatement st= con.prepareStatement(sql);
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
             System.out.println("debut get");
               int id_feed=res.getInt("id_feed");
               String description=res.getString(2);
               int iduser=res.getInt("id");
               int note=res.getInt("note");
               String email=res.getString("email");
               System.out.println("fu user is ="+res.getString("email"));
                obList.add(new Feedback(id_feed, description,note,iduser,email));
                System.out.println("feedback data = "+obList);
                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }

    @Override
    public void traiterFeedback(Feedback p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbrFeedback() {
 String sql="SELECT COUNT(*) FROM feedback";
        ResultSet rs;
        int countIdRec=0;
        try {
            PreparedStatement st= con.prepareStatement(sql);
			ResultSet res= st.executeQuery(); 
                        while(res.next()) {
                           countIdRec= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdRec;
    }
    


}

    

