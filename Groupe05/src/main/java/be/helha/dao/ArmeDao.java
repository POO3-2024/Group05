package be.helha.dao;

import be.helha.domaine.Arme;
import java.util.List;

public interface ArmeDao {
    void ajouterArme(Arme arme);
    void mettreAJourArme(Arme arme);
    List<Arme> ObtenirToutesLesArmes();
    void supprimerArme(int id);
}
