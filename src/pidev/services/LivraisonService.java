/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entity.Livraison;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author 21627
 */
public class LivraisonService {
    
    Connection Conn;
    Statement stm;
    
    public LivraisonService() {
          try {
               Conn = ConnexionBD.
                      getInstance()
                      .getConnection();
              stm = Conn.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void ajouterLivraison(Livraison l){
        
        String sql = "INSERT INTO livraison(adresse_depart,adresse_arrive,photo_produit,prix,fragile,poids,etat,date_reception,id_magasin,id_user) VALUES(?,?,?,?,?,?,?,?,?,?)";
 
        try (
                PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            pstmt.setString(1, l.getAdresse_depart());
            pstmt.setString(2, l.getAdresse_arrive());
            pstmt.setString(3,l.getPhoto_produit());
            pstmt.setInt(4,l.getPrix());
            pstmt.setString(5, l.getFragile());
            pstmt.setInt(6,l.getPoids());
            pstmt.setString(7,l.getEtat());
            pstmt.setString(8, l.getDate_reception());
            pstmt.setInt(9,l.getId_magasin());
            pstmt.setInt(10,l.getId_user());
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList <Livraison> afficherLivraison(int id){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT * from livraison WHERE id_user="+id;
            
           
           ResultSet rs = st.executeQuery(query);
           ArrayList<Livraison> liste_livraison = new ArrayList<>();
           
           while(rs.next()){
           
               liste_livraison.add(new Livraison(rs.getInt("id_livraison"),rs.getString("adresse_depart"),rs.getString("adresse_arrive"),rs.getString("photo_produit"),rs.getInt("prix"),rs.getString("fragile"),rs.getInt("poids"),rs.getString("etat"),rs.getInt("id_magasin"),rs.getInt("id_user"), rs.getString("date_reception")));
           
           }
            
           return liste_livraison;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_livraison = null;
        
        return liste_livraison;
    
    }
     public void ModifierLivraison(Livraison l){
        
        String sql = "Update livraison set adresse_depart=?, adresse_arrive=? ,photo_produit=? ,prix=? ,fragile=? ,poids=? ,etat=?,id_magasin=?,id_user=? where id_livraison=1";
 
        try (
            PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            pstmt.setString(1, l.getAdresse_depart());
            pstmt.setString(2, l.getAdresse_arrive());
            pstmt.setString(3,l.getPhoto_produit());
            pstmt.setInt(4,l.getPrix());
            pstmt.setString(5, l.getFragile());
            pstmt.setInt(6,l.getPoids());
            pstmt.setString(7, l.getEtat());
            pstmt.setInt(8,l.getId_magasin());
            pstmt.setInt(9,l.getId_user());
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
       public void update(Livraison l,int id) throws SQLException{
       String sql="UPDATE livraison SET etat=?,ID_emp=? WHERE id_livraison="+id;
       try (
            PreparedStatement pstmt = Conn.prepareStatement(sql)) {
        
          pstmt.setString(1, l.getEtat());
           pstmt.setInt(2, l.getID_emp());
       
     
       
        pstmt.executeUpdate();
       } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
     public void SupprimerLivraison(int id_livraison){
        try {
            PreparedStatement pt = Conn.prepareStatement("delete from livraison where (id_livraison=?)");
            pt.setInt(1,id_livraison);
            pt.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
         public ArrayList <Livraison> afficherLivraisonAdmin(){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT * from livraison";
            
           
           ResultSet rs = st.executeQuery(query);
           ArrayList<Livraison> liste_livraisonAdmin = new ArrayList<>();
           
           while(rs.next()){
           
               liste_livraisonAdmin.add(new Livraison(rs.getInt("id_livraison"),rs.getString("photo_produit"),rs.getString("etat"), rs.getString("date_reception")));
           
           }
            
           return liste_livraisonAdmin;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_livraisonAdmin = null;
        
        return liste_livraisonAdmin;
    
    }
         
          public ArrayList <Livraison> afficherLivraisonClient(){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT * from livraison ";
            
           
           ResultSet rs = st.executeQuery(query);
           ArrayList<Livraison> liste_livraison = new ArrayList<>();
           
           while(rs.next()){
           
               liste_livraison.add(new Livraison(rs.getInt("id_livraison"),rs.getString("adresse_depart"),rs.getString("adresse_arrive"),rs.getString("photo_produit"),rs.getInt("prix"),rs.getString("fragile"),rs.getInt("poids"),rs.getString("etat"),rs.getInt("id_magasin"),rs.getInt("id_user"), rs.getString("date_reception")));
           
           }
            
           return liste_livraison;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_livraison = null;
        
        return liste_livraison;
    
    }
          public void qrCode(){
          try{
            String query = "select adresse_arrive,adresse_depart from livraison";
            Statement stmt = null;
            stmt = Conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	LivraisonService.generate_qr(rs.getString("adresse_arrive"),rs.getString("adresse_depart"));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}}
        public static void generate_qr(String image_name,String qrCodeData) {
        try {
            String filePath = "C:\\wamp64\\www\\QRCode\\"+image_name+".png";
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
        }
    }
        
    }
        

