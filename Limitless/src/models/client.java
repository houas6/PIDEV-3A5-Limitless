/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author rassa
 */
public class client {
    
    private int id_client;
    private String nom_client;
    private String prenom_client;
    private String address_client;

    public client(int id_client, String nom_client, String prenom_client, String address_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.address_client = address_client;
    }

    public client() {
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public String getAddress_client() {
        return address_client;
    }

    public void setAddress_client(String address_client) {
        this.address_client = address_client;
    }

    @Override
    public String toString() {
        return "client{" + "id_client=" + id_client + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", address_client=" + address_client + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_client;
        hash = 47 * hash + Objects.hashCode(this.nom_client);
        hash = 47 * hash + Objects.hashCode(this.prenom_client);
        hash = 47 * hash + Objects.hashCode(this.address_client);
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
        final client other = (client) obj;
        if (this.id_client != other.id_client) {
            return false;
        }
        if (!Objects.equals(this.nom_client, other.nom_client)) {
            return false;
        }
        if (!Objects.equals(this.prenom_client, other.prenom_client)) {
            return false;
        }
        if (!Objects.equals(this.address_client, other.address_client)) {
            return false;
        }
        return true;
    }
    
}
