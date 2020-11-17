import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

public class BenutzerTest {

    @Test
    public void equalsTest()throws IOException,ClassNotFoundException {
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        char[] passwortTest2 = {'5', '6', '7', '8', '9', '9',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        Benutzer testbenutzer2 = new Benutzer("NichtMatze", passwortTest2);

        assertEquals(testbenutzer1,testbenutzer1);
        assertNotEquals(testbenutzer1,testbenutzer2);
}

    @Test
    void toStringTest() throws IOException,ClassNotFoundException{
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        char[] passwortTest2 = {'5', '6', '7', '8', '9', '9',};
        String teststring = "";
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        Benutzer testbenutzer2 = new Benutzer("NichtMatze", passwortTest2);
        teststring = testbenutzer1.toString();
        assertNotNull(testbenutzer1.toString());
        assertTrue(teststring.contains("UserId: "));
        assertTrue(teststring.contains("Passwort: "));

    }

    @Test
    void BenutzerKonstruktorTest(){
        char[] passwortTest1 = {'1', '2', '3', '4', '5', '6',};
        Benutzer testbenutzer1 = new Benutzer("Matze", passwortTest1);
        Benutzer testbenutzer2 = new Benutzer();
        assertNotNull(testbenutzer1);
        assertNotNull(testbenutzer2);
        assertEquals(testbenutzer1.getPasswort(),"123456");
        assertEquals(testbenutzer1.getUserId(),"Matze");
        assertNotEquals(testbenutzer2.getUserId(),"Matze");
        assertNotEquals(testbenutzer2.getPasswort(),"123456");

    }

}