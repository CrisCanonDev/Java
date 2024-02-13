module com.source.task4a {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task4a to javafx.fxml;
    exports com.source.task4a;
}