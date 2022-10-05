package TP3.fr.epu.bicycle;

import TP3.fr.epu.bicycle.exceptions.BatteryValueException;
import TP3.fr.epu.bicycle.exceptions.DistanceValueException;
import TP3.fr.epu.bicycle.exceptions.SpeedValueException;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une flotte de véhicules traçables.
 *
 * @author Michel K
 * @see Trackable
 * @see Bike
 * @see EBike
 * @see Scooter
 * @see Unicycle
 * @see Station
 */
public class Fleet<T extends Trackable> extends FleetOfTrackable<T> {


    /**
     * Constructeur qui initialise la liste de la flotte de véhicules
     */
    public Fleet() {
        super();
    }

    /**
     * Méthode permettant de renvoyer une liste de véhicules dont la position est proche à au plus "distanceMax" de
     * la position du véhicule courant "vehiclePosition".
     *
     * @param vehiclePosition la position du véhicule courant, autour de laquelle on va chercher d'autres véhicules.
     * @param distanceMax     la distance maximum à laquelle on va chercher des véhicules autour de la position courante.
     * @return Une liste de véhicules traçables, qui sont les véhicules trouvés "autour" du véhicule courant.
     */
    public List<T> around(Position vehiclePosition, int distanceMax) throws DistanceValueException {
        ArrayList<T> vehiclesAround = new ArrayList<>();
        for (T tr : fleetOfVehicles) {
            tr.getPosition().ifPresent(value -> {
                if (Position.distanceBetweenTwoPositions(value, vehiclePosition) <= distanceMax &&
                        tr.isBorrowable()) {
                    vehiclesAround.add(tr);
                }
            });
        }
        return vehiclesAround;
    }

    public void generateFleet() throws BatteryValueException, SpeedValueException {
        Station station = new Station(new Position(5, 5));
        Station station1 = new Station(new Position(8, 8));
        Station station2 = new Station(new Position(4, 4));
        Bike bike;
        for (int i = 0; i < 5; i++) {
            bike = new Bike();
            station.addBikeToStation(bike);
            this.addToAL((T) bike);
            bike = new Bike();
            station1.addBikeToStation(bike);
            this.fleetOfVehicles.add((T) bike);
            bike = new Bike();
            station2.addBikeToStation(bike);
            this.fleetOfVehicles.add((T) bike);
        }
        for (int i = 0; i < 5; i++) {
            this.fleetOfVehicles.add((T) new EBike(new Position(Math.toIntExact(Math.round(Math.random() * 10)), Math.toIntExact(Math.round(Math.random() * 10))), 20));
            this.fleetOfVehicles.add((T) new Scooter(new Position(Math.toIntExact(Math.round(Math.random() * 10)), Math.toIntExact(Math.round(Math.random() * 10))), 120));
            this.fleetOfVehicles.add((T) new Unicycle(new Position(Math.toIntExact(Math.round(Math.random() * 10)), Math.toIntExact(Math.round(Math.random() * 10)))));
        }
    }

    /*
    public static void main(String[] args) {
        Fleet fleet1 = new Fleet();
        fleet1.generateFleet();
        List<Trackable> trackables = fleet1.around(new Position(5, 5), 2);
        for(Trackable trackable : trackables){
            System.out.println(trackable.getPosition().get().getX() + "|" + + trackable.getPosition().get().getY());
        }
        System.out.println(trackables.size());
    }
    */
}
