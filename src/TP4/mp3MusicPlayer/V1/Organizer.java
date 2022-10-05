package TP4.mp3MusicPlayer.V1;

import TP4.mp3MusicPlayer.MusicPlayer;
import TP4.mp3MusicPlayer.NonAvailableFileException;

import java.util.ArrayList;
import java.util.List;

public class Organizer {

    private MusicPlayer musicPlayer;
    protected List<Piste> pisteList;

    public Organizer() {
        musicPlayer = new MusicPlayer();
        pisteList = new ArrayList<>();
    }

    public int getNombrePistesEnregistrees() {
        return this.pisteList.size();
    }

    public List<String> listerPistesEnregistrees() {
        List<String> nomPistesNom = new ArrayList<>();
        for (Piste piste : pisteList) {
            System.out.println(piste.getNom());
            nomPistesNom.add(piste.getNom());
        }
        return nomPistesNom;
    }

    public void ecouterPiste(Piste piste) throws NonAvailableFileException {
        musicPlayer.startPlaying(System.getProperty("user.dir") + piste.getReference());
    }

    public void stopperEcoutePiste() {
        musicPlayer.stop();
    }

}
