package be.helha.dao;

import java.util.List;

/**
 * Interface générique pour les opérations CRUD.
 */
public interface Dao<Arme> {
    void ajouter(Arme t);
    List<Arme> obtenirTous();
    void mettreAJour(Arme t);
    void supprimer(int id);
}

