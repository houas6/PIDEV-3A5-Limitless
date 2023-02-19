/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd.services.implementations;


import Entities.Utilisateur;
import java.util.List;

/**
 *
 * @author hasse
 */
public interface IUtilisateur {
    public void ajouterUtilisateur();
    public void ajouterUtilisateur2(Utilisateur u);
    public void modifierUtilisateur(int id, String nom, String mdp, String mail);
    public void supprimerUtilisateur(int id);
    public List<Utilisateur> afficherUtilisateur();
    
}
