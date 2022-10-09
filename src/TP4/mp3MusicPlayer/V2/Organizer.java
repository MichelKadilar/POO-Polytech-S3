package TP4.mp3MusicPlayer.V2;

import TP4.mp3MusicPlayer.MusicPlayer;
import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V2.exceptions.IndicePisteInvalideException;

import java.util.ArrayList;
import java.util.List;

import static TP4.mp3MusicPlayer.MusicPlayerDemo.USER_DIR;

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

    private void ecouterPiste(Piste piste) throws NonAvailableFileException {
        musicPlayer.startPlaying(USER_DIR + piste.getReference());
    }

    public void stopperEcoutePiste() {
        musicPlayer.stop();
    }

    public void jouerUnMorceauEnregistre(int indicePisteArraylist) throws NonAvailableFileException, IndicePisteInvalideException {
        if (this.getNombrePistesEnregistrees() > 0 && indicePisteArraylist >= 0 && indicePisteArraylist < this.getNombrePistesEnregistrees()) {
            this.ecouterPiste(this.pisteList.get(indicePisteArraylist));
        } else if (this.getNombrePistesEnregistrees() == 0) {
            throw new IndicePisteInvalideException("Il n'y a aucune piste à lire mais vous essayez d'en lire une.");
        } else {
            throw new IndicePisteInvalideException("L'indice de la piste à lire doit être comprise entre 0 et " + this.getNombrePistesEnregistrees());
        }
    }
}
