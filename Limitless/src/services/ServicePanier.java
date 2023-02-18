/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.panier;
import DB.MyConnection;
import models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rassa
 */
public class ServicePanier implements InterfaceServicePanier{
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
   /* @Override
    public void ajouterPanier(panier p1 , int id_product) {
        try {
            String req = "INSERT INTO `panier` (`id_client`,`id_product`) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, p1.getId_client());
            ps.setInt(2, id_product);
           
            ps.executeUpdate();
             System.out.println("panier item added !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
 @Override
public void ajouterPanier(panier p1, int id_product) {
    try {
        // Check if the product already exists in the cart
        String selectReq = "SELECT quantite_product FROM panier WHERE id_client = ? AND id_product = ?";
        PreparedStatement selectPs = conn.prepareStatement(selectReq);
        selectPs.setInt(1, p1.getId_client());
        selectPs.setInt(2, id_product);
        ResultSet rs = selectPs.executeQuery();

        if (rs.next()) {
            // Product already exists, update the quantity
            int quantite = rs.getInt("quantite_product") + 1;
            String updateReq = "UPDATE panier SET quantite_product = ? WHERE id_client = ? AND id_product = ?";
            PreparedStatement updatePs = conn.prepareStatement(updateReq);
            updatePs.setInt(1, quantite);
            updatePs.setInt(2, p1.getId_client());
            updatePs.setInt(3, id_product);
            updatePs.executeUpdate();
            System.out.println("Product quantity updated in the cart!");
        } else {
            // Product does not exist, add a new row to the cart
            String insertReq = "INSERT INTO panier (id_client, id_product, quantite_product) VALUES (?, ?, 1)";
            PreparedStatement insertPs = conn.prepareStatement(insertReq);
            insertPs.setInt(1, p1.getId_client());
            insertPs.setInt(2, id_product);
            insertPs.executeUpdate();
            System.out.println("Product added to the cart!");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    

    @Override
    public void supprimerPanier(int id_client) {
       
         try{
            String req = "DELETE FROM `panier` WHERE id_client = " + id_client;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("panier deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
        
        
       }

    @Override
    public panier getpanier(int id_client) {
      panier panier= new panier();
        ServiceProduct sa = new ServiceProduct();
          try {
        String req = "SELECT * FROM `panier` WHERE id_client =  ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_client);
            
        ResultSet result = pste.executeQuery();
        while(result.next()){
             
           product resultproduct = sa.getproduct(result.getInt(2));
      panier.addproduct(resultproduct);
        }
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
          panier.setId_client(id_client);
         double totalCost = panier.getProducts().stream().mapToDouble(x->x.getPrice_product()).sum();
         panier.setTotal_panier(totalCost);
    return panier;
    }
    
    
    
@Override
    public void decrementQuantite(panier p1, int id_product) {
    try {
        // Check if the product exists in the cart
        String selectReq = "SELECT quantite_product FROM panier WHERE id_client = ? AND id_product = ?";
        PreparedStatement selectPs = conn.prepareStatement(selectReq);
        selectPs.setInt(1, p1.getId_client());
        selectPs.setInt(2, id_product);
        ResultSet rs = selectPs.executeQuery();

        if (rs.next()) {
            int quantite = rs.getInt("quantite_product");
            if (quantite > 1) {
                // Product exists and quantity is more than 1, decrement the quantity
                String updateReq = "UPDATE panier SET quantite_product = ? WHERE id_client = ? AND id_product = ?";
                PreparedStatement updatePs = conn.prepareStatement(updateReq);
                updatePs.setInt(1, quantite - 1);
                updatePs.setInt(2, p1.getId_client());
                updatePs.setInt(3, id_product);
                updatePs.executeUpdate();
                System.out.println("Product quantity decremented in the cart!");
            } else {
                // Product exists but quantity is 1, remove the product from the cart
                String deleteReq = "DELETE FROM panier WHERE id_client = ? AND id_product = ?";
                PreparedStatement deletePs = conn.prepareStatement(deleteReq);
                deletePs.setInt(1, p1.getId_client());
                deletePs.setInt(2, id_product);
                deletePs.executeUpdate();
                System.out.println("Product removed from the cart!");
            }
        } else {
            // Product does not exist in the cart
            System.out.println("Product not found in the cart!");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    
    
    
    
    
    }
    

