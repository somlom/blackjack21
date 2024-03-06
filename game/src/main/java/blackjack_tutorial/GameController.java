package blackjack_tutorial;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameController {

  @FXML
  private ImageView carImageView;

  @FXML
  private Label scoreLabel;

  private int score = 0;
  private AnimationTimer gameLoop;
  private double carPositionX = 0;
  private double carSpeed = 5; // Adjust as needed
  private boolean isMovingLeft = false;
  private boolean isMovingRight = false;

  @FXML
  public void initialize() {
    startGameLoop();
  }

  private void startGameLoop() {
    gameLoop =
      new AnimationTimer() {
        @Override
        public void handle(long now) {
          update();
        }
      };
    gameLoop.start();
  }

  private void update() {
    // Update car position
    if (isMovingLeft) {
      carPositionX -= carSpeed;
    } else if (isMovingRight) {
      carPositionX += carSpeed;
    }

    // Update car ImageView position
    carImageView.setLayoutX(carPositionX);

    // Update score (for example, increment by 1 for each frame)
    score++;
    scoreLabel.setText("Score: " + score);
  }

  // Method to handle player input (e.g., move the car)
  @FXML
  private void handleKeyPress(KeyEvent event) {
    if (event.getCode() == KeyCode.LEFT) {
      isMovingLeft = true;
    } else if (event.getCode() == KeyCode.RIGHT) {
      isMovingRight = true;
    }
  }

  @FXML
  private void handleKeyRelease(KeyEvent event) {
    if (event.getCode() == KeyCode.LEFT) {
      isMovingLeft = false;
    } else if (event.getCode() == KeyCode.RIGHT) {
      isMovingRight = false;
    }
  }

  // Method to stop the game loop (e.g., when the game is over)
  public void stopGameLoop() {
    gameLoop.stop();
  }
}
