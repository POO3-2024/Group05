package be.helha.dao;

import be.helha.domaine.Arme;
import java.util.List;

public interface ArmeDao {
    boolean ajouterArme(Arme arme);
    boolean modifierArme(Arme arme);
    List<Arme> listerArme();
    boolean supprimerArme(int id);
}
