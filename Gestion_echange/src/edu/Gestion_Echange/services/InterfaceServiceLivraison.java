/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.services;
import edu.Gestion_Echange.entites.Livraison;
import java.util.List;
/**
 *
 * @author amine
 */
public interface InterfaceServiceLivraison {
    public void ajouterLivraison(Livraison e);
    public void ajouterLivraison2 (Livraison e);
    public void modifierLivraison(Livraison e);
    public void supprimerLivraison(int id);
    public int getIdLivraison (int n );
    public List<Livraison> afficherLivraison();
    public List<Livraison> searchLivraison(String searchTerm) ;
}
