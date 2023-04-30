/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.services;

import edu.Gestion_Echange.entites.Livraison;
import edu.Gestion_Echange.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amine
 */
public class CRUDLivraison implements InterfaceServiceLivraison {
Statement ste;
Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public void ajouterLivraison(Livraison e) {
          try {
        ste = conn.createStatement();
        String req = "Insert into livraison values(0,'"+e.getId_Livreur()+"','"+e.getId_commande()+"','"+e.getDate_livraison()+
                "','"+e.getAdresse_livraison()+"','"+e.getCode_postal_livraison()+"','"+e.getStatus_livraison()+"')";
        ste.executeUpdate(req);
        System.out.println("livraison ajouté");
    } catch (SQLException ex) {
            System.out.println("livraison non ajouté!!!!");    }
    }

    @Override
    public void ajouterLivraison2(Livraison e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierLivraison(Livraison e) {
               try {
            String req = "UPDATE `livraison` SET `id_livreur` = '" + e.getId_Livreur() + "', `id_commande` = '" + e.getId_commande() + "', `date_livraison` = '" + e.getDate_livraison()+"', `adresse_livraison` = '" + e.getAdresse_livraison()+ "', `code_postal_livraison` = '" + e.getCode_postal_livraison()+
                    "', `status_livraison` = '" + e.getStatus_livraison()+   "' WHERE `livraison`.`id_livraison` = " + e.getId_livraison();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("livraison updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerLivraison(int id) {
             try {
            String req = "DELETE FROM `livraison` WHERE id_livraison = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("echange deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getIdLivraison(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livraison> afficherLivraison() {
      List<Livraison> ech = new ArrayList<Livraison>();
        try {
            
           ste =conn.createStatement();
        String req = "SELECT * FROM `livraison`";
        ResultSet result = ste.executeQuery(req);
        while (result.next()) {
            Livraison resultPerson = new Livraison(result.getInt("id_livraison"), result.getInt("id_livreur"), result.getInt("id_commande"), result.getDate("date_livraison").toLocalDate()
              , result.getString("adresse_livraison"),result.getInt("code_postal_livraison"),result.getString("status_livraison"));
            ech.add(resultPerson);
        }
        System.out.println(ech);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return ech;
    }

    @Override
    public List<Livraison> searchLivraison(String searchTerm) {
            List<Livraison> LivraisonList = new ArrayList<>();
    try {
        String requete = "SELECT * FROM livraison WHERE id_livraison = ?";
        PreparedStatement pst = conn.prepareStatement(requete);
        pst.setInt(1, Integer.parseInt(searchTerm));
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Livraison Livraison = new Livraison();
            Livraison.setId_livraison(rs.getInt("id_livraison"));
            Livraison.setId_Livreur(rs.getInt("id_Livreur"));
            Livraison.setId_commande(rs.getInt("id_commande"));
            Livraison.setDate_livraison(rs.getDate("date_livraison").toLocalDate());
            Livraison.setAdresse_livraison(rs.getString("adresse_livraison"));
            Livraison.setCode_postal_livraison(rs.getInt("code_postal_livraison"));
            Livraison.setStatus_livraison(rs.getString("status_livraison"));
            LivraisonList.add(Livraison);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return LivraisonList;
    }
    
}
