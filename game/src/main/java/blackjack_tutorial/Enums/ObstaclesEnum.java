package blackjack_tutorial.Enums;

public enum ObstaclesEnum {
  TRAFFIC("traffic"),
  CONSTRUCTION("construction"),
  LORRY("lorry");

  private final String obstacleType;

  ObstaclesEnum(String obstacleType) {
    this.obstacleType = obstacleType;
  }

  public String getObstacleType() {
    return obstacleType;
  }
}
