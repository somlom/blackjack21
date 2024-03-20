package game;

import game.Enums.PicEnum;
import game.helpers.GameLoad;
import game.helpers.GameObject;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class Player extends GameObject {
  public static Player carPlayer;

  private Screen road;
  private double velocity = 0;

  public static int score = 0;
  public static int level = 1;

  public Player(@SuppressWarnings("exports") BorderPane root, Screen coordinates) {
    super(root, coordinates, PicEnum.PLAYER.getImage());
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
    double x = this.getCoordinates().x;
    if ((x + change > road.x) &&
        (x + change + getCoordinates().width < road.x + road.width)) {
      this.coordinates.x = (x + change);
      this.img.setX(x + change);
    }

    Screen.screen.showScore(score);
    Screen.screen.showLevel(level);

    GameLoad.gameLoad.update(acceleration);
  }
}
