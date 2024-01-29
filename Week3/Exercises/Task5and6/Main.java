package Week3.Exercises.Task5and6;

public class Main implements java.io.Serializable{
    public static void main(String[] args) {

        // Playlist class creation as a object
        Playlist songs = new Playlist();

        // Songs objects creation
        Song s1 = new Song("Michael Jackson", "Billie Jean", 10);
        Song s2 = new Song("U2", "One", 12);

        // Saving songs in playlist list.
        songs.setSong(s1, 0);
        songs.setSong(s2, 1);

        // Getting songs from playlist
        Song s1Get = songs.getSong(0);
        Song s2Get = songs.getSong(1);

        System.out.println("Song1: " + s1Get.getName() + ", " + s1Get.getSongName() + ", and played "
                + s1Get.getTimesPlayed() + " times.");
        System.out.println("Song2: " + s2Get.getName() + ", " + s1Get.getSongName() + ", and played "
                + s2Get.getTimesPlayed() + " times.");

        // Task6
        // Retrieving songsNumber via its get method (pointing class instead of an
        // instance)
        System.out.println(Song.getNumberOfSongs());
    }
}
