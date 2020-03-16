/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;
import java.sql.SQLException;
import pidev.entity.Produit_favoris;
import java.util.List;


/**
 *
 * @author amall
 */
public interface iProduit_favoriService {
    public void ajouterPF(Produit_favoris pf);
    public void supprimerPF(int id_favorite);
    public List<Produit_favoris> afficherPF(int id) throws SQLException;
    
}
