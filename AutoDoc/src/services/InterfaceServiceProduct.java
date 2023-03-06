/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.util.List;
import models.*;
/**
 *
 * @author rassa
 */
public interface InterfaceServiceProduct {
    public void ajouterproduct(Produit p);
    public void supprimerproduct(int id_product);
    public List<Produit> afficherproduct();
    public Produit getproduct(int id_product);
    
}
