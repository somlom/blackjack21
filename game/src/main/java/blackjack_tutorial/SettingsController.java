package blackjack_tutorial;

import java.io.IOException;
import javafx.fxml.FXML;

public class SettingsController {

  @FXML
  private void switchTostartScreen() throws IOException {
    App.setRoot("startScreen");
  }
}
