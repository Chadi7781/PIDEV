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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.utils.css.ConnexionBD;
import pidev.entity.Utilisateur;
/**
 *
 * @author Maryem
 */
public class ServiceEntreprise implements iServiceEntreprise{
 Connection Conn;
    Statement stm;

    public ServiceEntreprise() {
        try {
            Conn = ConnexionBD.getInstance().getConnection();
            stm = Conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void ajouterEntreprise(Utilisateur e) {
try {
               String req =
                "INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `activite`, `telephone`, `adresse`, `photo`, `Mission`, `Date_Naissance`, `Prenom`, `Note`, `governat`, `etat`,`cin`,`disponible`) VALUES (NULL, '"+e.getUsername()+"', NULL, '"+e.getEmail()+"', NULL, NULL, NULL, '"+e.getPassword()+"', NULL, NULL, NULL, 'societe', '"+e.getActivite()+"', '"+e.getTelephone()+"', '"+e.getAdresse()+"','"+e.getPhoto()+"', NULL, '"+e.getDate_naissance()+"', NULL, '', '', '', '', '')";
              
        
              stm.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
          }     
    }

    @Override
    public void modifierEntreprise(Utilisateur e, int id) {
        PreparedStatement pt;
try {
             pt =Conn.prepareStatement("UPDATE fos_user SET username=?,"
                 + "username_canonical=?,email=?,"
                 + "email_canonical=?,enabled=?,"
                 + "salt=?,password=?,"
                 + "last_login=?,confirmation_token=?,"
                 + "password_requested_at=?,roles=?,"
                 + "activite=?,telephone=?,adresse=?,photo=?,"
                 + "mission=?,date_naissance=?,prenom=?,cin`=? where id=?");
             pt.setString(1, e.getUsername());
             pt.setString(2, e.getUsername_canonical());
             pt.setString(3, e.getEmail());
             pt.setString(4, e.getEmail_canonical());
             pt.setString(5, e.getEnabled());
             pt.setString(6, e.getSalt());
             pt.setString(7, e.getPassword());
             pt.setString(8, e.getLast_login());
             pt.setString(10, e.getConfirmation_token());
             pt.setString(11, e.getPassword_requested_at());
             pt.setString(12, e.getRoles());
             pt.setString(13, e.getActivite());
             pt.setString(14, e.getTelephone());
             pt.setString(15, e.getAdresse());
             pt.setString(16, e.getPhoto());
             pt.setString(17, e.getMission());
             pt.setString(18, e.getDate_naissance());
             pt.setString(19, e.getPrenom());
             pt.setString(20, e.getCin());
             pt.setInt(21, id);
             
             
             
          pt.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
          }          }

    @Override
    public void supprimerEntreprise(Utilisateur e) {
try {
             String reqd="DELETE FROM `fos_user` WHERE id=? and roles='societe'";
             
          PreparedStatement ps = 
                      Conn.prepareStatement(reqd);
              ps.setInt(1, e.getId());
              ps.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
          }          }

    @Override
    public List<Utilisateur> afficherEntreprise(Utilisateur e) {
 try {
              String reqs =
                      "Select * from fos_user where roles='societe'";
              ResultSet res =   stm.executeQuery(reqs);
              
              while (res.next()) {
                  System.out.println("la societe  " +
                          res.getInt("id") +" "+
                          res.getString("nom")+" ayant comme activité"+
                          res.getInt("activite"));
              } 
    } catch (SQLException ex) {
              Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
          }
     return null;    }
    
}
