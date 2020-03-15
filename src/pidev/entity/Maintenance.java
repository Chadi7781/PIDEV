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
public class Maintenance {
    private int id;
    private String nature;
    private String date;
    private String description;
    private String cout;
    private String matricule;

    public Maintenance(int id, String nature, String date, String description, String cout, String matricule) {
        this.id = id;
        this.nature = nature;
        this.date = date;
        this.description = description;
        this.cout = cout;
        this.matricule = matricule;
    }

    public Maintenance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCout() {
        return cout;
    }
    public String getCT()
    {     return cout; }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Maintenance other = (Maintenance) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Maintenanance{" + "id=" + id + ", nature=" + nature + ", date=" + date + ", description=" + description + ", cout=" + cout + ", matricule=" + matricule + '}';
    }
    
    
    
}
