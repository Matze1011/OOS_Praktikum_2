public class main {
    public static void main(String[] args){

        char[] passwort1 = {'1','2','3'};
        char[] passwort2 = {'a','b','c'};
        char[] passwort3 = {'0','0','0'};
        Benutzer benutzer1 = new Benutzer("Matze1011",passwort1);
        Benutzer benutzer2 = new Benutzer("Micha1011",passwort2);
        Benutzer benutzer3 = new Benutzer("Matze1012",passwort3);

        System.out.println( "Sind Benutzer 1 und Benutzer 1 gleich?(true):" + benutzer1.equals(benutzer1));
        System.out.println( "Sind Benutzer 1 und Benutzer 2 gleich?:(false)" + benutzer1.equals(benutzer2));
        System.out.println( "Sind Benutzer 1 und Benutzer 3 gleich?:(true)" + benutzer1.equals(benutzer3));

        System.out.println("Benutzer 1 UserID:" + benutzer1.getUserId());
        System.out.println("Benutzer 1 wird ausgegeben: "+ benutzer1.toString());

        BenutzerVerwaltungAdmin admin1 = new BenutzerVerwaltungAdmin();

        admin1.benutzerEintragen(benutzer1);
        admin1.benutzerEintragen(benutzer2);


        System.out.println("Admin 1 verwaltet folgende Benutzer: " + admin1.toString(admin1.datenhaltung));
        System.out.println("Ist Benutzer 1 vorhandn?: " + admin1.benutzerVorhanden(benutzer1));

    }
}
