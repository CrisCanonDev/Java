module Task {
    requires javafx.controls;
    requires javafx.fxml;


    opens Task5 to javafx.fxml;
    exports Task5;
}