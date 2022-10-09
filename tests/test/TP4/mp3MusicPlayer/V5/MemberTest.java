package TP4.mp3MusicPlayer.V5;

import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V5.exceptions.IndicePisteInvalideException;
import TP4.mp3MusicPlayer.V5.exceptions.IsNotMemberException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    static Member member = new Member("Michel");
    static Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
    static Piste piste2 = new Piste("matchBoxBlues", "BlindLemonJefferson");
    static Piste piste3 = new Piste("OneDimeBlues", "BlindLemonJefferson");
    static Piste piste4 = new Piste("EarlyMorningBlues", "BlindBlake");

    @BeforeAll
    static void configurationPistes() throws NonAvailableFileException, IndicePisteInvalideException, IsNotMemberException {
        member.getMusicOrganizer().getPisteList().add(piste);
        member.getMusicOrganizer().getPisteList().add(piste2);
        member.getMusicOrganizer().getPisteList().add(piste3);
        member.getMusicOrganizer().getPisteList().add(piste4);
        for (int i = 0; i < 4; i++) {
            member.ecouterMusique(Optional.of(0));
        }
        for (int i = 0; i < 2; i++) {
            member.ecouterMusique(Optional.of(2));
        }
        for (int i = 0; i < 3; i++) {
            member.ecouterMusique(Optional.of(3));
        }
        for (int i = 0; i < 1; i++) {
            member.ecouterMusique(Optional.of(1));
        }
    }

    @Test
    void whenGetPistesPreferees_IfListContainsRightNumberofSongsAndRightSongs_thenAssertionSucceeds() {
        assertEquals(2, member.getMusicOrganizer().getPistePrefereeList().size());
        assertTrue(member.getMusicOrganizer().getPistePrefereeList().contains(piste));
        assertTrue(member.getMusicOrganizer().getPistePrefereeList().contains(piste4));
        assertFalse(member.getMusicOrganizer().getPistePrefereeList().contains(piste3));
        assertFalse(member.getMusicOrganizer().getPistePrefereeList().contains(piste2));
    }

    @Test
    void whenGetNom_ifNomEqualsMemberName_thenAssertionSucceeds() {
        assertEquals("Michel", member.getNom());
    }

    @Test
    void whenEcouterMusiqueIsRunWithAParameter_NumberOfListeningGrow_thenAssertionSucceeds() throws NonAvailableFileException, IndicePisteInvalideException, IsNotMemberException {
        member.ecouterMusique(Optional.of(0));
        assertEquals(5, piste.getNombreEcoute()); // Les 4 écoutes du départ + celle-ci.
    }

    @Test
    void whenEcouterMusiqueIsRunWithoutAParameter_NumberOfListeningGrowForRandomSong_thenAssertionSucceeds() throws NonAvailableFileException, IndicePisteInvalideException, IsNotMemberException {
        List<Integer> ancienNombreEcoutes = new ArrayList<>();
        List<Integer> nouveauNombreEcoutes = new ArrayList<>();
        for (Piste pisteFromMemberBeforeUpdate : member.getMusicOrganizer().getPisteList()) {
            ancienNombreEcoutes.add(pisteFromMemberBeforeUpdate.getNombreEcoute());
        }

        member.ecouterMusique(Optional.empty());

        for (Piste pisteFromMemberAfterUpdate : member.getMusicOrganizer().getPisteList()) {
            nouveauNombreEcoutes.add(pisteFromMemberAfterUpdate.getNombreEcoute());
        }

        boolean changementNombreEcoute = false;

        for (int nbEcoutes = 0; nbEcoutes < nouveauNombreEcoutes.size(); nbEcoutes++) {
            if (ancienNombreEcoutes.get(nbEcoutes).intValue() != nouveauNombreEcoutes.get(nbEcoutes).intValue()) {
                changementNombreEcoute = true;
                break;
            }
        }
        assertTrue(changementNombreEcoute);
    }

    @Test
    void whenGetNombreEcoutesTotaleDePistes_IfNombreEcouteTotalesIncrementsOfOneWhenASongIsListened_thenAssertionSucceeds()
            throws NonAvailableFileException, IndicePisteInvalideException, IsNotMemberException {
        int nbEcoutesTotalesActuelles = member.getNombreEcoutesTotaleDePistes();
        member.ecouterMusique(Optional.of(0));
        assertEquals(nbEcoutesTotalesActuelles + 1, member.getNombreEcoutesTotaleDePistes());
    }
}