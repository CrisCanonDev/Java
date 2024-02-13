module com.source.tasb4b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.tasb4b to javafx.fxml;
    exports com.source.tasb4b;
}