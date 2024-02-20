package Task5C;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PolygonMouseHover extends Application {
    Label labelOfMouseIntoCircle = new Label("The mouse is inside the polygon");
    Label labelOutOfCircle = new Label("The mouse is outside the polygon");

    @Override
    public void start(Stage primaryStage) {
        labelOfMouseIntoCircle.setVisible(false);
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                30.0, 10.0,   // x1, y1
                60.0, 30.0,  // x2, y2
                50.0, 70.0,  // x3, y3
                35.0, 35.0,   // x4, y4
               10.0, 50.0     // x5, y5
        );
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);

        Pane pane = new Pane();
        pane.getChildren().addAll(polygon, labelOfMouseIntoCircle, labelOutOfCircle);


        Scene scene = new Scene(pane, 250, 125);

        scene.setOnMouseMoved(event -> {
            if (polygon.contains(event.getX(), event.getY())) {
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

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Polygon Mouse Check");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
