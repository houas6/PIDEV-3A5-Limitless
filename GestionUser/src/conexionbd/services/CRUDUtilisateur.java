/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd.services;

import Entities.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import joksova.utils.MyConnection;

/**
 *
 * @author hasse
 */
public class CRUDUtilisateur {

    public CRUDUtilisateur() {
    }

    public void ajouterUtilisateur() {

        try {
            String requete = "INSERT INTO Utilisateur(username,password,mail) VALUES ('dhia','saibi','dhiaeddine.saibi@esprit.tn')";
            Statement st = new MyConnection().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Utilisateur ajoute");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterUtilisateur2(Utilisateur u) {

        try {
            String requete2 = "INSERT INTO Utilisateur(username,password,mail) VALUES (?,?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getMail());
            pst.executeUpdate();
            System.out.println("Utilisateur ajoute (methode dynamique)");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Utilisateur> afficherUtilsateur() {
        List<Utilisateur> users = new ArrayList<>();
        try {
            
            String requete3="SELECT * FROM Utilisateur";
            Statement st=new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while(rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setId_user(rs.getInt(1));
            u.setUsername(rs.getString(2));
            u.setPassword(rs.getNString(3));
            u.setMail(rs.getString(4));
            users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
return users;
    }
    
    public void supprimerUtilisateur(int id) {
        try {
            String requete4 = "DELETE FROM Utilisateur where id_user="+id;
            Statement st3=new MyConnection().getCnx().createStatement();
            st3.executeUpdate(requete4);
            System.out.println("Utilisateur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierUtilisateur (int id, String nom, String mdp, String mail)
    {
        try {
            String Requete5="UPDATE Utilisateur SET username='"+nom+"',password='"+mdp+"', mail='"+mail+"' where id_user="+id;
            PreparedStatement st4=new MyConnection().getCnx().prepareStatement(Requete5);
            st4.executeUpdate();
            System.out.println("Utilisateur modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }
}