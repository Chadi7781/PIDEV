/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class Reclamation {
    String objet;
    String description;
    
    //LocalDate date;

    public Reclamation(String objet, String description) {
        this.objet = objet;
        this.description = description;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
}