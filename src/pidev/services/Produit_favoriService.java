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
import javafx.collections.ObservableList;
import pidev.entity.Produit_favoris;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author amall
 */
public class Produit_favoriService implements iProduit_favoriService{
        Connection  myConnex;
      Statement ste;
    
    public Produit_favoriService() {
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
public void ajouterPF(Produit_favoris pf) {
try {
   
              String req =
                      "INSERT INTO favorite"
                      + "(id_favorite, id, id_produit) VALUES (?,?,?)";
                    PreparedStatement ps =
                            myConnex.prepareStatement(req);
                    ps.setInt(1, pf.getId_favorite());
                    ps.setInt(2, pf.getId());
                    ps.setInt(3, pf.getId_produit());
                    ps.executeUpdate();
               } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }    }
  @Override
    public void supprimerPF(int id_favorite) {
        try {
              String req =
                      "DELETE FROM favorite WHERE id_favorite=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req);
              ps.setInt(1, id_favorite);
              ps.executeUpdate();
           
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          } 
    }
    @Override
    public List<Produit_favoris> afficherPF(int id) throws SQLException {
    List<Produit_favoris> arr=new ArrayList<>();
               ResultSet rs=ste.executeQuery("select * from favorite where id="+String.valueOf(id));
                             System.out.println(rs.toString());

     while (rs.next()) {                
               int id_favorite=rs.getInt("id_favorite");
               int id_produit=rs.getInt("id_produit");
               Produit_favoris p=new Produit_favoris(id_favorite, id, id_produit);
     arr.add(p);
         System.out.println(p.toString());

     }
    return arr;
    }}

           
//select *,produit.libelle from favorite inner join produit on favorite.id_produit=produit.id where favorite.id='14'="+idc+");

    

