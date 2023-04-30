/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.entites;
import java.time.LocalDate;
/**
 *
 * @author amine
 */
public class Livraison {
    private int id_livraison;
    private int id_Livreur;
    private int id_commande;
    private LocalDate date_livraison;
    private String adresse_livraison;
    private int code_postal_livraison;
    private String status_livraison;

    public Livraison(int id_livraison, int id_Livreur, int id_commande, LocalDate date_livraison, String adresse_livraison, int code_postal_livraison, String status_livraison) {
        this.id_livraison = id_livraison;
        this.id_Livreur = id_Livreur;
        this.id_commande = id_commande;
        this.date_livraison = date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.code_postal_livraison = code_postal_livraison;
        this.status_livraison = status_livraison;
    }

    public Livraison(int id_Livreur, int id_commande, LocalDate date_livraison, String adresse_livraison, int code_postal_livraison, String status_livraison) {
        this.id_Livreur = id_Livreur;
        this.id_commande = id_commande;
        this.date_livraison = date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.code_postal_livraison = code_postal_livraison;
        this.status_livraison = status_livraison;
    }

    public Livraison() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public int getId_Livreur() {
        return id_Livreur;
    }

    public void setId_Livreur(int id_Livreur) {
        this.id_Livreur = id_Livreur;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public LocalDate getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(LocalDate date_livraison) {
        this.date_livraison = date_livraison;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public int getCode_postal_livraison() {
        return code_postal_livraison;
    }

    public void setCode_postal_livraison(int code_postal_livraison) {
        this.code_postal_livraison = code_postal_livraison;
    }

    public String getStatus_livraison() {
        return status_livraison;
    }

    public void setStatus_livraison(String status_livraison) {
        this.status_livraison = status_livraison;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", id_Livreur=" + id_Livreur + ", id_commande=" + id_commande + ", date_livraison=" + date_livraison + ", adresse_livraison=" + adresse_livraison + ", code_postal_livraison=" + code_postal_livraison + ", status_livraison=" + status_livraison + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_livraison;
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
        final Livraison other = (Livraison) obj;
        if (this.id_livraison != other.id_livraison) {
            return false;
        }
        return true;
    }
    
}
