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

    public static boolean signIn(String email,String password) {
        Utilisateur user = Utilisateur.getUserByEmail(email);
        currentUtilisateur = user;
        if (user != null && user.getPassword().equals(password)) {
            System.out.println(currentUtilisateur);
            System.out.println("Utilisateur Connecte");
            return true;
        } else {
            System.out.println(currentUtilisateur);
            System.out.println("Utilisateur NonConnecte");
            return false;
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
}
