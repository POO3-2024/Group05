package be.helha.daoimpl;

import be.helha.dao.ArmeDao;
import be.helha.domaine.Arme;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmeDaoImplTest {

    private ArmeDao armeDao;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\poo3.db");
        armeDao = new ArmeDaoImpl(connection);

        // Nettoyage de la bd avant chaque test
        connection.prepareStatement("DELETE FROM armes").executeUpdate();
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    void testAjouterArme() {
        Arme arme = new Arme(0, "Epée", 50);
        boolean ajoutReussi = armeDao.ajouterArme(arme);
        assertTrue(ajoutReussi);

        List<Arme> armes = armeDao.obtenirToutesLesArmes();
        assertEquals(1, armes.size());
        assertEquals("Epée", armes.get(0).getNom());
        assertEquals(50, armes.get(0).getDegats());
    }

    @Test
    void testObtenirToutesLesArmes() {
        Arme arme1 = new Arme(0, "Epée", 50);
        Arme arme2 = new Arme(0, "Hache", 75);
        armeDao.ajouterArme(arme1);
        armeDao.ajouterArme(arme2);

        List<Arme> armes = armeDao.obtenirToutesLesArmes();
        assertEquals(2, armes.size());
    }

    @Test
    void testMettreAJourArme() {
        Arme arme = new Arme(0, "Epée", 50);
        armeDao.ajouterArme(arme);

        Arme armeAjoutee = armeDao.obtenirToutesLesArmes().get(0);
        armeAjoutee.setNom("Epée Légendaire");
        armeAjoutee.setDegats(100);
        armeDao.mettreAJourArme(armeAjoutee);

        Arme armeModifiee = armeDao.obtenirArmeParId(armeAjoutee.getId());
        assertEquals("Epée Légendaire", armeModifiee.getNom());
        assertEquals(100, armeModifiee.getDegats());
    }

    @Test
    void testSupprimerArme() {
        Arme arme = new Arme(0, "Epée", 50);
        armeDao.ajouterArme(arme);

        Arme armeAjoutee = armeDao.obtenirToutesLesArmes().get(0);
        armeDao.supprimerArme(armeAjoutee.getId());

        List<Arme> armes = armeDao.obtenirToutesLesArmes();
        assertEquals(0, armes.size());
    }
}
