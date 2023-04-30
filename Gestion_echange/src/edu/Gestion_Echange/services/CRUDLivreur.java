/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.services;
import edu.Gestion_Echange.entites.Livreur;
import edu.Gestion_Echange.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author amine
 */
public class CRUDLivreur implements InterfaceServiceLivreur {
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public void ajouterLivreur(Livreur e) {
                 try {
        ste = conn.createStatement();
        String req = "Insert into livreur values(0,'"+e.getNom()+"','"+e.getMail()+"','"+e.getTelephone()+"')";
        ste.executeUpdate(req);
        System.out.println("livreur  ajouté");
    } catch (SQLException ex) {
            System.out.println("livreur non ajouté!!!!");    }
    }

    @Override
    public void ajouterLivreur2(Livreur e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierLivreur(Livreur e) {
         try {
            String req = "UPDATE `livreur` SET `nom` = '" + e.getNom() + "', `mail` = '" + e.getMail() + "', `telephone` = '" + e.getTelephone()+  "' WHERE `echanges`.`ID_livreur` = " + e.getID_livreur();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("livreur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerLivreur(int id) {
              try {
            String req = "DELETE FROM `livreur` WHERE ID_livreur = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("livreur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getIdLivreur(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livreur> afficherLivreur() {
        List<Livreur> ech = new ArrayList<Livreur>();
        try {
            
           ste =conn.createStatement();
        String req = "SELECT * FROM `livreur`";
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            Livreur resultPerson = new Livreur(result.getInt("ID_livreur"), result.getString("nom"), result.getString("mail"), result.getInt("telephone"));
            ech.add(resultPerson);
        }
        System.out.println(ech);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return ech;
    }

    @Override
    public List<Livreur> searchLivreur(String searchTerm) {
         List<Livreur> LivreurList = new ArrayList<>();
    try {
        String requete = "SELECT * FROM livreur WHERE ID_livreur = ?";
        PreparedStatement pst = conn.prepareStatement(requete);
        pst.setInt(1, Integer.parseInt(searchTerm));
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Livreur Livreur = new Livreur();
            Livreur.setID_livreur(rs.getInt("ID_livreur"));
            Livreur.setNom(rs.getString("nom"));
            Livreur.setMail(rs.getString("mail"));
            Livreur.setTelephone(rs.getInt("telephone"));
            LivreurList.add(Livreur);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return  LivreurList;
    }
    
}
