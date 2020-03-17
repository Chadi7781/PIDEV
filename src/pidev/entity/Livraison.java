/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author 21627
 */
public class Livraison {
   private int id_livraison;
   private String adresse_depart;
   private String adresse_arrive;
   private String photo_produit;
   private int prix;
   private String fragile;
   private int poids;
   private String etat;
   private int id_magasin;
   private int id_user;
   private int ID_emp;
   
   private String date_reception;

    
    private ImageView imgview;

    public Livraison() {
    }
    

    public Livraison(int id_livraison, String photo_produit, String etat, String date_reception) {
        this.id_livraison = id_livraison;
        this.photo_produit = photo_produit;
        this.etat= etat;
        this.date_reception = date_reception;
    }
    

    public Livraison(int id_livraison, String adresse_depart, String adresse_arrive, String photo_produit, int prix, String fragile, int poids, String etat, int id_magasin, int id_user , String date_reception) {
        this.id_livraison = id_livraison;
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = adresse_arrive;
        this.photo_produit = photo_produit;
        this.prix = prix;
        this.fragile = fragile;
        this.poids = poids;
        this.etat = etat;
        this.id_magasin = id_magasin;
        this.id_user = id_user;
        this.date_reception = date_reception ;
    }

    public Livraison(int prix, String date_reception) {
        this.prix = prix;
        this.date_reception = date_reception;
    }

    

    
    
    /*public Livraison(String adresse_depart, String adresse_arrive, String photo_produit, int prix, String fragile, int poids, String etat, int id_magasin, int id_user ) {
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = adresse_arrive;
        this.photo_produit = photo_produit;
        this.prix = prix;
        this.fragile = fragile;
        this.poids = poids;
        this.etat = etat;
        this.id_magasin = id_magasin;
        this.id_user = id_user;
        
    }*/

    public int getId_livraison() {
        return id_livraison;
    }
    

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public String getDate_reception() {
        return date_reception;
    }

    public void setDate_reception(String date_reception) {
        this.date_reception = date_reception;
    }

    public String getAdresse_depart() {
        return adresse_depart;
    }

    public void setAdresse_depart(String adresse_depart) {
        this.adresse_depart = adresse_depart;
    }

    public int getID_emp() {
        return ID_emp;
    }

    public void setID_emp(int ID_emp) {
        this.ID_emp = ID_emp;
    }
    

    public String getAdresse_arrive() {
        return adresse_arrive;
    }

    public void setAdresse_arrive(String adresse_arrive) {
        this.adresse_arrive = adresse_arrive;
    }

    public String getPhoto_produit() {
        return photo_produit;
    }

    public void setPhoto_produit(String photo_produit) {
        this.photo_produit = photo_produit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getFragile() {
        return fragile;
    }

    public void setFragile(String fragile) {
        this.fragile = fragile;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_magasin() {
        return id_magasin;
    }
      public ImageView getImgview() {
        return imgview;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    public void setImgview(ImageView imgview) {
        this.imgview = imgview;
        imgview.setFitHeight(150);
imgview.setFitWidth(250);
imgview.setPreserveRatio(false);
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", adresse_depart=" + adresse_depart + ", adresse_arrive=" + adresse_arrive + ", photo_produit=" + photo_produit + ", prix=" + prix + ", fragile=" + fragile + ", poids=" + poids + ", etat=" + etat + ", id_magasin=" + id_magasin + ", id_user=" + id_user + '}';
    }
    
    
    
     public static List<Livraison> generateImageViews(List<Livraison> Livraison) {
        List<Livraison> liste = new ArrayList<Livraison>();

        for (Livraison livraison : Livraison) {
            File f = new File("D:\\wamp64\\www\\Image\\" + livraison.getPhoto_produit());
            livraison.setImgview(new ImageView(new Image(f.toURI().toString())));
            liste.add(livraison);
        }
        return liste;
     }
     public static ArrayList<Livraison> generateImageViews(ArrayList<Livraison> Livraison) {
        ArrayList<Livraison> liste = new ArrayList<Livraison>();

        for (Livraison livraison : Livraison) {
            File f = new File("C:\\wamp64\\www\\JavaImages\\" + livraison.getPhoto_produit());
            livraison.setImgview(new ImageView(new Image(f.toURI().toString())));
            liste.add(livraison);
        }
        return liste;
    }
    public static Livraison generateImageViews(Livraison livraison) {
        
         Livraison s;
        
            File f = new File("C:\\wamp64\\www\\JavaImages\\" + livraison.getPhoto_produit());
            livraison.setImgview(new ImageView(new Image(f.toURI().toString())));
            s=livraison;
        
        return s;
    }
    
    
   
    
}
