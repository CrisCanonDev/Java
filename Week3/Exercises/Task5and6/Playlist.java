package Week3.Exercises.Task5and6;

public class Playlist {
    // Array to keep songs
    private Song[] songs;

    // Constructor to define a songs into every arrays' index position
    public Playlist() {
        songs = new Song[10];
        for (int x = 0; x > songs.length; x++) {
            songs[x] = new Song();
        }
    }

    // Setters and getters to append songs into array and return song's information
    // from it.
    public void setSong(Song s, int index) {
        if (index < 10) {
            songs[index] = s;
            // System.out.println("Songs succesfully appended to playlist!");
        } else {
            // Trying to insert songs in a non-valid index.
            System.out.println("The index position you were trying to append the songs is out of bounds.");
        }
    }

    public Song getSong(int index) {
        if (index < 10) {
            return songs[index];
        } else {
            return songs[0];
        }
    }
}
