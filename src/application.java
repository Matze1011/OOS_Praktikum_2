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
    public void start(Stage stage1) throws Exception{
        //Aufgabe 3
        Parent anwendung = FXMLLoader.load(getClass().getResource("anwendung.fxml"));
        Scene scene = new Scene(anwendung); //Neues Fenster erstellen
        stage1.setScene(scene);
        stage1.setTitle("Benutzerverwaltung");
        stage1.show();

        //Aufgabe4
        Stage stage2 = new Stage();
        Parent anwendung2 = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        Scene scene2 = new Scene(anwendung2); //Neues Fenster erstellen
        stage2.setScene(scene2);
        stage2.setTitle("Benutzerverwaltung");
        stage2.show();

        //Aufgabe5
        Stage stage3 = new Stage();
        Parent anwendung3 = FXMLLoader.load(getClass().getResource("anmeldungFXML.fxml"));
        Scene scene3 = new Scene(anwendung3); //Neues Fenster erstellen
        stage3.setScene(scene3);
        stage3.setTitle("Benutzerverwaltung");
        stage3.show();
    }
}
