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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev.entity.Depot;
import pidev.utils.css.ConnexionBD;

/**
 *
 * @author Maryem
 */
public class ServiceDepot {

    Connection Conn;
    Statement stm;
    ObservableList<Depot> obList = FXCollections.observableArrayList();


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
                d.setAdr(rs.getString("adresse"));
                l.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }

    public void ajouter(Depot p) {
        
        try {
            stm = Conn.createStatement();
       
        String requeteInsert = "INSERT INTO `depot` VALUES (NULL ,'"  + p.getAdr()+ "' , "+ p.getSurface()+ " ,null , " + p.getPrix()+ ",'" + "Disponible"+ "',null,null);";
           System.out.println(requeteInsert);                           
        stm.executeUpdate(requeteInsert); 
        } catch (SQLException ex) {
             System.out.println(ex);
         
        }   }
    
     public ArrayList<Depot> findAllDepotsNondispo() {
        
        ArrayList<Depot> l = new ArrayList<Depot>();
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot where etat!='Disponible'");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Depot d = new Depot();
                d.setId(rs.getInt("id"));
                d.setPrix(rs.getInt("prix"));
                d.setSurface(rs.getInt("surface"));
                l.add(d);
            }
        } catch (SQLException ex) {  
        }
        return l;
    }
      

    public void LouerDepot(int idDepot ,int idUser){
        Statement st;
        try {
            st = Conn.createStatement();
            String req = "insert into depot_user (id_depot,id_user) values(" + idDepot + "," + idUser + ")";
            st.executeUpdate(req);
            String req2 = "UPDATE `depot` SET `etat` = 'indispo' WHERE `depot`.`id` = "+idDepot;
            st.executeUpdate(req2);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
     public ObservableList afficher()  
    {
    List<Depot> array= new ArrayList<>();
        Conn = ConnexionBD.getInstance().getConnection();
        ResultSet rs;//   obList.clear();

         try {
           
			PreparedStatement st= Conn.prepareStatement("select * from depot");
			ResultSet res= st.executeQuery();
        

     while (res.next()) {        
      
               String adresse=res.getString(2);
               Integer prix=res.getInt(5);
               String Etat=res.getString(6);
               int surface=res.getInt(3);
               int id = res.getInt(1);
              
                obList.add(new Depot(id,adresse,Etat,prix,surface));
                System.out.println("dattttt = "+obList);
                
                

     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }

    public ArrayList<Integer> getAllDepotForEntreprise(int id){
         
        ArrayList<Integer> l = new ArrayList<Integer>();
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot_user where id_user="+id);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                
                l.add(rs.getInt("id_depot"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public Integer getSurfaceDepotbyId(int id){
        try {
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

//    public ArrayList<Integer> getAllDepotForEntreprise(int id) {
//
//        ArrayList<Integer> l = new ArrayList<Integer>();
//        try {
//            PreparedStatement st = Conn.prepareStatement("SELECT * FROM `depot_user` WHERE id_user = "+id+" AND etat = 'nonfini'");
//
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//
//                l.add(rs.getInt("id_depot"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return l;
//    }

//    public int getSurfaceDepotbyId(int id) {
//        try {
//
////////////////////////////////////////////////
//            PreparedStatement st = Conn.prepareStatement("select * from depot where id=?");
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            rs.beforeFirst();
//            if (rs.next()) {
//                return rs.getInt("Surface");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//
//    }

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

          public void modifier(Depot p ,int id) {
           try {
              PreparedStatement pre =Conn.prepareStatement(
                      "UPDATE `depot` SET `adresse` = ?,"
                      + " `surface` = ?, `idproduit` = ?, `prix` = ?, "
                      + " `etat` = ? WHERE `id` = ?");
     pre.setInt(1, p.getSurface());
     pre.setInt(2, p.getId_pro());
     pre.setInt(3, p.getPrix());
     pre.setString(4, p.getEtat());
     pre.setInt(5,id);
    pre.executeUpdate();
    
          } catch (SQLException ex) {
              System.out.println(ex);
          }
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
 public ArrayList<Depot> findAllDepotsdispo() {
        
        ArrayList<Depot> l = new ArrayList<Depot>();
        try {
            PreparedStatement st = Conn.prepareStatement("select * from depot where etat='Disponible'");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Depot d = new Depot();
                d.setId(rs.getInt("id"));
                d.setPrix(rs.getInt("prix"));
                d.setSurface(rs.getInt("surface"));
                l.add(d);
            }
        } catch (SQLException ex) {  
        }
        return l;
    }
 
  public void supprimer(int p) {
         try {
              String req2 =
                      "delete from depot where id=?";    
             
              PreparedStatement ps = 
                      Conn.prepareStatement(req2);
              ps.setInt(1, p);
              ps.executeUpdate();
           
          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }
}
