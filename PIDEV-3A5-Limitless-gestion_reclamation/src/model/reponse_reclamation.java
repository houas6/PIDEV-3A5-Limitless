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
public class reponse_reclamation {
    private int id;
    private String contenu ;
    private int id_reclamation ;

    public reponse_reclamation(String contenu, int id_reclamation) {
        this.contenu = contenu;
        this.id_reclamation = id_reclamation;
    }

    public reponse_reclamation(int id, String contenu, int id_reclamation) {
        this.id = id;
        this.contenu = contenu;
        this.id_reclamation = id_reclamation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
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
        final reponse_reclamation other = (reponse_reclamation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_reclamation != other.id_reclamation) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reponse_reclamation{" + "id=" + id + ", contenu=" + contenu + ", id_reclamation=" + id_reclamation + '}';
    }

   
    
}
