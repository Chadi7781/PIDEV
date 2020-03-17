/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

/**
 *
 * @author 21627
 */
public class Magasin {
    private int id_magasin;
    private String pays;
    private int log;
    private int lat;
    private String nom;
    private String horaire_travail;

    public Magasin() {
    }

    public Magasin(int id_magasin, String pays, int log, int lat, String nom,String horaire_travail) {
        this.id_magasin = id_magasin;
        this.pays = pays;
        this.log = log;
        this.lat = lat;
        this.nom = nom;
        this.horaire_travail = horaire_travail;
    }

    public Magasin(int id_magasin, String nom, String horaire_travail) {
        this.id_magasin = id_magasin;
        this.nom = nom;
        this.horaire_travail = horaire_travail;
    }
    

    public Magasin(String pays, int log, int lat, String nom ,String horaire_travail) {
        this.pays = pays;
        this.log = log;
        this.lat = lat;
        this.nom = nom;
        this.horaire_travail = horaire_travail;
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

    public int getLog() {
        return log;
    }

    public void setLog(int log) {
        this.log = log;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        
        this.nom = nom;
    }

    public String getHoraire_travail() {
        return horaire_travail;
    }

    public void setHoraire_travail(String horaire_travail) {
        this.horaire_travail = horaire_travail;
    }
    
    @Override
    public String toString() {
        return "Magasin{" + "id_magasin=" + id_magasin + ", pays=" + pays + ", log=" + log + ", lat=" + lat + ", nom=" + nom + ",horaire_travail" +horaire_travail+'}';
    }

   
    
    
    
}