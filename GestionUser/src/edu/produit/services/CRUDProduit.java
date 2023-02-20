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
    
    
    /*public void ajouterproduit(Produit p) {
        try {
        ste = conn.createStatement();
        String req = "Insert into produit values(0,'"+p.getNom_produit()+"','"+p.getPrix()+"','"+p.getDescription()+"')";
        ste.executeUpdate(req);
        System.out.println("Produit ajouté");
    } catch (SQLException ex) {
            System.out.println("Produit non ajouté!!!!");    }
    }*/

    
    @Override
    public void ajouterproduit(Produit p) {
       try {
            String req = "INSERT INTO `produit` (`nom_produit`, `prix`,`description`,`id_user`,`image`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setBytes(5, p.getImage());
            ps.setInt(4, p.getId_user());
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
            String req = "UPDATE `produit` SET `nom_produit` = '"+ p.getNom_produit()+ "',`prix` = '" +p.getPrix()+ "',`description`='"+p.getDescription()+"',`id_user`='"+p.getId_user()+"' WHERE `produit`.`id_produit` = " + p.getId_produit();
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
            ste =conn.createStatement();
            String req = "SELECT * FROM `produit`";
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            Produit resultProduit = new Produit(result.getInt("id_produit"), result.getString("nom_produit"),result.getFloat("prix"),result.getString("description"),result.getInt("id_user"),result.getBytes("image"));
            prod.add(resultProduit);
        }
        System.out.println(prod);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return prod;
    }
    
    
    public int getid (int n ){ 
    int t=0 ; 
    try {
            String requete = "select * from produit where ?= id_produit";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, n);
            ResultSet e = pst.executeQuery();
            while(e.next()){
            Produit pre = new Produit(); 
            
            pre.setId_produit(e.getInt("id_produit"));
            t=pre.getId_produit();   }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
return t ; 
    }
}
