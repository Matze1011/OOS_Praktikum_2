
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class AnmeldungsController {

    MainApplication Steuerung;
    @FXML TextField useridTextfield;
    @FXML TextField passwortTextfield;
    @FXML Button submit;
    @FXML TextField wiederholungTextfield;
    @FXML Label hiddenMeldung;
    @FXML Label error;

    @FXML
    private void ausführen() throws ClassNotFoundException, IOException {
        //Als Reaktion auf Drücken des Buttons wird wie folgt verfahren:

        if(passwortTextfield.getText().equals(wiederholungTextfield.getText())) {

            //In dem Fall, dass sie gleich sind, wird die Kontrolle wieder an
            //das MainApplication-Objekt durch den Aufruf der Call-BackMethode neuerBenutzer(benutzer)übergeben.
            //Dabei wird im Parameter der im AnmeldungController erzeugte Benutzer übergeben.

            error.setVisible(false);
            Benutzer benutzer = new Benutzer(useridTextfield.getText(),passwortTextfield.getText().toCharArray());
            System.out.println(benutzer.toString());
            submit.getScene().getWindow().hide();
            Steuerung.neuerBenutzer(benutzer);
        } else {
            //In dem Fall, dass die Inhalte der beiden Passwortfelder
            //verschieden sind, wird wie bisher verfahren.
            error.setVisible(true);
            hiddenMeldung.setVisible(false);
        }
    }

    //Setter
    public void setSteuerung(MainApplication steuerung) throws NullPointerException{
        this.Steuerung = steuerung;
    }

    public void setNachricht(String Nachricht){
        hiddenMeldung.setText(Nachricht);
    }

}