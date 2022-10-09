package TP4.mp3MusicPlayer.V5;

import TP4.mp3MusicPlayer.MusicPlayer;
import TP4.mp3MusicPlayer.NonAvailableFileException;
import TP4.mp3MusicPlayer.V5.exceptions.IndicePisteInvalideException;
import TP4.mp3MusicPlayer.V5.exceptions.KeywordUnfoundInArtistName;
import TP4.mp3MusicPlayer.V5.exceptions.KeywordUnfoundInPisteName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static TP4.mp3MusicPlayer.MusicPlayerDemo.USER_DIR;

public class Organizer {

    private MusicPlayer musicPlayer;
    private List<Piste> pisteList;
    private List<Piste> pistePrefereeList;

    public Organizer() {
        musicPlayer = new MusicPlayer();
        pisteList = new ArrayList<>();
        pistePrefereeList = new ArrayList<>();
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
        this.stopperEcoutePiste();
        piste.ajouterUneEcoute();
        musicPlayer.playSample(USER_DIR + piste.getReference(), 10);
        updatePreferee();
        updatePreferee2();
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

    public void jouerUnMorceauAuHasard() throws NonAvailableFileException, IndicePisteInvalideException {
        jouerUnMorceauEnregistre(new Random().nextInt(0, this.pisteList.size()));
    }

    public List<Piste> listerPistesTitreMotClefEnregistrees(String motclef) throws KeywordUnfoundInPisteName {
        List<Piste> pistes = new ArrayList<>();
        for (Piste piste : pisteList) {
            if (piste.getNom().toLowerCase().contains(motclef)) {
                pistes.add(piste);
            }
        }
        if (pistes.isEmpty()) {
            throw new KeywordUnfoundInPisteName("Le mot clé : " + motclef + "n'a pas été trouvé dans le titre de l'une des pistes enregistrées.");
        }
        return pistes;
    }

    public List<Piste> listerPistesMotClefArtisteEnregistrees(String motclef) throws KeywordUnfoundInArtistName {
        List<Piste> pistes = new ArrayList<>();
        for (Piste piste : pisteList) {
            if (piste.getNomArtiste().toLowerCase().contains(motclef)) {
                pistes.add(piste);
            }
        }
        if (pistes.isEmpty()) {
            throw new KeywordUnfoundInArtistName("Le mot clé : " + motclef + "n'a pas été trouvé dans le nom de l'artiste d'une des pistes enregistrées.");
        }
        return pistes;
    }

    public void lireToutesPistesMemeArtiste(String nomArtiste) throws NonAvailableFileException {
        for (Piste piste : pisteList) {
            if (piste.getNomArtiste().equals(nomArtiste)) {
                musicPlayer.playSample(USER_DIR + piste.getReference(), 500);
                piste.ajouterUneEcoute();
            }
        }
        updatePreferee();
        updatePreferee2();
    }

    private List<Piste> updatePreferee() {
        this.pistePrefereeList.clear();
        int tailleListePistes = this.pisteList.size();
        List<Piste> listePisteTrieeParEcoute = Organizer.trierParNombreEcoutePiste(this.pisteList);
        float valeurMediane;
        if (tailleListePistes % 2 == 0) {
            int premierePositionMediane = (int) Math.floor((float) tailleListePistes / 2) - 1;
            int deuxiemePositionMediane = premierePositionMediane + 1;
            int mediane1 = listePisteTrieeParEcoute.get(premierePositionMediane).getNombreEcoute();
            int mediane2 = listePisteTrieeParEcoute.get(deuxiemePositionMediane).getNombreEcoute();
            valeurMediane = (float) (mediane1 + mediane2) / 2;
        } else {
            int positionMediane = (int) Math.floor((float) (tailleListePistes) / 2) + 1 - 1;
            valeurMediane = listePisteTrieeParEcoute.get(positionMediane).getNombreEcoute();
        }
        for (Piste piste : listePisteTrieeParEcoute) {
            if (piste.getNombreEcoute() > valeurMediane) this.pistePrefereeList.add(piste);
        }
        return this.pistePrefereeList; // ça ne coute rien de le renvoyer même si ça ne sert à rien je pense.
    }

    private void updatePreferee2() {
        int tailleListePistes = this.pisteList.size();
        List<Piste> listePisteTrieeParEcoute = Organizer.trierParNombreEcoutePiste(this.pisteList);
        float valeurMediane;
        if (tailleListePistes % 2 == 0) {
            int premierePositionMediane = (int) Math.floor((float) tailleListePistes / 2) - 1;
            int deuxiemePositionMediane = premierePositionMediane + 1;
            int mediane1 = listePisteTrieeParEcoute.get(premierePositionMediane).getNombreEcoute();
            int mediane2 = listePisteTrieeParEcoute.get(deuxiemePositionMediane).getNombreEcoute();
            valeurMediane = (float) (mediane1 + mediane2) / 2;
        } else {
            int positionMediane = (int) Math.floor((float) (tailleListePistes) / 2) + 1 - 1;
            valeurMediane = listePisteTrieeParEcoute.get(positionMediane).getNombreEcoute();
        }
        for (Piste piste : listePisteTrieeParEcoute) {
            piste.setPreferee(piste.getNombreEcoute() > valeurMediane);
        }
    }

    protected static List<Piste> trierParNomArtistePiste(List<Piste> pisteList) {
        List<Piste> pisteList1 = new ArrayList<>(pisteList);
        pisteList1.sort(Comparator.comparing(Piste::getNomArtiste, Comparator.nullsFirst(String::compareToIgnoreCase)));
        return pisteList1;
    }

    protected static List<Piste> trierParTitrePiste(List<Piste> pisteList) {
        List<Piste> pisteList1 = new ArrayList<>(pisteList);
        pisteList1.sort(Comparator.comparing(Piste::getNom, Comparator.nullsFirst(String::compareToIgnoreCase)));
        return pisteList1;
    }

    protected static List<Piste> trierParNombreEcoutePiste(List<Piste> pisteList) {
        List<Piste> pisteList1 = new ArrayList<>(pisteList);
        pisteList1.sort(Comparator.comparing(Piste::getNombreEcoute));
        return pisteList1;
    }

    public MusicPlayer getMusicPlayer() {
        return this.musicPlayer;
    }

    public List<Piste> getPisteList() {
        return this.pisteList;
    }

    public List<Piste> getPistePrefereeList() {
        return this.pistePrefereeList;
    }

    public List<Piste> getPistePrefereeListFromPrefereeField() {
        List<Piste> pistesPreferees = new ArrayList<>();
        for (Piste piste : this.getPisteList()) {
            if (piste.isPreferee()) {
                pistesPreferees.add(piste);
            }
        }
        return pistesPreferees;
    }
}
