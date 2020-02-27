/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entity.Commande;
import pidev.entity.Produit;
import pidev.entity.Produit_Commande;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author amall
 */
public class ProduitCommandeService implements iProduitCommandeService{
        Connection  myConnex;
      Statement ste;
    
    public ProduitCommandeService() {
          try {
              myConnex  = ConnexionBD.
                      getInstance()
                      .getConnection();
              ste = myConnex.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    @Override
public void ajouterProdCmd(Produit_Commande pc) {
try {
   
              String req =
                      "INSERT INTO produit_commande"
                      + "(id, id_commande, quantite) VALUES (?,?,?)";
                    PreparedStatement ps =
                            myConnex.prepareStatement(req);
                    ps.setInt(1, pc.getId());
                    ps.setInt(2, pc.getId_commande());
                    ps.setInt(3, pc.getQuantite());
                    ps.executeUpdate();
               } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }    }


    @Override
    public void modifierProdCmd(int id_prodcmd, int new_quantite) {
try {
              String req =
                      "UPDATE produit_commande SET quantite=? WHERE id_prodcmd=?";
                    PreparedStatement ps =
                            myConnex.prepareStatement(req);
                    ps.setInt(1, new_quantite);
                    ps.setInt(2, id_prodcmd);
                    ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
   }
    }
    @Override
    public void supprimerProdCmd(int id_prodcmd) {
        try {
              String req =
                      "DELETE FROM produit_commande WHERE id_prodcmd=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req);
              ps.setInt(1, id_prodcmd);
              ps.executeUpdate();
           
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          } 
    }




    @Override
    public List<Produit_Commande> afficherProdCmd(Produit_Commande pc) {
try {
              String req =
                      "select * from produit_commande";
              ResultSet res =   ste.executeQuery(req);
              
              while (res.next()) {
                  System.out.println("le produit_commande est " +
                          res.getInt("id_prodcmd") +" "+
                          res.getInt("id")+" "+
                          res.getInt("id_commande")+" "+
                          res.getInt("quantite"));
                  
              
          }}
catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;    }
    
 
}
