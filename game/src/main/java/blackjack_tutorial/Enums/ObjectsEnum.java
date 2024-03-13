package blackjack_tutorial.Enums;

public enum ObjectsEnum {
  LORRY("lorry"),
  OBSTACLE("obstacle"),
  ROAD("road"),
  PLAYER("player"),
  TRAFFIC("traffic"),
  CONSTRUCTION("construction");

  private final String elementName;

  ObjectsEnum(String elementName) {
    this.elementName = elementName;
  }

  public String getElementName() {
    return elementName;
  }
}
