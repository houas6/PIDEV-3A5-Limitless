/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd.services;

import Entities.Personne;
import java.util.List;

/**
 *
 * @author hasse
 */
public interface EService {
    public void ajouterpersonne(Personne p);
    public void ajouterpersonne2(Personne p);
    public void modifierpersonne(Personne p);
    public void supprimerrpersonne(int id);
    public List<Personne> afficherpersonne();
}
