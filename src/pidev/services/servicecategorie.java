/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev.entity.Produit;
import pidev.entity.Utilisateur;
import pidev.entity.categorie;
import pidev.utils.css.ConnexionBD;


public class servicecategorie {
     private Connection con;
    private Statement ste;
      ObservableList<categorie> obList = FXCollections.observableArrayList();
    public servicecategorie() {
     
          try {
              con  = ConnexionBD.
                      getInstance()
                      .getConnection();
              ste = con.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
     public void ajouter(categorie e) {
try {
     ste = con.createStatement();
               String req =
                "INSERT INTO `categorie`  VALUES (NULL,'"+e.getNom()+"','"+e.getPht()+"')";
              ste.executeUpdate(req);
              System.out.println(req);
          } catch (SQLException ex) {
              Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
          }     
    }
     public ObservableList getAll() throws SQLException  
    {
        int id;
    List<categorie> array= new ArrayList<>();
        con= ConnexionBD.getInstance().getConnection(); 
        ResultSet rs;//   obList.clear();

         try {
           
			PreparedStatement st= con.prepareStatement("select * from categorie");
			ResultSet res= st.executeQuery();
  
     while (res.next()) {        
      
                id  =res.getInt(1);
               String nom=res.getString(2);
                obList.add(new categorie(id ,nom));
                System.out.println("dattttt = "+obList);
                                System.out.println("id cate = "+id);

              
                
                         }
    
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }
     
         public String getPhotobyId(int id) {
        try {
            PreparedStatement st = con.prepareStatement("select * from categorie where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("photo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     public String getnom(int id) throws SQLException{
            PreparedStatement st = con.prepareStatement("select * from categorie WHERE `id`=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("nom");
            }
        return "";
    
        }
         public void modifier(categorie p ,int id) {
           try {
              PreparedStatement pre =con.prepareStatement(
                      "UPDATE categorie SET nom = ?, photo = ?,"
                      + "  WHERE id = ?");
              System.out.println("jana"+pre);
     pre.setString(2, p.getPht());
    pre.setString(1, p.getNom());
     pre.setInt(3,id);
    pre.executeUpdate();
    
          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }
         
         
     public void supprimer(int p) {
         try {
              String req2 =
                      "delete from categorie where id="+p;    
             
              PreparedStatement ps = 
                      con.prepareStatement(req2);
              
             
              ps.executeUpdate();
           
          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }
 
}
