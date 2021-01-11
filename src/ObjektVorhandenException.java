/**
 * @author Thavarupan Mahendralingham
 * @version 1.3
 * @see Exception
 * Diese Unterklasse der Klasse Exception, bietet eine selbstdefnierte Klasse ObjektVorhandenException an die an einer anderen Stelle
 * verwerndet wird
 */
public class ObjektVorhandenException extends Exception {
    /**
     * Der Default Konstruktor der Klasse ObjektVorhandenException, erstellt eine Exeption dem ein String übergeben werden kann
     * welcher ausgegeben wird sobald die Exeption ausgelöst wird
     */
    ObjektVorhandenException(String Fehlermeldung) {
        super(Fehlermeldung);
    }
}
