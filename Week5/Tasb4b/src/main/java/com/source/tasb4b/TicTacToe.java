package com.source.tasb4b;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TicTacToe extends Application {
    ImageView temporalValueImage;

    public List<Image> GetImageOptionsForTicTacToe() {
        List<Image> ticTacToeOptionsImages = new ArrayList<>(3);

        File directory = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week5\\Tasb4b\\images");
        File[] allImages = directory.listFiles();

        if (allImages != null) {
            for (int i = 0; i < allImages.length; i++) {
                ticTacToeOptionsImages.add(new Image(allImages[i].toURI().toString()));
            }
        }
        return ticTacToeOptionsImages;
    }
    public List<ImageView> GetImageViewToDisplay(List<Image> imagesTicTacToeOptions){
        List<ImageView> ticTacToeOptionsImagesView = new ArrayList<>(3);
        for(Image turn: imagesTicTacToeOptions){
            ticTacToeOptionsImagesView.add(new ImageView(turn));
        }
        return ticTacToeOptionsImagesView;
    }
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TIC TAC TOE!");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        List<Image> imagesViewToDisplay = GetImageOptionsForTicTacToe();


        int column=0;
        int row=0;
        Random random  = new Random();
        for(int i=0; i<9;i++){
            int randomChoice = random.nextInt(3);
            ImageView imageView = new ImageView(imagesViewToDisplay.get(randomChoice));
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            gridPane.add(imageView, column, row);
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