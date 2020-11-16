import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

public class BenutzerVerwaltungAdminTest implements Serializable {

    public void setUp(){
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
}
