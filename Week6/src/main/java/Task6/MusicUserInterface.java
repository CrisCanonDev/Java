package Task6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class MusicUserInterface extends Application {
    private ArrayList<Song> songsPlaylist = new ArrayList<>();
    Button listAllSongs = new Button("List of songs"), random = new Button("Random"), mostPlayed = new Button("Most Played Song"), play = new Button("Play a song"), stop  = new Button("Stop a song");
    Song currentSong;
    Label songsInformation = new Label();

    public void defaultSettings(HBox layout, Stage primaryStage){
        random.setDisable(false);
        mostPlayed.setDisable(false);
        play.setDisable(true);
        stop.setDisable(true);
        listAllSongs.setDisable(false);
        primaryStage.setTitle("Playlist Application");
        songsInformation.setText("Welcome!");
        layout.setBackground(new Background(new BackgroundFill(Color.WHEAT,null, null)));

    }

    static void getSongsText(ArrayList<Song> x) {
        // ArrayList<Song> songsArrayList = new ArrayList<Song>();
        try {
            File f = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week6\\src\\main\\java\\Task6\\songs.txt");
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String nline = line.trim();
                if (!nline.isEmpty()) {
                    int parameter = nline.indexOf("(");
                    String paraSubstring = nline.substring(parameter + 1, nline.length() - 2);
                    System.out.println(paraSubstring);
                    String[] param = paraSubstring.split(",");
                    int le = param.length;
                    System.out.println(le);
                    if (le >= 2) {
                        Song nSong = new Song();
                        String songName = (param[0].substring(1, param[0].length() - 1)).trim();
                        String songArtist = (param[1].substring(2, param[1].length() - 1)).trim();
                        nSong.setName(songArtist);
                        nSong.setSongName(songName);

                        if (param.length == 3) {
                            String timesPlayed = (param[2].substring(1, param[2].length())).trim();
                            if (timesPlayed.startsWith("\"")) {
                                timesPlayed = timesPlayed.replace("\"", "");
                                timesPlayed = timesPlayed.replaceAll("\\s+", "");
                            }
                            nSong.setTimesPlayed(Integer.parseInt(timesPlayed));
                        }
                        x.add(nSong);
                    }
                    if (le <= 1) {
                        break;
                    }
                }
            }
            System.out.println("Songs text File obtained and added to array list.");
            reader.close();

        } catch (IOException e) {
            System.out.println("Unable to find file");
        }
    }

    private static boolean fileExists() {
        Path filePath = Paths.get("SongsData.data");
        return Files.exists(filePath);
    }
    public void serialization_read(){
        if (fileExists()) {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("SongsData.data"));
                songsPlaylist = (ArrayList<Song>) input.readObject();
                input.close();
            } catch (FileNotFoundException fnf) {
                System.out.println("The file cannot be found. Please check file's name");
            } catch (Exception ioe) {
                System.out.println(ioe);
            }
        } else {
            System.out.println("FILE DOES NOT EXISTS");
            getSongsText(songsPlaylist);
        }

        serialization_write(songsPlaylist);
    }
    static void serialization_write(ArrayList<Song> x) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("SongsData.data", true));

            output.writeObject(x);
            output.close();
            System.out.println("Serialization made successfully.");

        } catch (IOException ioe) {
            System.out.println("Error ocurred during serialization: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }



    public void listAllSongs() {
        // Implementation
        System.out.println("---List of Songs---");
        if (songsPlaylist.isEmpty()) {
            System.out.println("The music library is empty.");
        } else {
            for (int x = 0; x < songsPlaylist.size(); x++) {
                Song s = songsPlaylist.get(x);
                System.out.println("SONG " + (x + 1) + ": " + s.toString());
            }
        }
    }
    public void setLabelSongInformation(){
        songsInformation.setText(getSong().toString());
    }

    public void randomSong(ActionEvent event) {
        setLabelSongInformation();
        play.setDisable(false);
    }
    public int getRandomIndexFromPlaylist(){
        Random rn = new Random();
        int lengthIndexMusicLibrary = songsPlaylist.size() - 1;
        return rn.nextInt(lengthIndexMusicLibrary);

    }
    public Song getSong(){
        currentSong = songsPlaylist.get(getRandomIndexFromPlaylist());
        return currentSong;
    }
    public void mostPlayed(ActionEvent event){
        songsInformation.setText(findMostPlayedSong());
    }

    public String findMostPlayedSong() {
        // Implementation
        System.out.println("---Finding the most played song---");
        int highestTimesPlayed = 0;
        int indexHighestTimesSong = 0;
        for (int x = 0; x < songsPlaylist.size(); x++) {
            Song currentSong = songsPlaylist.get(x);
            int currentTimesPlayed = currentSong.getTimesPlayed();
            if (currentTimesPlayed > highestTimesPlayed) {
                indexHighestTimesSong = x;
                highestTimesPlayed = currentTimesPlayed;
            }
        }
        Song songHighest = songsPlaylist.get(indexHighestTimesSong);
        return ("The song that has been played the most is: " + songHighest.toString());
    }

    public static void changeTitle(Stage stage, String newTitle){
        stage.setTitle("Playing "+ newTitle);
    }
    private Color generateRandomColor() {
        Random rand = new Random();
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    private String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public void changeBackgroundColor(HBox layout){
        layout.setBackground(new Background(new BackgroundFill(generateRandomColor(), null, null)));
    }

    public VBox setTextLayout(){

        VBox labelInformationLayout = new VBox();
        labelInformationLayout.setAlignment(Pos.CENTER);
        labelInformationLayout.setSpacing(10);
        labelInformationLayout.getChildren().add(songsInformation);
        return labelInformationLayout;
    }
    public VBox setButtonsLayout(){
        VBox buttonsLayout = new VBox();
        buttonsLayout.setAlignment(Pos.CENTER_LEFT);
        buttonsLayout.setSpacing(10);
        buttonsLayout.getChildren().addAll(listAllSongs, random, mostPlayed, play, stop);
        return buttonsLayout;
    }
    @Override
    public void start(Stage primaryStage) {
        VBox buttonLayout = setButtonsLayout();
        VBox textLayout  = setTextLayout();

        HBox mainLayout = new HBox(buttonLayout, textLayout);
        Scene scene = new Scene(mainLayout,750,300);

        serialization_read();
        listAllSongs();

        defaultSettings(mainLayout, primaryStage);

        listAllSongs.setOnAction(event -> listAllSongs(primaryStage));
        random.setOnAction(this::randomSong);
        mostPlayed.setOnAction(this::mostPlayed);

        play.setOnAction(event ->{
            String songName = currentSong.getSongName();
            currentSong.setTimesPlayed(currentSong.getTimesPlayed()+1);
            songsInformation.setText(currentSong.toString());
            changeTitle(primaryStage, songName);
            changeBackgroundColor(mainLayout);
            random.setDisable(true);
            mostPlayed.setDisable(true);
            stop.setDisable(false);
        });

        stop.setOnAction(event -> {
            defaultSettings(mainLayout, primaryStage);

        }
        );

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


    private void listAllSongs(Stage primaryStage) {
        // Display list of songs in a new window
        ListView<String> listView = new ListView<>();
        for (Song song : songsPlaylist) {
            listView.getItems().add(song.toString());
        }
        VBox vBox = new VBox(listView);
        Scene scene = new Scene(vBox, 300, 250);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("List of Songs");
        stage.initOwner(primaryStage);
        stage.show();
    }
}
