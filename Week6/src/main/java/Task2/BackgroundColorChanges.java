package Task2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class BackgroundColorChanges extends Application {
    String[] colors = new String[]{"RED","BLUE","GREEN"};
    HBox layout;
    public Button settingButton(int colorIndex){
        String colorSelected = colors[colorIndex];
        Button button = new Button(colorSelected);
        button.setTextFill(Color.valueOf(colorSelected));
        return button;
    }

    public void changeBackground(int indexColor){
        layout.setBackground(new Background(new BackgroundFill(Color.valueOf(colors[indexColor]), null, null)));
    }

    @Override
    public void start(Stage primaryStage)  {
        Button buttonRed = settingButton(0);
        Button buttonBlue = settingButton(1);
        Button buttonYellow = settingButton(2);


        layout = new HBox(20, buttonRed, buttonBlue, buttonYellow);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout,250,100);
        layout.setBackground(new Background(new BackgroundFill(Color.TURQUOISE, null, null)));

        buttonRed.setOnAction(actionEvent -> changeBackground(0));
        buttonBlue.setOnAction(actionEvent -> changeBackground(1));
        buttonYellow.setOnAction(actionEvent -> changeBackground(2));


        primaryStage.setTitle("Changing Color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}