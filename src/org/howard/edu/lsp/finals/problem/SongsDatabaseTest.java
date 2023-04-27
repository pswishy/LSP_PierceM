package src.org.howard.edu.lsp.finals.problem;

import static org.junit.Assert.assertEquals;

import java.util.*;
import org.junit.*;

public class SongsDatabaseTest {

    private SongsDatabase db;

    @Test
    public void testGetSongs() {

        db = new SongsDatabase();
        db.addSong("R&B", "Wait For You");
        db.addSong("Rap", "Freestyle");
        db.addSong("Hip Hop", "Hypnotize");
        db.addSong("Country", "The Dance");
        db.addSong("Country", "Before He Cheats");


        Set<String> expected_rap = new HashSet<String>();
        expected_rap.add("Freestyle");
        assertEquals(expected_rap, db.getSongs("Rap"));

        Set<String> expected_gospel = new HashSet<String>();
        assertEquals(expected_gospel, db.getSongs("Gospel")); // Should return Empty Set 

        Set<String> expected_country = new HashSet<String>();
        expected_country.add("The Dance");
        expected_country.add("Before He Cheats");
        assertEquals(expected_country, db.getSongs("Country")); // Should return Empty Set 
    }

    @Test
    public void testGetGenreOfSong() {
        db = new SongsDatabase();
        db.addSong("R&B", "Wait For You");
        db.addSong("Rap", "Freestyle");
        db.addSong("Hip Hop", "Hypnotize");
        db.addSong("Country", "The Dance");
        db.addSong("Country", "Before He Cheats");
        
        assertEquals("Rap", db.getGenreOfSong("Freestyle"));

        assertEquals("", db.getGenreOfSong("Fake Song Name"));


    }
}
