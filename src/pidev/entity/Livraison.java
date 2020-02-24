package pidev.entity;
public class Livraison {
    private int id ;
    private String adresse_depart ;
    private String adresse_arrive;
    private String photo_prod;
    private double prix;
    private boolean fragile;
    private double poids;
    private String Etat;
    private int id_magasine;
    private int id_user;

    public Livraison(int id, String adresse_depart, String adresse_arrive, String photo_prod, double prix, boolean fragile, double poids, String Etat, int id_magasine, int id_user) {
        this.id = id;
        this.adresse_depart = adresse_depart;
        this.adresse_arrive = adresse_arrive;
        this.photo_prod = photo_prod;
        this.prix = prix;
        this.fragile = fragile;
        this.poids = poids;
        this.Etat = Etat;
        this.id_magasine = id_magasine;
        this.id_user = id_user;
    }
    
    
    
    
    
    

    public int getId() {
        return id;
    }

    public String getAdresse_depart() {
        return adresse_depart;
    }

    public String getAdresse_arrive() {
        return adresse_arrive;
    }

    public String getPhoto_prod() {
        return photo_prod;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isFragile() {
        return fragile;
    }

    public double getPoids() {
        return poids;
    }

    public String getEtat() {
        return Etat;
    }

    public int getId_magasine() {
        return id_magasine;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdresse_depart(String adresse_depart) {
        this.adresse_depart = adresse_depart;
    }

    public void setAdresse_arrive(String adresse_arrive) {
        this.adresse_arrive = adresse_arrive;
    }

    public void setPhoto_prod(String photo_prod) {
        this.photo_prod = photo_prod;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setId_magasine(int id_magasine) {
        this.id_magasine = id_magasine;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", adresse_depart=" + adresse_depart + ", adresse_arrive=" + adresse_arrive + ", photo_prod=" + photo_prod + ", prix=" + prix + ", fragile=" + fragile + ", poids=" + poids + ", Etat=" + Etat + ", id_magasine=" + id_magasine + ", id_user=" + id_user + '}';
    }
    
    
    
    
    
}
