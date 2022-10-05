package TP3.fr.epu.bicycle;

import TP3.fr.epu.bicycle.exceptions.BatteryValueException;
import TP3.fr.epu.bicycle.exceptions.DistanceValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FleetOfTrackableTest {

    FleetOfTrackable<Unicycle> fUC;
    Unicycle u1 = new Unicycle(new Position(10, 10));
    Unicycle u2 = new Unicycle(new Position(20, 15));
    Unicycle u3 = new Unicycle(new Position(13, 11));
    Unicycle u4 = new Unicycle(new Position(9, 9));

    FleetOfTrackableTest() throws BatteryValueException {
    }

    @BeforeEach
    void setUp() {
        fUC = new FleetOfTrackable<>();
        fUC.fleetOfVehicles.add(u1);
        fUC.fleetOfVehicles.add(u2);
        fUC.fleetOfVehicles.add(u3);
        fUC.fleetOfVehicles.add(u4);
    }

    @Test
    void fleetOfUnicyleTest() {
        assertEquals(4, fUC.getFleetSize());
    }

    @Test
    void getPositionsTest() {
        List<Position> list = fUC.getPositions();
        assertEquals(4, list.size());
        assertTrue(list.contains(new Position(9, 9)));
    }

    @Test
    void closeToTest() throws DistanceValueException {
        Position currentPosition = new Position(0, 0);
        List<Unicycle> list = fUC.closeTo(currentPosition, 15);
        assertTrue(list.contains(u1), getDistanceMessage(u1, currentPosition));
        assertFalse(list.contains(u2), getDistanceMessage(u2, currentPosition));
        assertFalse(list.contains(u3), getDistanceMessage(u3, currentPosition));
        assertTrue(list.contains(u4), getDistanceMessage(u4, currentPosition));
        assertEquals(2, list.size());
    }


    private String getDistanceMessage(Trackable v, Position currentPosition) {
        if (v.getPosition().isPresent()) {
            return v + " should be in, distance from " + currentPosition + " : " +
                    Position.distanceBetweenTwoPositions(v.getPosition().get(), currentPosition);
        }
        return v + "has no position";


    }
}