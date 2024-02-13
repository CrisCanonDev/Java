module com.source.task4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task3B to javafx.fxml;
    exports com.source.task3B;
}