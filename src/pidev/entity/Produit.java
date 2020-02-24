package pidev.entity;
public class Produit {
    private int id_pro;
    private String photo;
    private double poids;
    private double prix;
    private String description;
    private boolean Etat;
    private String categorie;
    private int id_depot;
    private String nom_pd;

    public Produit(int id_pro, String photo, double poids, double prix, String description, boolean Etat, String categorie, int id_depot, String nom_pd) {
        this.id_pro = id_pro;
        this.photo = photo;
        this.poids = poids;
        this.prix = prix;
        this.description = description;
        this.Etat = Etat;
        this.categorie = categorie;
        this.id_depot = id_depot;
        this.nom_pd = nom_pd;
    }
    
    
    

    public int getId_pro() {
        return id_pro;
    }

    public String getPhoto() {
        return photo;
    }

    public double getPoids() {
        return poids;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEtat() {
        return Etat;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getId_depot() {
        return id_depot;
    }

    public String getNom_pd() {
        return nom_pd;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(boolean Etat) {
        this.Etat = Etat;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setId_depot(int id_depot) {
        this.id_depot = id_depot;
    }

    public void setNom_pd(String nom_pd) {
        this.nom_pd = nom_pd;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_pro=" + id_pro + ", photo=" + photo + ", poids=" + poids + ", prix=" + prix + ", description=" + description + ", Etat=" + Etat + ", categorie=" + categorie + ", id_depot=" + id_depot + ", nom_pd=" + nom_pd + '}';
    }
    
    
    
    
    
}
