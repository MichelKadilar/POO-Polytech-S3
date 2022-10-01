package TP2.fr.epu.bicycle;

import static org.junit.jupiter.api.Assertions.*;

class ScooterTest {
    int scooterMaxSpeed = 120;

    @org.junit.jupiter.api.Test
    void testAddKm() {
        Scooter bike = new Scooter(scooterMaxSpeed);
        int value = -5;
        bike.addKm(value);
        assertEquals(0, bike.getKm());
    }

    @org.junit.jupiter.api.Test
    void testCreateScooter() {
        Scooter bike = new Scooter(scooterMaxSpeed);
        assertEquals(scooterMaxSpeed, bike.getMaxSpeed());
    }

}