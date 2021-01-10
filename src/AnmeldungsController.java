import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.application.Application;
import java.util.stream.Collectors;
import java.util.Arrays;

public class AnmeldungsController extends Application {

    //Attribute
    MainApplication app;

    //Buttons und Textfelder
    @FXML Button submit;
    @FXML TextField useridTextfield;
    @FXML TextField passwortTextfield;
    @FXML TextField wiederholungTextfield;
    @FXML Label hiddenMeldung;
    @FXML Label error;

    public static void main(String args){
        launch(args);
    }

    @Override
    public void start(Stage stage){}

    @FXML
    public void ausführen(Event event) throws Exception {
        //Passwort String zu char Array konvertieren
        String passwort = passwortTextfield.getText();
        char[] passwortkonvertiert = new char[passwort.length()];
        for (int i = 0; i < passwort.length(); i++) {
            passwortkonvertiert[i] = passwort.charAt(i);
        }

        //Passwort Wiederholung String zu char Array konvertieren
        String passwortWiederholung = wiederholungTextfield.getText();
        char[] passwortWiederholungKonvertiert = new char[passwortWiederholung.length()];
        for (int i = 0; i < passwortWiederholung.length(); i++) {
            passwortWiederholungKonvertiert[i] = passwortWiederholung.charAt(i);
        }

        //Passwörter vergleichen und Benutzer mit eingegebenen Daten anlegen
        if(passwort.equals(passwortWiederholung)==true) {
            Benutzer neuerBenutzer = new Benutzer(""+useridTextfield.getText(), passwortkonvertiert);
            app.neuerBenutzer(neuerBenutzer);
            System.out.println("Neuer Benutzer erstellt: " + neuerBenutzer.toString());

        }
        else{
            hiddenMeldung.setVisible(true);

        }
    }
    //Getter-Setter Praktikum 5
    public void setMainApp(MainApplication app){this.app = app;}
    public MainApplication getMainApp(){return app;}
    public void setError(String string){error.setText(string);}
}
