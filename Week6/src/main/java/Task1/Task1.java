package Task1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Task1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(200,100);
        Button buttonToTurn45 = new Button("Turn 45 degrees");
        VBox layout = new VBox(20,rectangle,buttonToTurn45);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300,300);
        rectangle.setFill(Color.RED);
        buttonToTurn45.setOnAction(actionEvent -> rectangle.setRotate( rectangle.getRotate() + 45));

        primaryStage.setTitle("Turn around");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}