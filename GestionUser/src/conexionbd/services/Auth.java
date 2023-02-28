/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd.services;

/**
 *
 * @author hasse
 */
import Entities.Utilisateur;
import java.sql.*;

public class Auth {
    private static Utilisateur currentUtilisateur;

    public static Utilisateur getCurrentUtilisateur() {
        return currentUtilisateur;
    }

    public static Utilisateur signIn(String email,String password) {
        Utilisateur user = Utilisateur.getUserByEmail(email);
        currentUtilisateur = user;
        if (user != null && user.getPassword().equals(password)) {
            System.out.println(currentUtilisateur);
            System.out.println("Utilisateur Connecte");
            return currentUtilisateur;
        } else {
            System.out.println(currentUtilisateur);
            System.out.println("Utilisateur NonConnecte");
            return currentUtilisateur;
        }
    }

    public static boolean signUp(String nom,String prenom, String cin, String email, String password, String numero) {
        
        if (Utilisateur.getUserByEmail(email) == null) {
            Utilisateur currentUtilisateur = new Utilisateur();
            currentUtilisateur.setMail(email);
            currentUtilisateur.setPassword(password);
            currentUtilisateur.setPrenom(prenom);
            currentUtilisateur.setNom(nom);
            currentUtilisateur.setCin(cin);
            currentUtilisateur.setNumero(numero);
            CRUDUtilisateur cu=new CRUDUtilisateur();
            cu.ajouterUtilisateur2(currentUtilisateur);
            return true;
        } else {
            return false;
        }
    }

    public static void logout() {
        currentUtilisateur = null;
    }
    
    
public static boolean changePassword(String mail, String newPassword) {
    try {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/limitless", "root", "");
        String query = "UPDATE utilisateur SET password=? WHERE mail=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, newPassword);
        pstmt.setString(2, mail);

        // Exécuter la requête
        pstmt.executeUpdate();

        // Fermer la connexion
        conn.close();

        System.out.println("Mot de passe modifié avec succès.");
        return true;
    } catch (Exception e) {
        System.err.println("Erreur : " + e.getMessage());
        return false;
    }
}

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean checkEmail(String email) {
boolean exists = false;
    try {
        // Vérifier si l'email existe déjà dans la base de données
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/limitless", "root", "");
        String query = "SELECT COUNT(*) FROM utilisateur WHERE mail = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        if (count > 0) {
            exists = true;
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    return exists;
    }
}
