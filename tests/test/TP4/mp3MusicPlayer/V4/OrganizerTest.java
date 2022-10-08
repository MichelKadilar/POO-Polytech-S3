package TP4.mp3MusicPlayer.V4;

import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V3.exceptions.IndicePisteInvalideException;
import TP4.mp3MusicPlayer.V3.exceptions.KeywordUnfoundInPisteName;
import TP4.mp3MusicPlayer.V4.exceptions.KeywordUnfoundInArtistName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerTest {
    static Organizer organizer = new Organizer();
    static Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
    static Piste piste2 = new Piste("matchBoxBlues", "BlindLemonJefferson");
    static Piste piste3 = new Piste("OneDimeBlues", "BlindLemonJefferson");
    static Piste piste4 = new Piste("EarlyMorningBlues", "BlindBlake");

    @BeforeAll
    static void configurationPistes() throws NonAvailableFileException, IndicePisteInvalideException {
        organizer.pisteList.add(piste);
        organizer.pisteList.add(piste2);
        organizer.pisteList.add(piste3);
        organizer.pisteList.add(piste4);
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
    void whenSongsWithListeningNumberOverMedianAreAmongPreferredSongs_thenAssertionSucceeds() {
        assertEquals(2, organizer.pistePrefereeList.size());
        assertTrue(organizer.pistePrefereeList.contains(piste));
        assertTrue(organizer.pistePrefereeList.contains(piste4));
        assertFalse(organizer.pistePrefereeList.contains(piste3));
        assertFalse(organizer.pistePrefereeList.contains(piste2));
    }

    @Test
    void whenKeywordSearchedInArtistNameAndItExists_thenAssertionSucceeds() throws KeywordUnfoundInArtistName {
        List<Piste> pisteList = organizer.listerPistesMotClefArtisteEnregistrees("blind");
        assertTrue(pisteList.contains(piste2));
        assertTrue(pisteList.contains(piste3));
        assertTrue(pisteList.contains(piste4));
        assertFalse(pisteList.contains(piste));
    }

    @Test
    void whenKeywordSearchedNotInArtistNameAndItDoesNotExistsAndExceptionThrown_thenAssertionSucceeds() {
        assertThrows(KeywordUnfoundInArtistName.class, () -> {
            organizer.listerPistesMotClefArtisteEnregistrees("l'ane trotro");
        });
    }

    @Test
    void whenSortedByArtistName_IfWellSortedThenAssertionSucceeds() {
        List<Piste> listePisteTrieeParNomArtiste = organizer.trierParNomArtistePiste();
        assertEquals(piste.getNomArtiste(), listePisteTrieeParNomArtiste.get(0).getNomArtiste());
        assertEquals(piste4.getNomArtiste(), listePisteTrieeParNomArtiste.get(1).getNomArtiste());
        assertEquals(piste2.getNomArtiste(), listePisteTrieeParNomArtiste.get(2).getNomArtiste());
        assertEquals(piste3.getNomArtiste(), listePisteTrieeParNomArtiste.get(3).getNomArtiste());
    }

    @Test
    void whenSortedBySongName_IfWellSortedThenAssertionSucceeds() {
        List<Piste> listePisteTrieeParTitrePiste = organizer.trierParTitrePiste();
        assertEquals(piste.getNom(), listePisteTrieeParTitrePiste.get(0).getNom());
        assertEquals(piste4.getNom(), listePisteTrieeParTitrePiste.get(1).getNom());
        assertEquals(piste2.getNom(), listePisteTrieeParTitrePiste.get(2).getNom());
        assertEquals(piste3.getNom(), listePisteTrieeParTitrePiste.get(3).getNom());
    }

    @Test
    void whenSortedByNumberOfListening_IfWellSortedThenAssertionSucceeds() {
        List<Piste> listePisteTrieeParNombreEcoute = organizer.trierParNombreEcoutePiste();
        assertEquals(piste.getNombreEcoute(), listePisteTrieeParNombreEcoute.get(3).getNombreEcoute());
        assertEquals(piste4.getNombreEcoute(), listePisteTrieeParNombreEcoute.get(2).getNombreEcoute());
        assertEquals(piste3.getNombreEcoute(), listePisteTrieeParNombreEcoute.get(1).getNombreEcoute());
        assertEquals(piste2.getNombreEcoute(), listePisteTrieeParNombreEcoute.get(0).getNombreEcoute());
    }
}