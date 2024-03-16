package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class RoadDash {

  private Image carImage = new Image("/static/dash.png");

  @SuppressWarnings("exports")
  public ImageView img;

  public Screen coordinates;
  public static double velocity = 0;

  public RoadDash(@SuppressWarnings("exports") BorderPane root, Screen coordinate) {
    this.coordinates = coordinate;
    img = new ImageView();
    img.setImage(carImage);
    root.getChildren().add(createImage());
  }

  @SuppressWarnings("exports")
  public ImageView createImage() {
    img.setX(coordinates.x);
    img.setY(coordinates.y);
    return img;
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
