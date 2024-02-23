package Task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;


public class TrafficLights extends Application {
    GridPane layout = new GridPane();

    Circle circle1 = new Circle(), circle2 = new Circle(), circle3 = new Circle();
    Circle[] trafficLights = new Circle[]{circle1,circle2,circle3};
    CheckBox checkOn = new CheckBox("ON");
    final  ToggleGroup group = new ToggleGroup();
    RadioButton red = new RadioButton("RED"), yellow = new RadioButton("YELLOW"), green = new RadioButton("GREEN"), random = new RadioButton("RANDOM");
    RadioButton[] buttonList = new RadioButton[]{red, yellow, green, random};
    public void setLayoutSettings(){
        layout.setPadding(new Insets(10));
        layout.setVgap(5);
        layout.setHgap(10);
    }

    public void setLightsRadiusAndStroke(){
        double circleRadius = 20.0;
        for(Circle lights:trafficLights){
            lights.setRadius(circleRadius);
            lights.setStroke(Color.BLACK);
        }
    }

    public void chekingCheck(){
        checkOn.setSelected(true);
    }

    public void setLightButtons(Circle trafficLight, int indexPosition){
        setLightsRadiusAndStroke();
        trafficLight.setFill(Color.TRANSPARENT);
        layout.add(trafficLight,0,indexPosition);
    }
    public void changeLightsColors(Circle trafficLightSelected){
        String[] colors = {"RED","YELLOW","GREEN"};
        for(int i=0; i<trafficLights.length;i++){
            if (trafficLights[i] == trafficLightSelected){
                trafficLights[i].setFill(Color.valueOf(colors[i]));
            }else{
                trafficLights[i].setFill(Color.TRANSPARENT);
            }
        }
    }
    public void randomizeLightColors(){
        for(int i=0; i<trafficLights.length;i++){
                trafficLights[i].setFill(Color.color(Math.random(), Math.random(), Math.random()));
        }
    }
    public void updateLightColors(ActionEvent event){
        RadioButton radioButtonClicked = (RadioButton) event.getSource();
        String radioName = radioButtonClicked.getText();
        System.out.println(radioName);
        if(radioButtonClicked.getText().equals("RED")) changeLightsColors(trafficLights[0]);
        if(radioButtonClicked.getText().equals("YELLOW")) changeLightsColors(trafficLights[1]);
        if(radioButtonClicked.getText().equals("GREEN")) changeLightsColors(trafficLights[2]);
        if(radioButtonClicked.getText().equals("RANDOM")) randomizeLightColors();


    }
    public void placingLightsInLayout(){
        for(int i=0; i<trafficLights.length; i++){
            Circle currentLight = trafficLights[i];
            setLightButtons(currentLight, i);
        }
        setCheckBox();
        setRadioButtons();
    }
    public void setCheckBox(){
        layout.add(checkOn,1,0);
    }
    public void setRadioButtons(){
        for(int i=0 ; i<buttonList.length; i++){
            RadioButton currentButtonList = buttonList[i];
            currentButtonList.setToggleGroup(group);
            layout.add(currentButtonList,2,i);
        }
    }
    public boolean isCheckOn(){
         return checkOn.isSelected();
    }
    public void togglingRadioButton(boolean value){
        for(RadioButton radioButton: buttonList){
            radioButton.setDisable(value);
        }
    }
    public void togglingCheck(ActionEvent event){
        if (isCheckOn()){
            togglingRadioButton(true);
        }else{
            togglingRadioButton(false);
        }
    }


    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(layout, 250, 200);
        setLayoutSettings();
        placingLightsInLayout();

//        circle1.setOnMouseClicked(this::updateLightColors);
//        circle2.setOnMouseClicked(this::updateLightColors);
//        circle3.setOnMouseClicked(this::updateLightColors);

        checkOn.setOnAction(this::togglingCheck);

        red.setOnAction(this::updateLightColors);
        yellow.setOnAction(this::updateLightColors);
        green.setOnAction(this::updateLightColors);
        random.setOnAction(this::updateLightColors);


        primaryStage.setTitle("Traffic color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}