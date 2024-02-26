package Task6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayInBarChart extends Application {

    String fileAsText ="";
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

    private void isFileFound(boolean foundBoolean) {
        if(foundBoolean){

        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Display BarCharts");
        Scene scene = new Scene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
