/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;
import pidev.entity.Commande;
import java.sql.SQLException;
import java.util.List;
/**
 *
 */
public interface iCommandeService {
    public void ajouterCommande(Commande c); /*changer le void par une classe ou autre type par exemple boolean*/
    public void modifierCommande(String new_adresse_dest);
    public void supprimerCommande(int id_commande);
    public List<Commande> afficherCommande(int id) throws SQLException;

}
