/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entity.Produit_Commande;
import java.util.List;

/**
 *
 * @author amall
 */
public interface iProduitCommandeService {
   public void ajouterProdCmd(Produit_Commande pc); 
    public void modifierProdCmd(int id_prodcmd,int new_quantite);
    public void supprimerProdCmd(int id_prodcmd);
    public List<Produit_Commande> afficherProdCmd(Produit_Commande pc);

}
