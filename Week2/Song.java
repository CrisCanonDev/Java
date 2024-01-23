package Week2;

public class Song {
    private String name;
    private String songName;
    private int timesPlayed;

    Song(String newName, String newSongName, int newTimesPlayed) { 
        name = newName;
        songName = newSongName;
        timesPlayed = newTimesPlayed;
    }
    Song(){
    }

    public static void main(String[] args) {
        Song s = new Song();
        s.setName("Michael Jackson");
        s.setSongName("Billie Jean");
        s.setTimesPlayed(10);

        Song s1 = new Song();
        s1.setName("U2");
        s1.setSongName("One");
        s1.setTimesPlayed(20);
        
        Song s2 = new Song();
        s2.setName("John Lennon");
        s2.setSongName("Imagine");
        s2.setTimesPlayed(123);
                
        System.out.println(s.getName()+" "+s.getSongName() +" "+s.getTimesPlayed());
        System.out.println(s1.getName()+" "+s1.getSongName() +" "+s1.getTimesPlayed());
        System.out.println(s2.getName()+" "+s2.getSongName() +" "+s2.getTimesPlayed());




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
