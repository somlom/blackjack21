module blackjack_tutorial {
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;

  opens blackjack_tutorial to javafx.fxml;
  exports blackjack_tutorial ;
}
