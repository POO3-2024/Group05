package tests;

import be.helha.Personnage.Personnage;
import be.helha.dao.PersonnageDao;
import be.helha.daoimpl.DaoFactory;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPersonnageDao {

    private static PersonnageDao personnageDao = (PersonnageDao) DaoFactory.getInstance().getDaoImpl(PersonnageDao.class);
    private static Personnage personnage1;
    private static Personnage personnage2;
    private static Personnage personnage3;
    private static Personnage personnage4;
    private static Personnage personnageTest;


    private static List<Personnage> personnagesAjoutees = new ArrayList<>();

    @BeforeAll
    public static void setUp() {

        DaoFactory.getInstance().setTestConfiguration(); //pour utiliser la BDD de test

        personnage1 = new Personnage("Archer", 100, 70);
        personnage2 = new Personnage("Guerrier", 500, 80);
        personnage3 = new Personnage("BIBII", 490, 50);
        personnage4 = new Personnage("Bfgh", 490, 50);
        personnageTest = new Personnage("Testeur", 500, 40);


    }

    @Test
    @Order(1)
    public void testAjouter() {
        //ajouter un Personnage
        assertTrue(personnageDao.ajouterPersonnage(personnage3));
    }


    @Test
    @Order(2)
    public void testLister() {
        personnageDao.ajouterPersonnage(personnage1);
        personnagesAjoutees.add(personnage1);

        personnageDao.ajouterPersonnage(personnage2);
        personnagesAjoutees.add(personnage2);
        personnagesAjoutees.add(personnage3);//Perso3 deja ajouter dans le Test ci-dessus

        //Récupérer la liste des personnages
        List<Personnage> personnagesRecuperees = personnageDao.listerPersonnages();

        assertEquals(3, personnagesRecuperees.size());
        assertTrue(personnagesRecuperees.contains(personnage1));
        assertTrue(personnagesRecuperees.contains(personnage2));
        assertTrue(personnagesRecuperees.contains(personnage3));
    }

    @Test
    @Order(3)
    public void testSimpleGetPersonnage() {
        // Insérer un personnage

        personnageDao.ajouterPersonnage(personnageTest);

        // Essayer de le récupérer
        Personnage recupered = personnageDao.getPersonnage(personnageTest.getId());
        assertNotNull(recupered);

    }

    @Test
    @Order(4)
    public void testModifier() {
        personnageDao.ajouterPersonnage(personnage4);
        // Supposons que personnage2 est celui à modifier
        personnage4.setName("BOUBOU");
        assertTrue(personnageDao.modifierPersonnage(personnage4));  // Assurez-vous de modifier personnage2

        // Vérifier si le personnage a été modifiée avec succès
        Personnage personnageRecuperee = personnageDao.getPersonnage(personnage4.getId());
        assertEquals("BOUBOU", personnageRecuperee.getName());
    }

    @Test
    @Order(5)
    public void testSupp(){
        assertTrue(personnageDao.supprimerPersonnage(personnage1.getId()));
        assertTrue(personnageDao.supprimerPersonnage(personnage2.getId()));
        assertTrue(personnageDao.supprimerPersonnage(personnage3.getId()));
        assertTrue(personnageDao.supprimerPersonnage(personnage4.getId()));
        assertTrue(personnageDao.supprimerPersonnage(personnageTest.getId()));
    }


}