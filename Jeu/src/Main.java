import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent st = FXMLLoader.load(getClass().getResource("/FXML/Fenetre.fxml"));
        primaryStage.setScene(new Scene(st));
        primaryStage.show();
    }
}
