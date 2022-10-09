package TP4.mp3MusicPlayer.V5;

import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V5.exceptions.IndicePisteInvalideException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrganizerTest {

    static Organizer organizer = new Organizer();
    static Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
    static Piste piste2 = new Piste("matchBoxBlues", "BlindLemonJefferson");
    static Piste piste3 = new Piste("OneDimeBlues", "BlindLemonJefferson");
    static Piste piste4 = new Piste("EarlyMorningBlues", "BlindBlake");

    @BeforeAll
    static void configurationPistes() throws NonAvailableFileException, IndicePisteInvalideException {
        organizer.getPisteList().add(piste);
        organizer.getPisteList().add(piste2);
        organizer.getPisteList().add(piste3);
        organizer.getPisteList().add(piste4);
        for (int i = 0; i < 4; i++) {
            organizer.jouerUnMorceauEnregistre(0);
        }
        for (int i = 0; i < 2; i++) {
            organizer.jouerUnMorceauEnregistre(2);
        }
        for (int i = 0; i < 3; i++) {
            organizer.jouerUnMorceauEnregistre(3);
        }
        for (int i = 0; i < 1; i++) {
            organizer.jouerUnMorceauEnregistre(1);
        }
    }

    @Test
    void whenGetPistePrefereeListFromPrefereeField_IfEqualToGetPistePrefereeList_thenAssertionSucceeds() {
        boolean egaliteEntreLesDeuxListesPreferees = true;
        assertEquals(organizer.getPistePrefereeList().size(), organizer.getPistePrefereeListFromPrefereeField().size());
        for (int indicePiste = 0; indicePiste < organizer.getPistePrefereeList().size(); indicePiste++) {
            if (!organizer.getPistePrefereeListFromPrefereeField().contains(organizer.getPistePrefereeList().get(indicePiste))) {
                egaliteEntreLesDeuxListesPreferees = false;
            }
        }
        assertTrue(egaliteEntreLesDeuxListesPreferees);
    }
}