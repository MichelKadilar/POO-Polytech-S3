package TP2.fr.epu.bicycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScooterTest {
    int scooterMaxSpeed = 120;

    @org.junit.jupiter.api.Test
    void testAddKm() {
        Scooter bike = new Scooter(new Position(2, 2), scooterMaxSpeed);
        int value = -5;
        bike.addKm(value);
        assertEquals(0, bike.getKm());
    }

    @org.junit.jupiter.api.Test
    void testCreateScooter() {
        Scooter bike = new Scooter(new Position(2, 2),scooterMaxSpeed);
        assertEquals(scooterMaxSpeed, bike.getMaxSpeed());
    }

}