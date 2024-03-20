package game.helpers;

import game.Screen;
import game.interfaces.IGameObject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public abstract class GameObject implements IGameObject {

    public Screen coordinates;
    public ImageView img;

    public GameObject(
            BorderPane root,
            Screen coordiantes,
            Image img) {
        this.coordinates = coordiantes;
        this.img = new ImageView();
        this.img.setImage(img);
        root.getChildren().add(this.createImage());
    }

    public ImageView createImage() {
        this.img.setX(coordinates.x);
        this.img.setY(coordinates.y);
        return this.img;
    }
}