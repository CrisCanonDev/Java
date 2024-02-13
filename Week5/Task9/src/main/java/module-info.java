module com.source.task9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task9 to javafx.fxml;
    exports com.source.task9;
}