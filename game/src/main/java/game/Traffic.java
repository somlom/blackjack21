package game;

import java.util.Random;

import game.Enums.PicEnum;
import game.helpers.GameLoad;
import game.helpers.GameObject;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

public class Traffic extends GameObject {

  public static double velocity = 0;
  static double points = 525;

  public Traffic(
      @SuppressWarnings("exports") BorderPane root,
      Screen trafficCoordiantes) {
    super(root, trafficCoordiantes, PicEnum.TRAFFIC.getImage());
  }

  public void createRoad(Screen roadCoordinates) {
    createImage().setClip(new Rectangle(400, 0, 460, 960));
  }

  public void restartGame() {
    velocity = points;
    restart();
  }

  public void resume() {
    velocity = 0;
  }

  public void levelUp(double acceleration) {
    Rectangle rect = (Rectangle) createImage().getClip();
    double d = velocity * acceleration;
    double y = coordinates.y;
    if (y + d < rect.getHeight()) {
      coordinates.y = (y + d);
      img.setY(y + d);
    }

    if (y + d > 960) {
      Player.score += 1 * Player.level;
      if (Player.score > (Player.level * Player.level)) {
        Player.level++;
        Traffic.velocity += 75;
        RoadDash.velocity += 75;
        GameLoad.velocityStep += 75;
      }
      restart();
    }
  }

  private void restart() {
    Rectangle rect = (Rectangle) createImage().getClip();
    coordinates.x = (rect.getX() +
        (rect.getWidth() - coordinates.width) *
            new Random().nextDouble());
    img.setX(
        rect.getX() +
            (rect.getWidth() - coordinates.width) *
                new Random().nextDouble());
    coordinates.y = (-coordinates.height);
    img.setY(-coordinates.height);
  }
}
