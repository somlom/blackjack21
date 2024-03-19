package game.Enums;

import javafx.scene.image.Image;

public enum PicEnum {
  PLAYER(new Image("/static/green.png")),
  DASH(new Image("/static/dash.png")),
  TRAFFIC(new Image("/static/red.png")),
  ICON(new Image("/static/icon.png")),
  FOREST(new Image("/static/forest.png"));

  private final Image image;

  PicEnum(Image image) {
    this.image = image;
  }

  public Image getImage() {
    return image;
  }
}
