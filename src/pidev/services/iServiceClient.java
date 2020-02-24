/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.util.List;
import pidev.entity.Utilisateur;

/**
 *
 * @author Maryem
 */
public interface iServiceClient {
      public void  ajouterClient(Utilisateur c);
  public void modifierClient(Utilisateur c,int id);
    public void supprimerClient(int id);
    public List<Utilisateur> afficherClient(int id);
    
}
