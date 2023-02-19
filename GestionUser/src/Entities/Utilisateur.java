/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author hasse
 */
public class Utilisateur {
    private int id_user;
    private String username;
    private String nom;
    private String prenom;
    private String cin;
    private String role;
    private String adresse;
    private String password;
    private String mail;
   

    public Utilisateur() {
    }

    public Utilisateur(String mail, String password ) {
        this.mail = mail;
        this.password = password;
        
    }
    
    
    public Utilisateur(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }
    
    
    public Utilisateur(int id_user, String username, String password, String mail) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public Utilisateur(int id_user, String username, String nom, String prenom, String cin, String role, String adresse, String password, String mail) {
        this.id_user = id_user;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.role = role;
        this.adresse = adresse;
        this.password = password;
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public static Utilisateur getUserById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Utilisateur user = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esprit", "root", "");
            stmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE id_user = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return user;
    }

    public static Utilisateur getUserByEmail(String email) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Utilisateur user = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esprit", "root", "");
            stmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE mail = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            return user;
        }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.id_user;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_user=" + id_user + ", username=" + username + ", password=" + password + ", mail=" + mail + '}';
    }
    
    
}
