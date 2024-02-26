package Task6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayTextFile extends Application {
    VBox mainLayout = new VBox();
    String fileAsText = "";
    Button viewFile = new Button("View");
    TextArea textArea = new TextArea();
    TextField textField = new TextField();
    public void getTextFromTextFile(String fileName){
        try {
            System.out.println("hola");
            File file = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week7\\src\\main\\java\\Task6\\"+fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.equals(null)) fileAsText += data+"\n";
            }
            myReader.close();
            isFileFound(true);
        }
        catch (FileNotFoundException E){
            System.out.println("The file does not exist.");
            isFileFound(false);
        }
    }

    private void isFileFound(boolean fileFound) {
        if(fileFound) addTextFileInTextArea();
        else textArea.setText("FILE HAS BEEN NOT FOUND.");
    }

    public void addTextFileInTextArea(){
        textArea.setText(fileAsText);
    }
    public HBox fileNameSection(){
        Label label = new Label("Filename");
        label.setMinWidth(mainLayout.getWidth()/4);

        textField.setMinWidth(mainLayout.getWidth()/2);
        viewFile.setMinWidth(mainLayout.getWidth()/4);
        return new HBox(label,textField,viewFile);
    }
    public void setMainLayout(){
        mainLayout.setMinWidth(400);
        mainLayout.setMaxWidth(400);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        setMainLayout();
        textArea.setMinWidth(mainLayout.getWidth());
        textArea.setMinHeight(mainLayout.getHeight() - (mainLayout.getHeight()/5));

        viewFile.setOnAction(event ->  getTextFromTextFile(textField.getText()));


        mainLayout.getChildren().addAll(textArea, fileNameSection());
        primaryStage.setTitle("Display a text.txt file");
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
