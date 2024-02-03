package Week4.Task7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface MusicLibrary {
    void listAllSongs();

    void addNewSong(Scanner scanner);

    void removeSong(Scanner scanner);

    void findMostPlayedSong();
}

class MusicLibraryApp implements MusicLibrary {
    private ArrayList<Song> musicLibrary;

    public MusicLibraryApp(ArrayList<Song> musicLibrary) {
        this.musicLibrary = musicLibrary;
    }

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        // ArrayList<Song> musicLibrary = new ArrayList<>();
        MusicLibraryApp musicApp = new MusicLibraryApp(playlist.getPlaylist());
        musicApp.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------ Music Library Menu ------");
            System.out.println("1. List all songs");
            System.out.println("2. Add a new song");
            System.out.println("3. Remove a song");
            System.out.println("4. Find the most played song");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    listAllSongs();
                    break;
                case 2:
                    addNewSong(scanner);
                    break;
                case 3:
                    removeSong(scanner);
                    break;
                case 4:
                    findMostPlayedSong();
                    break;
                case 5:
                    serialization_write();
                    System.out.println("Exiting the Music Library. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void serialization_write() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("songdata.data"));
            output.writeObject(musicLibrary);
            output.close();
            System.out.println("Serialization made successfully.");

        } catch (IOException ioe) {
            System.out.println("Error ocurred during serialization: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    @Override
    public void listAllSongs() {
        // Implementation
        System.out.println("---List of Songs---");
        if (musicLibrary.isEmpty()) {
            System.out.println("The music library is empty.");
        } else {
            for (int x = 0; x < musicLibrary.size(); x++) {
                Song s = musicLibrary.get(x);
                System.out.println("SONG " + x + ": " + s.getName() + " " + s.getSongName() + " " + s.getTimesPlayed());
            }
        }
    }

    @Override
    public void addNewSong(Scanner scanner) {
        // Implementation
        System.out.println("---Adding a new song---");
        Song newSong = new Song();
        System.out.print("Enter a song name: ");
        String songName = scanner.nextLine();
        System.out.print("Enter a the artist of the song: ");
        String ArtistName = scanner.nextLine();
        System.out.print("Enter a times of song has been played: ");
        int songTimesPlayed = scanner.nextInt();

        newSong.setName(ArtistName);
        newSong.setSongName(songName);
        newSong.setTimesPlayed(songTimesPlayed);
        musicLibrary.add(newSong);
        System.out.println("Song added succesfully.");
    }

    @Override
    public void removeSong(Scanner scanner) {
        // Implementation
        System.out.println("---Removing a  song---");
        System.out.print("Enter the index value of Song  you want to delete: ");
        try {
            int indexOption = scanner.nextInt();
            musicLibrary.remove(indexOption);

        } catch (IndexOutOfBoundsException iobe) {
            // TODO: handle exception
            System.out.println("The index value is not in the ArrayList.");
        }

    }

    @Override
    public void findMostPlayedSong() {
        // Implementation
        System.out.println("---Finding the most played song---");
        int highestTimesPlayed = 0;
        int indexHighestTimesSong = 0;
        for (int x = 0; x < musicLibrary.size(); x++) {
            Song currentSong = musicLibrary.get(x);
            int currentTimesPlayed = currentSong.getTimesPlayed();
            if (currentTimesPlayed > highestTimesPlayed) {
                indexHighestTimesSong = x;
                highestTimesPlayed = currentTimesPlayed;
            }
        }
        Song songHighest = musicLibrary.get(indexHighestTimesSong);
        System.out.println("The song that has been played the most is: " + songHighest.getName() + ", played "
                + highestTimesPlayed + " times.");
    }
}
