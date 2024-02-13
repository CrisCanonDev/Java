package com.example.jaavafxtesting;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

//import java.io.IOException;

import javafx.scene.layout.HBox;
import javafx.geometry.Insets;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {//throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("Click Me"));
        Scene scene = new Scene(pane, 300, 300);

        HBox hBox = new HBox(15); // Create an HBox with 15px spacing
        hBox.setPadding(new Insets(15, 15, 15, 15));
        //hBox.setStyle("-fx-background-color: gold");
        hBox.getChildren().add(new Button("Computer Science"));
        hBox.getChildren().add(new Button("Chemistry"));
        hBox.getChildren().add(new Button("Right"));

        //ImageView imageView = new ImageView(new Image("image/us.gif"));
        //hBox.getChildren().add(imageView);

        pane.getChildren().add(hBox);



        primaryStage.setTitle("First JavaFX Program.");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void start1(Stage primaryStage) {//throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Scene scene = new Scene(new Button("Ok"),200,250);
        primaryStage.setTitle("Minun Java FX");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("Second eli sec Staage");
        stage.setScene(new Scene(new Button("Uusi Stage"),200,250));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}