package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class Player {

  @SuppressWarnings("exports")
  public ImageView imgPlacholder;

  private Image carImage = new Image("/static/green.png");
  public static Player carPlayer;

  private Screen road;
  static ImageView staticImg;
  private Screen coordinates;
  private double velocity = 0;

  public Player(@SuppressWarnings("exports") BorderPane root, Screen coordinate) {
    this.coordinates = coordinate;
    this.imgPlacholder = new ImageView();
    this.imgPlacholder.setImage(carImage);
    Player.staticImg = createImage();
    root.getChildren().add(createImage());
  }

  @SuppressWarnings("exports")
  public ImageView createImage() {
    imgPlacholder.setX(coordinates.x);
    imgPlacholder.setY(coordinates.y);
    return imgPlacholder;
  }

  public void setRoad(Screen road) {
    this.road = road;
  }

  public void gameOver() {
    GameLoad.gameLoad.gameOver();
  }

  public void keyPressed(@SuppressWarnings("exports") KeyCode press) {
    if (press == KeyCode.LEFT) {
      velocity = -450;
    } else if (press == KeyCode.RIGHT) {
      velocity = 450;
    } else {
    }
  }

  public void keyReleased(@SuppressWarnings("exports") KeyCode release) {
    if (release == KeyCode.LEFT || release == KeyCode.RIGHT) {
      velocity = 0;
    }
  }

  public Screen getCoordinates() {
    return coordinates;
  }

  public static int score = 0;
  public static int level = 1;

  public void changingBoard(double acceleration) {
    double change = velocity * acceleration;
    double x = getCoordinates().x;
    if ((x + change > road.x) &&
        (x + change + getCoordinates().width < road.x + road.width)) {
      coordinates.x = (x + change);
      imgPlacholder.setX(x + change);
    }

    Screen.screen.showScore(score);
    Screen.screen.showLevel(level);

    GameLoad.gameLoad.update(acceleration);
  }
}
