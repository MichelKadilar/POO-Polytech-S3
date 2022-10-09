package TP1.fr.epu.bicycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GPSTest {

    @org.junit.jupiter.api.Test
    void testCreateGPS() {
        GPS gps = new GPS();
        int initialPositionValue = 0;
        assertEquals(initialPositionValue ,gps.getPosition().getX());
        assertEquals(initialPositionValue ,gps.getPosition().getY());
    }

    @org.junit.jupiter.api.Test
    void testChangePosition() {
        GPS gps = new GPS();
        int XPositionValue = 10;
        int YPositionValue = 14;
        gps.changePosition(XPositionValue, YPositionValue);
        assertEquals(XPositionValue ,gps.getPosition().getX());
        assertEquals(YPositionValue ,gps.getPosition().getY());
    }
}