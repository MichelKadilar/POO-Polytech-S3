package TP4.mp3MusicPlayer.V3;

import TP4.mp3MusicPlayer.V3.exceptions.KeywordUnfoundInPisteName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrganizerTest {

    @Test
    void whenKeywordSearchedInPisteNameAndItExists_thenAssertionSucceeds() throws KeywordUnfoundInPisteName {
        Organizer organizer = new Organizer();
        Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
        organizer.pisteList.add(piste);
        List<Piste> pisteList = organizer.listerPistesMotClefEnregistrees("baby");
        assertEquals(piste, pisteList.get(0));
    }

    @Test
    void whenKeywordSearchedNotInPisteNameAndItDoesNotExistsAndExceptionThrown_thenAssertionSucceeds() {
        Organizer organizer = new Organizer();
        Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
        organizer.pisteList.add(piste);
        assertThrows(KeywordUnfoundInPisteName.class, () -> {
            organizer.listerPistesMotClefEnregistrees("l'âne trotro");
        });
    }

}