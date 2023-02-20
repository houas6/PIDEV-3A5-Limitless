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
    private String numero;
    private String nom;
    private String prenom;
    private String cin;
    private String role;
    private String password;
    private String mail;
   

    public Utilisateur() {
    }

    public Utilisateur(String mail, String password ) {
        this.mail = mail;
        this.password = password;   
    }
    
    
    public Utilisateur(String numero, String password, String mail) {
        this.numero = numero;
        this.password = password;
        this.mail = mail;
    }
    
    public Utilisateur(int id_user, String password, String mail) {
        this.id_user = id_user;
        this.password = password;
        this.mail = mail;
    }
    
    public Utilisateur(int id_user, String numero, String password, String mail) {
        this.id_user = id_user;
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return numero;
    }

    public void setUsername(String numero) {
        this.numero = numero;
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/limitless", "root", "");
            stmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE id_user = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3));
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/limitless", "root", "");
            stmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE mail = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3));
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
        if (!Objects.equals(this.numero, other.numero)) {
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
        return "Utilisateur{" + "id_user=" + id_user + ", numero=" + numero + ", password=" + password + ", mail=" + mail + '}';
    }
    
    
}
