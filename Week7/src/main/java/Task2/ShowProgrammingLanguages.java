package Task2;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowProgrammingLanguages extends Application {
    ListView listViewOfProgramming = new ListView<>();
    TextArea textToPresentLanguages = new TextArea();
    ArrayList<String> fileText = new ArrayList<>();
    public void getProgrammingFromTextFile(){
        try {
            File file = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week7\\src\\main\\java\\Task2\\programmingLanguages.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileText.add(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException E){
            System.out.println("The file does not exist.");
        }
    }
    public void addingLanguagesToListView(){
        for(String programmingLanguage: fileText){
            listViewOfProgramming.getItems().add(programmingLanguage);
        }
    }
    public void setListViewInLayout(){
        listViewOfProgramming.setMinWidth(80);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setListViewInLayout();
        getProgrammingFromTextFile();
        addingLanguagesToListView();
        listViewOfProgramming.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        listViewOfProgramming.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            ObservableList<String> selectedLanguages = listViewOfProgramming.getSelectionModel().getSelectedItems();
            String programmingLanguages = String.join(", ", selectedLanguages);
            textToPresentLanguages.setText("You have selected: "+ programmingLanguages);

        });

        HBox layout = new HBox();
        layout.getChildren().addAll(listViewOfProgramming, textToPresentLanguages);

        Scene scene = new Scene(layout,400,400);
        primaryStage.setTitle("Programming Languages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
