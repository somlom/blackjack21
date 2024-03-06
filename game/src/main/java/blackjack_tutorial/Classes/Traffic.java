package blackjack_tutorial.Classes;

public class Traffic extends Obstacle {

  public Traffic(String name, int[] position) {
    super(name, true, position);
  }

  public Traffic(String name, int[] position, int speed) {
    super(name, true, position, speed);
  }

  void move(int[] position) {
    this.position = position;
  }
}
