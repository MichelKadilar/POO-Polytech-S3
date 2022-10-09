package TP2.fr.epu.bicycle;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class FleetTest {

    @Test
    void evaluateTime4around() {
        long totalTime = 0;
        Position currentPosition = new Position(7, 7);
        Fleet fleet = new Fleet();
        fleet.generateFleet();
        for (int i = 0; i < 1000; i++) {
            long startTime = System.nanoTime();
            fleet.around(currentPosition, 2);
            long endTime = System.nanoTime();
            long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
            totalTime += durationInNano;
        }
        System.out.println("total time in nano : " + totalTime);
        System.out.println("total time in milli : " + TimeUnit.NANOSECONDS.toMillis(totalTime));
    }


}