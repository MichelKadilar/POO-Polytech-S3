package TP4.mp3MusicPlayer.V4;

public class Piste {

    private final String nom;

    private final String reference;

    private final String nomArtiste;

    private int nombreEcoute;

    public Piste(String nom, String nomArtiste) {
        this.nom = nom;
        this.reference = "/resources/audio/" + nomArtiste + "-" + nom + ".mp3";
        this.nomArtiste = nomArtiste;
        this.nombreEcoute = 0;
    }

    public void ajouterUneEcoute() {
        this.nombreEcoute++;
    }

    public String getNom() {
        return this.nom;
    }

    public String getReference() {
        return this.reference;
    }

    public String getNomArtiste() {
        return this.nomArtiste;
    }

    public int getNombreEcoute() {
        return this.nombreEcoute;
    }

}
