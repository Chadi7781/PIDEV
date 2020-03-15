/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

import java.util.Objects;

/**
 *
 * @author PC
 */
public class Vehicule {

    private String mat;

    private String governorat;

    private String genre;
    private String type;
    private String puissance;
    private String energie;
    private String marque;
    public String kilometrages;
    private String nbPlaces;
    private String etat;
    String mar;
    String prix;
    String dated;
    String datef;

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }
    
    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }
    

    public Vehicule() {

    }

    public String getGovernorat() {
        return governorat;
    }

    public void setGovernorat(String governorat) {
        this.governorat = governorat;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getkilometrages() {
        return kilometrages;
    }

    public void setKilometrages(String kilometrages) {
        this.kilometrages = kilometrages;
    }


    public String getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(String nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Vehicule(String mat, String governorat, String genre, String type, String puissance, String energie, String marque, String kilomerages, String nbPlaces, String etat) {
        this.mat = mat;
        this.governorat = governorat;
        this.genre = genre;
        this.type = type;
        this.puissance = puissance;
        this.energie = energie;
        this.marque = marque;
        this.kilometrages = kilomerages;
        this.nbPlaces = nbPlaces;
        this.etat = etat;
    }

    

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicule other = (Vehicule) obj;
        if (this.mat != other.mat) {
            return false;
        }
        if (!Objects.equals(this.marque, other.marque)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        return true;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "mat=" + mat + ", genre=" + genre + ", type=" + type + ", puissance=" + puissance + ", energie=" + energie + ", marque=" + marque + ", kilometrages=" + mar + ", nbPlaces=" + nbPlaces + ", etat=" + etat + '}';
    }

   

   
}
