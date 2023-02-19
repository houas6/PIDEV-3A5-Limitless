/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
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
public class ServiceCommande implements InterfaceServiceCommande{
  Statement ste;
   Connection conn = MyConnection.getInstance().getConnection();
   
    @Override
    public void ajoutercommande(commande c) {
        ServicePanier sp= new ServicePanier();
        panier resultpanier = sp.getpanier(c.getCl().getId_user());
        
        try {
            String req = "INSERT INTO `commande` (`id_commande`,`id_user`,`nom`,`prenom`,`adresse`,`total`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, c.getId_commande());
            ps.setInt(2, c.getCl().getId_user());
            ps.setString(3, c.getCl().getNom());
            ps.setString(4, c.getCl().getPrenom());
            ps.setString(5, c.getCl().getAdresse());
            ps.setDouble(6, resultpanier.getTotal_panier());
           
            ps.executeUpdate();
             System.out.println("commande item added !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public commande recupererCommandeClient(int id_user) {
         
        ServiceUtilisateur sc = new ServiceUtilisateur();
        ServicePanier sp= new ServicePanier();
        commande command = new commande();
     
          try {
        String req = "SELECT * FROM `commande` WHERE id_user = ?";
        PreparedStatement pste=conn.prepareStatement(req);
        pste.setInt(1, id_user);
        
        ResultSet result = pste.executeQuery();
       result.next();
           command.setId_commande(result.getInt(1));
        
      
    }catch (SQLException ex) {
         System.out.println(ex);   
    }
          
          command.setCl(sc.getutilisateur(id_user)); 
          
        panier resultpanier = sp.getpanier(id_user);
        command.setTotal_commande(resultpanier.getTotal_panier());
    return command;
    }

    @Override
    public void supprimercommande(int id_commande) {
       PreparedStatement stmt = null;
        try {

            // Préparation de la requête de suppression
            String sql = "DELETE FROM commande WHERE id_commande = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_commande);

            // Exécution de la requête
            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("La commande avec l'ID " + id_commande + " a été supprimée.");
            } else {
                System.out.println("Aucune commande avec l'ID " + id_commande + " n'a été trouvée.");
            }

        } catch (SQLException ex) {
            System.err.println("Une erreur s'est produite lors de la suppression de la commande : " + ex.getMessage());
        }
    }
    
}
