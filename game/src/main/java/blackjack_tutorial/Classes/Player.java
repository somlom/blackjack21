package blackjack_tutorial.Classes;

import blackjack_tutorial.Enums.ObjectsEnum;

public class Player {

  boolean moveable;
  int speed;
  public int[] position;
  ObjectsEnum name;
  int points = 0;

  public Player(boolean moveable, int[] position, int speed) {
    this.name = ObjectsEnum.PLAYER;
    this.moveable = moveable;
    this.speed = speed;
    this.position = position;
  }

  public int[] move(int[] position) {
    return this.position = position;
  }

  public int setSpeed(int speed) {
    return this.speed = speed;
  }

  public int incrementPoints() {
    return this.points++;
  }
}
