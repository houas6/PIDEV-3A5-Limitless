/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.services;

import edu.produit.entites.Produit;
import java.util.List;

/**
 *
 * @author USER
 */
public interface InterfaceServices {
    
    public void ajouterproduit (Produit p);
    public void modifierproduit(Produit p);
    public void supprimerproduit(int id_produit);
    public List<Produit> afficherproduit();
}
