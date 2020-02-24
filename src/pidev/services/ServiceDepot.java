/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entity.Depot;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author Maryem
 */
public class ServiceDepot {

    Connection Conn;
    Statement stm;

    public ServiceDepot() {
        try {
            Conn = ConnexionBD.getInstance().getConnection();
            stm = Conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Depot> findAllDepots() {

        ArrayList<Depot> l = new ArrayList<Depot>();
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot where etat='dispo'");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Depot d = new Depot();
                d.setId(rs.getInt("id"));
                d.setPrix(rs.getInt("prix"));
                d.setSurface(rs.getInt("surface"));
                d.setPays(rs.getString("adresse"));
                l.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }

    public void LouerDepot(int idDepot, int idUser, String d, String d1) {
        Statement st;
        try {
            PreparedStatement pt;
            String req = "UPDATE depot SET datedebut=?,"
                    + "datefin=? where id=?";
            pt = Conn.prepareStatement(req);

            pt.setString(1, d);
            pt.setString(2, d1);

            pt.setInt(3, idDepot);
            //  System.out.println(req);

            pt.executeUpdate();
            st = Conn.createStatement();
            String req2 = "insert into depot_user (id_depot,id_user,datedebut,datefin,etat) values(" + idDepot + "," + idUser + ",'" + d + "','" + d1 + "','nonfini')";
            st.executeUpdate(req2);
            String req3 = "UPDATE `depot` SET `etat` = 'indispo' WHERE `id` = " + idDepot;
            st.executeUpdate(req3);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Integer> getAllDepotForEntreprise(int id) {

        ArrayList<Integer> l = new ArrayList<Integer>();
        try {
            PreparedStatement st = Conn.prepareStatement("SELECT * FROM `depot_user` WHERE id_user = "+id+" AND etat = 'nonfini'");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                l.add(rs.getInt("id_depot"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public int getSurfaceDepotbyId(int id) {
        try {

//////////////////////////////////////////////
            PreparedStatement st = Conn.prepareStatement("select * from depot where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt("Surface");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int getPrixDepotbyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt("prix");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
    public String getDateDebutDepotbyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getDate("datedebut").toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

    }
    
     public String getDateFinDepotbyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getDate("datefin").toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

    }

    public String getAdresseDepotbyId(int id) {
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("adresse");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

    }
    
    
     public void SetDepotDispo(int id) {
        Statement st;
        try {
            
            st = Conn.createStatement();
            
            String req3 = "UPDATE `depot` SET `etat` = 'dispo' WHERE `depot`.`id` = " + id;
            String req = "UPDATE `depot_user` SET `etat` = 'fini' WHERE `id_depot` = " + id;
            st.executeUpdate(req3);
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
