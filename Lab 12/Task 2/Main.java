public class Main {
    public static void main(String[] args) {
        PlayList pakistaniPlaylist = new PlayList();

        pakistaniPlaylist.addSong(new Song("Pasoori", "Ali Sethi & Shae Gill"));
        pakistaniPlaylist.addSong(new Song("Afreen Afreen", "Rahat Fateh Ali Khan & Momina Mustehsan"));
        pakistaniPlaylist.addSong(new Song("Tajdar-e-Haram", "Atif Aslam"));
        pakistaniPlaylist.addSong(new Song("Dil Dil Pakistan", "Vital Signs"));
        pakistaniPlaylist.addSong(new Song("Pee Jaun", "Farhan Saeed & Momina Mustehsan"));
        pakistaniPlaylist.addSong(new Song("Sajni", "Strings"));

        System.out.println("\n");

        System.out.println("Pakistani Playlist (Forward):");
        SongIterator forward = pakistaniPlaylist.iterator();
        while (forward.hasNext()) {
            System.out.println(forward.next());
        }

        System.out.println("\n");

        System.out.println("\nPakistani Playlist (Reverse):");
        SongIterator reverse = pakistaniPlaylist.reverseIterator();
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }
    }
}
