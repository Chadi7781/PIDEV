/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

/**
 *
 * @author Maryem
 */
public class Magasin {
        private int id_magasin;
        private String pays; 
        private String nom;
       private int latitude; 
       private int longitude;

    public Magasin(int id_magasin, String pays, String nom, int latitude, int longitude) {
        this.id_magasin = id_magasin;
        this.pays = pays;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Magasin() {
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Magasin{" + "id_magasin=" + id_magasin + ", pays=" + pays + ", nom=" + nom + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
    
    
    
}