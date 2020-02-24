package pidev.entity;
public class Depot {
    private int id ;
    private String pays;
    private String attitude;
    private String langitude;
    private int surface ;
    private int id_pro;
    private int prix;
    String datedebut;
    String datefin;

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
    
    public Depot(int id, String pays, String attitude, String langitude, int surface, int id_pro) {
        this.id = id;
        this.pays = pays;
        this.attitude = attitude;
        this.langitude = langitude;
        this.surface = surface;
        this.id_pro = id_pro;
    }

    public Depot() {
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public String getPays() {
        return pays;
    }

    public String getAttitude() {
        return attitude;
    }

    public String getLangitude() {
        return langitude;
    }

    public int getSurface() {
        return surface;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public void setLangitude(String langitude) {
        this.langitude = langitude;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    @Override
    public String toString() {
        return "Depot{" + "id=" + id + ", pays=" + pays + ", attitude=" + attitude + ", langitude=" + langitude + ", surface=" + surface + ", id_pro=" + id_pro + '}';
    }
    
    
    
    
    
    
}
