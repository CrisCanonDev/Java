package com.source.task3B;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorLayout extends Application {
    Button button;
    private int gridRowPosition = 0;
    private int gridColumnPosition = 0;

    public void increaseColumnPosition(){
        this.gridColumnPosition +=1;
    }
    public void increaseRowPosition(){
        this.gridRowPosition +=1;
    }
    public int getRowPosition(){
        return gridRowPosition;
    }
    public int getColumnPosition(){
        return gridColumnPosition;
    }
    public void restartRowValues(){
        this.gridRowPosition = 0;
    }
    public void setLabelAndTextField(String labelInformation, GridPane grid){
        restartRowValues();

        Label label1 = new Label();
        label1.setText(labelInformation);
        label1.setPrefHeight(25);
        label1.setPadding(new Insets(0,10,0,0));
        TextField textField = new TextField();

        grid.add(label1,getRowPosition(), getColumnPosition());
        increaseRowPosition();
        grid.add(textField,getRowPosition(), getColumnPosition());
        increaseRowPosition();

        increaseColumnPosition();
    }

    public void setOperators(GridPane gridPane){
        restartRowValues();
        ArrayList<String> operators = new ArrayList<String>(Arrays.asList("Add","Subtract", "Multiply", "Divide"));
        for(String operator: operators){
            Button button = new Button(operator);
            gridPane.add(button,getRowPosition(),getColumnPosition());
            increaseRowPosition();
        }
        increaseColumnPosition();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Calculator");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.TOP_CENTER);

        setLabelAndTextField("First Operand: ",gridPane);
        setLabelAndTextField("Second Operand: ",gridPane);
        setOperators(gridPane);
        setLabelAndTextField("Result ",gridPane);


        Scene scene = new Scene(gridPane, 500,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}