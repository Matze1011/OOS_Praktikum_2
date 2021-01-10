import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AnwendungsController extends Application {
    //Buttons
    @FXML Button abbrechenbutton;

    @Override
    public void start(Stage stage) throws Exception{

    }
    public static void main(String args){
        launch(args);
    }

    //Methoden
    @FXML
    public void meldung(Event event){
        Stage stage = (Stage) abbrechenbutton.getScene().getWindow();
        stage.close();
        System.out.println("Es wurde " + event.getSource() + " gedrückt.");
    }

}
