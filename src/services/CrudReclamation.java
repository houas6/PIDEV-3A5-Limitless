/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import BD.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.reclamations;

/**
 *
 * @author achra
 */
public class CrudReclamation implements InterfaceService{
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
        
    
    @Override
    public void ajouterreclamation(reclamations r) {
    try {
        System.out.println(conn);
        ste = conn.createStatement();
        String req = "INSERT INTO `gestion des reclamations` VALUES(0,'"+r.getNomClient()+"','"+r.getDescription()+"','"+r.getEtat()+"')";
        System.out.println(req);
        ste.executeUpdate(req);
        System.out.println("reclamation ajouté");
    } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Reclamation non ajouté!!!!");    }
    }
    
    @Override
    public List<reclamations> afficherreclamation() {
    List<reclamations> pers = new ArrayList<reclamations>();
        try {
        String req = "SELECT * FROM `gestion des reclamations`";
        ste = conn.createStatement();
        ResultSet result = ste.executeQuery(req);
        System.out.println(result);
        while (result.next()) {
            reclamations resultPerson = new reclamations(result.getInt("id"), result.getString("nom client"), result.getString("description"),result.getString("etat"));
            pers.add(resultPerson);
        }
        System.out.println(pers);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return pers;
 }
    
    
    public void modifierreclamation(reclamations r) {
        try {
            String req = "UPDATE `gestion des reclamations` SET `nom client` = '" + r.getNomClient() + "', `description` = '" + r.getDescription() + "',`etat` = '" + r.getEtat() + "' WHERE `gestion des reclamations`.`id` = " + r.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamtion updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        public void supprimerreclamation(int id) {
        try {
            String req = "DELETE FROM `gestion des reclamations` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterpersonne2(reclamations r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierpersonne(reclamations r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerpersonne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
