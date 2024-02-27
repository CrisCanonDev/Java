package Task6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DisplayInBarChart extends Application {
    VBox mainLayout = new VBox();
    String fileAsText ="";
    Button btnView = new Button("View");
    TextField textField = new TextField();
    ArrayList<Double> countArray = new ArrayList<>(26);
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();

    public void setAxes() {
        yAxis.setTickUnit(1.0);
    }

    BarChart<String, Number> barChart;
    XYChart.Series<String, Number> series = new XYChart.Series<>();

    public void getTextFromTextFile(String fileName){
        try {
            fileAsText = "";
            File file = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week7\\src\\main\\java\\Task6\\"+fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.equals(null)) {
                    fileAsText += data+"\n";
                }
            }
            myReader.close();
            isFileFound(true);
        }
        catch (FileNotFoundException E){
            System.out.println("The file does not exist.");
            isFileFound(false);
        }
    }
    public HBox fileNameSection(){
        Label label = new Label("Filename");
        label.setMinWidth(mainLayout.getWidth()/4);

        textField.setMinWidth(mainLayout.getWidth()/2);
        btnView.setMinWidth(mainLayout.getWidth()/4);
        return new HBox(label,textField,btnView);
    }

    private void isFileFound(boolean  fileFound) {
        if(fileFound) setBarChart();
        else series.getData();
    }
    public void settingLetterOccurrences(String textInputted) {
        String inputText = textInputted.toLowerCase();
        countArray.clear();

        for(int i=0; i< 26;i++){
            countArray.add(0.0);
        }
        for (char ch : inputText.toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = ch - 'a';
                countArray.set(index, countArray.get(index)+1);
            }
        }
    }
    public void enteringDataToBartChart() {
        for(int i=0; i<countArray.size(); i++){
            char c = (char) ('a' +i);
            series.getData().add(new XYChart.Data<>(String.valueOf(c), countArray.get(i)));
            System.out.println(countArray.get(i));
        }
    }
    public void setBarChart(){
        settingLetterOccurrences(fileAsText);
        enteringDataToBartChart();

        barChart.getData().clear();
        barChart.getData().add(series);
        double maxValue = Collections.max(countArray);

        // Set the upper bound of the Y-axis to the maximum value plus a buffer
        yAxis.setAutoRanging(false); // Disable auto-ranging to allow manual setting of bounds
        yAxis.setUpperBound(maxValue + 1); // Set the upper bound with a buffer

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        setAxes();
        barChart = new BarChart<>(xAxis, yAxis);
        setBarChart();

        mainLayout.getChildren().addAll(barChart,fileNameSection());

        btnView.setOnAction(event -> {
            getTextFromTextFile(textField.getText());
            System.out.println(countArray);
        });

        primaryStage.setTitle("Display BarCharts");
        Scene scene = new Scene(mainLayout, 1000,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
