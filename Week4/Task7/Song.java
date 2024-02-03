package Week4.Task7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class Song implements java.io.Serializable {
    private static final boolean IOException = false;
    // Datafields
    private String name;
    private String songName;
    private int timesPlayed;

    // static variable to keep track of songs #
    private static int songsNumber = 0;

    public Song(String newName, String newSongName, int i) {
        this.name = newName;
        this.songName = newSongName;
        this.timesPlayed = i;
        songsNumber += 1; // once a constructor is created through object creation increase songsNumber
    }

    Song() {
        songsNumber += 1;
        ; // once a constructor is created through object creation increase songsNumber
    }

    static int getNumberOfSongs() {
        return songsNumber;
    }

    public String getName() {
        return name;
    }

    public String getSongName() {
        return songName;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    void setName(String newName) {
        name = newName;
    }

    void setSongName(String newSongName) {
        songName = newSongName;
    }

    void setTimesPlayed(int newTimesPlayed) {
        timesPlayed = newTimesPlayed;
    }

    


}
