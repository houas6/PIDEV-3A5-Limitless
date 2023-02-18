/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.product;
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
    public void ajouterproduct(product p) {
       try {
            String req = "INSERT INTO `products` (`name_product`, `price_product`) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getName_product());
            ps.setFloat(2, (float) p.getPrice_product());
         
            ps.executeUpdate();
            System.out.println("product ajouter !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerproduct(int id_product) {
        try{
            String req = "DELETE FROM `products` WHERE id_product = " + id_product;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("product deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    @Override
    public List<product> afficherproduct() {
       try {
        ste= conn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
    }
    List<product> productss = new ArrayList<product>();
        try {
        String req = "SELECT * FROM `products`";
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            product resultproduct = new product(result.getInt("id_product"), result.getString("name_product"), result.getFloat("price_product"));
            productss.add(resultproduct);
        }
        System.out.println(productss);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return productss;
    }

    @Override
    public product getproduct(int id_product) {
       
         try {
        String req = "SELECT * FROM `products` WHERE id_product = ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_product);
        
        ResultSet result = pste.executeQuery();
       result.next();
           product resultproduct = new product(result.getInt("id_product"), result.getString("name_product"), result.getFloat("price_product"));
        return resultproduct;
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
    return null;
    }
    }
   

