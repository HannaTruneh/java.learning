import java.util.ArrayList;
import java.util.List;


abstract class Song {
    String title;
    int duration;

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    abstract String songInfo();
}

class PopSong extends Song {
    String artist;

    public PopSong(String title, int duration, String artist) {
        super(title, duration);
        this.artist = artist;
    }

    @Override
    String songInfo() {
        return "Title: " + title + "\n" +
                "Duration: " + duration + " seconds\n" +
                "Artist: " + artist;
    }
}

class RockSong extends Song {
    boolean hasGuitarSolo;

    public RockSong(String title, int duration, boolean hasGuitarSolo) {
        super(title, duration);
        this.hasGuitarSolo = hasGuitarSolo;
    }

    @Override
    String songInfo() {
        String soloInfo = hasGuitarSolo ? "Yes" : "No";
        return "Title: " + title + "\n" +
                "Duration: " + duration + " seconds\n" +
                "Solo: " + soloInfo;
    }
}

interface User {
    String getName();

    void addSong(Song song);
}


class MusicUser implements User {
    private String name;
    private List<Song> songs;

    public MusicUser(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    void printSongs() {
        System.out.println("Songs of " + name + ":");
        for (Song song : songs) {
            System.out.println(song.songInfo());
            System.out.println("-------------------");
        }
    }
}

public class MusicDemo {
    public static void main(String[] args) {
        MusicUser user = new MusicUser("Alice");

        PopSong popSong = new PopSong("Shape of You", 240, "Ed Sheeran");
        RockSong rockSong = new RockSong("Bohemian Rhapsody", 354, false);

        user.addSong(popSong);
        user.addSong(rockSong);

        user.printSongs();
    }
}

