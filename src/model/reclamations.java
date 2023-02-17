/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author achra
 */
public class reclamations {
     private int id;
    private String nomClient,description,etat;

    public reclamations(int id, String nomClient, String description, String etat) {
        this.id = id;
        this.nomClient = nomClient;
        this.description = description;
        this.etat = etat;
    }

    public reclamations(String nomClient, String description, String etat) {
        this.nomClient = nomClient;
        this.description = description;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final reclamations other = (reclamations) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomClient, other.nomClient)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reclamations{" + "id=" + id + ", nomClient=" + nomClient + ", description=" + description + ", etat=" + etat + '}';
    }
    
    
    
    
}
