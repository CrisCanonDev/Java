package Task5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Countries extends Application implements java.io.Serializable {
    public VBox mainLayout = new VBox();
    TextField countryName = new TextField(), countryPopulation = new TextField();
    public ArrayList<String> continents = new ArrayList<>(List.of("Asia","Africa","Europe","Oceania","Antarctica","North America","South America"));
    ComboBox comboBoxContinents = new ComboBox<>(FXCollections.observableArrayList(continents));

    public ArrayList<Country> listOfCountries = new ArrayList<Country>();

    Button addCountry = new Button("Add");
    public Label setLabel(String nameLabel){
        Label label = new Label(nameLabel);
        label.setMinWidth(80);
        return  label;
    }
    public TextField setTextField(TextField name){
        name.setMinWidth(120);
        return  name;
    }
    public HBox setLabelAndTextField(String name, TextField textField){
        HBox hBox = new HBox(setLabel(name), setTextField(textField));
        hBox.setPadding(new Insets(10,0,10,0));
        return hBox;
    }
    public HBox setComboBoxOfContinents(){
        comboBoxContinents.setMinWidth(150);
        HBox hbox= new HBox(setLabel("Continents"),comboBoxContinents);
        hbox.setPadding(new Insets(10,0,10,0));
        return hbox;
    }
    public Button setButtonToAddCountry(){
        addCountry.setMinWidth(120);
        return addCountry;
    }

    public void setObjectsInLayout(){
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(setLabelAndTextField("Name", countryName), setLabelAndTextField("Population", countryPopulation), setComboBoxOfContinents(), setButtonToAddCountry());
    }
    private void checkTextFieldDataType(ActionEvent event) {
        Boolean iscountryNameValid = isDataTypeCorrect(countryName, "[a-zA-Z]+");
        Boolean iscountryPopulationValid = isDataTypeCorrect(countryPopulation, "\\d+");
        Boolean isContinentValid = checkComboBox();
        if(iscountryNameValid && iscountryPopulationValid && isContinentValid){
           addNewCountryToList( setNewCountry() );
           serialize_write(listOfCountries);
        }
    }
    public Country setNewCountry(){
        Country newCountry = new Country();
        newCountry.setName(countryName.getText().strip());
        newCountry.setPopulation(Integer.parseInt(countryPopulation.getText().strip()));
        newCountry.setContinent((String) comboBoxContinents.getValue());
        return  newCountry;
    }
    public void addNewCountryToList(Country newCountry){
        listOfCountries.add(newCountry);
    }
    private Boolean checkComboBox() {
        if(comboBoxContinents.getValue() != null) return true;
        return false;
    }

    private boolean isDataTypeCorrect(TextField textField, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textField.getText().strip());
        return  matcher.matches();
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Countries");
        setObjectsInLayout();


        addCountry.setOnAction(this::checkTextFieldDataType);
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }

    public void serialize_write(ArrayList<Country> countries){
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("countriesData.data"));
            output.writeObject(countries);
            output.close();
            System.out.println("Serialization made successfully.");

        } catch (IOException ioe) {
            System.out.println("Error ocurred during serialization: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public ArrayList<Country> serialize_read(){
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("countriesData.data"));
            input.close();
            return  (ArrayList<Country>) input.readObject();
        } catch (FileNotFoundException fnf) {
            System.out.println("The file cannot be found. Please check file's name");
        } catch (Exception ioe) {
            System.out.println(ioe);
        }
        return null;
    }
}
