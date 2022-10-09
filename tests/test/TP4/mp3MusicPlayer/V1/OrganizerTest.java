package TP4.mp3MusicPlayer.V1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrganizerTest {

    @Test
    void testPisteListSize() {
        Organizer organizer = new Organizer();
        organizer.pisteList.add(new Piste("toto", "/resources/toto.mp3"));
        organizer.pisteList.add(new Piste("titi", "/resources/titi.mp3"));
        assertEquals(2, organizer.getNombrePistesEnregistrees());
        organizer.pisteList.add(new Piste("tata", "/resources/tata.mp3"));
        assertEquals(3, organizer.getNombrePistesEnregistrees());
    }

    @Test
    void testListerPistesEnregistrees() {
        Organizer organizer = new Organizer();
        organizer.pisteList.add(new Piste("toto", "/resources/toto.mp3"));
        organizer.pisteList.add(new Piste("titi", "/resources/titi.mp3"));
        organizer.pisteList.add(new Piste("tata", "/resources/tata.mp3"));
        ArrayList<String> listeTheorique = new ArrayList<>();
        listeTheorique.add("toto");
        listeTheorique.add("titi");
        listeTheorique.add("tata");
        assertEquals(listeTheorique, organizer.listerPistesEnregistrees());
    }
}