/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

import java.sql.Date;

/**
 *
 * @author 21627
 */
public class Facture {
    private int id_facture;
    private int id_livraison;
    private String type_paiement;
    private Date date;

    public Facture() {
        
    }

    public Facture(int id_livraison, String type_paiement, Date date) {
        this.id_livraison = id_livraison;
        this.type_paiement = type_paiement;
        this.date = date;
    }
    

    public Facture(int id_facture, int id_livraison, String type_paiement, Date date) {
        this.id_facture = id_facture;
        this.id_livraison = id_livraison;
        this.type_paiement = type_paiement;
        this.date = date;
    }
    

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Facture{" + "id_facture=" + id_facture + ", id_livraison=" + id_livraison + ", type_paiement=" + type_paiement + ", date=" + date + '}';
    }
    
    
}
