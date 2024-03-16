package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Car {

  public Screen coordinates;

  @SuppressWarnings("exports")
  public ImageView imgPlacholder;

  public Car(
    @SuppressWarnings("exports") BorderPane root,
    Screen coordiantes,
    @SuppressWarnings("exports") Image img
  ) {
    this.coordinates = coordiantes;
    this.imgPlacholder = new ImageView();
    this.imgPlacholder.setImage(img);
    root.getChildren().add(createImage());
  }

  @SuppressWarnings("exports")
  public ImageView createImage() {
    imgPlacholder.setX(coordinates.x);
    imgPlacholder.setY(coordinates.y);
    return imgPlacholder;
  }

  public Screen getCoordinates() {
    return coordinates;
  }
}
