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
    @Override
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
    
    
    
    
    
    
    
    
    
    }
    

