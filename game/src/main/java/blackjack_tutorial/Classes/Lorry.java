package blackjack_tutorial.Classes;

public class Lorry extends Traffic {

  public Lorry(int[] position) {
    super("Lorry", position);
  }

  public Lorry(int[] position, int speed) {
    super("Lorry", position, speed);
  }

  void move(int[] position) {
    this.position = position;
  }
}
