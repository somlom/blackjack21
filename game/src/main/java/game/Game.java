package game;

import game.helpers.GameLoad;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class Game extends Scene {

  public Game(@SuppressWarnings("exports") BorderPane root, double width, double height) {
    super(root, width, height);
    Screen road = new Screen(400, 0, 460, 960);
    GameLoad.gameLoad = new GameLoad(root, road);
    Screen.screen = new Screen(root, road);
    setupKeyEventHandler();
  }

  private void setupKeyEventHandler() {
    setOnKeyPressed(key -> {
      KeyCode press = key.getCode();

      if (press == KeyCode.ENTER) {
        restart();
      } else if (press == KeyCode.UP) {
        if (Traffic.velocity < Traffic.points) {
          Traffic.velocity += 150;
          RoadDash.velocity += 150;
          GameLoad.velocityStep += 150;
        }
      } else if (press == KeyCode.LEFT || press == KeyCode.RIGHT) {
        Player.carPlayer.keyPressed(press);
      } else if (press == KeyCode.DOWN) {
        if (Traffic.velocity >= 150 * 2) {
          Traffic.velocity -= 150;
          RoadDash.velocity -= 150;
          GameLoad.velocityStep -= 150;
        }
      }
    });
    setOnKeyReleased(key -> {
      KeyCode release = key.getCode();
      if (release == KeyCode.LEFT || key.getCode() == KeyCode.RIGHT) {
        Player.carPlayer.keyReleased(release);
      }
    });
  }

  private void restart() {
    Screen.getInstance().stop();
    GameLoad.gameLoad.resume();
    Player.level = 1;
    Player.score = 0;
    Traffic.velocity = 525;
    RoadDash.velocity = 525;
    GameLoad.velocityStep = 525;
    GameLoad.gameLoad.gameLoad();
    Screen.screen.init();
    Screen.getInstance().start();
    GameLoad.gameLoad.start();
  }

  public void start() {
    GameLoad.gameLoad.start();
  }

  public void resume() {
    GameLoad.gameLoad.resume();
  }
}
