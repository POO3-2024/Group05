package be.helha.dao;

import be.helha.domaine.Arme;

import java.util.List;

/**
 * Interface pour les opérations CRUD sur les objets Arme.
 */
public interface ArmeDao {
    List<Arme> obtenirToutesLesArmes();

    boolean ajouterArme(Arme arme);

    void supprimerArme(int id);

    void mettreAJourArme(Arme arme);

    Arme obtenirArmeParId(int id);
}
