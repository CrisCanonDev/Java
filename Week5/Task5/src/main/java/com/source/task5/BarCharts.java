package com.source.task5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BarCharts extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        String[] labels = {"Project", "Quiz", "Midterm", "Final"};
        double[] values = {20,10,30,40};
        String[] colors = {"RED", "BLUE", "GREEN", "GOLD"};

        pane.setPrefSize(400,100);;
        pane.setPadding(new Insets(10));

        double barWidth = pane.getPrefWidth() / values.length;


        for (int i=0; i<values.length;i++){
            Rectangle bar = new Rectangle(barWidth-10, (values[i] / 100) *  pane.getPrefHeight());
            bar.setX((i * barWidth)+5);
            bar.setY(pane.getPrefHeight() - bar.getHeight());
            bar.setFill(Color.valueOf(colors[i]));

            // Create text for the value
            Text valueText = new Text(labels[i]+" -- "+String.valueOf(values[i]));
            valueText.setX(bar.getX() + barWidth / 2 - valueText.getLayoutBounds().getWidth() / 2);
            valueText.setY(bar.getY() - 5);

            pane.getChildren().addAll(bar, valueText);

        }

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Bar Chart Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}