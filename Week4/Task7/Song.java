package Week4.Task7;

public class Song implements java.io.Serializable {
    // Datafields
    private String name;
    private String songName;
    private int timesPlayed;

    // Task8 (Data fields)
    private int review;
    private String textReview;

    // static variable to keep track of songs #
    private static int songsNumber = 0;

    public Song(String newName, String newSongName, int i) {
        this.name = newName;
        this.songName = newSongName;
        this.timesPlayed = i;
        songsNumber += 1; // once a constructor is created through object creation increase songsNumber
        review = 0;
    }

    
    Song() {
        songsNumber += 1; // once a constructor is created through object creation increase songsNumber
        review = 0;
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

    // Task 8
    public int getReview() {
        return review;
    }

    public void setReview(int newReview) {
        if (review >= 0 && review <= 5) {
            review = newReview;
        } else {
            System.out.println("Please enter a valid review (from 0 to 5).");
        }
    }

    public String getTextReview() {
        return textReview;
    }

    public void setTextReview(String newTextReview) {
        textReview = newTextReview;
    }

    public String toString() {
        if (review == 0 && textReview == null) {
            return "Artist:" + name + " | Song:" + songName + " | TimesPlayed: " + timesPlayed;
        } else {
            return "Artist:" + name + " | Song:" + songName + " | TimesPlayed: " + timesPlayed + " | Review:" + review
                    + " - " + textReview;
        }

    }
}
