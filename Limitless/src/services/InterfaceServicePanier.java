/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.panier;

/**
 *
 * @author rassa
 */
public interface InterfaceServicePanier {
    public void ajouterPanier(panier p1 , int id_product);
    public void supprimerPanier(int id_client);
    public panier getpanier (int id_client);
     public void decrementQuantite(panier p1, int id_product);
     public void incrementQuantite(panier p1, int id_product);
      public int getQuantite(int client_id, int product_id);
      public void supprimerproduitpannier(int id_client, int id_product);
    
}
