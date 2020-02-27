/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

import java.util.Objects;

/**
 *
 * @author amall
 */
public class Produit_Commande {
    private int id;
    private int id_commande;
    private int quantite;

    public Produit_Commande() {
    }

    public Produit_Commande(int id, int id_commande, int quantite) {
        this.id = id;
        this.id_commande = id_commande;
        this.quantite = quantite;
    }

    public Produit_Commande(int quantite) {
        this.quantite = quantite;
    }


    public int getId() {
        return id;
    }

    public int getId_commande() {
        return id_commande;
    }

    public int getQuantite() {
        return quantite;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.id_commande;
        hash = 97 * hash + this.quantite;
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
        final Produit_Commande other = (Produit_Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_commande != other.id_commande) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit_Commande{" + "id=" + id + ", id_commande=" + id_commande + ", quantite=" + quantite + '}';
    }
    
    
}


