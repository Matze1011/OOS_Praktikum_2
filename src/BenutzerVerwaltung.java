/**
 * @author Marcel Buschmann
 */

/**
 * Interface zur Erzeugung einer Benutzer Verwaltung.
 */
public interface BenutzerVerwaltung {
    void benutzerEintragen (Benutzer benutzer);
    boolean benutzerVorhanden(Benutzer benutzer);

}
