package TP4.mp3MusicPlayer.V2;

public class Piste {

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String reference;

    public Piste(String nom, String reference) {
        this.nom = nom;
        this.reference = reference;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String ref) {
        this.reference = ref;
    }
}
