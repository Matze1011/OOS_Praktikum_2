import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class application extends Application {

    private Button abbrechenbutton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent anwendung = FXMLLoader.load(getClass().getResource("anwendung.fxml"));

        Scene scene = new Scene(anwendung); //Neues Fenster erstellen
        stage.setScene(scene);
        stage.setTitle("Benutzerverwaltung");
        stage.show();

    }
}
