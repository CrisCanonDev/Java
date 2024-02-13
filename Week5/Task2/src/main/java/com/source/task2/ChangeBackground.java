package com.source.task2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeBackground extends Application {
    Button button1,button2, button3;
    Scene scene;
    HBox root;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Task2");
        button1 = new Button("Button 1");
        button2 = new Button("Button 2");
        button3 = new Button("Button 3");


        button1.setOnAction(actionEvent -> changeBackground("-fx-background-color: lightblue;"));
        button2.setOnAction(actionEvent -> changeBackground("-fx-background-color: green;"));
        button3.setOnAction(actionEvent -> changeBackground("-fx-background-color: violet;"));

        root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(button1,button2,button3);

        scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeBackground(String color){
        root.setStyle(color);
    }
    public static void main(String[] args) {
        launch();
    }
}