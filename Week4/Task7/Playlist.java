package Week4.Task7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playlist {
    // Array to keep songs
    private ArrayList<Song> songsP = new ArrayList<>();

    // Constructor to define a songs into every arrays' index position
    public Playlist() {
        // songs = new Song[10];
        // for (int x = 0; x > songs.length; x++) {
        // songs[x] = new Song();
        // }
        if (fileExists()) {
            System.out.println("FILE EXISTS");
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("songdata.data"));
                // Song[] vArray = (Song[]) (input.readObject());
                songsP = (ArrayList<Song>) input.readObject();
                // songsP = new ArrayList<>(List.of(vArray));
                input.close();
            } catch (FileNotFoundException fnf) {
                System.out.println("The file cannot be found. Please check file's name");
            } catch (Exception ioe) {
                System.out.println(ioe);
            }
        } else {
            System.out.println("FILE DOES NOT EXISTS");
            getSongsText(songsP);
        }

        serialization_write(songsP);
    }

    private static boolean fileExists() {
        Path filePath = Paths.get("songdata.data");
        return Files.exists(filePath);
    }

    // Setters and getters to append songs into array and return song's information
    // from it.
    public void setSong(Song s, int index) {
        if (index < songsP.size() - 1) {
            songsP.set(index, s);
            // System.out.println("Songs succesfully appended to playlist!");
        } else {
            // Trying to insert songs in a non-valid index.
            System.out.println("The index position you were trying to append the songs is out of bounds.");
        }
    }

    public Song getSong(int index) {
        if (index < songsP.size() - 1) {
            return songsP.get(index);
        } else {
            return songsP.get(0);
        }
    }

    // Task7
    static void getSongsText(ArrayList<Song> x) {
        // ArrayList<Song> songsArrayList = new ArrayList<Song>();
        try {
            File f = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week4\\Task7\\songs.txt");
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

        } catch (

        IOException e) {
            System.out.println("Unable to find file");
        }

    }

    public static void serialization_write(ArrayList<Song> x) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("songdata.data", true));

            output.writeObject(x);
            output.close();
            System.out.println("Serialization made successfully.");

        } catch (IOException ioe) {
            System.out.println("Error ocurred during serialization: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    // task8
    public ArrayList<Song> getPlaylist() {
        return songsP;
    }

    public void appendSong(Song newSongForPlay) {
        songsP.add(newSongForPlay);
    }
}
