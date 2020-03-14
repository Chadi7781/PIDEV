package pidev.entity;
import java.util.Objects;

/**
 *
 * @author amall
 */
public class Produit {
    private int id_pro;
    private String photo;
    private int poids;
    private int prix;
    private String description;
    private String Etat;
    private int categorie;
    private int id_depot;
    private String nom_pd;
    private int Quantite;
    private String ADR;
    
    public Produit(int id,int prix, String Etat, int categorie, String nom_pd, int Quantite) {
        this.id_pro=id;
        this.prix = prix;
        this.Etat = Etat;
        this.categorie = categorie;
        this.nom_pd = nom_pd;
        this.Quantite = Quantite;
        this.ADR=ADR;
    }

      
    public Produit(int id_pro, String photo, int poids, int prix, String description, String Etat, int categorie, int id_depot, String nom_pd, int Quantite) {
        this.id_pro = id_pro;
        this.photo = photo;
        this.poids = poids;
        this.prix = prix;
        this.description = description;
        this.Etat = Etat;
        this.categorie = categorie;
        this.id_depot = id_depot;
        this.nom_pd = nom_pd;
        this.Quantite = Quantite;
    }
    //amal
    public Produit(String nom_pd, String photo, int prix, String description, int categorie) {
        this.photo = photo;
        this.description = description;
        this.categorie = categorie;
        this.nom_pd = nom_pd;
        this.prix = prix;
    }
    //Constructeur par copie amal
    
    public Produit(Produit p)
    {
        this.id_pro = p.id_pro;
        this.photo = p.photo;
        this.poids = p.poids;
        this.prix = p.prix;
        this.description = p.description;
        this.Etat = p.Etat;
        this.categorie = p.categorie;
        this.id_depot = p.id_depot;
        this.nom_pd = p.nom_pd;
        this.Quantite = p.Quantite;
    }

    public Integer getId_pro() {
        return id_pro;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPoids() {
        return poids;
    }

    public int getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public String getEtat() {
        return Etat;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public int getId_depot() {
        return id_depot;
    }

    public String getNom_pd() {
        return nom_pd;
    }

    public int getQuantite() {
        return Quantite;
    }

    public String getADR() {
        return ADR;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setId_depot(int id_depot) {
        this.id_depot = id_depot;
    }

    public void setNom_pd(String nom_pd) {
        this.nom_pd = nom_pd;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    public void setADR(String ADR) {
        this.ADR = ADR;
    }
 


   

   @Override
    public String toString() {
        return "Produit{" + "id_pro=" + id_pro + ", photo=" + photo + ", poids=" + poids + ", prix=" + prix + ", description=" + description + ", Etat=" + Etat + ", categorie=" + categorie + ", id_depot=" + id_depot + ", nom_pd=" + nom_pd + ", Quantite=" + Quantite + '}';
    }

    public Produit() {
    }
//amal
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
      Produit other = (Produit) obj;
      if (this.id_pro != other.id_pro)
         return false;
      return true;
    }
   
    
    
    
    
}
   
    
    
    
    

    
    
    

    