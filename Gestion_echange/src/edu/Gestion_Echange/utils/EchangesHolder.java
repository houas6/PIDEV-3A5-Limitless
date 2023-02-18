/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.utils;

import edu.Gestion_Echange.entites.Echanges;

/**
 *
 * @author amine
 */
public class EchangesHolder {
    private Echanges Echanges;
  private static EchangesHolder instance;
public static EchangesHolder getInstance() {
        if(instance == null){
            instance = new EchangesHolder();
        }
        return instance;
    }

 public Echanges getEchanges() {
        return Echanges;
    }

  public void setEchanges(Echanges e) {
        this.Echanges = e;
    }

}
