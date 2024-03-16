package game;

import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Screen {

  public double x, y, width, height;
  private static Screen gamePlay = new Screen();
  private BorderPane root;
  public Screen road;
  private boolean isPlaying = false;

  public Screen(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  private Screen() {}

  public static Screen getInstance() {
    return gamePlay;
  }

  public Screen(BorderPane root, Screen roadBoundary) {
    this.root = root;
    this.road = roadBoundary;

    init();
  }

  private Text score, level;

  public void init() {
    score = show("SCORE", Color.WHITE, 0);
    level = show("LEVEL", Color.WHITE, 120);
  }

  private Text show(String title, Color bg, double offset) {
    Rectangle rectBg = new Rectangle(10, offset, 10, 110);
    // invisibe border for data structurisation

    Text score = new Text(title);
    score.setFill(Color.WHITE);
    score.setX(rectBg.getX() + 25);
    score.setY(rectBg.getY() + 35);

    Text level = new Text();
    level.setFill(Color.WHITE);
    level.setX(score.getX() + 25);
    level.setY(score.getY() + 35);

    root.getChildren().addAll(score, level);
    return level;
  }

  public void showScore(int point) {
    score.setText(String.valueOf(point));
  }

  public void showLevel(int speed) {
    level.setText(String.valueOf(speed));
  }

  public static Screen screen;
  public Player carPlayer;
  public ArrayList<Traffic> trafficList = new ArrayList<Traffic>();
  public ArrayList<RoadDash> dashesList = new ArrayList<RoadDash>();

  public void addEntity(Traffic traffic) {
    trafficList.add(traffic);
  }

  public void addEntity(RoadDash dash) {
    this.dashesList.add(dash);
  }

  public void setMainEntity(Player carPlayer) {
    this.carPlayer = carPlayer;
  }

  public void start() {
    isPlaying = true;

    for (int i = 0; i < trafficList.size(); i++) {
      trafficList.get(i).restartGame();
    }
  }

  private long previous = 0;

  public void changingBoard(long now) {
    if (previous == 0 || isPlaying == false) {
      previous = now;
      return;
    }

    double dt = (now - previous) / Math.pow(10, 9);

    for (int i = 0; i < dashesList.size(); i++) {
      RoadDash roadDash = dashesList.get(i);

      roadDash.moveDash(dt);
    }

    for (int i = 0; i < trafficList.size(); i++) {
      Traffic traffic = trafficList.get(i);

      if (
        carPlayer
          .createImage()
          .getBoundsInParent()
          .intersects(traffic.createImage().getBoundsInParent())
      ) {
        Player.carPlayer.gameOver();
      }

      traffic.levelUp(dt);
    }

    carPlayer.changingBoard(dt);

    previous = now;
  }

  public void stop() {
    isPlaying = false;
    for (int i = 0; i < trafficList.size(); i++) {
      trafficList.get(i).resume();
    }
    trafficList.clear();
  }
}
