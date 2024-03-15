package game.Classes;

import game.Enums.ObjectsEnum;

public class Lorry extends Traffic {

  public Lorry(int[] position) {
    super(ObjectsEnum.LORRY, position);
  }

  public Lorry(int[] position, int speed) {
    super(ObjectsEnum.LORRY, position, speed);
  }

  void move(int[] position) {
    this.position = position;
  }
}
