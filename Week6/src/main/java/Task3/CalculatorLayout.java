package Task3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorLayout extends Application {
    String[] buttonName = new String[]{"Add", "Subtract", "Multiply", "Divide"};

    TextField firstOperand = new TextField(), secondOperand = new TextField(), result = new TextField();
    Button add, subtract, multiply, divide;
    int textIndex = -1;

    public HBox textAndLabel(String labelText, TextField textFieldToEnter){
        Label label = new Label(labelText);
        label.setMinWidth(100);
        return new HBox(label, textFieldToEnter);
    }
    public HBox  placeButtonBox(){
        add = setButton();
        subtract = setButton();
        multiply = setButton();
        divide = setButton();

        HBox buttonPlace = new HBox(add,subtract, multiply, divide);
        buttonPlace.setAlignment(Pos.CENTER_LEFT);
        return  buttonPlace;
    }
    public Button setButton(){
        increaseIndexNames();
        return new Button(buttonName[textIndex]);
    }
        public void increaseIndexNames(){
            textIndex +=1;
        }
    public boolean areTextFieldsAbleToOperate(){
        try {
            if(firstOperand.getText().matches("\\d+") && secondOperand.getText().matches("\\d+")) return  true;
        }catch(NullPointerException e){
            return false;
        }
        return false;
    }

    public double resultValue(String operandAsText){
        Double firstDoubleOperandValue = Double.parseDouble(firstOperand.getText());
        Double secondDoubleOperandValue = Double.parseDouble(secondOperand.getText());

        return switch (operandAsText) {
            case "Add" -> firstDoubleOperandValue + secondDoubleOperandValue;
            case "Subtract" -> firstDoubleOperandValue - secondDoubleOperandValue;
            case "Multiply" -> firstDoubleOperandValue * secondDoubleOperandValue;
            default -> firstDoubleOperandValue / secondDoubleOperandValue;
        };

    }

    private void updateResultValue(ActionEvent event) {
        if (areTextFieldsAbleToOperate()) {
            Button clickedButton = (Button) event.getSource();
            String operandText = clickedButton.getText();
            double calculatedResult = resultValue(operandText);
            result.setText(String.valueOf(calculatedResult));
            result.setDisable(false);

        } else {
            result.setText("INVALID VALUES");
            result.setDisable(true);
        }

    }
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Calculator");

        VBox layout = new VBox(20);
        HBox firstOperandBox = textAndLabel("First Operand: ", firstOperand);
        HBox secondOperandBox = textAndLabel("Second Operand: ", secondOperand);
        HBox buttonsBox = placeButtonBox();
        HBox resultBox = textAndLabel("Result: ", result);


        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(firstOperandBox, secondOperandBox, buttonsBox, resultBox);

        add.setOnAction(this::updateResultValue);
        subtract.setOnAction(this::updateResultValue);
        multiply.setOnAction(this::updateResultValue);
        divide.setOnAction(this::updateResultValue);

        Scene scene = new Scene(layout,250,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}