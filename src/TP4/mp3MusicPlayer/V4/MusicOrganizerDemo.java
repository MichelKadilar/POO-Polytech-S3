package TP4.mp3MusicPlayer.V4;

public class MusicOrganizerDemo {

    public static void main(String[] args) {
        Organizer organizer = new Organizer();
        Piste piste = new Piste("BabyPleaseDontGo1", "BigBillBroonzy");
        Piste piste2 = new Piste("matchBoxBlues", "BlindLemonJefferson");
        Piste piste3 = new Piste("OneDimeBlues", "BlindLemonJefferson");
        Piste piste4 = new Piste("EarlyMorningBlues", "BlindBlake");
        organizer.pisteList.add(piste);
        organizer.pisteList.add(piste2);
        organizer.pisteList.add(piste3);
        organizer.pisteList.add(piste4);
        /*
        for(int i=0; i<4;i++) {
            organizer.jouerUnMorceauEnregistre(0);
        }
        System.out.println(piste.getNombreEcoute());
        System.out.println(organizer.pistePrefereeList.size());
        System.out.println(organizer.pisteList.get(0).getNom() + ":" + organizer.pisteList.get(0).getNombreEcoute());
        System.out.println(organizer.pisteList.get(1).getNom() + ":" + organizer.pisteList.get(1).getNombreEcoute());
        System.out.println(organizer.pisteList.get(2).getNom() + ":" + organizer.pisteList.get(2).getNombreEcoute());
        System.out.println(organizer.pisteList.get(3).getNom() + ":" + organizer.pisteList.get(3).getNombreEcoute());
        */

        //organizer.jouerUnMorceauAuHasard();
       /* try {
            organizer.listerPistesMotClefEnregistrees("toto");
        } catch (KeywordUnfoundInPisteName e) {

        }*/

        for(Piste p: organizer.trierParNomArtistePiste()){
            System.out.println(p.getNomArtiste());
        }
    }
}
