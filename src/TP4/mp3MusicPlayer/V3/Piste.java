package TP4.mp3MusicPlayer.V3;

public class Piste {

    private final String nom;

    private final String reference;

    private final String nomArtiste;

    public Piste(String nom, String nomArtiste) {
        this.nom = nom;
        this.reference = "/resources/audio/" + nomArtiste + "-" + nom + ".mp3";
        this.nomArtiste = nomArtiste;
    }

    public String getNom() {
        return nom;
    }

    public String getReference() {
        return this.reference;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }
}
