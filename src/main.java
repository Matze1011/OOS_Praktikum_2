import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        char[] passwort1 = {'1','2','3'};
        char[] passwort2 = {'a','b','c'};
        char[] passwort3 = {'1','2','3'};
        char[] passwort4 = {'5','5','3','5','5',};
        char[] passwort5 = {'5','5','b','5','5',};
        char[] passwort6 = {'5','5','5','c','5',};

        System.out.println("\n"+ "Benutzer 1 bis 5 werden erzeugt." );
        Benutzer benutzer1 = new Benutzer("Benutzer1",passwort1);
        Benutzer benutzer2 = new Benutzer("benutzer2",passwort2);
        Benutzer benutzer3 = new Benutzer("Benutzer3",passwort3);
        Benutzer benutzer4 = new Benutzer("Benutzer4",passwort4);
        Benutzer benutzer5 = new Benutzer("Benutzer5",passwort5);
        Benutzer benutzer6 = new Benutzer("Benutzer6",passwort6);

        System.out.println("Equals Methoden Test: ");
        System.out.println("Sind Benutzer 1 und Benutzer 1 gleich?(true): " + benutzer1.equals(benutzer1));
        System.out.println( "Sind Benutzer 1 und Benutzer 2 gleich?:(false): " + benutzer1.equals(benutzer2));
        System.out.println( "Sind Benutzer 1 und Benutzer 3 gleich?:(false): " + benutzer1.equals(benutzer3));
        System.out.println("==============================================================");
        System.out.println("Benutzer 1 UserID (getter Test):" + benutzer1.getUserId());
        System.out.println("Benutzer 1 Passwort (getter Test):" + benutzer1.getPasswort());
        System.out.println("Benutzer 1 wird ausgegeben (über toString Methode): "+ benutzer1.toString());
        System.out.println("==============================================================");

        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin("TestDbInit.txt");
        //BenutzerVerwaltungAdmin adminTest = new BenutzerVerwaltungAdmin("UnitTestDbInit.txt");
        //admin1.deserialisieren();
        //adminTest.dbInit();
        admin1.dbInit();
        System.out.println("Benutzer 1 - 5  werden in die Datenhaltung geaddet.");

        admin1.benutzerEintragen(benutzer1);
        admin1.benutzerEintragen(benutzer2);
        admin1.benutzerEintragen(benutzer3);
        admin1.benutzerEintragen(benutzer4);
        admin1.benutzerEintragen(benutzer5);
        //admin1.benutzerEintragen(benutzer6);
        //admin1.benutzerEintragen(benutzer3);

        System.out.println("Admin 1 verwaltet jetzt folgende Benutzer(5 Benutzer erwartet): " + admin1.toString(admin1.datenhaltung));
        System.out.println("==============================================================");
        System.out.println("Benutzer 1 wird gelöscht");

        admin1.benutzerLoeschen(benutzer1);


        System.out.println("Admin 1 verwaltet nun folgende Benutzer (4 Benutzer erwartet): " + admin1.toString(admin1.datenhaltung));
        System.out.println("Ist Benutzer 1 vorhanden? (erwartet wird false): " + admin1.benutzerVorhanden(benutzer1));
        System.out.println("==============================================================");

        admin1.benutzerEintragen(benutzer1);

        System.out.println("Benutzer 1 wird wieder in die Datenhaltung geaddet");
        System.out.println("Admin 1 verwaltet nun folgende Benutzer (5 Benutzer erwartet): " + admin1.toString(admin1.datenhaltung));
        System.out.println("Ist Benutzer 1 vorhanden? (erwartet wird true): " + admin1.benutzerVorhanden(benutzer1));
        System.out.println("==============================================================");
        System.out.println("Diesmal wird Benutzer 2 gelöscht.");
        admin1.benutzerLoeschen(benutzer2);
        System.out.println("Admin 1 verwaltet nun folgende Benutzer (4 Benutzer erwartet, Benutzer 2 gelöscht): " + admin1.toString(admin1.datenhaltung));
        System.out.println("==============================================================");
        System.out.println("Jetzt wird Benutzer 6 hinzugefügt. ");
        admin1.benutzerEintragen(benutzer6);
        System.out.println("Admin 1 verwaltet nun folgende Benutzer (5 Benutzer erwartet, Benutzer 6 an zweiter Stelle): " + admin1.toString(admin1.datenhaltung));

        //admin1.benutzerEintragen(benutzer2);



    }
}
