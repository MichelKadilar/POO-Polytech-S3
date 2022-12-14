package TP2.fr.epu.bicycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EBikeTest {

    @org.junit.jupiter.api.Test
    void testAddKm() {
        EBike bike = new EBike(new Position(5, 5), 20);
        int value = -5;
        bike.addKm(value);
        assertEquals(EBike.INITIAL_DISTANCE, bike.getKm());
    }

    @org.junit.jupiter.api.Test
    void testCreateEBike() {
        EBike bike = new EBike(new Position(5, 5), 20);
        assertEquals(EBike.INITIAL_DISTANCE, bike.getKm());
    }
}