package game;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameLoad {

  private Image tree = new Image("/static/tree.png");
  public static double velocityStep = 525;
  public static GameLoad gameLoad;
  private Text informationText;
  private BorderPane root;
  private AnimationTimer scroll;
  public Screen screen;
  private ImageView leftSign[], rightSign[];

  public GameLoad(@SuppressWarnings("exports") BorderPane root, Screen road) {
    this.root = root;
    this.screen = road;
    gameLoad();
  }

  public void gameLoad() {
    ImageView LT = new ImageView(); // left top tree
    LT.setImage(tree);
    LT.setX(0);
    LT.setY(-150);
    ImageView LB = new ImageView(); // left bottom tree
    LB.setImage(tree);
    LB.setX(0);
    LB.setY(250);
    ImageView RT = new ImageView(); // right top tree
    RT.setImage(tree);
    RT.setX(980);
    RT.setY(-150);
    ImageView RB = new ImageView(); // right bottom tree
    RB.setImage(tree);
    RB.setX(980);
    RB.setY(250);
    root.getChildren().addAll(RT, RB, LT, LB);

    scroll = new AnimationTimer() { // scoll of screen
      @Override
      public void handle(long now) {
        Screen.getInstance().changingBoard(now);
      }
    };

    Rectangle road = new Rectangle(400, 0, 460, 960); // road layer on center
    road.setFill(Color.GRAY);
    root.getChildren().add(road);

    for (int i = 0; i < 6; i++) {
      RoadDash dash = new RoadDash(root, new Screen(400, 0, 460, 960));
      dash.coordinates.x = 630;
      dash.img.setX(630);
      dash.coordinates.y = (-480 * i);
      dash.img.setY(-480 * i);
      Screen.getInstance().addEntity(dash);
    }

    leftSign = new ImageView[6];
    rightSign = new ImageView[6];

    for (int i = 0; i < 6; i++) {
      leftSign[i] = createImage(350, -480 * i, 0, "/static/icon.png");
      rightSign[i] = createImage(860, -480 * i, 0, "/static/icon.png");
    }

    Screen car = new Screen(605, 580, 64, 128);
    Player.carPlayer = new Player(root, car);
    Player.carPlayer.setRoad(screen);
    Screen.getInstance().setMainEntity(Player.carPlayer);

    Screen trafficBoundary = new Screen(0, 0, 64, 128);
    Traffic traffic = new Traffic(root, trafficBoundary);
    traffic.createRoad(screen);

    Screen.getInstance().addEntity(traffic);

    informationText = new Text();
    informationText.setX(400);
    informationText.setY(300);
    root.getChildren().add(informationText);
  }

  private ImageView createImage(
      double x,
      double y,
      double rotation,
      String imgPath) {
    ImageView tree = new ImageView();
    tree.setImage(new Image(imgPath));
    tree.setX(x);
    tree.setY(y);
    root.getChildren().add(tree);
    return tree;
  }

  public void update(double dt) {
    double displacement = velocityStep * dt;
    for (int i = 0; i < 6; i++) {
      double y = leftSign[i].getY();
      if (y < screen.height) {
        leftSign[i].setY(y + displacement);
        rightSign[i].setY(y + displacement);
      } else {
        leftSign[i].setY(-screen.height);
        rightSign[i].setY(-screen.height);
      }
    }
  }

  public void gameOver() {
    Screen.getInstance().stop();
    Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 50);
    informationText.setText(
        "GAME OVER\nYour score " + Player.score + "\nPress ENTER to restart");
    informationText.setFont(font);
  }

  public void start() {
    Text informationText = new Text();

    if (Traffic.velocity == 0) {
      informationText.setX(400);
      informationText.setY(300);
    } else {
      informationText.setX(-1000);
      informationText.setY(300);
    }
    root.getChildren().add(informationText);
    Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30);
    informationText.setText("PLEASE ENTER TO START");
    informationText.setFont(font);

    scroll.start();
  }

  public void resume() {
    scroll.stop();
    root.getChildren().clear();
  }
}
