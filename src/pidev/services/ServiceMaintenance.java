/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entity.Maintenance;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author Maryem
 */
public class ServiceMaintenance  {

    Connection Conn;
    Statement stm;
    
    
     public ServiceMaintenance() {
        try {
            Conn = ConnexionBD.getInstance().getConnection();
            stm = Conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
      public void ajouterMaintenance(Maintenance m) {
        try {
            String req
                    = "INSERT INTO `maintenace_vehicule`(`id`, `nature`, `date`, `description`, `cout`, `matricule`) VALUES(NULL, '" + m.getNature() + "','" + m.getDate()+ "','" + m.getDescription()+ "','" + m.getCT()+ "','" + m.getMatricule()+ "')";
            System.out.println(req);
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
