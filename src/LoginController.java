import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class LoginController {

    //Attribute
    private boolean neuAnmeldung = false;

    //Getter
    public boolean getNeuanmeldung(){
        return neuAnmeldung;
    }

    //Buttons
    @FXML Button submit;
    @FXML TextField useridTextfield;
    @FXML TextField passwortTextfield;
    @FXML CheckBox checkboxNeuanmeldung;

    //Methoden
    @FXML
    public boolean neuanmeldungSetzen(Event event){
        if(checkboxNeuanmeldung.isSelected()){
        neuAnmeldung = true;}
        else {
            neuAnmeldung= false;
        }
        System.out.println("Neuanmeldung wurde geändert: " + neuAnmeldung);
        return neuAnmeldung;
    }

    public void benutzerHinzufügen(Event event) {
        //Passwort String zu char Array konvertieren
        String passwort = passwortTextfield.getText();
        char[] passwortkonvertiert = new char[passwort.length()];
        for (int i = 0; i < passwort.length(); i++) {
            passwortkonvertiert[i] = passwort.charAt(i);
        }

        //Benutzer mit eingegebenen Daten anlegen
        Benutzer neuerBenutzer = new Benutzer(useridTextfield.getText(),passwortkonvertiert);
        System.out.println("Neuer Benutzer erstellt: " + neuerBenutzer.toString());

        //Fenster schließen
        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();
    }
}
