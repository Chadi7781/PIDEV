/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.util.List;
import pidev.entity.Reclamation;

/**
 *
 * @author PC
 */
public interface IReclamationService {
    public void ajouterReclamation(Reclamation p);  
    public void modifierReclamation(Reclamation p);
    public void SupprimerReclamation(Reclamation p);
    public List<Reclamation> afficherReclamation(Reclamation p);
    
    
}
