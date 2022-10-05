package TP4.mp3MusicPlayer.V2;

import TP4.mp3MusicPlayer.V2.exceptions.IndicePisteInvalideException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerTest {

    @Test
    void whenExceptionThrown_thenAssertionSucceeds() {
        Organizer organizer = new Organizer();
        assertThrows(IndicePisteInvalideException.class, () -> {
            organizer.jouerUnMorceauEnregistre(0);
        });
        assertThrows(IndicePisteInvalideException.class, () -> {
            organizer.jouerUnMorceauEnregistre(1);
        });
    }

}