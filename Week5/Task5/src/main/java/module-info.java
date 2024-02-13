module com.source.task5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task5 to javafx.fxml;
    exports com.source.task5;
}