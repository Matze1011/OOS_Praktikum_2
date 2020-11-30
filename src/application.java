import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class application extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Label start = new Label ("Test");
        TextField halloFeld = new TextField();
        FlowPane anzeige = new FlowPane();
        anzeige.getChildren().addAll(start,halloFeld);
        GridPane fensterinhalt = new GridPane();
        fensterinhalt.add(anzeige,0,0);

        Scene scene = new Scene(fensterinhalt);
        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();
    }
}
