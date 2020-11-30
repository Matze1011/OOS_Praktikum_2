import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class AnmeldungsController {

    //Buttons
    @FXML Button submit;
    @FXML TextField useridTextfield;
    @FXML TextField passwortTextfield;
    @FXML TextField wiederholungTextfield;

    @FXML
    public void passwortVergleich(Event event) {
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
            Benutzer neuerBenutzer = new Benutzer(useridTextfield.getText(), passwortkonvertiert);
            System.out.println("Neuer Benutzer erstellt: " + neuerBenutzer.toString());
            //Fenster schließen
            Stage stage = (Stage) submit.getScene().getWindow();
            stage.close();
        }
        else{
            useridTextfield.setText("Passwort != Wiederholung");

        }
    }


}
