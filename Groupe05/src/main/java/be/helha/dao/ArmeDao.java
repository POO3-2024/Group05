package be.helha.dao;

import be.helha.domaine.arme.Arme;
import java.util.List;

public interface ArmeDao {
    List<Arme> getAllArmes();
    Arme getArmeById(int id);
    void addArme(Arme arme);
    void updateArme(Arme arme);
    void deleteArme(int id);
}
