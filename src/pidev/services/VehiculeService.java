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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import pidev.entity.Depot;
import pidev.entity.Reclamation;
import pidev.entity.Vehicule;
import pidev.utils.css.ConnexionBD;
import pidev.views.ReclamationServiceController;

/**
 *
 * @author PC
 */
public class VehiculeService implements IVehiculeService {

    ObservableList<Vehicule> obList = FXCollections.observableArrayList();

    private Connection con;
    Statement st;
    private ResultSet rs;
    String mat;

    public VehiculeService() {
        try {
            con = ConnexionBD.getInstance().getConnection();
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ajouterVehicule(Vehicule v) {
        /*      PreparedStatement pst;
         int n=0;

        
             try{
                
            pst= con.prepareStatement("insert into vehicule values ( ? , ? , ?  )");
			pst.setInt(1,v.getMat());
			pst.setString(2,v.getMarque());
			pst.setString(3,v.getEtat());
			
			n= pst.executeUpdate();
			pst.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
         */

    }

    @Override
    public void modifierVehicule(Vehicule v) {

        /*  
        String sql2="UPDATE vehicule SET marque=?,etat=? WHERE mat=?";
        try{
            
             PreparedStatement pstmt = con.prepareStatement(sql2);
            
            pstmt.setString(1,v.getMarque());
            pstmt.setString(2,v.getEtat());
            pstmt.setInt(3,v.getMat());
            pstmt.executeUpdate();
            pstmt.close();

            
       }catch (SQLException ex) {
           ex.printStackTrace();
       }
        //*/
    }

    @Override
    public void supprimerVehicule(Vehicule v) {
        /* int n=0;
		PreparedStatement st;
		try {
			
			
			st= con.prepareStatement("DELETE FROM `vehicule` WHERE `mat`=?");
			
			st.setInt(1,v.getMat());
			
			
			n= st.executeUpdate();
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
    }

    @Override
    public ObservableList<Vehicule> getVehicule() {
        return null;
        /*      List<Vehicule> array= new ArrayList<>();
        ResultSet rs;//   obList.clear();

         try {
           
	    PreparedStatement st= con.prepareStatement("select * from vehicule");
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
         System.out.println("hh");
               int mat=res.getInt("mat");
               String type=res.getString("marque");
               String etat = res.getString("etat");
                obList.add(new Vehicule(mat, type,etat));
                                System.out.println("data = "+obList);

                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;*/

    }

    @Override
    public String getVehiculeById() {

        try {

            PreparedStatement st = con.prepareStatement("select mat from vehicule");
            ResultSet res = st.executeQuery();

            while (res.next()) {
                mat = res.getString(1);
                System.out.println(mat);

            }
            rs = st.executeQuery();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return mat;

    }

    public void AjouterVehicule(Vehicule v) {

        try {
            String req = "INSERT INTO `vehicule`(`matricule`, `genre`, `type`, `puissance`, `energie`, `marque`, `kilometrage`, `nbPlace`, `etat`, `prix`) VALUES('" + v.getMat() + "','" + v.getGenre() + "','" + v.getType() + "','" + v.getPuissance() + "','" + v.getEnergie() + "','" + v.getMarque() + "','" + v.getkilometrages() + "','" + v.getNbPlaces() + "','disponnible','" + v.getPrix()+ "')";

            st.executeUpdate(req);
            System.out.println(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Vehicule> findAllVehicule() {

        ArrayList<Vehicule> l = new ArrayList<Vehicule>();
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule where etat='disponnible'");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vehicule v = new Vehicule();
                v.setMat(rs.getString("matricule"));
                v.setGenre(rs.getString("genre"));
                v.setType(rs.getString("type"));
                v.setPuissance(rs.getString("puissance"));
                v.setEnergie(rs.getString("energie"));
                v.setMarque(rs.getString("marque"));
                v.setMar(rs.getString("kilometrage"));
                v.setNbPlaces(rs.getString("nbPlace"));
                v.setEtat(rs.getString("etat"));
                v.setPrix(rs.getString("prix"));

                l.add(v);
                 
            }
        } catch (SQLException ex) {
        }
        return l;
    }
    public ArrayList<Vehicule> findAllVehiculeadmin() {

        ArrayList<Vehicule> l = new ArrayList<Vehicule>();
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule ");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vehicule v = new Vehicule();
                v.setMat(rs.getString("matricule"));
                v.setGenre(rs.getString("genre"));
                v.setType(rs.getString("type"));
                v.setPuissance(rs.getString("puissance"));
                v.setEnergie(rs.getString("energie"));
                v.setMarque(rs.getString("marque"));
                v.setMar(rs.getString("kilometrage"));
                v.setNbPlaces(rs.getString("nbPlace"));
                v.setEtat(rs.getString("etat"));
                v.setPrix(rs.getString("prix"));

                l.add(v);
                 
            }
        } catch (SQLException ex) {
        }
        return l;
    }
    public void LouerVehicule(String mat, int idUser, String d, String d1) {
        
        try {
            String req = "INSERT INTO `vehicule_user`(`id`, `matricule`, `id_user`, `date_debut`, `date_fin`) VALUES(NULL, '" + mat + "',' " + idUser + " ','" + d + "','" + d1 + "')";
            st.executeUpdate(req);
            System.out.println(req);
           String req3 = "UPDATE `vehicule` SET `etat`='indisponible' WHERE `matricule`= "+"'"+mat+"'";
           System.out.println(req3);
           st.executeUpdate(req3);
                 
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     public ArrayList<String> findAllVehiculeforentreprise(int id) {

        ArrayList<String> lv = new ArrayList<String>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM `vehicule_user` WHERE `id_user`="+id);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
             lv.add(rs.getString("matricule"));
                
            }
        } catch (SQLException ex) {
        }
        return lv;
    }
     
     public String getTypebymat(String matricule) {
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule where matricule=?");
            st.setString(1, matricule);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

      } 
       public String getPuissbymat(String matricule) {
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule where matricule=?");
            st.setString(1, matricule);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("puissance");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

      } 
       
         public String getMarqbymat(String matricule) {
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule where matricule=?");
            st.setString(1, matricule);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("marque");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

      } 
         
     public String getnbPlacesbymat(String matricule) {
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule where matricule=?");
            st.setString(1, matricule);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("nbPlace");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

      } 
     public String getprixbymat(String matricule) {
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule where matricule=?");
            st.setString(1, matricule);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("prix");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

      } 
     
     public String getDateDebut(String matricule) {
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule_user where matricule=?");
            st.setString(1, matricule);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getDate("date_debut").toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

      } 
     
     public String getDateFin(String matricule) {
        try {
            PreparedStatement st = con.prepareStatement("select * from vehicule_user where matricule=?");
            st.setString(1, matricule);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getDate("date_fin").toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDepot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";

      }
     
}
