/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

/**
 *
 * @author amall
 */
public class Produit_favoris {
    private int id_favorite;
    private int id;
    private int id_produit;

    public Produit_favoris() {
    }

    public Produit_favoris(int id_favorite, int id, int id_produit) {
        this.id_favorite = id_favorite;
        this.id = id;
        this.id_produit = id_produit;
    }

    public int getId_favorite() {
        return id_favorite;
    }

    public void setId_favorite(int id_favorite) {
        this.id_favorite = id_favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id_favorite;
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
        final Produit_favoris other = (Produit_favoris) obj;
        if (this.id_favorite != other.id_favorite) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.id_produit != other.id_produit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit_favoris{" + "id_favorite=" + id_favorite + ", id=" + id + ", id_produit=" + id_produit + '}';
    }
    
    
}
