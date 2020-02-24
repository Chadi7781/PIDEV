package pidev.entity;
public class Commande {
    private int id_comm;
    private String date ;
    private int quantite;
    private String adresse_desti;
    private double prix;
    private String type;

    public Commande(int id_comm, String date, int quantite, String adresse_desti, double prix, String type) {
        this.id_comm = id_comm;
        this.date = date;
        this.quantite = quantite;
        this.adresse_desti = adresse_desti;
        this.prix = prix;
        this.type = type;
    }
    
    
    

    public int getId_comm() {
        return id_comm;
    }

    public String getDate() {
        return date;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getAdresse_desti() {
        return adresse_desti;
    }

    public double getPrix() {
        return prix;
    }

    public String getType() {
        return type;
    }

    public void setId_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setAdresse_desti(String adresse_desti) {
        this.adresse_desti = adresse_desti;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_comm=" + id_comm + ", date=" + date + ", quantite=" + quantite + ", adresse_desti=" + adresse_desti + ", prix=" + prix + ", type=" + type + '}';
    }
    
    
    
}
