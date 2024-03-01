package blackjack_tutorial;

import java.io.IOException;
import javafx.fxml.FXML;

public class GameController {

  @FXML
  private void escapeGame() throws IOException {
    App.setRoot("startScreen");
  }
}
