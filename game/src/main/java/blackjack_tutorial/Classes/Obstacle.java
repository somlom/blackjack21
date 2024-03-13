// package blackjack_tutorial.Classes;

// import blackjack_tutorial.Enums.ObjectsEnum;

// public class Obstacle {

//   boolean moveable;
//   int speed;
//   int[] position;
//   ObjectsEnum name;

//   public Obstacle(
//     ObjectsEnum name,
//     boolean moveable,
//     int[] position,
//     int speed
//   ) {
//     this.name = name;
//     this.moveable = moveable;
//     this.speed = speed;
//     this.position = position;
//   }

//   public Obstacle(ObjectsEnum name, boolean moveable, int[] position) {
//     this.name = name;
//     this.moveable = moveable;
//     this.position = position;
//   }
// }
package blackjack_tutorial.Classes;

import blackjack_tutorial.Enums.ObjectsEnum;
import javafx.scene.layout.Pane; // Import Pane for visibility calculations

public class Obstacle {

  boolean moveable;
  int speed;
  int[] position; // Assuming position[0] is X and position[1] is Y
  ObjectsEnum name;

  Pane gamePane; // Assuming the obstacle is added to a Pane
  private int width;
  private int height;

  public Obstacle(
    ObjectsEnum name,
    boolean moveable,
    int[] position,
    int speed
  ) {
    this.name = name;
    this.moveable = moveable;
    this.speed = speed;
    this.position = position;
    this.width = 10;
    this.height = 15;
  }

  public Obstacle(ObjectsEnum name, boolean moveable, int[] position) {
    this.name = name;
    this.moveable = moveable;
    this.position = position;
  }

  // New methods for movement and resetting
  public void updatePosition(int x,int y) {
    int[] pos = {x,y};
    this.position = pos; // Update obstacle X position by its speed
  }

  // Getters for position and dimensions
  public int getLayoutX() {
    return position[0];
  }

  public int getLayoutY() {
    return position[1];
  }

  public int getWidth() { // Assuming you have a width property or can calculate it
    return this.width;
  }

  public int getHeight() { // Assuming you have a height property or can calculate it
    return this.height;
  }
}
