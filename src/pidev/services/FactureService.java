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
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entity.Facture;
import pidev.utils.css.ConnexionBD;


/**
 *
 * @author 21627
 */
public class FactureService {
    Connection  Conn;
    Statement stm;

    public FactureService() {
        try {
              Conn  = ConnexionBD.
                      getInstance()
                      .getConnection();
              stm = Conn.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
    public void ajouterFacture(Facture f){
        
        String sql = "INSERT INTO facture(id_livraison,type_paiement,date) VALUES(?,?,?)";
 
        try (
          PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            pstmt.setInt(1, f.getId_livraison());
            pstmt.setString(2, f.getType_paiement());
            pstmt.setDate(3,f.getDate());
            
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList <Facture> afficherFacture(){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT * from facture";
            
           
           ResultSet rs = st.executeQuery(query);
           ArrayList<Facture> liste_facture = new ArrayList<>();
           
           while(rs.next()){
           
               liste_facture.add(new Facture(rs.getInt("id_facture"),rs.getInt("id_livraison"),rs.getString("type_paiement"),rs.getDate("date")));
           
           }
            
           return liste_facture;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_facture = null;
        
        return liste_facture;
    
    }
     public void ModifierFacture(Facture f){
        
        String sql = "Update facture set id_livraison=?, type_paiement=? ,date=? where id_facture=1";
 
        try (
            PreparedStatement pstmt = Conn.prepareStatement(sql)) {
            pstmt.setInt(1, f.getId_livraison());
            pstmt.setString(2, f.getType_paiement());
            pstmt.setDate(3,f.getDate());
           

            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void SupprimerFacture(int id_facture){
        try {
            PreparedStatement pt = Conn.prepareStatement("delete from facture where id_facture=?");
            pt.setInt(1,id_facture);
            pt.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
