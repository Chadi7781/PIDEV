/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entity.Utilisateur;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author Maryem
 */
public class ServiceClient implements iServiceClient {

    Connection Conn;
    Statement stm;

    public ServiceClient() {
        try {
            Conn = ConnexionBD.getInstance().getConnection();
            stm = Conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(String username, String motpass) {

        try {
            PreparedStatement pt = Conn.prepareStatement("select * from fos_user where email=? and password=?");
            pt.setString(1, username);
            pt.setString(2, motpass);
            ResultSet rs = pt.executeQuery();
            if (rs.isBeforeFirst()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void ajouterClient(Utilisateur c) {
        try {
            String req
                    = "INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `activite`, `telephone`, `adresse`, `photo`, `Mission`, `Date_Naissance`, `Prenom`, `Note`, `governat`, `etat`,`cin`,`disponible`) VALUES (NULL, '" + c.getUsername() + "', NULL, '" + c.getEmail() + "', NULL, NULL, NULL, '" + c.getPassword() + "', NULL, NULL, NULL, 'client', NULL, '" + c.getTelephone() + "', '" + c.getAdresse() + "','"+c.getPhoto()+"', NULL, '" + c.getDate_naissance() + "', '" + c.getPrenom() + "', '', '', '','','')";

            stm.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierClient(Utilisateur c, int id) {
        PreparedStatement pt;
        try {
                    String req= "UPDATE fos_user SET username=?,"
                    + "username_canonical=?,email=?,"
                    + "email_canonical=?,enabled=?,"
                    + "salt=?,password=?,"
                    + "last_login=?,confirmation_token=?,"
                    + "password_requested_at=?,"
                    + "activite=?,telephone=?,adresse=?,photo=?,"
                    + "mission=?,date_naissance=?,prenom=? where id=?";
                                pt = Conn.prepareStatement(req);

            pt.setString(1, c.getUsername());
            pt.setString(2, c.getUsername_canonical());
            pt.setString(3, c.getEmail());
            pt.setString(4, c.getEmail_canonical());
            pt.setString(5, c.getEnabled());
            pt.setString(6, c.getSalt());
            pt.setString(7, c.getPassword());
            pt.setString(8, c.getLast_login());
            pt.setString(9, c.getConfirmation_token());
            pt.setString(10, c.getPassword_requested_at());
            pt.setString(11, c.getActivite());
            pt.setString(12, c.getTelephone());
            pt.setString(13, c.getAdresse());
            pt.setString(14, c.getPhoto());
            pt.setString(15, c.getMission());
            pt.setString(16, c.getDate_naissance());
            pt.setString(17, c.getPrenom());
            pt.setInt(18, id);
           System.out.println(pt);

            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void setNewMotPass(int idUser ,String pass){
       PreparedStatement st;
        try {
            String req = "UPDATE `fos_user` SET `password` ='" + pass + "' WHERE `fos_user`.`id` = "+idUser;
            st = Conn.prepareStatement(req);
            st.executeUpdate(req);
             System.out.println(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }

    @Override
    public void supprimerClient(int id) {
        try {
            String reqd = "DELETE FROM `fos_user` WHERE id=" + id;

            PreparedStatement ps
                    = Conn.prepareStatement(reqd);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> afficherClient(int id) {
        try {
            String reqs
                    = "Select * from fos_user where roles='client'";
            ResultSet res = stm.executeQuery(reqs);

            while (res.next()) {
                System.out.println("le client  "
                        + res.getInt("id") + " "
                        + res.getString("nom") + " "
                        + res.getInt("prenom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getIdbymail(String mail) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where email=?");
            st.setString(1, mail);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public String getRolebyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("roles");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

    }

    public String getNombyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("username");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

    }

    public String getPrenombyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("Prenom");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

    }

    public String getDatebyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getDate("Date_Naissance").toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public Date getDateDbyId(int id) {
        Date d = new Date(1, 1, 1);
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getDate("Date_Naissance");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public String getTelbyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("telephone");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String getPassbyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String getMailbyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("email");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String getActivitebyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("activite");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String getAdressebyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("adresse");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String getPhotobyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("photo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public String getCodebyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from fos_user where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("code");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
