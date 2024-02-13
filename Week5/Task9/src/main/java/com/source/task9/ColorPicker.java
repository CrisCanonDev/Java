package com.source.task9;
//TASK 9
//Usage of ColorPicker object that allows to fill the rectangle with the color selected through an eveny
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ColorPicker extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un selector de colores
        HBox root = new HBox();
        javafx.scene.control.ColorPicker colorPicker = new javafx.scene.control.ColorPicker();
        Rectangle rectangle = new Rectangle(100,50);


        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(colorPicker,rectangle);
        Scene scene = new Scene(root, 300, 200);
        rectangle.setY(scene.getY());
        rectangle.setX(100);

        colorPicker.valueProperty().addListener((observableValue, color, newColor) -> {
            rectangle.setFill(newColor);
        });



        primaryStage.setScene(scene);
        primaryStage.setTitle("Color Picker Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
