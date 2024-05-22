package be.helha.dao;

import be.helha.Personnage.Personnage;

import java.util.List;

public interface PersonnageDao extends Dao {

    boolean ajouterPersonnage(Personnage personnage);
    Personnage getPersonnage(int id);
    List<Personnage> listerPersonnages();
    boolean supprimerPersonnage(int id);
    boolean modifierPersonnage(Personnage personnage);

}
