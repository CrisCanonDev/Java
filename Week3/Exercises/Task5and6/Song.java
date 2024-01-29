package Week3.Exercises.Task5and6;

public class Song implements java.io.Serializable{
    //Datafields
    private String name;
    private String songName;
    private int timesPlayed;

    //static variable to keep track of songs #
    private static int songsNumber = 0 ; 

    public Song(String newName, String newSongName, int newTimesPlayed) {
        this.name = newName;
        this.songName = newSongName;
        this.timesPlayed = newTimesPlayed;
        songsNumber += 1; //once a constructor is created through object creation increase songsNumber
    }

    Song() {
        songsNumber += 1;; //once a constructor is created through object creation increase songsNumber
    }

    static int getNumberOfSongs(){
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
