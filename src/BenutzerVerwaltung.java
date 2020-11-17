/**
 * @author Marcel Buschmann
 */

import java.io.IOException;

/**
 * Interface zur Erzeugung einer Benutzer Verwaltung.
 */
public interface BenutzerVerwaltung {
    void benutzerEintragen (Benutzer benutzer) throws IOException, ClassNotFoundException;
    boolean benutzerVorhanden(Benutzer benutzer) throws IOException, ClassNotFoundException;

}
