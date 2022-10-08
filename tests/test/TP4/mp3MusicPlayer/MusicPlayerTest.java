package TP4.mp3MusicPlayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {

    final String filename = System.getProperty("user.dir") + "/resources/audio/" + "BigBillBroonzy-BabyPleaseDontGo1.mp3";

    @Test
    void playSampleKnownTest() throws NonAvailableFileException {
        MusicPlayer mp = new MusicPlayer();
        //Not easy to test it in an automatic way !
        mp.playSample(filename, 500);
    }
    @Test
    void playSampleUnknownFileTest() {
        MusicPlayer mp = new MusicPlayer();
        assertThrows(NonAvailableFileException.class, ()-> mp.playSample("unknown.mp3", 500));
        assertThrows(NonAvailableFileException.class, ()-> mp.playSample("unknown", 500));
    }

    @Test
    void startPlayingUnknownFileTest() {
        MusicPlayer mp = new MusicPlayer();
        assertThrows(NonAvailableFileException.class, ()-> mp.startPlaying("unknown.mp3"));
    }

}