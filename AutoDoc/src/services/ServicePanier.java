/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.panier;
import BD.MyConnection;
import java.sql.Blob;
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
public void ajouterPanier(panier p1, int id_produit) {
    try {
        // Check if the produit already exists in the cart
        String selectReq = "SELECT quantite_product FROM panier WHERE id_user = ? AND id_produit = ?";
        PreparedStatement selectPs = conn.prepareStatement(selectReq);
        selectPs.setInt(1, p1.getId_user());
        selectPs.setInt(2, id_produit);
        ResultSet rs = selectPs.executeQuery();

        if (rs.next()) {
            // Product already exists, update the quantity
            int quantite = rs.getInt("quantite_product") + 1;
            String updateReq = "UPDATE panier SET quantite_product = ? WHERE id_user = ? AND id_produit = ?";
            PreparedStatement updatePs = conn.prepareStatement(updateReq);
            updatePs.setInt(1, quantite);
            updatePs.setInt(2, p1.getId_user());
            updatePs.setInt(3, id_produit);
            updatePs.executeUpdate();
            System.out.println("Product quantity updated in the cart!");
        } else {
            // Product does not exist, add a new row to the cart
            String insertReq = "INSERT INTO panier (id_user, id_produit, quantite_product) VALUES (?, ?, 1)";
            PreparedStatement insertPs = conn.prepareStatement(insertReq);
            insertPs.setInt(1, p1.getId_user());
            insertPs.setInt(2, id_produit);
            insertPs.executeUpdate();
            System.out.println("Product added to the cart!");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
}
    

    @Override
    public void supprimerPanier(int id_user) {
       
         try{
            String req = "DELETE FROM `panier` WHERE id_user = " + id_user;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("panier deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
        
        
       }

    @Override
    public panier getpanier(int id_user) {
      panier panier= new panier();
        ServiceProduct sa = new ServiceProduct();
        ServicePanier sp = new ServicePanier();
   
         int quantite=1;
          try {
        String req = "SELECT * FROM `panier` WHERE id_user =  ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_user);
            
        ResultSet result = pste.executeQuery();
        while(result.next()){
             
           Produit resultproduct = sa.getproduct(result.getInt(2));
            quantite= result.getInt(3);
           
      panier.addproduct(resultproduct);
        }
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
          panier.setId_user(id_user);
          panier.setQuantite(quantite);
         double totalCost = panier.getProducts().stream().mapToDouble(x->x.getPrix() * sp.getQuantite(id_user, x.getId_produit())).sum();
         panier.setTotal_panier(totalCost);
    return panier;
    }
    
    
    
@Override
    public void decrementQuantite(panier p1, int id_produit) {
    try {
        // Check if the produit exists in the cart
        String selectReq = "SELECT quantite_product FROM panier WHERE id_user = ? AND id_produit = ?";
        PreparedStatement selectPs = conn.prepareStatement(selectReq);
        selectPs.setInt(1, p1.getId_user());
        selectPs.setInt(2, id_produit);
        ResultSet rs = selectPs.executeQuery();

        if (rs.next()) {
            int quantite = rs.getInt("quantite_product");
            if (quantite > 1) {
                // Product exists and quantity is more than 1, decrement the quantity
                String updateReq = "UPDATE panier SET quantite_product = ? WHERE id_user = ? AND id_produit = ?";
                PreparedStatement updatePs = conn.prepareStatement(updateReq);
                updatePs.setInt(1, quantite - 1);
                updatePs.setInt(2, p1.getId_user());
                updatePs.setInt(3, id_produit);
                updatePs.executeUpdate();
                System.out.println("Product quantity decremented in the cart!");
            } else {
                // Product exists but quantity is 1, remove the produit from the cart
                String deleteReq = "DELETE FROM panier WHERE id_user = ? AND id_produit = ?";
                PreparedStatement deletePs = conn.prepareStatement(deleteReq);
                deletePs.setInt(1, p1.getId_user());
                deletePs.setInt(2, id_produit);
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
    
    
    
    
@Override
    public void incrementQuantite(panier p1, int id_produit) {
    try {
        // Check if the produit exists in the cart
        String selectReq = "SELECT quantite_product FROM panier WHERE id_user = ? AND id_produit = ?";
        PreparedStatement selectPs = conn.prepareStatement(selectReq);
        selectPs.setInt(1, p1.getId_user());
        selectPs.setInt(2, id_produit);
        ResultSet rs = selectPs.executeQuery();

        if (rs.next()) {
            // Product exists in the cart, increment the quantity
            int quantite = rs.getInt("quantite_product");
            String updateReq = "UPDATE panier SET quantite_product = ? WHERE id_user = ? AND id_produit = ?";
            PreparedStatement updatePs = conn.prepareStatement(updateReq);
            updatePs.setInt(1, quantite + 1);
            updatePs.setInt(2, p1.getId_user());
            updatePs.setInt(3, id_produit);
            updatePs.executeUpdate();
            System.out.println("Product quantity incremented in the cart!");
        } else {
            // Product does not exist in the cart, add the produit with quantity 1
            String insertReq = "INSERT INTO panier (id_user, id_produit, quantite_product) VALUES (?, ?, 1)";
            PreparedStatement insertPs = conn.prepareStatement(insertReq);
            insertPs.setInt(1, p1.getId_user());
            insertPs.setInt(2, id_produit);
            insertPs.executeUpdate();
            System.out.println("Product added to the cart!");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    
    
    
    
    
    
@Override
    public int getQuantite(int user_id, int produit_id) {
    int quantite = 0;
    try {
        String req = "SELECT quantite_product FROM panier WHERE id_user=? AND id_produit=?";
        PreparedStatement ps = conn.prepareStatement(req);
        ps.setInt(1, user_id);
        ps.setInt(2, produit_id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            quantite = rs.getInt("quantite_product");
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return quantite;
}
    
    
    
    
@Override
    public void supprimerproduitpannier(int id_user, int id_produit) {
    try {
        String req = "DELETE FROM panier WHERE id_user = " + id_user + " AND id_produit = " + id_produit;
        Statement st = conn.createStatement();
        st.executeUpdate(req);
        System.out.println("Product " + id_produit + " deleted from cart of utilisateur " + id_user);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    
    
    
    
    
    
    
     public byte[] getProductImage(int productId) throws SQLException {
        // Create the SQL statement to retrieve the BLOB column from the "produit" table
        String sql = "SELECT image FROM produit WHERE id_produit = ?";

        // Create a PreparedStatement to execute the SQL statement with the product ID parameter
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, productId);

        // Execute the query and get the ResultSet containing the BLOB data
        ResultSet rs = stmt.executeQuery();

        // Get the BLOB data from the ResultSet
        if (rs.next()) {
            Blob imageBlob = rs.getBlob("image");
            if (imageBlob != null) {
                return imageBlob.getBytes(1, (int) imageBlob.length());
            }
        }

        // Return null if the BLOB column is not found or is null
        return null;
    }
    
    
    
    
    
    
    }
    

