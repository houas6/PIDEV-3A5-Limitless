/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.produit;
import DB.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rassa
 */
public class ServiceProduct implements InterfaceServiceProduct{
    
    Statement ste;
Connection conn = MyConnection.getInstance().getConnection();

    @Override
    public void ajouterproduct(produit p) {
       try {
            String req = "INSERT INTO `produit` (`nom_produit`, `prix`, `description`, `id_user` ) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getNom_produit());
            ps.setFloat(2, (float) p.getPrix());
            ps.setString(3, p.getDescritpion());
            ps.setInt(4, p.getId_user());
         
            ps.executeUpdate();
            System.out.println("product ajouter !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerproduct(int id_produit) {
        try{
            String req = "DELETE FROM `produit` WHERE id_produit = " + id_produit;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("product deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    @Override
    public List<produit> afficherproduct() {
       try {
        ste= conn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
    }
    List<produit> productss = new ArrayList<produit>();
        try {
        String req = "SELECT * FROM `produit`";
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            produit resultproduct = new produit(result.getInt("id_produit"), result.getString("nom_produit"), result.getFloat("prix"));
            productss.add(resultproduct);
        }
        System.out.println(productss);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return productss;
    }

    @Override
    public produit getproduct(int id_produit) {
       
         try {
        String req = "SELECT * FROM `produit` WHERE id_produit = ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_produit);
        
        ResultSet result = pste.executeQuery();
       result.next();
           produit resultproduct = new produit(result.getInt("id_produit"), result.getString("nom_produit"), result.getFloat("prix"));
        return resultproduct;
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
    return null;
    }
    }
   

