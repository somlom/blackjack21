package blackjack_tutorial;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartScreenController {

    @FXML
    private void switchToSettings() throws IOException {
        App.setRoot("settings");
    }

    @FXML
    private void startGame() throws IOException {
        App.setRoot("game");
    }
}
