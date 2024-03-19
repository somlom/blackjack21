package game;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartScreenController {

  @FXML
  private Button startScreenButton;

  @FXML
  private void startGame(ActionEvent event) throws IOException {
    Stage stage = (Stage) startScreenButton.getScene().getWindow();
    Game game = new Game(new BorderPane(), 1280, 720);
    stage.setFullScreen(true);
    stage.setScene(game);

    game.start();
  }
}
