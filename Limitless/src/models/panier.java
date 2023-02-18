/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author rassa
 */
public class panier {
   
    private int id_client;
 private ArrayList<product> products;
    private double total_panier;
    private int quantite=1;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public double getTotal_panier() {
        return total_panier;
    }

    public void setTotal_panier(double total_panier) {
        this.total_panier = total_panier;
    }
   

    public panier(int id_client) {
        
        this.id_client = id_client;
        this.products = new ArrayList<>();
        
    }
    
     public void addproduct(product product) {
        products.add(product);
        total_panier += product.getPrice_product();
    }
    public panier() {
        products = new ArrayList<>();
    }

    


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public ArrayList<product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "panier{" +  "id_client=" + id_client + ", products=" + products + ", total_panier=" + total_panier + '}';
    }

   

    
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 71 * hash + this.id_client;
        hash = 71 * hash + Objects.hashCode(this.products);
       
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final panier other = (panier) obj;
       
        if (this.id_client != other.id_client) {
            return false;
        }
        
        if (!Objects.equals(this.products, other.products)) {
            return false;
        }
        return true;
    }
    
}
