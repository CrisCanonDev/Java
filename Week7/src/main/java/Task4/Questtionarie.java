package Task4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
            System.out.println(question.getCorrect());
            VBox newQ = showingFullQuestion(question);
            questionLayout.getChildren().add(newQ);
        }
    }
    public void checkingButton() {
        Button checkingQuestion = new Button("Check");
        checkingQuestion.setOnAction(e -> checkAnswer());
        questionLayout.getChildren().add(checkingQuestion);
    }

    public void assigningQuestionToObject(String[] split){
        MultipleChoiceQuestions MCQ = new MultipleChoiceQuestions();
        MCQ.setQuestion(split[0].strip());
        MCQ.setOption1(split[1].strip());
        MCQ.setOption2(split[2].strip());
        MCQ.setOption3(split[3].strip());
        MCQ.setCorrect(Integer.parseInt(split[4].strip()));

        bankOfQuestions.add(MCQ);
    }
    public void placeQuestionFromTextFile(){
        extractQuestionsFromFile file = new extractQuestionsFromFile();
        ArrayList<String> fullQuestions =  file.getQuestionsPlainList();
        for (String question:fullQuestions){
            assigningQuestionToObject(question.split(","));


        }
    }
    @Override
    public void start(Stage primaryStage) {
        placeQuestionFromTextFile();
        questionLayout.setSpacing(20);
        questionLayout.setPadding(new Insets(10));

        placingQuestionsInStage();

        checkingButton();

        primaryStage.setTitle("Questtionarie");
        Scene scene = new Scene(questionLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}