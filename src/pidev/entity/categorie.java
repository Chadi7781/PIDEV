/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;


public class categorie {
      Integer id;
      int idpro;
      String nom;
       String pht;

    public categorie( Integer id ,String nom) {
       this.id = id;
        this.nom = nom;
    }

    public categorie() {
    }

    public categorie(int id, int idpro, String nom, String pht) {
        this.id = id;
        this.idpro = idpro;
        this.nom = nom;
        this.pht = pht;
    }

    public String getPht() {
        return pht;
    }

    public void setPht(String pht) {
        this.pht = pht;
    }

    
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "categorie{" + "id=" + id + ", idpro=" + idpro + ", nom=" + nom + ", pht=" + pht + '}';
    }

   
      
      
    
    
}
