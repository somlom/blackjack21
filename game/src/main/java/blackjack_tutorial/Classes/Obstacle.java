package blackjack_tutorial.Classes;

public class Obstacle {

  boolean moveable;
  int speed;
  int[] position;
  String name;

  public Obstacle(String name, boolean moveable, int[] position, int speed) {
    this.name = name;
    this.moveable = moveable;
    this.speed = speed;
    this.position = position;
  }

  public Obstacle(String name, boolean moveable, int[] position) {
    this.name = name;
    this.moveable = moveable;
    this.position = position;
  }
}
