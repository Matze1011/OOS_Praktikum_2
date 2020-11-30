import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AnwendungsController {
    //Buttons
    @FXML Button abbrechenbutton;

    //Methoden
    @FXML
    public void meldung(Event event){
        Stage stage = (Stage) abbrechenbutton.getScene().getWindow();
        stage.close();
        System.out.println("Es wurde " + event.getSource() + " gedrückt.");
    }

}
