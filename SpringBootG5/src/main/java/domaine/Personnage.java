package domaine;

public class Personnage {
    private int id;
    private String Name;
    private int pv;
    private int mana;

    public Personnage(int id, String Name, int pv, int mana) {
        this.id = id;
        this.Name = Name;
        this.pv = pv;
        this.mana = mana;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getpv() {
        return pv;
    }

    public void setpv(int pv) {
        this.pv = pv;
    }

    public int getMana(){
        return mana;
    }
    public void setMana(int mana){
        this.mana = mana;
    }
}
