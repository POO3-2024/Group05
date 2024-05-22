package be.helha.Personnage;

import java.util.Objects;

public class Personnage {
    private int id;
    private String name;
    private int pv;
    private int manna;

    public Personnage(String name, int pv, int manna) {
        this.name = name;
        this.pv = pv;
        this.manna = manna;
    }

    public Personnage(Personnage personnage){
        this.id = personnage.id;
        this.name = personnage.name;
        this.pv = personnage.pv;
        this.manna = personnage.manna;
    }

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

    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pv=" + pv +
                ", manna=" + manna +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnage that = (Personnage) o;
        return id == that.id && pv == that.pv && manna == that.manna && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pv, manna);
    }
}

