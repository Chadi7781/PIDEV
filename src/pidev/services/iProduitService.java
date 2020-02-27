/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;
import pidev.entity.Produit;
import java.util.List;
/**
 *
 * @author amall
 */
public interface iProduitService {
    public void ajouterProduit(Produit p); /*changer le void par une classe ou autre type par exemple boolean*/
    public void modifierProduit(int id_produit,String new_libelle_produit,String new_photo_produit, int new_poids, int new_prix, String new_description, String new_categorie);
    public void supprimerProduit(int id_produit);
    public List<Produit> afficherProduit(Produit p);
    public List<Produit> afficherParPrix(int prix);

}
