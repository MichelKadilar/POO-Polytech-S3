package TP4.mp3MusicPlayer.V5;

import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V5.exceptions.IndicePisteInvalideException;
import TP4.mp3MusicPlayer.V5.exceptions.IsNotMemberException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MembershipTest {

    static Membership membership = new Membership();
    static Member member = new Member("Michel");
    static Member member1 = new Member("Jean");

    static Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
    static Piste piste2 = new Piste("matchBoxBlues", "BlindLemonJefferson");
    static Piste piste3 = new Piste("OneDimeBlues", "BlindLemonJefferson");
    static Piste piste4 = new Piste("EarlyMorningBlues", "BlindBlake");


    @BeforeAll
    static void configurationPistes() throws NonAvailableFileException, IndicePisteInvalideException, IsNotMemberException {
        membership.ajouterMembre(member);
        membership.ajouterMembre(member1);

        member.getMusicOrganizer().getPisteList().add(piste);
        member.getMusicOrganizer().getPisteList().add(piste2);
        member.getMusicOrganizer().getPisteList().add(piste3);
        member.getMusicOrganizer().getPisteList().add(piste4);

        member1.getMusicOrganizer().getPisteList().add(piste);
        member1.getMusicOrganizer().getPisteList().add(piste2);
        member1.getMusicOrganizer().getPisteList().add(piste3);
        member1.getMusicOrganizer().getPisteList().add(piste4);

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

        for (int i = 0; i < 2; i++) {
            member1.ecouterMusique(Optional.of(0));
        }
        for (int i = 0; i < 1; i++) {
            member1.ecouterMusique(Optional.of(2));
        }
        for (int i = 0; i < 5; i++) {
            member1.ecouterMusique(Optional.of(3));
        }
        for (int i = 0; i < 3; i++) {
            member1.ecouterMusique(Optional.of(1));
        }
    }

    @Test
    void whenTryingToListenToASongWithoutBeingAMember_thenAssertionThrowsAndSucceeds() {
        Member member2 = new Member("Solene");
        assertThrows(IsNotMemberException.class, () -> {
            member2.ecouterMusique(Optional.empty());
        });
    }

    @Test
    void whenAjouterMembre_ifMemberIsAddedToMemberList_thenAssertionSucceeds() {
        assertEquals(2, membership.getNumberOfMembers());
        assertEquals("Michel", membership.getMemberList().get(0).getNom());
        assertEquals("Jean", membership.getMemberList().get(1).getNom());
    }

    @Test
    void whenAMemberIsAdded_IfSubscriptionDateIsTheDayHeSubscribed_thenAssertionSucceeds() {
        assertEquals(10, member.getMoisInscription());
        assertEquals(2022, member.getAnneeInscription());
        assertEquals(10, member1.getMoisInscription());
        assertEquals(2022, member1.getAnneeInscription());
    }

    @Test
    void isMember() {
        assertTrue(membership.isMember("Michel"));
        assertTrue(membership.isMember("Jean"));
        assertFalse(membership.isMember("l'ane Trotro"));
    }

    @Test
    void getNumberOfMembers() {
        assertEquals(2, membership.getNumberOfMembers());
    }


    @Test
    void trierParLesPistesLesPlusEcouteesDuClub() {
        List<Piste> pisteListTrieesParEcoute = membership.trierParLesPistesLesPlusEcouteesDuClub();
        assertEquals(piste4.getNom(), pisteListTrieesParEcoute.get(0).getNom());
        assertEquals(piste.getNom(), pisteListTrieesParEcoute.get(1).getNom());
    }

    @Test
    void trierParMembresQuiEcoutentLePlusDeMusique() {
        List<Member> memberList = membership.trierParMembresQuiEcoutentLePlusDeMusique();
        assertEquals(member1.getNom(), memberList.get(0).getNom());
        assertEquals(member.getNom(), memberList.get(1).getNom());
    }

    @Test
    void whenAMemberUnSubscribed_ItIsRemovedFromSubscribersAndSubscriptionDateIsReinitialized() {
        Member member2 = new Member("Solene");
        membership.ajouterMembre(member2);
        assertTrue(membership.isMember(member2.getNom()));
        membership.desabonnerUnMembre(member2);
        assertEquals(0, member2.getAnneeInscription());
        assertEquals(0, member2.getMoisInscription());
        assertFalse(membership.isMember(member2.getNom()));
    }
}