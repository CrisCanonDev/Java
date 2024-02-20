package Task5B;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleMouseHover extends Application {
    Rectangle rectangle = new Rectangle(100,40);
    Label labelOfMouseIntoCircle = new Label("The mouse is inside the rectangle");
    Label labelOutOfCircle = new Label("The mouse is outside the rectangle");
    Pane pane = new Pane(rectangle, labelOfMouseIntoCircle, labelOutOfCircle);
    Scene scene = new Scene(pane, 250, 150);

    public void setRectangleLayout() {
        rectangle.setX(50);
        rectangle.setY(30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.TRANSPARENT);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        setRectangleLayout();
        labelOfMouseIntoCircle.setVisible(false);


        scene.setOnMouseMoved(event -> {
            if (rectangle.contains(event.getX(), event.getY())) {
                labelOfMouseIntoCircle.setVisible(true);
                labelOutOfCircle.setVisible(false);
                labelOfMouseIntoCircle.setLayoutX(event.getX());
                labelOfMouseIntoCircle.setLayoutY(event.getY() - 15);
            } else {
                labelOutOfCircle.setVisible(true);
                labelOfMouseIntoCircle.setVisible(false);
                labelOutOfCircle.setLayoutX(event.getX());
                labelOutOfCircle.setLayoutY(event.getY() - 15);
            }
        });


        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Geometry");
        primaryStage.show();
    }
}
