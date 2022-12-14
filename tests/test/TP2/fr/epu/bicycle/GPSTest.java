package TP2.fr.epu.bicycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GPSTest {

    @Test
    void testCreateGPS() {
        GPS gps = new GPS();
        int initialPositionValue = 0;
        assertEquals(initialPositionValue, gps.getPosition().getX());
        assertEquals(initialPositionValue, gps.getPosition().getY());
    }

    @Test
    void testChangePosition() {
        GPS gps = new GPS();
        int XPositionValue = 10;
        int YPositionValue = 14;
        gps.changePosition(XPositionValue, YPositionValue);
        assertEquals(XPositionValue, gps.getPosition().getX());
        assertEquals(YPositionValue, gps.getPosition().getY());
    }
}