package game;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

public class Traffic {

  private Image trafficImg = new Image("/static/red.png");

  @SuppressWarnings("exports")
  public ImageView imgPlacholder;

  public Screen coordinates;
  static double velocity = 0;
  static double balance = 525;

  public Traffic(
    @SuppressWarnings("exports") BorderPane root,
    Screen trafficCoordiantes
  ) {
    this.coordinates = trafficCoordiantes;
    this.imgPlacholder = new ImageView();
    this.imgPlacholder.setImage(trafficImg);
    root.getChildren().add(createImage());
  }

  @SuppressWarnings("exports")
  public ImageView createImage() {
    imgPlacholder.setX(coordinates.x);
    imgPlacholder.setY(coordinates.y);
    return imgPlacholder;
  }

  public void createRoad(Screen roadCoordinates) {
    createImage().setClip(new Rectangle(400, 0, 460, 960));
  }

  public void restartGame() {
    velocity = balance;
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
      imgPlacholder.setY(y + d);
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
    coordinates.x =
      (
        rect.getX() +
        (rect.getWidth() - coordinates.width) *
        new Random().nextDouble()
      );
    imgPlacholder.setX(
      rect.getX() +
      (rect.getWidth() - coordinates.width) *
      new Random().nextDouble()
    );
    coordinates.y = (-coordinates.height);
    imgPlacholder.setY(-coordinates.height);
  }
}
