/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.util.List;
import models.produit;
/**
 *
 * @author rassa
 */
public interface InterfaceServiceProduct {
    public void ajouterproduct(produit p);
    public void supprimerproduct(int id_product);
    public List<produit> afficherproduct();
    public produit getproduct(int id_product);
    
}
