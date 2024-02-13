module com.source.task3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task3 to javafx.fxml;
    exports com.source.task3;
}