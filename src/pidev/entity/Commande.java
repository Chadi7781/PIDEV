package pidev.entity;
import java.util.Objects;
import java.sql.Timestamp;    
import java.util.Date;    
import java.text.SimpleDateFormat;
/**
 *
 * @author amall
 */
public class Commande {
    
    private int id_commande;
    private int id;
    private Date date;
    private String adresse_dest;
    private int prix_total;

    public Commande() {
    }

    public Commande(int id, Date date, String adresse_dest, int prix_total) {
        this.id = id;
        this.date = date;
        this.adresse_dest = adresse_dest;
        this.prix_total = prix_total;
    }

    public Commande(String adresse_dest) {
        this.adresse_dest = adresse_dest;
    }
    

    public Commande(int id, String adresse_dest) {
        this.id = id;
        this.adresse_dest = adresse_dest;
    }
    

    public Commande(int id_commande, int id, Date date, String adresse_dest, int prix_total) {
        this.id_commande = id_commande;
        this.id = id;
        this.date = date;
        this.adresse_dest = adresse_dest;
        this.prix_total = prix_total;

    }

    public int getId_commande() {
        return id_commande;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getAdresse_dest() {
        return adresse_dest;
    }

    public int getPrix_total() {
        return prix_total;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAdresse_dest(String adresse_dest) {
        this.adresse_dest = adresse_dest;
    }

    public void setPrix_total(int prix_total) {
        this.prix_total = prix_total;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_commande;
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
        final Commande other = (Commande) obj;
        if (this.id_commande != other.id_commande) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.prix_total != other.prix_total) {
            return false;
        }
        if (!Objects.equals(this.adresse_dest, other.adresse_dest)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    



    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", id=" + id + ", date=" + date + ", adresse_dest=" + adresse_dest + ", prix_total=" + prix_total + '}';
    }
    
}
