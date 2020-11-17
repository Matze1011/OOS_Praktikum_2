import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

public class BenutzerVerwaltungAdminTest implements Serializable {

    public void setUp2(){
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTest.txt");
    }

    @Test
    public void BenutzerEintragenTest() throws IOException {
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTest.txt");

        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
        admin1.benutzerEintragen(testbenutzer1);
        assertTrue(admin1.benutzerVorhanden(testbenutzer1));
    }

    @Test
    public void Benutzerlöschen() throws  IOException{
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTest.txt");
        admin1.benutzerEintragen(testbenutzer1);
        admin1.benutzerLoeschen(testbenutzer1);
        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
    }

    @Test
    public void BenutzerVorhandenTest(){
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTest.txt");
        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
        admin1.benutzerEintragen(testbenutzer1);
        assertTrue(admin1.benutzerVorhanden(testbenutzer1));
    }

    public void setUp() throws IOException {
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestAufgabe3.txt");
        admin1.dbInit();
    }
    @Test
    public void BenutzerEintragenTestDbInit() throws IOException {
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        setUp(); //dbInit

        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
        admin1.benutzerEintragen(testbenutzer1);
        assertTrue(admin1.benutzerVorhanden(testbenutzer1));
    }

    @Test
    public void BenutzerlöschenDbInit() throws  IOException{
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        setUp(); //DbInit
        admin1.benutzerEintragen(testbenutzer1);
        admin1.benutzerLoeschen(testbenutzer1);
        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
    }

    @Test
    public void BenutzerVorhandenTestDbInit(){
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
        admin1.benutzerEintragen(testbenutzer1);
        assertTrue(admin1.benutzerVorhanden(testbenutzer1));
    }

    @Test //Hier muss natürlich eine duplicate Exception ausgelöst werden
    public void BenutzerBereitsVorhandenExceptionTest() throws IOException {
        setUp();
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        Exception testException = assertThrows(BenutzerVerwaltungAdmin.DuplicateObjectException.class,
                () -> {
                    admin1.benutzerEintragen(testbenutzer1);
                    admin1.benutzerEintragen(testbenutzer1);
                });
        System.out.println(testException.getMessage());
    }

    @Test
    public void ohnedbInitExceptionTest() throws FileNotFoundException{
        File f = new File("/Users/marcelbuschmann/IdeaProjects/OOS_Praktikum_2/UnitTestDbInit.txt");
        f.delete();
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        char[] passwortTest2 = {'1', '2', '0', '0', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");

        Exception testException = assertThrows(FileNotFoundException.class,
                ()-> {
                    Benutzer testbenutzer = new Benutzer("Test", passwortTest2);
                    admin1.benutzerEintragen(testbenutzer);
                });
        System.out.println(testException.getMessage());
    }
}
