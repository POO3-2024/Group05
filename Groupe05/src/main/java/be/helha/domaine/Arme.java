package be.helha.domaine;

/**
 * Classe représentant une Arme.
 */
public class Arme {
    private int id;
    private String nom;
    private int degats;

    /**
     * Constructeur de la classe Arme.
     *
     * @param id     l'identifiant unique de l'arme
     * @param nom    le nom de l'arme
     * @param degats les dégâts infligés par l'arme
     */
    public Arme(int id, String nom, int degats) {
        this.id = id;
        this.nom = nom;
        this.degats = degats;
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDegats() {
        if (degats > 100) {
            throw new IllegalStateException("Les dégâts ne peuvent pas dépasser 100.");
        }
        return degats;
    }


    public void setDegats(int degats) {
        if (degats > 100) {
            throw new IllegalArgumentException("Les dégâts ne peuvent pas dépasser 100.");
        }
        this.degats = degats;
    }

}