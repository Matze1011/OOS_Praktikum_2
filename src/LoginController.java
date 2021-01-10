import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.application.Application;
import java.util.stream.Collectors;

public class LoginController extends Application {

    //Attribute
    private boolean neuAnmeldung = false;

    private MainApplication app;

    @Override
    public void start(Stage stage) throws Exception{}

    //Getter
    public boolean getNeuanmeldung(){
        return neuAnmeldung;
    }

    //Getter-Setter Praktikum 5
    public void setMainApp(MainApplication app){ this.app = app;}
    public MainApplication getMainApp(){return app;}
    public void setError(String string){error.setText(string);}

    public static void main(String args){
        launch(args);
    }

    //Buttons
    @FXML Button submit;
    @FXML TextField useridTextfield;
    @FXML PasswordField passwortTextfield;
    @FXML CheckBox checkboxNeuanmeldung;
    @FXML public Label error;

    //Methoden
    @FXML
    public boolean neuanmeldungSetzen(Event event)throws Exception{
        if(checkboxNeuanmeldung.isSelected()){
        neuAnmeldung = true;}
        else {
            neuAnmeldung= false;
        }
        System.out.println("Neuanmeldung wurde geändert: " + neuAnmeldung);
        return neuAnmeldung;
    }


    //Wenn der sumbit Button gedrückt wird
    @FXML
    public void benutzerHinzufügen(Event event) throws Exception {
        //Passwort String zu char Array konvertieren
        String passwort = passwortTextfield.getText();
        char[] passwortkonvertiert = new char[passwort.length()];
        for (int i = 0; i < passwort.length(); i++) {
            passwortkonvertiert[i] = passwort.charAt(i);
        }

        //Benutzer mit eingegebenen Daten anlegen
        Benutzer neuerBenutzer = new Benutzer(useridTextfield.getText(),passwortkonvertiert);

        //Fenster schließen
        //Stage stage = (Stage) submit.getScene().getWindow();
        //stage.close();
        if(neuAnmeldung){

            //Call-Back
            app.neuAnmeldung();
        }else{
            //Call-Back
            app.benutzerLogin(neuerBenutzer);
        }

    }


}
