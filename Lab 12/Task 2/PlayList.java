import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public SongIterator iterator() {
        return new ForwardIterator();
    }

    public SongIterator reverseIterator() {
        return new ReverseIterator();
    }

    // --- Forward Iterator ---
    private class ForwardIterator implements SongIterator {
        private int index = 0;

        public boolean hasNext() {
            return index < songs.size();
        }

        public Song next() {
            return songs.get(index++);
        }
    }

    // --- Reverse Iterator (Bonus) ---
    private class ReverseIterator implements SongIterator {
        private int index = songs.size() - 1;

        public boolean hasNext() {
            return index >= 0;
        }

        public Song next() {
            return songs.get(index--);
        }
    }
}

