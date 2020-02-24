package pidev.entity;
public class Facture {
    private int id_fact;
    private int id_livra;
    private String type_paiment;
    private String date ;

    public Facture(int id_fact, int id_livra, String type_paiment, String date) {
        this.id_fact = id_fact;
        this.id_livra = id_livra;
        this.type_paiment = type_paiment;
        this.date = date;
    }

    public int getId_fact() {
        return id_fact;
    }

    public int getId_livra() {
        return id_livra;
    }

    public String getType_paiment() {
        return type_paiment;
    }

    public String getDate() {
        return date;
    }

    public void setId_fact(int id_fact) {
        this.id_fact = id_fact;
    }

    public void setId_livra(int id_livra) {
        this.id_livra = id_livra;
    }

    public void setType_paiment(String type_paiment) {
        this.type_paiment = type_paiment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Facture{" + "id_fact=" + id_fact + ", id_livra=" + id_livra + ", type_paiment=" + type_paiment + ", date=" + date + '}';
    }
    
    
    
    
    
}
