package be.helha.dao;

import be.helha.domaine.Arme;
import java.util.List;

public interface ArmeDao {
    void ajouterArme(Arme arme);
    Arme obtenirArmeParId(int id);
    List<Arme> obtenirToutesLesArmes();
    void mettreAJourArme(Arme arme);
    void supprimerArme(int id);
}
