package vues;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class End {

    @FXML
    public Button restartButton;

    @FXML
    public Button quitButton;


    public void quitAction(ActionEvent actionEvent) {
        Stage s = (Stage) quitButton.getScene().getWindow();
        s.close();
    }

    public void restartGame(ActionEvent actionEvent) {

    }
}
