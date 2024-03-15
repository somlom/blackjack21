package game;

import java.io.IOException;
import javafx.fxml.FXML;

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
