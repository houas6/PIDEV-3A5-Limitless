/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.services;
import edu.Gestion_Echange.entites.Livreur;
import java.util.List;

/**
 *
 * @author amine
 */
public interface InterfaceServiceLivreur {
     public void ajouterLivreur(Livreur e);
    public void ajouterLivreur2 (Livreur e);
    public void modifierLivreur(Livreur e);
    public void supprimerLivreur(int id);
    public int getIdLivreur (int n );
    public List<Livreur> afficherLivreur();
    public List<Livreur> searchLivreur(String searchTerm) ;
    
}
