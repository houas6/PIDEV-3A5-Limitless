/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.*;
import java.util.List;

/**
 *
 * @author amine
 */
public interface InterfaceServicesEchanges  {
    public void ajouterechange(Echanges e);
    public void ajouterechange2 (Echanges e);
    public void modifierechange(Echanges e);
    public void supprimerechange(int id);
    public int getIdechange (int n );
    public List<Echanges> afficherechange();
    public List<Echanges> afficherechangeFront(int id);
    public List<Echanges> searchEchange(String searchTerm) ;
}
