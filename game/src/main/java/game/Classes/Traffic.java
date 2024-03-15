package game.Classes;

import game.Enums.ObjectsEnum;

public class Traffic extends Obstacle {

  public Traffic(ObjectsEnum name, int[] position) {
    super(name, true, position);
  }

  public Traffic(ObjectsEnum name, int[] position, int speed) {
    super(name, true, position, speed);
  }

  void move(int[] position) {
    this.position = position;
  }
}