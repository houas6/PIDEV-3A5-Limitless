/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.services;

import edu.Gestion_Echange.entites.Echanges;
import java.util.List;

/**
 *
 * @author amine
 */
public interface InterfaceServices  {
    public void ajouterechange(Echanges e);
    public void ajouterechange2 (Echanges e);
    public void modifierechange(Echanges e);
    public void supprimerechange(int id);
    public int getIdechange (int n );
    public List<Echanges> afficherechange();
}
