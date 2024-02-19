package com.source.task4a;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImagesGridPane extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Grid images");

        File directory = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week5\\Task4a\\src\\main\\java\\images");
        File[] allImages = directory.listFiles();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        HBox HB = new HBox();


        List<Image> images = new ArrayList<>();

        if(allImages != null){
            for(int i=0; i<allImages.length;i++){
                if(allImages[i].isFile() && ( allImages[i].getName().toLowerCase().endsWith(".jpg") || allImages[i].getName().toLowerCase().endsWith(".png")) ){
                    images.add(new Image(allImages[i].toURI().toString()));
                }
            }
        }
        System.out.println(images);

        int column = 0;
        int row = 0;
        for(Image image:images){
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            gridPane.add(imageView, column, row);
            System.out.println("s");
            column++;
            if(column == 3){
                column = 0;
                row++;
            }

        }
        gridPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(gridPane, 800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}