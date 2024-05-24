package domaine;

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
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
