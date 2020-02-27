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
public class LignePanier {
    private int id_pro;
    private String libelle;
    private int prix;
    private int quantite=1;

    public LignePanier() {
    }

    public LignePanier(int id_pro, String libelle, int prix) {
        this.id_pro = id_pro;
        this.libelle = libelle;
        this.prix = prix;
    }

    public int getId_pro() {
        return id_pro;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId_produit(int id_pro) {
        this.id_pro = id_pro;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    @Override
    public int hashCode() {
      return id_pro;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      LignePanier other = (LignePanier) obj;
      if (this.id_pro != other.id_pro)
         return false;
      return true;
    }
     @Override
    public String toString() {
        return new String( "LignePanier{" + "id_pro=" + id_pro + ", prix=" + String.valueOf(prix) + ", nom_pd=" + libelle + ", Quantite=" + quantite + '}');
    }
}
