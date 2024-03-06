package blackjack_tutorial.Classes;

public class Player {

  boolean moveable;
  int speed;
  int[] position;
  String name;
  int points = 0;

  public Player(String name, boolean moveable, int[] position, int speed) {
    this.name = name;
    this.moveable = moveable;
    this.speed = speed;
    this.position = position;
  }

  int[] move(int[] position) {
    return this.position = position;
  }

  int setSpeed(int speed) {
    return this.speed = speed;
  }

  int incrementPoints() {
    return this.points++;
  }
}
