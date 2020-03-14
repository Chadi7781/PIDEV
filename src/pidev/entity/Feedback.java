/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entity;

import java.util.Objects;
import org.controlsfx.control.Rating;

/**
 *
 * @author Chédy
 */
public class Feedback {
    private int id_feed;
    private String description;
    private int note;
    private int id;
    private String email;
    
    
    public Feedback() {}

    public Feedback(String description, int note) {
        this.description = description;
        this.note = note;
    }
    
    

    public Feedback(int id_feed, String description, int note) {
        this.id_feed = id_feed;
        this.description = description;
        this.note = note;
    }

    public Feedback(int id_feed,String description, int note, int id,String email) {
        this.description = description;
        this.note = note;
        this.id = id;
        this.id_feed=id_feed;
        this.email=email;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_feed;
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.note);
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
        final Feedback other = (Feedback) obj;
        if (this.id_feed != other.id_feed) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

    public int getId_feed() {
        return id_feed;
    }

    public void setId_feed(int id_feed) {
        this.id_feed = id_feed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
}
