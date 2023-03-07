/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import BD.MyConnection;
import models.*;
import java.sql.Connection;
import java.sql.DriverManager;
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
    public List<commande> afficherCommands2() {
        List<commande> comds = new ArrayList<>();
        Utilisateur user = Auth.getCurrentUtilisateur();
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
//        String req = "SELECT * FROM commande WHERE id_user = ?";
//        ste=conn.createStatement();
//        ResultSet result = ste.executeQuery(req);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/limitless", "root", "");
            stmt = conn.prepareStatement("SELECT * FROM commande WHERE id_user = ?");
            stmt.setInt(1, user.getId_user());
            rs = stmt.executeQuery();

            while (rs.next()) {
                commande resultCommand = new commande(rs.getInt("id_commande"), rs.getInt("id_user"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getFloat("total"), rs.getString("status"));
                comds.add(resultCommand);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return comds;
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
   
    public List<commande> afficherCommands() {
    List<commande> comds = new ArrayList<>();
        try {
        String req = "SELECT * FROM commande";
        ste=conn.createStatement();
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            commande resultCommand = new commande(result.getInt("id_commande"),result.getInt("id_user"), result.getString("nom"), result.getString("prenom"), result.getString("adresse"),result.getFloat("total"),result.getString("status"));

            comds.add(resultCommand);
        }
        
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return comds;
    }
    
    
    @Override
    public void modifierCommand(commande c) {
        try {
            String req = "UPDATE commande SET status = '" + c.getStatus()+ "' WHERE `id_commande` = " + c.getId_commande();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println(" updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
