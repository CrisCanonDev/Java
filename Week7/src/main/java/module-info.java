module Task {
    requires javafx.controls;
    requires javafx.fxml;


    opens Task1 to javafx.fxml;
    exports Task1;
}