package com.source.task7;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ThreeClocks extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label newYorkLabel = new Label();
        Label joensuuLabel = new Label();
        Label tokyoLabel = new Label();

        HBox clockBox = new HBox(10, newYorkLabel, joensuuLabel, tokyoLabel);
        clockBox.setPadding(new Insets(10));

        // Create a Timeline to update the time every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            updateClock(newYorkLabel, ZoneId.of("America/New_York"));
            updateClock(joensuuLabel, ZoneId.of("Europe/Helsinki"));
            updateClock(tokyoLabel, ZoneId.of("Asia/Tokyo"));

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Create VBox to hold the clock box
        VBox root = new VBox(clockBox);
        root.setPadding(new Insets(10));

        // Create a Scene
        Scene scene = new Scene(root);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Multi Clock Example");
        primaryStage.show();
    }

    private void updateClock(Label label, ZoneId zoneId) {
        LocalDateTime time = LocalDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        if (zoneId.getId().equals("Europe/Helsinki")){
            label.setText("Eastern Finland : "+time.format(formatter));
        }else{
            label.setText(zoneId.getId() + ": " + time.format(formatter));
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}