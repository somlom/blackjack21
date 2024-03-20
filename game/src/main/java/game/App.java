package game;

import java.io.IOException;

import game.Enums.PicEnum;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  private static Scene scene;

  @Override
  public void start(@SuppressWarnings("exports") Stage stage)
      throws IOException {
    scene = new Scene(loadFXML("startScreen"), 1280, 720); // hd standart width
    stage.setScene(scene);
    stage.setFullScreen(true);
    stage.setTitle("Der lange Weg nach Langsteinbach");
    stage.getIcons().add(PicEnum.ICON.getImage());
    stage.show();
  }

  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
        App.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }

  public static void main(String[] args) {
    launch();
  }
}
