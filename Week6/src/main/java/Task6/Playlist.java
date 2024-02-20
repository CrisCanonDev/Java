package Task6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    // Array to keep songs
    private ArrayList<Song> songsP = new ArrayList<>();

    // Constructor to define a songs into every arrays' index position
    public Playlist() {
        if (fileExists()) {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("songdata.data"));
                songsP = (ArrayList<Song>) input.readObject();
                input.close();
            } catch (FileNotFoundException fnf) {
                System.out.println("The file cannot be found. Please check file's name");
            } catch (Exception ioe) {
                System.out.println(ioe);
            }
        } else {
            System.out.println("FILE DOES NOT EXISTS");
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
    // (1)

    static void serialization_write(ArrayList<Song> x) {
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
