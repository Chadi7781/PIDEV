/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.utils.css;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maryem
 */

public class ConnexionBD {

    private static String url="jdbc:mysql://localhost:3308/gestion_entrepot";
    private static String login = "root";
    private static String password = "";
    private static Connection conn;
    private static ConnexionBD connBD;

    private static  ConnexionBD inst;
    
     ConnexionBD(){
       try {
          conn = DriverManager
                  .getConnection(url, login, password);

          System.out.println("connexion etablie");
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }
   
    public static ConnexionBD getInstance(){
        
        if(connBD == null)
         connBD = new ConnexionBD();
           
        return connBD;
    }
    
    
    public  Connection getConnection(){
        
       
            return conn;
    }}


    

