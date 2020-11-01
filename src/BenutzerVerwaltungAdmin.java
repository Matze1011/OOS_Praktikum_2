/**
 * @author Marcel Buschmann
 * version 1.0
 */

/**
 * Klasse BenutzerVerwaltungAdmin, mit der Admins erzeugt werden können, welche dann {@link Benutzer} verwalten können
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {
    /**
     * Array in dem mehrere Benutzer gespeichert werden können.
     */
    Benutzer datenhaltung[] = new Benutzer[10];
    String AdminUsername;
    String passwort;

    /**
     * Trägt einen Benutzer in die Datenhaltung eines Admins ein.
     * @see #datenhaltung
     * @see Benutzer
     * @param benutzer Der einzutragende Benutzer
     */
    @Override
    public void benutzerEintragen(Benutzer benutzer) {
        for (int i = 0; i < 10; i++) {
            if (datenhaltung[i] == null) {
                datenhaltung[i] = benutzer;
                break;
            }

        }
    }

    /**
     * Prüft, ob ein {@link Benutzer} bereits vorhanden ist in der Datenhaltung des Admins
     * @param benutzer Der auf Vorhandenheit zu prüfende Benutzer.
     * @return Gibt zurück, ob der Benutzer bereits vorhanden ist oder nicht.
     */
    @Override
    public boolean benutzerVorhanden(Benutzer benutzer) {
        boolean vorhanden = true;
        for (int i = 0; i < 10; i++) {
            if(datenhaltung[i]==null){
                return false;
            }
            else if (datenhaltung[i].equals(benutzer)) {
                vorhanden = true;
                break;
            } else {
                vorhanden = false;

            }

        } return vorhanden;
    }

    /**
     * Default Konstruktor
     */
    //Konstruktor
    BenutzerVerwaltungAdmin() {};

    /**
     * toString Methode mittels der alle {@link Benutzer} einer Datenhaltung als String ausgegeben werden können.
     * @param array Das auzugebende Array welches die Benutzer enthält.
     * @return Gibt alle Benutzer aus.
     */
    //toString
    String toString(Benutzer array[]) {
        String datenhaltungErgebnis = "";
        for (int i = 0; i < datenhaltung.length; i++) {
            if (datenhaltung[i] != null) {
              datenhaltungErgebnis += datenhaltung[i].toString();
            }
        }
        return datenhaltungErgebnis;
    }
}