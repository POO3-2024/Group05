package be.helha.daoimpl;

import be.helha.Personnage.Personnage;
import be.helha.dao.PersonnageDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PersonnageDaoImpl implements PersonnageDao {
    private static final String GET = "SELECT * FROM personnages p WHERE p.ID = ?";
    private static final String AJOUT = "INSERT INTO personnages (ID, Nom, Point_de_vie, Manna) VALUES (?,?,?,?)";
    private static final String MAJ = "UPDATE personnaes SET Nom= ?, Point_de_vie= ?, Manna= ? WHERE ID= ?";
    private static final String LISTER = "SELECT * FROM personnages p ORDER BY p.ID";
    private static final String SUPPRIMER = "DELETE FROM personnages p WHERE p.ID = ?";

    private void cloturer(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception ex) {
        }
        try {
            if (ps != null)
                ps.close();
        } catch (Exception ex) {
        }
        try {
            if (con != null)
                con.close();
        } catch (Exception ex) {
        }
    }
    /**
     * @param personnage
     * @return
     */
    @Override
    public boolean ajouterPersonnage(Personnage personnage) {
        return false;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Personnage getPersonnage(int id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Personnage> listerPersonnages() {
        return List.of();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean supprimerPersonnage(int id) {
        return false;
    }

    /**
     * @param personnage
     * @return
     */
    @Override
    public boolean modifierPersonnage(Personnage personnage) {
        return false;
    }
}
