
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.io.IOException;

public class LoginController {

    MainApplication Steuerung;

    @FXML private boolean neuAnmeldung = false;

    @FXML CheckBox checkboxNeuanmeldung;
    @FXML TextField useridTextfield;
    @FXML PasswordField passwortTextfield;
    @FXML Label hiddenMeldung;
    @FXML Button submit;

    @FXML
    public void check() throws Exception {//ändern der Checkbox
        neuAnmeldung = checkboxNeuanmeldung.isSelected();
        System.out.println("CheckBox Wert geändert:" + neuAnmeldung);
        if(neuAnmeldung) Steuerung.neuAnmeldung();
    }

    public void setNachricht(String Nachricht){
        hiddenMeldung.setText(Nachricht);
    }

    @FXML
    public void ausführen() throws IOException, ClassNotFoundException {
        Benutzer benutzer = new Benutzer(useridTextfield.getText(),passwortTextfield.getText().toCharArray());
        System.out.println(benutzer.toString());
        submit.getScene().getWindow().hide();
        Steuerung.benutzerLogin(benutzer);
    }

    //Setter
    public void setSteuerung(MainApplication steuerung)
    {
        this.Steuerung = steuerung;
    }

}

