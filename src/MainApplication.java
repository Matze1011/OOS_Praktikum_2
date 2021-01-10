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

    //Deklaration Admin
    BenutzerVerwaltungAdmin admin;

    //Variable um die Auswahl zu speichern
    int dbinitquery;

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
    FXMLLoader anwendungsloader = new FXMLLoader(getClass().getResource("Benutzerverwaltung.fxml"));
    Parent anwendungsroot = anwendungsloader.load();
    AnwendungsController anwendungscontroller = anwendungsloader.getController();

    FXMLLoader loginloader2 = new FXMLLoader(getClass().getResource("a4.fxml"));
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

        //übergabe der main Stage
        this.mainstage = stage;

        //Initialisierung Admin
        admin = new BenutzerVerwaltungAdmin("C:\\Users\\localadmin\\Desktop\\oos\\daten.txt");

        //Abfrage
        System.out.print("Datenhaltung initialisieren ?(0/1): ");
        BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
        dbinitquery = Integer.parseInt(din.readLine());

        if(dbinitquery==1){ admin.dbInit();}

        //übergabe der MainApplication an den controller
        logincontroller.setMainApp(this);
        //neue scene
        Scene scene = new Scene(loginroot);
        stage.setScene(scene);
        //go
        stage.show();
    }

    //wird von logincotroller ausgeführt (bei neuAnmeldung==true + ausführen)
    public void neuAnmeldung() throws Exception {
        //übergabe MainApp
        anmeldecontroller.setMainApp(this);
        //neue Anmeldungs Scene
        Scene scene = new Scene(anmelderoot);
        mainstage.setScene(scene);
    }

    //wird vom Anmeldungscontroller ausgeführt wenn Button gedrückt wird und die pw's stimmen
    public void neuerBenutzer(Benutzer benutzer) throws Exception {
        //versuche Benutzer einzutragen
        try{
            admin.benutzerEintragen(benutzer);
            //Error anzeigen
        }catch(Exception e){
            //Anzeigen des Fehlers (bereits vorhanden)
            anmeldecontroller.setError("Error: UserID vergeben");
            //keine neue scene
            return;
        }
        //konnte nicht loginroot 2 mal verwenden. Man hätte wahrscheinlich die alte loginscene benutzen können
        //übergabe
        logincontroller2.setMainApp(this);
        //neue Scene
        Scene scene = new Scene(loginroot2);
        mainstage.setScene(scene);
    }

    //wird vom logincotroller aufgerufen, eingegebener Benutzer vorhanden (Eingabe richtig)
    public void benutzerLogin(Benutzer benutzer) throws Exception {
        if(admin.benutzerVorhanden(benutzer)){
            //anwendungsfenster id/pw richtig
            Scene scene = new Scene(anwendungsroot);
            mainstage.setScene(scene);
        }else{
            //login scene fehler Benutzer/PW falsch
            logincontroller.setError("Benutzer||Passwort falsch");
            //da man nicht weiß wo man her kommt einfach beide
            logincontroller2.setError("Benutzer||Passwort falsch");
        }
    }
}