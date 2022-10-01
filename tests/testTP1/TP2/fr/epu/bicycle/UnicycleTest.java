package TP2.fr.epu.bicycle;

import static org.junit.jupiter.api.Assertions.*;

class UnicycleTest {

    @org.junit.jupiter.api.Test
    void testAddKm() {
        Unicycle unicycle = new Unicycle();
        int value = -5;
        unicycle.addKm(value);
        assertEquals(0, unicycle.getKm());
    }

    @org.junit.jupiter.api.Test
    void testCreateUnicycle() {
        Unicycle unicycle = new Unicycle();
        assertEquals(0, unicycle.getKm());
    }

}