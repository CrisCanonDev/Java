package Task3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Questtionarie extends Application {
    VBox questionLayout = new VBox();

    ArrayList<ToggleGroup> groups = new ArrayList<>();
    ArrayList<MultipleChoiceQuestions> bankOfQuestions = new ArrayList<>();

    public VBox showingFullQuestion(MultipleChoiceQuestions MCQ) {
        Label question = new Label(MCQ.getQuestion());
        ToggleGroup group = new ToggleGroup();

        RadioButton option1 = new RadioButton(MCQ.getOption1());
        option1.setId("1");
        RadioButton option2 = new RadioButton(MCQ.getOption2());
        option2.setId("2");
        RadioButton option3 = new RadioButton(MCQ.getOption3());
        option3.setId("3");

        option1.setToggleGroup(group);
        option2.setToggleGroup(group);
        option3.setToggleGroup(group);
        groups.add(group);



        VBox questionBox = new VBox(question, option1, option2, option3);
        questionBox.setAlignment(Pos.CENTER_LEFT);
        questionBox.setSpacing(2);
        return questionBox;
    }

    private void checkAnswer() {
        for (int i=0; i<groups.size();i++) {
            ToggleGroup currentGroup = groups.get(i);
            ObservableList<Toggle> toggle = currentGroup.getToggles();
            resetRadioButton(currentGroup);
            MultipleChoiceQuestions question = bankOfQuestions.get(i);
            for(int j=0; j<toggle.size();j++){
                RadioButton answerRadioButton = (RadioButton) toggle.get(j);
                int idAnswer = Integer.parseInt(answerRadioButton.getId());
                if(answerRadioButton.isSelected()){
                    if(idAnswer == question.getCorrect()) notifyUserAnswer(true, answerRadioButton);
                    else notifyUserAnswer(false,answerRadioButton);
                }
            }
        }
    }

    public void resetRadioButton(ToggleGroup group){
        ObservableList<Toggle> toggles = group.getToggles();
        for (int i=0;i< toggles.size(); i++){
            RadioButton current = (RadioButton) toggles.get(i);
            current.setTextFill(Color.BLACK);
        }
    }
    public void notifyUserAnswer(boolean correctAnswered, RadioButton radioButton){
        if(correctAnswered) radioButton.setTextFill(Color.GREEN);
        else radioButton.setTextFill(Color.RED);

    }
    public void placingQuestionsInStage() {
        for (MultipleChoiceQuestions question : bankOfQuestions) {
            VBox newQ = showingFullQuestion(question);
            questionLayout.getChildren().add(newQ);
        }
    }
    public void checkingButton() {
        Button checkingQuestion = new Button("Check");
        checkingQuestion.setOnAction(e -> checkAnswer());
        questionLayout.getChildren().add(checkingQuestion);
    }
    @Override
    public void start(Stage primaryStage) {
        questionLayout.setSpacing(20);
        MultipleChoiceQuestions MCQ1 = new MultipleChoiceQuestions("What is the capital of Fiji?", "Joensuu", "Suva", "New york", 2);
        bankOfQuestions.add(MCQ1);
        MultipleChoiceQuestions MCQ2 = new MultipleChoiceQuestions("What is the capital of Colombia?", "Caracas", "Bogota", "La Paz", 1);
        bankOfQuestions.add(MCQ2);
        MultipleChoiceQuestions MCQ3 = new MultipleChoiceQuestions("What is the capital of Brazil?", "Brasilia", "Rio de Janeiro", "Sao Paulo", 3);
        bankOfQuestions.add(MCQ3);
        placingQuestionsInStage();

        checkingButton();

        primaryStage.setTitle("Questtionarie");
        Scene scene = new Scene(questionLayout, 200, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}