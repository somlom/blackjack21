package game;

import game.Enums.PicEnum;
import game.helpers.GameObject;
import javafx.scene.layout.BorderPane;

public class RoadDash extends GameObject {

  public static double velocity = 0;

  public RoadDash(@SuppressWarnings("exports") BorderPane root, Screen coordinates) {
    super(root, coordinates, PicEnum.DASH.getImage());
  }

  public void moveDash(double acceleration) {
    double d = velocity * acceleration;
    double y = coordinates.y;
    if (y < coordinates.height) {
      coordinates.y = (y + d);
      img.setY(y + d);
    } else {
      coordinates.y = -coordinates.height;
      img.setY(-coordinates.height);
    }
  }
}
