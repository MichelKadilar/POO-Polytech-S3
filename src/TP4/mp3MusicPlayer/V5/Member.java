package TP4.mp3MusicPlayer.V5;

import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V5.exceptions.IndicePisteInvalideException;
import TP4.mp3MusicPlayer.V5.exceptions.IsNotMemberException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Member {

    private String nom;

    private int moisInscription;
    private int anneeInscription;

    private Organizer musicOrganizer;

    private int nombreEcoutesTotales;

    private boolean estInscrit;

    public Member(String nom) {
        this.nom = nom;
        this.musicOrganizer = new Organizer();
        this.nombreEcoutesTotales = 0;
        LocalDate currentdate = LocalDate.now();
        this.moisInscription = currentdate.getMonthValue();
        this.anneeInscription = currentdate.getYear();
        this.estInscrit = false;
    }

    public List<Piste> getPistesPreferees() {
        return this.musicOrganizer.getPistePrefereeList();
    }

    public String getNom() {
        return this.nom;
    }

    public void ecouterMusique(Optional<Integer> indiceMusiquePlaylist) throws NonAvailableFileException, IndicePisteInvalideException, IsNotMemberException {
        if (this.estInscrit) {
            if (indiceMusiquePlaylist.isPresent()) {
                this.musicOrganizer.jouerUnMorceauEnregistre(indiceMusiquePlaylist.get());
            } else {
                this.musicOrganizer.jouerUnMorceauAuHasard();
            }
            this.nombreEcoutesTotales++;
        } else {
            throw new IsNotMemberException(this.nom + "n'est pas membre et ne peut donc pas jouer une musique");
        }
    }

    public int getNombreEcoutesTotaleDePistes() {
        return nombreEcoutesTotales;
    }

    public Organizer getMusicOrganizer() {
        return musicOrganizer;
    }

    public void setEstInscrit(boolean estInscrit) {
        this.estInscrit = estInscrit;
    }

    public int getMoisInscription() {
        return moisInscription;
    }

    public int getAnneeInscription() {
        return anneeInscription;
    }

    public void reinitialiserDateInscription() {
        this.moisInscription = 0;
        this.anneeInscription = 0;
    }

    // On ne remet pas à 0 le nombre d'écoutes au cas où la personne se réinscrit plus tard.
}
