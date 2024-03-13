package blackjack_tutorial;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

  private static Scene scene;

  @Override
  public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
    scene = new Scene(loadFXML("startScreen"), 1280, 720); // hd standart width
    stage.setScene(scene);
    stage.setFullScreen(true);
    stage.setTitle("Der lange Weg nach Langsteinbach");
    stage.getIcons().add(new Image("/icon.png"));
    stage.show();
    
  }

  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
      App.class.getResource(fxml + ".fxml")
    );
    return fxmlLoader.load();
  }
//    public class YourController {

//     @FXML
//     private Slider slider;

//     public void initialize() {
        
//         slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            
//             int selectedValue = newValue.intValue();
            
//             System.out.println("Selected value: " + selectedValue);
//         });
//     }
// }
public class SampleController {
  @FXML
  private Slider slider;
}


  public static void main(String[] args) {
    launch();
  }
}
