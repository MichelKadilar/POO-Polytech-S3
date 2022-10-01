package TP2.fr.epu.bicycle;

import TP2.fr.epu.bicycle.Battery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BatteryTest {

    @Test
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