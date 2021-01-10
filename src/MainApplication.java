import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
Aufgabe:
 Die Klasse Main Application steuert das Zusammenspiel der anderen Klassen und soll von "Application" erben!
 Lediglich die launch-Methode soll aufgerufen werden.
*/
public class MainApplication extends Application { //extends Application
    //global stage
    Stage mainstage;

    //Admin "admin2" erstellen
    BenutzerVerwaltungAdmin admin2;

    //Variable um die Auswahl zu speichern, ob die DB inittialisiert werden soll
    int dbInitialisieren;

    //----------------------Login Scene -----------------
    //erstellen des FXMLLoader und setzen der Ressourcen
    FXMLLoader loginloader = new FXMLLoader(getClass().getResource("loginFXML.fxml"));

    //load() und get root für die Szene
    Parent loginroot = loginloader.load();

    //Controller vom Loader bekommen
    LoginController logincontroller = loginloader.getController();


    //--------------------- Anmelde Scene -----------------------
    //gleiches Vorgehen wie für Login Scene
    //das gleiche für Anmelden und Anwendung und der 2ten Login Scene
    FXMLLoader anmeldeloader = new FXMLLoader(getClass().getResource("anmeldungFXML.fxml"));
    Parent anmelderoot = anmeldeloader.load();
    AnmeldungsController anmeldecontroller = anmeldeloader.getController();

    //-------------------- Anwendungs Scene -----------------------
    FXMLLoader anwendungsloader = new FXMLLoader(getClass().getResource("anwendung.fxml"));
    Parent anwendungsroot = anwendungsloader.load();
    AnwendungsController anwendungscontroller = anwendungsloader.getController();

    //-------------------- Benutzerverwaltung (Anmelde Scene 2) -----------------------
    FXMLLoader loginloader2 = new FXMLLoader(getClass().getResource("loginFXML.fxml"));
    Parent loginroot2 = loginloader2.load();
    LoginController logincontroller2 = loginloader2.getController();

    //throws IOException
    public MainApplication() throws IOException {}

    //standard main
    public static void main(String args) { launch(args); }

    //start der MainApp, dbInit Abfrage, neuer Admin, Login Scene
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Benutzerverwaltung");

        //Übergabe der main Stage
        this.mainstage = stage;

        //Initialisierung eines Admins
        admin2 = new BenutzerVerwaltungAdmin("Praktikum5_Daten2.txt");

        //Abfrage
        System.out.print("Möchten Sie die Datenhaltung initialisieren? (0=nein / 1=ja): ");
        //Zum einlesen einer Zahl in der Standardeingabe
        BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
        dbInitialisieren = Integer.parseInt(din.readLine());

        //Bei 1 wird die DB initialisiert
        if(dbInitialisieren ==1)
        {
            admin2.dbInit();
        }

        //übergabe der MainApplication an den Controller
        logincontroller.setMainApp(this);


        //Neue scene erstellen
        Scene scene = new Scene(loginroot);
        stage.setScene(scene);
        //stage ausgeben
        stage.show();
    }

    //--------- void neuAnmeldung -------------
    //wird von logincotroller ausgeführt wenn neuAnmeldung==true
    public void neuAnmeldung() throws Exception {
        //übergabe an MainApp
        anmeldecontroller.setMainApp(this); // Übergabe der eigenen Referenz
        //neue Anmeldungs Scene
        Scene scene = new Scene(anmelderoot);
        mainstage.setScene(scene);
    }

    //wird vom Anmeldungscontroller ausgeführt wenn submit Button gedrückt wird und die passwörter stimmen
    public void neuerBenutzer(Benutzer benutzer) throws Exception {
        //versuche neuen Benutzer einzutragen
        try{
            admin2.benutzerEintragen(benutzer);
            //Error anzeigen
        }catch(Exception e){
            //Anzeigen des Fehlers (bereits vorhanden)
            anmeldecontroller.setError("Error: User bereits vorhanden");
            //keine neue scene
            return;
        }
        //konnte nicht loginroot 2 mal verwenden. Man hätte wahrscheinlich die alte loginscene benutzen können
        //übergabe
        logincontroller2.setMainApp(this); //Übergabe der eigenen Referenz an den Controller
        //neue Scene
        Scene scene = new Scene(loginroot2);
        mainstage.setScene(scene);
    }

    //wird vom logincotroller aufgerufen, eingegebener Benutzer vorhanden (Eingabe richtig)
    public void benutzerLogin(Benutzer benutzer) throws Exception {
        if(admin2.benutzerVorhanden(benutzer)){
            //Passwort Überprüfung nicht gefordert?
            Scene scene = new Scene(anwendungsroot);
            mainstage.setScene(scene);
        }else{
            //login scene fehler Benutzer/PW falsch
            logincontroller.setError("Benutzer oder Passwort falsch");
            //da man nicht weiß wo man her kommt einfach beide
            logincontroller2.setError("Benutzer oder Passwort falsch");
        }
    }
}
