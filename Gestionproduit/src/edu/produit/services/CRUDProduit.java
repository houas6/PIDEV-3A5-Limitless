/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.services;

import edu.produit.entites.Produit;
import edu.produit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class CRUDProduit implements InterfaceServices{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConnection();
    
    
    public void ajouterproduit(Produit p) {
        try {
        ste = conn.createStatement();
        String req = "Insert into produit values(0,'"+p.getNom_produit()+"','"+p.getPrix()+"','"+p.getDescription()+"','"+p.getId_fournisseur()+"')";
        ste.executeUpdate(req);
        System.out.println("Produit ajouté");
    } catch (SQLException ex) {
            System.out.println("Produit non ajouté!!!!");    }
    }

    
    public void ajouterproduit2(Produit p) {
       try {
            String req = "INSERT INTO `produit` (`nom_produit`, `prix`,`description`,`id_fournisseur`) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(4, p.getId_fournisseur());
            ps.setString(3, p.getDescription());
            ps.setFloat(2, p.getPrix());
            ps.setString(1, p.getNom_produit());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void modifierproduit(Produit p) {
       try {
            String req = "UPDATE `produit` SET `nom_produit` = '"+ p.getNom_produit()+ "','`prix` = '" +p.getPrix()+ "','`description`='"+p.getDescription()+"' WHERE `produit`.`id_produit` = " + p.getId_produit();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Produit updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void supprimerproduit(int id_produit) {
        try {
            String req = "DELETE FROM `produit` WHERE id_produit = " + id_produit;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Produit deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public List<Produit> afficherproduit() {
       List<Produit> prod = new ArrayList<Produit>();
        try {
        String req = "SELECT * FROM `produit`";
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            Produit resultProduit = new Produit(result.getInt("id_produit"), result.getString("nom_produit"),result.getFloat("prix"),result.getString("description"),result.getInt("id_fournisseur"));
            prod.add(resultProduit);
        }
        System.out.println(prod);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return prod;
    }
    
}
