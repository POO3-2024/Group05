package be.helha.dao;

import be.helha.domaine.Arme;
import java.util.List;

public interface ArmeDao {
    List<Arme> obtenirToutesLesArmes();
    void ajouterArme(Arme arme);
    void supprimerArme(int id);
    void mettreAJourArme(Arme arme);
    Arme obtenirArmeParId(int id);
}
