package be.helha.domaine;
/**
 * Classe représentant une arme dans le jeu.
 */
public class Arme {
    private int id;
    private String nom;
    private int degats;
    /**
     * Constructeur avec paramètres.
     *
     * @param id     l'identifiant unique de l'arme
     * @param nom    le nom de l'arme
     * @param degats les dégâts de l'arme
     */
    public Arme(int id, String nom, int degats) {
        this.id = id;
        this.nom = nom;
        this.degats = degats;
    }

    /**
     * Constructeur sans identifiant (pour insertion).
     *
     * @param nom    le nom de l'arme
     * @param degats les dégâts de l'arme
     */
    public Arme(String nom, int degats) {
        this.nom = nom;
        this.degats = degats;
    }

    // Getters et setters

    /**
     * Obtient l'identifiant de l'arme.
     * @return l'identifiant de l'arme
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'arme.
     * @param id l'identifiant de l'arme
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le nom de l'arme.
     * @return le nom de l'arme
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'arme.
     * @param nom le nom de l'arme
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient les dégâts de l'arme.
     * @return les dégâts de l'arme
     */
    public int getDegats() {
        return degats;
    }

    /**
     * Définit les dégâts de l'arme.
     * @param degats les dégâts de l'arme
     */
    public void setDegats(int degats) {
        this.degats = degats;
    }
}
