module blackjack_tutorial {
    requires javafx.controls;
    requires javafx.fxml;

    opens blackjack_tutorial to javafx.fxml;
    exports blackjack_tutorial;
}
