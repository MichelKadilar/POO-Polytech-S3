package TP4.mp3MusicPlayer.V5;

import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V3.exceptions.IndicePisteInvalideException;

import java.util.List;
import java.util.Optional;

public class Member {

    private String nom;

    private int mois;
    private int annee;

    private Organizer musicOrganizer;

    public Member(String nom) {
        this.nom = nom;
        this.musicOrganizer = new Organizer();
    }

    public List<Piste> getPistesPreferees() {
        return this.musicOrganizer.getPistePrefereeList();
    }

    public String getNom() {
        return this.nom;
    }

    public void ecouterMusique(Optional<Integer> indiceMusiquePlaylist) throws NonAvailableFileException, IndicePisteInvalideException {
        if (indiceMusiquePlaylist.isPresent()) {
            this.musicOrganizer.jouerUnMorceauEnregistre(indiceMusiquePlaylist.get());
        } else {
            this.musicOrganizer.jouerUnMorceauAuHasard();
        }
    }

    public int getNombreEcoutesTotaleDePistes() {
        int nombreEcoutesTotale = 0;
        for (Piste piste : this.musicOrganizer.getPisteList()) {
            nombreEcoutesTotale += piste.getNombreEcoute();
        }
        return nombreEcoutesTotale;
    }
}
