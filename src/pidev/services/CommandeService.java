/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entity.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev.utils.css.ConnexionBD;
/**
 *
 * @author amall
 */
public class CommandeService implements iCommandeService{
        Connection  myConnex;
      Statement ste;
      ObservableList<Commande> cmdList = FXCollections.observableArrayList();

    public CommandeService() {
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
   public void ajouterCommande(Commande c) {
    try {
   
              String req =
                      "INSERT INTO commande"
                      + "(id,adresse_dest,date,total) VALUES (?,?, CURRENT_TIMESTAMP,?)";
                    PreparedStatement ps =
                            myConnex.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, c.getId());
                    ps.setString(2, c.getAdresse_dest());
                    ps.setInt(3, (int) c.getPrix_total());
                    

                    
         
            int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating Commande failed, no rows affected.");
        }
        
        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                c.setId_commande(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating Commande failed, no ID obtained.");
            }
        }
                     
        } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }    }

    @Override
    public void modifierCommande(String new_adresse_dest) {
        try {
              String req =
                      "UPDATE commande SET adresse_dest=? WHERE id_commande=?";
                    PreparedStatement ps =
                            myConnex.prepareStatement(req);
                    ps.setString(1, new_adresse_dest);
                    ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void supprimerCommande(int id_commande) {
try {
              String req =
                      "DELETE FROM commande WHERE id_commande=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req);
              ps.setInt(1, id_commande);
              ps.executeUpdate();
           
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }  }
        
@Override
    public List<Commande> afficherCommande(int id) throws SQLException {
    List<Commande> arr=new ArrayList<>();
               ResultSet rs=ste.executeQuery("select * from commande where id="+String.valueOf(id));
                             System.out.println(rs.toString());

     while (rs.next()) {                
               int id_commande=rs.getInt("id_commande");
               Date date=rs.getDate("date");
               String adresse_dest=rs.getString("adresse_dest");
               int prix_total=rs.getInt("total");
               Commande c=new Commande(id_commande, id, date, adresse_dest, prix_total);
     arr.add(c);
         System.out.println(c.toString());

     }
    return arr;
    }}
      