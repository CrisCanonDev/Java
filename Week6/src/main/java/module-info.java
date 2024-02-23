module Task6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens Task6 to javafx.fxml;
    exports Task6;
}