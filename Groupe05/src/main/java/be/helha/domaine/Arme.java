package be.helha.domaine;

public class Arme {
    private int id;
    private String nom;
    private int degats;

    public Arme(int id, String nom, int degats) {
        this.id = id;
        this.nom = nom;
        this.degats = degats;
    }

    // Getters and setters...
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getDegats() {
        return degats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
