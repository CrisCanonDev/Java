module com.source.task7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.source.task7 to javafx.fxml;
    exports com.source.task7;
}