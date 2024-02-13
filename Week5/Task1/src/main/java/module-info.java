module com.source.task1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task1 to javafx.fxml;
    exports com.source.task1;
}