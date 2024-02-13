module com.source.task2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task2 to javafx.fxml;
    exports com.source.task2;
}