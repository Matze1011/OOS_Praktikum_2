import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainApplication extends Application  {

    //neuen Admin erstellen
    BenutzerVerwaltungAdmin admin;
    Stage MainStage = new Stage();


    //---------------------- Wird zu erst angezeigt ----------------------------
    @Override
    public void start(Stage firstStage) throws Exception{
        try {
            admin = new BenutzerVerwaltungAdmin("DatenhaltungNeu.txt");
            System.out.println("Soll die Datenhaltung initialisiert werden? Nein[0]  Ja[1]");

            BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
            int dbInitialisieren = Integer.parseInt(din.readLine());

            if (dbInitialisieren == 1)
            {
                admin.dbInit(); //Vorherige Daten werden gelöscht
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginFXML.fxml"));
            Parent login = loader.load();
            LoginController LoginSceneController = (LoginController) loader.getController();
            LoginSceneController.setSteuerung(this);
            firstStage.setTitle("Login");
            firstStage.setScene(new Scene(login));
            firstStage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //---------------------------- Geforderte Methoden --------------------------------
    //Die Szene wird durch eine Anmeldungszene ersetzt und deren Controller wird die eigene Referenz übergeben
    public void neuAnmeldung() throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anmeldungFXML.fxml"));
            Parent anmeldung = loader.load();
            AnmeldungsController AnmeldungSceneController = (AnmeldungsController) loader.getController();
            AnmeldungSceneController.setSteuerung(this);
            MainStage.setTitle("Anmeldung");
            MainStage.setScene(new Scene(anmeldung));
            MainStage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    //Neuen Benutzer hinzufügen mit Hilfe von benutzerEintragen()
    public void neuerBenutzer(Benutzer benutzer) throws IOException, ClassNotFoundException, BenutzerVerwaltungAdmin.DuplicateObjectException {

        try {
            admin.benutzerEintragen(benutzer);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginFXML.fxml"));
            Parent login_neuerBenutzer = loader.load();
            LoginController LoginSceneController = (LoginController) loader.getController();
            LoginSceneController.setSteuerung(this);
            LoginSceneController.setNachricht("Erfolgreich! Einloggen ist nun möglich!");
            MainStage.setTitle("Login Neuer Benutzer");
            MainStage.setScene(new Scene(login_neuerBenutzer));
            MainStage.show();


        }
        catch (Exception e)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anmeldungFXML.fxml"));
            Parent anmeldung = loader.load();
            AnmeldungsController AnmeldungSceneController = (AnmeldungsController) loader.getController();
            AnmeldungSceneController.setSteuerung(this);
            AnmeldungSceneController.setNachricht("Benutzer kann nicht eingetragen werden");
            MainStage.setTitle("Neuer Benutzer fehlgeschlagen");
            MainStage.setScene(new Scene(anmeldung));
            MainStage.show();
        }

    }




    void benutzerLogin(Benutzer benutzer) throws IOException, ClassNotFoundException {

        //Es wird durch Aufruf der Methode benutzerVorhanden(benutzer)
        //überprüft, ob der Benutzer bereits in BenutzerVerwaltungAdmin
        //eingetragen ist.
        if (admin.benutzerVorhanden(benutzer)) {

            Parent root = FXMLLoader.load(getClass().getResource("anwendung.fxml"));
            MainStage.setTitle("BenutzerLogin");
            MainStage.setScene(new Scene(root));
            MainStage.show();
            //Ist dies der Fall, soll dem Anwender angezeigt werden, dass er nun
            //das System benutzen kann, indem eine AnwendungsScene erzeugt wird.
        }

        else{ //Wenn Benutzer nicht vorhanden ist
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginFXML.fxml"));
            Parent login = loader.load();
            LoginController LoginSceneController = (LoginController) loader.getController();
            LoginSceneController.setNachricht("Benutzer nicht vorhanden oder Login Daten falsch");
            LoginSceneController.setSteuerung(this);
            MainStage.setTitle("Login");
            MainStage.setScene(new Scene(login));
            MainStage.show();

        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}