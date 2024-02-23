module Task {
    requires javafx.controls;
    requires javafx.fxml;


    opens Task2 to javafx.fxml;
    exports Task2;
}