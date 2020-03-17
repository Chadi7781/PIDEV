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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entity.Utilisateur;
import pidev.utils.css.ConnexionBD;
import pidev.entity.Magasin;
public class LivreurService {
   Connection Conn;
    Statement stm;
    
    public LivreurService() {
          try {
              Conn  = ConnexionBD.
                      getInstance()
                      .getConnection();
              stm = Conn.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(LivreurService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
    
    
    
    
     public ArrayList <Utilisateur> afficherLivreurParGouvernorat(String gouvernorat){
    
        
        try {
           Statement st = Conn.createStatement();
           String query = "SELECT ID_emp,username,disponible,mission,prenom from employe WHERE governat  = \"" + gouvernorat +"\"" ;
            
            System.out.println(query);
           ResultSet rs = st.executeQuery(query);
           ArrayList<Utilisateur> liste_livreur = new ArrayList<>();
           
           while(rs.next()){
           
               liste_livreur.add(new Utilisateur(rs.getInt("ID_emp"),rs.getString("username"),rs.getString("disponible"),rs.getString("mission"),rs.getString("prenom")));
           
           }
            
           return liste_livreur;
            
        }
       
         catch (SQLException ex) {
            Logger.getLogger(MagasinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList liste_magasin = null;
        
        return liste_magasin;
    
    }
    
    
}
