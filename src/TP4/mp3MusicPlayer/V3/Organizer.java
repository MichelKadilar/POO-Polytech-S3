package TP4.mp3MusicPlayer.V3;

import TP4.mp3MusicPlayer.MusicPlayer;
import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V3.exceptions.IndicePisteInvalideException;
import TP4.mp3MusicPlayer.V3.exceptions.KeywordUnfoundInPisteName;

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

    public List<Piste> listerPistesMotClefEnregistrees(String motclef) throws KeywordUnfoundInPisteName {
        List<Piste> pistes = new ArrayList<>();
        for (Piste piste : pisteList) {
            if (piste.getNom().toLowerCase().contains(motclef)) {
                pistes.add(piste);
            }
        }
        if (pistes.isEmpty()) {
            throw new KeywordUnfoundInPisteName("Le mot clé : " + motclef + "n'a pas été trouvé dans une des pistes enregistrées.");
        }
        return pistes;
    }

    public void lireToutesPistesMemeArtiste(String nomArtiste) throws NonAvailableFileException {
        for (Piste piste : pisteList) {
            if (piste.getNomArtiste().equals(nomArtiste)) {
                musicPlayer.playSample(USER_DIR + piste.getReference(), 500);
            }
        }
    }
}
