/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

/**
 *
 * @author 21627
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entity.Magasin;
import pidev.utils.css.ConnexionBD;


public class MagasinService {
    Connection Conn;
    Statement stm;
    

    public MagasinService() {
          try {
              Conn  = ConnexionBD.
                      getInstance()
                      .getConnection();
              stm = Conn.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public void ajouterMagasin(Magasin m){
        
        String sql = "INSERT INTO point_collecte(nom,pays,horaire_travail,log,lat) VALUES(?,?,?,?,?)";
 
        try (
           PreparedStatement pstmt = Conn.prepareStatement(sql)) {
           pstmt.setString(1,m.getNom());
            pstmt.setString(2, m.getPays());
            pstmt.setString(3,m.getHoraire_travail());
            pstmt.setInt(4,m.getLog());
            pstmt.setInt(5,m.getLat());
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList <Magasin> afficherMagasin(){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT * from point_collecte";
            
           
           ResultSet rs = st.executeQuery(query);
           ArrayList<Magasin> liste_magasin = new ArrayList<>();
           
           while(rs.next()){
           
               liste_magasin.add(new Magasin(rs.getInt("id_magasin"),rs.getString("pays"),rs.getInt("log"),rs.getInt("lat"),rs.getString("nom"),rs.getString("horaire_travail")));
           
           }
            
           return liste_magasin;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_magasin = null;
        
        return liste_magasin;
    
    }
    
    public ArrayList <Magasin> afficherMagasinParGouvernorat(String gouvernorat){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT * from point_collecte WHERE pays  = \"" + gouvernorat +"\"";
            
            System.out.println(query);
           ResultSet rs = st.executeQuery(query);
           ArrayList<Magasin> liste_magasin = new ArrayList<>();
           
           while(rs.next()){
           
               liste_magasin.add(new Magasin(rs.getInt("id_magasin"),rs.getString("pays"),rs.getInt("log"),rs.getInt("lat"),rs.getString("nom"),rs.getString("horaire_travail")));
           
           }
            
           return liste_magasin;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_magasin = null;
        
        return liste_magasin;
    
    }
    
    public ArrayList <Integer> afficherIDMagasin(String nom){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT id_magasin from point_collecte WHERE nom  = \"" + nom +"\"";
            
            System.out.println(query);
           ResultSet rs = st.executeQuery(query);
           ArrayList<Integer> liste_magasin = new ArrayList<>();
           
           while(rs.next()){
           
               liste_magasin.add(rs.getInt("id_magasin"));
           
           }
            
           return liste_magasin;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_magasin = null;
        
        return liste_magasin;
    
    }
    
    
    /* public ArrayList <String> afficherHoraireMagasin(int id){
    
        
        try {
           Statement st = myConnex.createStatement();
           String query = "SELECT id_magasin from point_collecte WHERE id_magasin =?";
            
            System.out.println(query);
           ResultSet rs = st.executeQuery(query);
           ArrayList<String> liste_magasin = new ArrayList<>();
           
           while(rs.next()){
           
               liste_magasin.add(rs.getString("id_magasin"));
           
           }
            
           return liste_magasin;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_magasin = null;
        
        return liste_magasin;
    
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    
     public void ModifierMagasin(Magasin m){
        
        String sql = "Update point_collecte set nom=?,horaire_travail=?,pays=?,log=?,lat=? where id_magasin=?";
 
        try (
            PreparedStatement pstmt = Conn.prepareStatement(sql)) {
           
            pstmt.setString(1, m.getNom());
            pstmt.setString(2, m.getHoraire_travail());
             pstmt.setString(3, m.getPays());
            pstmt.setInt(4, m.getLog());
            pstmt.setInt(5,m.getLat());
            pstmt.setInt(6,m.getId_magasin());

            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void SupprimerMagasin(int id_magasin){
        try {
            PreparedStatement pt = Conn.prepareStatement("delete from point_collecte where id_magasin=?");
            pt.setInt(1,id_magasin);
            pt.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public ArrayList <Magasin> afficherMagasinClient(){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT * from point_collecte where id_magasin = ?";
            
           
           ResultSet rs = st.executeQuery(query);
           ArrayList<Magasin> liste_magasin = new ArrayList<>();
           
           while(rs.next()){
           
               liste_magasin.add(new Magasin(rs.getInt("id_magasin"),rs.getString("nom"),rs.getString("horaire_travail")));
           
           }
            
           return liste_magasin;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_magasin = null;
        
        return liste_magasin;
    
    }
    
    
}

    
    
   
 