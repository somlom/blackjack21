package blackjack_tutorial;

import blackjack_tutorial.Classes.Obstacle;
import blackjack_tutorial.Classes.Player;
import blackjack_tutorial.Enums.ObjectsEnum;
// import blackjack_tutorial.Classes.Obstacle;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameController {

  // @FXML
  // private ImageView carImageView;

  // @FXML
  // private Label scoreLabel;

  // private int score = 0;
  // private AnimationTimer gameLoop;
  // private double carPositionX = 0;
  // private double carSpeed = 5; // Adjust as needed
  // private boolean isMovingLeft = false;
  // private boolean isMovingRight = false;

  // @FXML
  // public void initialize() {
  //   startGameLoop();
  //   carImageView.requestFocus(); // Set focus on car image
  // }

  @FXML
  private ImageView carImageView; // Matches FXML ID

  @FXML
  private Label scoreLabel;

  private int score = 0;
  private AnimationTimer gameLoop;
  private double carPositionX = 100; // Starting position in lane 2 (assuming lane width is 266)
  private double carSpeed = 5;
  private boolean isMovingLeft = false;
  private boolean isMovingRight = false;
  private List<Obstacle> obstacles; // List to store obstacles
  private int[] pos = { 20, 0 };
  private Player player = new Player(true, pos, 0);

  @FXML
  public void initialize() {
    startGameLoop();
    carImageView.requestFocus(); // Set focus on car image

    obstacles = new ArrayList<>();
    // Create and add obstacles to gamePane (refer to FXML structure)
    for (int i = 0; i < 3; i++) { // Add 3 obstacles initially
      int[] position = { 20, 20 };
      obstacles.add(new Obstacle(ObjectsEnum.LORRY, true, position, 3)); // Adjust positions and speed
    }
  }

  private void moveObstacles() {
    for (Obstacle obstacle : obstacles) {
      obstacle.updatePosition(obstacle.getLayoutX() - 1, obstacle.getLayoutY()); // Update obstacle X position
      // Check if obstacle has gone off-screen (assuming positive speed)
      // if (obstacle.getLayoutX() < 0) {
      //   obstacle.repositionObstacle(); // Reset obstacle position off-screen on the right
      // }
    }
  }

  private void checkForCollisions() {
    for (Obstacle obstacle : obstacles) {
      // Get car and obstacle bounding boxes
      double carX = carImageView.getLayoutX();
      double carY = carImageView.getLayoutY();
      double carWidth = carImageView.getFitWidth();
      double carHeight = carImageView.getFitHeight();

      double obstacleX = obstacle.getLayoutX();
      double obstacleY = obstacle.getLayoutY();
      double obstacleWidth = obstacle.getWidth();
      double obstacleHeight = obstacle.getHeight();

      // Check for intersection of car and obstacle bounding boxes
      if (
        carX + carWidth >= obstacleX &&
        carX <= obstacleX + obstacleWidth &&
        carY + carHeight >= obstacleY &&
        carY <= obstacleY + obstacleHeight
      ) {
        // Handle collision (e.g., stop the game, deduct points, etc.)
        System.out.println("Collision detected!");
        // Implement your desired collision handling logic here (e.g., stopGameLoop(), deduct score, etc.)
      }
    }
  }

  // private void startGameLoop() {
  //   gameLoop =
  //     new AnimationTimer() {
  //       @Override
  //       public void handle(long now) {
  //         update();
  //       }
  //     };
  //   gameLoop.start();
  // }

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

  // private void update() {
  //   // Update car position
  //   if (isMovingLeft) {
  //     carPositionX -= carSpeed;
  //   } else if (isMovingRight) {
  //     carPositionX += carSpeed;
  //   }

  //   // Update car ImageView position
  //   carImageView.setLayoutX(carPositionX);

  //   // Update score (for example, increment by 1 for each frame)
  //   score++;
  //   scoreLabel.setText("Score: " + score);
  // }

  private void update() {
    // Update car position
    if (isMovingLeft && carPositionX > 10) { // Assuming lane1 ID exists in FXML
      // if (isMovingLeft && carPositionX > 1) { // Assuming lane1 ID exists in FXML
      carPositionX -= carSpeed;
    } else if (
      isMovingRight && carPositionX < 30 + 30
      // isMovingRight && carPositionX < 3 + 3
    ) { // Assuming lane3 ID exists in FXML
      carPositionX += carSpeed;
    }
    // Update score
    score++;
    scoreLabel.setText("Score: " + score);
    // Move and check for collisions with obstacles
    moveObstacles();
    checkForCollisions();
  }

  @FXML
  private void handleKeyPress(KeyEvent event) {
    System.out.println("press");
    if (event.getCode() == KeyCode.LEFT) {
      isMovingLeft = true;
    } else if (event.getCode() == KeyCode.RIGHT) {
      isMovingRight = true;
    }
    // Consider using event.consume() cautiously here if needed
  }

  @FXML
  private void handleKeyRelease(KeyEvent event) {
    System.out.println("release");
    if (event.getCode() == KeyCode.LEFT) {
      pos[0] -= 10;
      isMovingLeft = false;
    } else if (event.getCode() == KeyCode.RIGHT) {
      pos[0] += 10;
      isMovingRight = false;
    }
    player.move(pos);

    // Update car ImageView position
    carImageView.setLayoutX(carPositionX);
    // Consider using event.consume() cautiously here if needed
  }

  public void stopGameLoop() {
    gameLoop.stop();
  }
}
