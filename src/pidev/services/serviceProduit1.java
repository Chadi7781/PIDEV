/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entity.Produit;
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
import pidev.utils.css.ConnexionBD;
//import static pidev.views.CategorieentreController.idcat;

public class serviceProduit1 {
    private Connection con;
    private Statement ste;
     ObservableList<Produit> obList = FXCollections.observableArrayList();
    public serviceProduit1() {

          try {
              con  = ConnexionBD.
                      getInstance()
                      .getConnection();
              ste = con.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
  public String getLibellebyId(int idxx){
        try {
            PreparedStatement st = con.prepareStatement("select * from produit where id=?");
            st.setInt(1, idxx);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("libelle");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
        
    }
    
          public String getPhotobyId(int id) {
        try {
            PreparedStatement st = con.prepareStatement("select * from produit where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("photo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }  

public String getDescbyId(int id) throws SQLException{
            PreparedStatement st = con.prepareStatement("select * from produit WHERE `id`=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getString("desription");
            }
        return "";
    
        }

public Integer getCategobyId(int id){
        try {
            PreparedStatement st = con.prepareStatement("select * from produit where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt("idcat");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
        }

public Integer getQtegobyId(int id){
        try {
            PreparedStatement st = con.prepareStatement("select * from produit where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt("quantite");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
        }

public Integer getPrixbyId(int id){
        try {
            PreparedStatement st = con.prepareStatement("select * from produit where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt("prix");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
        }

public Integer getPoidsbyId(int id){
        try {
            PreparedStatement st = con.prepareStatement("select * from produit where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                return rs.getInt("poids");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceProduit1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
        }


    
    public void ajouter(Produit p,int id,int idc ,Integer idcat) {
        
        try {
            ste = con.createStatement();
       
        String requeteInsert = "INSERT INTO produit VALUES (NULL , '"+p.getPhoto()+"', "+ p.getPoids() + ", " + p.getPrix() +  ",'" + "disponible" + "', '" + p.getDescription() + "' ," + idcat + ","+id+" , '" + p.getNom_pd() + "'," + p.getQuantite() + ","+idc+");";
           System.out.println(requeteInsert);                           
        ste.executeUpdate(requeteInsert); 
        } catch (SQLException ex) {
             System.out.println(ex);
         
        }   }

       public void ajouter1(Produit p,int id,int idc)
    {
        try {
          ste = con.createStatement();
       
        String requeteInsert = "INSERT INTO produit VALUES (NULL , '"+p.getPhoto()+"', "+ p.getPoids() + ", " + p.getPrix() +  ",'" + "disponible" + "', '" + p.getDescription() + "' ,'"+idc+"' ,null , '" + p.getNom_pd() + "'," + p.getQuantite() + ","+id+");";
           System.out.println(requeteInsert);                           
        ste.executeUpdate(requeteInsert);
    } catch (SQLException ex) {
         
        }   }
    
    public void modifier(Produit p ,int id) {
           try {
              PreparedStatement pre =con.prepareStatement(
                      "UPDATE produit SET photo = ?, poids = ?,"
                      + " prix = ?, desription = ?, categorie = ?, "
                      + " libelle = ? WHERE id = ?");
              System.out.println("jana"+pre);
     pre.setString(1, p.getPhoto());
    pre.setDouble(2, p.getPoids());
    pre.setDouble(3, p.getPrix());
   
    pre.setString(4, p.getDescription());
    pre.setInt(5, p.getCategorie());
     
     pre.setString(6, p.getNom_pd());
     pre.setInt(7,id);
    pre.executeUpdate();
    
          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }

    
    public void supprimer(int p) {
         try {
              String req2 =
                      "delete from produit where id=?";    
             
              PreparedStatement ps = 
                      con.prepareStatement(req2);
              ps.setInt(1, p);
              ps.executeUpdate();
           
          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }

    
  

 public ObservableList afficher(int idc) throws SQLException  
    {
        int id;
    List<Produit> array= new ArrayList<>();
        con= ConnexionBD.getInstance().getConnection(); 
        ResultSet rs;//   obList.clear();

         try {
           
			PreparedStatement st= con.prepareStatement("select * from produit where id_user="+idc);
			ResultSet res= st.executeQuery();
  
     while (res.next()) {        
      
               int categorie=res.getInt(7);
               Integer prix=res.getInt(4);
               String Etat=res.getString(5);
                String nom_pd=res.getString(9);
               int Quantite=res.getInt(10);
               id = res.getInt(1);
            
                obList.add(new Produit(id,prix,Etat,categorie,nom_pd,Quantite));
                System.out.println("dattttt = "+obList);
              
                
                         }
    
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }

 
 
 
  public ObservableList getAll(int idc , int idx) throws SQLException  
    {
        int id;
    List<Produit> array= new ArrayList<>();
        con= ConnexionBD.getInstance().getConnection(); 
        ResultSet rs;//   obList.clear();

         try {
           
			PreparedStatement st= con.prepareStatement("select * from produit where id_user="+idc+" and id_depot="+idx);
			ResultSet res= st.executeQuery();
  
     while (res.next()) {        
      
               int categorie=res.getInt(7);
               Integer prix=res.getInt(4);
               String Etat=res.getString(5);
                String nom_pd=res.getString(9);
               int Quantite=res.getInt(10);
               id = res.getInt(1);
            
                obList.add(new Produit(id,prix,Etat,categorie,nom_pd,Quantite));
                System.out.println("dattttt = "+obList);
              
                
                         }
    
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }
 

//amal
   
    public List<Produit> search(String entry, String categorie, String ordre)throws SQLException{
        List<Produit> arr=new ArrayList<>();
        String pentry="_";
        String pcategorie="%";
        String porder="A-Z";
        if (categorie!="Tout"){
            pcategorie=categorie;
        }
        if (pentry!=""){
            pentry=entry;
        }
        if(ordre=="A-Z"){
            porder="order by libelle asc";
        }
        if(ordre=="Z-A"){
            porder="order by libelle desc";
        }
        if(ordre=="Prix ascendant"){
        porder="order by prix asc";
        }
        if(ordre=="Prix descendant"){
        porder="order by prix desc";
        }
        //SELECT produit.id,produit.photo,produit.poids,produit.prix,produit.desription,produit.etat, categorie.nom,produit.id_depot,produit.libelle,produit.quantite FROM produit INNER JOIN categorie ON produit.idcat=categorie.id WHERE ((libelle like 'm') or (desription like 'm')) and categorie.nom like 'autre' 
        PreparedStatement ps = con.prepareStatement ("SELECT produit.id,produit.photo,produit.poids,produit.prix,produit.desription,produit.etat,produit.idcat,categorie.nom,produit.id_depot,produit.libelle,produit.quantite FROM produit INNER JOIN categorie ON produit.idcat=categorie.id where ((libelle like ?) or (desription like ?)) and categorie.nom like ? "+porder);
        ps.setString(1, "%" + entry + "%");
        ps.setString(2, "%" + entry + "%");
        ps.setString(3, pcategorie);
        ResultSet res = ps.executeQuery();

              System.out.println(ps.toString());
       while (res.next()) { 
               int id_produit=res.getInt("id");
               String photo_produit=res.getString("photo");
               int poids=res.getInt("poids");
               int prix=res.getInt("prix");
               String description=res.getString("desription");
               String Etat=res.getString("Etat");
               int catg=res.getInt("idcat");
               int id_depot=res.getInt("id_depot");
               String libelle=res.getString("libelle");
               int quantite=res.getInt("quantite");
               
               Produit p=new Produit(id_produit,photo_produit,poids,prix,description,Etat,catg,id_depot,libelle,quantite);
               System.out.println(p.toString());
     arr.add(p);
     }
    return arr;
        
    }


}
