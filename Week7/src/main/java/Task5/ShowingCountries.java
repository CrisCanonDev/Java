package Task5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ShowingCountries extends Application implements java.io.Serializable {
    ArrayList<Country> listOfCountries = new ArrayList<>();
    ObservableList<Country> observableListOfCountries;


    public ObservableList<Country> filterByContinent(String continent){
        ObservableList<Country> filtered = FXCollections.observableArrayList();
        for (Country country : observableListOfCountries){
            if(country.getContinent().equals(continent)){
                filtered.add(country);
            }
        }
        return filtered;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        serialize_read();
        observableListOfCountries = FXCollections.observableArrayList(listOfCountries);
        TableView<Country> tableView = new TableView<>();
        tableView.setItems(observableListOfCountries);

        TableColumn<Country, String> countryName = new TableColumn<>("Name");
        countryName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Country, Integer> countryPopulation = new TableColumn<>("Population");
        countryPopulation.setCellValueFactory(new PropertyValueFactory<>("population"));

        TableColumn<Country, String> countryContinent = new TableColumn<>("Continent");
        countryContinent.setCellValueFactory(new PropertyValueFactory<>("continent"));

        tableView.getColumns().addAll(countryName, countryContinent, countryPopulation);


        ComboBox<String> filterComboBox = new ComboBox<>();
        filterComboBox.getItems().addAll("All","Asia","Africa","Europe","Oceania","Antarctica","North America","South America");
        filterComboBox.setValue("All");

        filterComboBox.setOnAction(event -> {
            String selectedContinent =filterComboBox.getValue();
            if(selectedContinent.equals("All")){
                tableView.setItems(observableListOfCountries);
            }else{
                tableView.setItems(filterByContinent(selectedContinent));
            }
        });

        VBox root = new VBox(filterComboBox,tableView);

        primaryStage.setTitle("Showing information");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public void serialize_read() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("countriesData.data"));
            listOfCountries = (ArrayList<Country>) input.readObject();
            input.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("The file cannot be found. Please check file's name");
        } catch (Exception ioe) {
            System.out.println("ss" + ioe);
        }
    }
}
