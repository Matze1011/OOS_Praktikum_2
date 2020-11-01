/**
 * @author Matze
 */

import java.util.Arrays;

/**
 * Enthält enthält userID's und die Passwörter aller Benutzer des Systems. Außerdem Methoden um mit den Benutzer Instanzen arbeiten zu können.
 */
public class Benutzer {
    /**
     * User ID eines Benutzers
     */
    private String userId;
    /**
     * Passwort des Benutzers
     */
    private char[] passwort = new char[50];

    /**
     * Getter
     * @return Gibt die UserId eines Benutzers zurück.
     */
    public String getUserId(){
        return userId;
    }

    /**
     * Getter
     * @return Gibt das Passwort eines Benutzers zurück.
     */
    public String getPasswort(){
        String stringPasswort = "";
        stringPasswort= stringPasswort.copyValueOf(this.passwort);
        return stringPasswort;
    }

    public void setUserId(String username){
        this.userId=username;
    }


    /**
     * Default Konstruktor
     */
    Benutzer(){};

    /**
     * Konstruktor, der die beiden Attribute userID und passwort mit den übergebenen Parametern initialisiert.
     * @param userid User ID des anzulgenden Benutzers.
     * @param password Passwort des anzulegendes Benutzers.
     */
    Benutzer(String userid, char[] password){
        this.userId = userid;
        this.passwort = password;

    }

    /** Equals Methode zum Vergleich zweier Benutzer ID's
     *
     * @param o das zu vergleichende Objekt
     * @return Gibt zurück, ob die Objekte übereinstimmen oder nicht.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Benutzer)) return false;

        Benutzer benutzer = (Benutzer) o;

        return this.userId.equals(benutzer.userId);
        }

    /**
     * Methode um einen Benutzer als String ausgeben zu lassen
     * @return Gibt Benutzer als String zurück
     */
    public String toString(){
        return ("\n" + "UserId: " + this.getUserId() +" | " + "Passwort: " + this.getPasswort());
    }

}