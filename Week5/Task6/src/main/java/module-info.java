module com.source.task6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task6 to javafx.fxml;
    exports com.source.task6;
}