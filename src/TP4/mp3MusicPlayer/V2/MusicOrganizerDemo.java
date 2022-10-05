package TP4.mp3MusicPlayer.V2;

import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V2.exceptions.IndicePisteInvalideException;

import java.util.Scanner;

public class MusicOrganizerDemo {

    public static void main(String[] args) throws NonAvailableFileException, IndicePisteInvalideException {
        Organizer organizer = new Organizer();
        Piste piste = new Piste("BigBillBroonzy-BabyPleaseDontGo1", "/resources/audio/BigBillBroonzy-BabyPleaseDontGo1.mp3");
        organizer.pisteList.add(piste);
        organizer.jouerUnMorceauEnregistre(0);
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez 0 pour interrompre le son :");
        int monEntier = clavier.nextInt();
        if (monEntier == 0) organizer.stopperEcoutePiste();
    }
}
