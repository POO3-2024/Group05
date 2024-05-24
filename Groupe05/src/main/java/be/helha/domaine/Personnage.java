package be.helha.domaine;

/**
 * Classe représentant un Personnage.
 */
public class Personnage {
    private int id;
    private String name;
    private int pv;
    private int mana;

    /**
     * Constructeur de la classe Personnage.
     *
     * @param id    l'identifiant unique du personnage
     * @param name  le nom du personnage
     * @param pv    les points de vie du personnage
     * @param mana  les points de mana du personnage
     */
    public Personnage(int id, String name, int pv, int mana) {
        this.id = id;
        this.name = name;
        this.pv = pv;
        this.mana = mana;
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
