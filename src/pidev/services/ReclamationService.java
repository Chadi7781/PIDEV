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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import pidev.views.ReclamationServiceController;
import pidev.entity.Reclamation;
import pidev.entity.Utilisateur;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author PC
 */
public class ReclamationService  implements IReclamationService{
        ObservableList<Reclamation>obList = FXCollections.observableArrayList();
               ObservableList<Utilisateur>obListUser = FXCollections.observableArrayList();
 

    private Connection con;
    private Statement st;
    private  ResultSet rs;
    
    private LineChart<String,Date>lineChart;

    public ReclamationService() {
        con= ConnexionBD.getInstance().getConnection();
    }
    
    
    @Override
    public void ajouterReclamation(Reclamation p) {
        PreparedStatement pst;
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());         
            String etat = "0";
            
            try{
                
            String sql = "INSERT INTO reclamation (objet,description,etat,date,id)VALUES(?,?,?,?,?) ";
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getObjet());
            pst.setString(2, p.getDescription());
            pst.setInt(3,p.getEtat());
            pst.setString(4, date);
            pst.setInt(5,p.getId());
            pst.executeUpdate();
    
            
            
            } catch (Exception ex) {
                Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
   @Override
    public void modifierReclamation(Reclamation p) {
    
       
        String sql2="UPDATE reclamation SET objet=?,description=? WHERE id_rec=?";
        try{
            
             PreparedStatement pstmt = con.prepareStatement(sql2);
            
            pstmt.setString(1,p.getObjet());
            pstmt.setString(2,p.getDescription());
            pstmt.setInt(3,p.getId());
            pstmt.executeUpdate();
            pstmt.close();

            
       }catch (SQLException ex) {
           Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
       }
        //
       
    
    }
           
       // showReclamations();
   @Override
    public ObservableList<Reclamation> getAllReclamation() {
        List<Reclamation> array= new ArrayList<>();
        ResultSet rs;//   obList.clear();
        String sql ="select * from reclamation  R "
                + "JOIN fos_user FU ON FU.id=R.id";

         try {
           
	    PreparedStatement st= con.prepareStatement(sql);
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
             System.out.println("debut get");
               int id=res.getInt(1);
               String objet=res.getString(2);
               String description=res.getString(3);
               int etat = res.getInt(4);
               int iduser=res.getInt("id");
               String email=res.getString("email");
               String nom =res.getString("username");   
               String tel=res.getString("telephone");
               System.out.println("fu user is ="+res.getString("email"));
               System.out.println("user is ="+email+" ,"+nom+", "+tel);
                obList.add(new Reclamation(objet, description,id,etat,iduser,email));
                System.out.println("dattttt = "+obList);
                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }

    @Override
    public int getNbrReclamation() {
        String sql="SELECT COUNT(*) FROM reclamation";
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

    @Override
    public void traiterReclamation(Reclamation p ) {
        
        
        String sql2="UPDATE reclamation SET etat=? WHERE id_rec=?";
        try{
            
             PreparedStatement pstmt = con.prepareStatement(sql2);
            
            pstmt.setInt(1,p.getEtat());
            pstmt.setInt(2,p.getId());
            pstmt.executeUpdate();
            pstmt.close();

            
       }catch (Exception ex) {
           Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

 
    @Override
    public ObservableList<Reclamation> getReclamationByEtatNonTraite() {
     List<Reclamation> array= new ArrayList<>();
        ResultSet rs;//   obList.clear();
        String sql ="select * from reclamation";

         try {
           
	    PreparedStatement st= con.prepareStatement(sql);
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
             System.out.println("debut get");
               int id=res.getInt(1);
               String objet=res.getString(2);
               String description=res.getString(3);
               int etat = res.getInt(4);
               int iduser=res.getInt("id");
          
               if(etat==0){
                obList.add(new Reclamation(objet, description));
                System.out.println("etat="+etat+", et data = "+obList);
               }
                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     }

     @Override
    public ObservableList<Reclamation> getReclamationByEtatTraite() {
     List<Reclamation> array= new ArrayList<>();
        ResultSet rs;//   obList.clear();
        String sql ="select * from reclamation";

         try {
           
	    PreparedStatement st= con.prepareStatement(sql);
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
             System.out.println("debut get");
               int id=res.getInt(1);
               String objet=res.getString(2);
               String description=res.getString(3);
               int etat = res.getInt(4);
               int iduser=res.getInt("id");
          
               if(etat==1){
                obList.add(new Reclamation(objet, description));
                System.out.println("etat="+etat+", et data = "+obList);
               }
                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     }


    
    



}
    

