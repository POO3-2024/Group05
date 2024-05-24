package be.helha.daoimpl;

import be.helha.Personnage.Personnage;
import be.helha.dao.PersonnageDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonnageDaoImpl implements PersonnageDao {
    private static final String GET = "SELECT * FROM personnages WHERE id = ?";
    private static final String AJOUT = "INSERT INTO personnages (name, pv, manna) VALUES (?,?,?)";
    private static final String MAJ = "UPDATE personnages SET name = ?, pv = ?, manna = ? WHERE id = ?";
    private static final String LISTER = "SELECT * FROM personnages ORDER BY personnages.id";
    private static final String SUPPRIMER = "DELETE FROM personnages WHERE id = ?";

    private DaoFactory daoFactory;

    public PersonnageDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }

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

    @Override
    public boolean ajouterPersonnage(Personnage personnage) {
        boolean ajoutReussi = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = this.daoFactory.getConnexion();
            ps = con.prepareStatement(AJOUT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, personnage.getName());
            ps.setInt(2, personnage.getPv());
            ps.setInt(3, personnage.getManna());
            int resultat = ps.executeUpdate();
            if (resultat == 1) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    personnage.setId(rs.getInt(1));
                    ajoutReussi = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cloturer(rs, ps, con);
        }
        return ajoutReussi;
    }

    @Override
    public Personnage getPersonnage(int id) {
        Personnage personnage = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = this.daoFactory.getConnexion();
            ps = con.prepareStatement(GET);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                personnage = new Personnage(rs.getString("Name"), rs.getInt("pv"), rs.getInt("manna"));
                personnage.setId(rs.getInt("id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cloturer(rs, ps, con);
        }
        return personnage;
    }

    @Override
    public List<Personnage> listerPersonnages() {
        List<Personnage> liste = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = this.daoFactory.getConnexion();
            ps = con.prepareStatement(LISTER);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("name");
                int pv = rs.getInt("pv");
                int manna = rs.getInt("manna");
                Personnage personnage = new Personnage(nom, pv, manna);
                personnage.setId(id);
                liste.add(personnage);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cloturer(rs, ps, con);
        }
        return liste;
    }

    @Override
    public boolean supprimerPersonnage(int id) {
        boolean suppressionReussie = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = this.daoFactory.getConnexion();
            ps = con.prepareStatement(SUPPRIMER);
            ps.setInt(1, id);
            int nb = ps.executeUpdate();
            if (nb == 1)
                suppressionReussie = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cloturer(null, ps, con);
        }
        return suppressionReussie;
    }

    @Override
    public boolean modifierPersonnage(Personnage personnage) {
        boolean modificationReussie = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = this.daoFactory.getConnexion();
            ps = con.prepareStatement(MAJ);
            ps.setString(1, personnage.getName().trim());
            ps.setInt(2, personnage.getPv());
            ps.setInt(3, personnage.getManna());
            ps.setInt(4, personnage.getId());
            int resultat = ps.executeUpdate();
            if (resultat == 1) {
                modificationReussie = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cloturer(null, ps, con);
        }
        return modificationReussie;
    }
}
