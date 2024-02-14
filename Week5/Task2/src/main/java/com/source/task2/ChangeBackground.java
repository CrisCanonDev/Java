package com.source.task2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeBackground extends Application {
    Button button1,button2, button3;
    Scene scene;
    HBox root;
    public void changeBackgroundColor(String color){
        root.setStyle(color);
    }
    public Button setButton(String buttonText, String backgroundColor) {
        Button button = new Button(buttonText);
        button.setOnAction(actionEvent -> changeBackgroundColor("-fx-background-color:"+backgroundColor+";"));
        return button;
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Task2");

        button1 = setButton("Button1","lightBlue");
        button2 = setButton("Button2","green");
        button3 = setButton("Button3", "violet");

        root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(button1, button2,button3);

        scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}