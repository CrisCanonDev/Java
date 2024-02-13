module com.source.task8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task8 to javafx.fxml;
    exports com.source.task8;
}