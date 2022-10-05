package TP3.fr.epu.bicycle;

import java.util.List;

public class FleetManager {

    List<Fleet<Trackable>> fleetOfTrackable;

    public FleetManager(VehicleTypes... args) {
        for(VehicleTypes arg: args){
            if(arg == VehicleTypes.BIKE){
                Fleet<Bike> bikeFleet = new FleetOfBike();
                //fleetOfTrackable.add();
            }
        }
    }
}
