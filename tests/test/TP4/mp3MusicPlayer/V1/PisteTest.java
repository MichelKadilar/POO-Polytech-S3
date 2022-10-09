package TP4.mp3MusicPlayer.V1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PisteTest {

    @Test
    void testNomEtReferencePiste() {
        Piste piste = new Piste("toto", "/resources/toto.mp3");
        assertEquals("toto", piste.getNom());
        assertEquals("/resources/toto.mp3", piste.getReference());
        piste.setNom("titi");
        piste.setReference("/resources/titi.mp3");
        assertEquals("titi", piste.getNom());
        assertEquals("/resources/titi.mp3", piste.getReference());
    }

}