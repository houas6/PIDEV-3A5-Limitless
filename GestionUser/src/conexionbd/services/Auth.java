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
    private static Utilisateur currentUtilisateur = null;

    public static Utilisateur getCurrentUtilisateur() {
        return currentUtilisateur;
    }

    public static boolean signIn(String email, String password) {
        Utilisateur user = Utilisateur.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            currentUtilisateur = user;
            System.out.println("Utilisateur Connecte");
            return true;
        } else {
            System.out.println("Utilisateur NonConnecte");
            return false;
        }
    }

    public static boolean signUp(String username, String email, String password) {
        CRUDUtilisateur cu=new CRUDUtilisateur();
        if (Utilisateur.getUserByEmail(email) == null) {
            currentUtilisateur.setMail(email);
            currentUtilisateur.setPassword(password);
            currentUtilisateur.setUsername(username);
            cu.ajouterUtilisateur2(currentUtilisateur);
            return true;
        } else {
            return false;
        }
    }

    public static void logout() {
        currentUtilisateur = null;
    }
}
