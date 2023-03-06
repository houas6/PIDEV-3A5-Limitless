/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.commande;

/**
 *
 * @author rassa
 */
public interface InterfaceServiceCommande {
     public void ajoutercommande(commande c);
     public commande recupererCommandeClient(int id_Client);
     public void supprimercommande(int id_commande);
     public List<commande> afficherCommands();
      public void modifierCommand(commande c) ;
    
}
