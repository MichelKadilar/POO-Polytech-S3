package TP2.fr.epu.bicycle;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private ArrayList<ElectricVehicle> fleet;

    public Fleet() {
        this.fleet = new ArrayList<>();
    }

    public List<ElectricVehicle> around(Position vehiclePosition, int distanceMax) {
        ArrayList<ElectricVehicle> vehiclesAround = new ArrayList<>();
        for (ElectricVehicle eV : fleet) {
            if (eV.getPosition().isPresent() &&
                    Position.distanceBetweenTwoPositions(eV.getPosition().get(), vehiclePosition) <= distanceMax) {
                vehiclesAround.add(eV);
            }
        }
        return vehiclesAround;
    }

    public int getFleetSize() {
        return fleet.size();
    }
}
