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
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
    }

    @AfterEach // Damit die Testdateien immer wieder gelöscht werden nach jedem Testdurchlauf
    public void dateiLoeschen(){
        File f = new File("UnitTestDbInit.txt");
        f.delete(); //ansonsten: C:\Users\matze\IdeaProjects\OOS Praktikum 2\UnitTestDbInit.txt
    }

    @Test
    public void BenutzerEintragenTest() throws IOException,ClassNotFoundException {
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTest.txt");

        Exception testException = assertThrows(FileNotFoundException.class,
                ()-> {
                    assertFalse(admin1.benutzerVorhanden(testbenutzer1));
                    admin1.benutzerEintragen(testbenutzer1);
                    assertTrue(admin1.benutzerVorhanden(testbenutzer1));
                });
        System.out.println("BenutzerEintragen Methode: " + testException.getMessage());

    }

    @Test
    public void Benutzerlöschen() throws  IOException,ClassNotFoundException{
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTest.txt");
        Exception testException = assertThrows(FileNotFoundException.class,
                ()-> {
                    admin1.benutzerEintragen(testbenutzer1);
                    admin1.benutzerLoeschen(testbenutzer1);;
                });
        System.out.println("BenutzerLoeschen Methode: " + testException.getMessage());

    }

    @Test
    public void BenutzerVorhandenTest() throws ClassNotFoundException,IOException{
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTest.txt");

        Exception testException = assertThrows(FileNotFoundException.class,
                ()-> {
                    assertFalse(admin1.benutzerVorhanden(testbenutzer1));
                    admin1.benutzerEintragen(testbenutzer1);
                    assertTrue(admin1.benutzerVorhanden(testbenutzer1));
                });
        System.out.println("BenutzerVorhanden Methode: " + testException.getMessage());
    }

    public void setUp() throws IOException {
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        admin1.dbInit();
    }
    @Test
    public void BenutzerEintragenTestDbInit() throws IOException,ClassNotFoundException {
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        setUp(); //DbInit

        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
        admin1.benutzerEintragen(testbenutzer1);
        assertTrue(admin1.benutzerVorhanden(testbenutzer1));
    }

    @Test
    public void BenutzerlöschenDbInit() throws  IOException,ClassNotFoundException{
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        setUp(); //DbInit
        admin1.benutzerEintragen(testbenutzer1);
        admin1.benutzerLoeschen(testbenutzer1);
        assertFalse(admin1.benutzerVorhanden(testbenutzer1));
    }

    @Test
    public void BenutzerVorhandenTestDbInit() throws ClassNotFoundException,IOException{
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        setUp();
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
    public void ohnedbInitExceptionTest() throws FileNotFoundException {

        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        char[] passwortTest2 = {'1', '2', '0', '0', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        File f = new File("C:\\Users\\matze\\IdeaProjects\\OOS Praktikum 2\\UnitTestDbInit.txt");
        f.delete();

        Exception testException = assertThrows(FileNotFoundException.class,
                ()-> {
                    Benutzer testbenutzer = new Benutzer("Test", passwortTest2);
                    admin1.benutzerEintragen(testbenutzer);
                });
        System.out.println(testException.getMessage());

    }
}
