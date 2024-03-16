package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class Player {

  @SuppressWarnings("exports")
  public ImageView imgPlaceholder;

  private Image carImage = new Image("/static/green.png");
  public static Player carPlayer;

  private Screen road;
  static ImageView staticImg;
  private Screen coordinates;
  private double velocity = 0;
  public static int score = 0;
  public static int level = 1;

  public Player(@SuppressWarnings("exports") BorderPane root, Screen coordinates) {
    this.coordinates = coordinates;
    this.imgPlaceholder = new ImageView();
    this.imgPlaceholder.setImage(carImage);
    Player.staticImg = createImage();
    root.getChildren().add(createImage());
  }

  @SuppressWarnings("exports")
  public ImageView createImage() {
    this.imgPlaceholder.setX(coordinates.x);
    this.imgPlaceholder.setY(coordinates.y);
    return this.imgPlaceholder;
  }

  public void setRoad(Screen road) {
    this.road = road;
  }

  public void gameOver() {
    GameLoad.gameLoad.gameOver();
  }

  public void keyPressed(@SuppressWarnings("exports") KeyCode press) {
    if (press == KeyCode.LEFT) {
      this.velocity = -450;
    } else if (press == KeyCode.RIGHT) {
      this.velocity = 450;
    } else {
    }
  }

  public void keyReleased(@SuppressWarnings("exports") KeyCode release) {
    if (release == KeyCode.LEFT || release == KeyCode.RIGHT) {
      this.velocity = 0;
    }
  }

  public Screen getCoordinates() {
    return this.coordinates;
  }

  public void changingBoard(double acceleration) {
    double change = this.velocity * acceleration;
    double x = getCoordinates().x;
    if ((x + change > road.x) &&
        (x + change + getCoordinates().width < road.x + road.width)) {
      this.coordinates.x = (x + change);
      this.imgPlaceholder.setX(x + change);
    }

    Screen.screen.showScore(score);
    Screen.screen.showLevel(level);

    GameLoad.gameLoad.update(acceleration);
  }
}
