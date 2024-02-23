    package Task5;
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.Label;
    import javafx.scene.layout.Pane;
    import javafx.scene.paint.Color;
    import javafx.scene.shape.Circle;
    import javafx.stage.Stage;

    public class CircleGeometry extends Application {
        Circle circle = new Circle(50);
        Label labelOfMouseIntoCircle = new Label("The mouse is inside the circle");
        Label labelOutOfCircle = new Label("The mouse is outside the circle");
        Pane pane = new Pane(circle, labelOfMouseIntoCircle, labelOutOfCircle);
        Scene scene = new Scene(pane, 250, 150);

        public void setCircleInLayout() {
            circle.setCenterX(100);
            circle.setCenterY(60);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.TRANSPARENT);
        }


        @Override
        public void start(Stage primaryStage) throws Exception {
            labelOfMouseIntoCircle.setVisible(false);
            setCircleInLayout();

//            circle.setOnMouseMoved(event -> {
//                labelOfMouseIntoCircle.setLayoutX(event.getX());
//                labelOfMouseIntoCircle.setLayoutY(event.getY() - 15);
//            });
//            circle.setOnMouseExited(event -> {
//                labelOutOfCircle.setLayoutX(event.getX());
//                labelOutOfCircle.setLayoutY(event.getY() - 15);
//            });



            scene.setOnMouseMoved(event -> {
                if (circle.contains(event.getX(), event.getY())) {
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

        public static void main(String[] args) {
            launch(args);
        }
    }
