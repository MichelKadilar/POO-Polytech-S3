package TP4.mp3MusicPlayer.V3;

import TP4.mp3MusicPlayer.NonAvailableFileException;

public class MusicOrganizerDemo {

    public static void main(String[] args) throws NonAvailableFileException {
        Organizer organizer = new Organizer();
        Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
        Piste piste2 = new Piste("matchBoxBlues", "BlindLemonJefferson");
        Piste piste3 = new Piste("OneDimeBlues", "BlindLemonJefferson");
        organizer.pisteList.add(piste);
        organizer.pisteList.add(piste2);
        organizer.pisteList.add(piste3);
        organizer.lireToutesPistesMemeArtiste("BlindLemonJefferson");

       /* try {
            organizer.listerPistesMotClefEnregistrees("toto");
        } catch (KeywordUnfoundInPisteName e) {

        }*/
    }
}
