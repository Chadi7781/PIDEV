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
public interface iServiceEntreprise {
      public void  ajouterEntreprise(Utilisateur e);
  public void modifierEntreprise(Utilisateur e, int id);
    public void supprimerEntreprise(Utilisateur e);
    public List<Utilisateur> afficherEntreprise(Utilisateur e);
}
