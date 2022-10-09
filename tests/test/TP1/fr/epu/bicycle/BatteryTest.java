package TP1.fr.epu.bicycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BatteryTest {

    @org.junit.jupiter.api.Test
    void testCreateBattery() {
        Battery battery = new Battery(100, 48);
        assertEquals(100, battery.getCharge());
    }

    @Test
    void addEnergy() {
        Battery battery = new Battery(40, 48);
        battery.addEnergy(20);
        assertEquals(60, battery.getCharge());
    }
}