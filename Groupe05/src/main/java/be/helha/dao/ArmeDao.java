package be.helha.dao;

import be.helha.domaine.Arme;
import java.util.List;

/**
 * Interface pour les opérations CRUD sur les armes.
 */
public interface ArmeDao {
    /**
     * Ajoute une arme à la base de données.
     * @param arme l'arme à ajouter
     */
    void ajouterArme(Arme arme);

    /**
     * Obtient toutes les armes de la base de données.
     * @return une liste d'armes
     */
    List<Arme> obtenirToutesLesArmes();

    /**
     * Met à jour une arme dans la base de données.
     * @param arme l'arme à mettre à jour
     */
    void mettreAJourArme(Arme arme);

    /**
     * Supprime une arme de la base de données.
     * @param id l'identifiant de l'arme à supprimer
     */
    void supprimerArme(int id);
}
