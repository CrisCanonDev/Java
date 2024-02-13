package com.source.task6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MicrowaveLayout extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        File imageFood = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week5\\Task6\\images\\hamburger.jpg");
        Image image = new Image(imageFood.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(320);


        Pane buttonsAndDisplay = new Pane();
        VBox vroot = new VBox(2);

        TextField textField = new TextField();
        textField.setStyle("-fx-alignment: center;");
        textField.setText("0:00");
        textField.setPrefSize(300, 50);

        GridPane microwaveButtonGrid = new GridPane();
        microwaveButtonGrid.setPrefSize(300,240);

        int row =0;
        int column=0;
        for(int i=1; i<13;i++){
            Button button = new Button();
            button.setPrefSize(95,60);
            if(i<=9){
                button.setText( (String.valueOf(i)));
            }else {
                if (i == 10) button.setText("0");
                if (i == 11) button.setText("Start");
                if (i == 12) button.setText("Stop");
            }
            microwaveButtonGrid.add(button,column,row);
            column++;
            if(column == 3){
                column = 0;
                row++;
            }
        }


        vroot.getChildren().addAll(textField,microwaveButtonGrid);
        buttonsAndDisplay.getChildren().addAll(vroot);

        HBox root = new HBox();
        root.getChildren().addAll(imageView,buttonsAndDisplay);


        Scene scene = new Scene(root, 820, 300);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}