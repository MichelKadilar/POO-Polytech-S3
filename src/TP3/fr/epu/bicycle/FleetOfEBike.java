package TP3.fr.epu.bicycle;

import TP3.fr.epu.bicycle.exceptions.BatteryValueException;
import TP3.fr.epu.bicycle.exceptions.KmValueException;

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
public class FleetOfEBike extends Fleet<EBike> {

    /**
     * Constructeur qui initialise la liste de la flotte de véhicules
     */
    public FleetOfEBike() {
        super();
    }

    public List<EBike> EBikesWithMileageOver(int maxKm) throws KmValueException {
        if (maxKm > 0) {
            List<EBike> ebikesWithOverKm = new ArrayList<>();
            for (EBike ebike : this.fleetOfVehicles) {
                if (ebike.getKm() >= maxKm) {
                    ebikesWithOverKm.add(ebike);
                }
            }
            return ebikesWithOverKm;
        } else throw new KmValueException("On ne peut pas avoir un kilométrage maximum négatif.");
    }

    /**
     * Méthode "fun" pour générer une flotte de test de manière très naïve, nulle et moche.
     */
    @Override
    public void generateFleet() throws BatteryValueException {
        for (int i = 0; i < 5; i++) {
            this.fleetOfVehicles.add(new EBike(
                    new Position(
                            Math.toIntExact(Math.round(Math.random() * 10)),
                            Math.toIntExact(Math.round(Math.random() * 10))
                    ),
                    Math.toIntExact(Math.round(Math.random() * 100))
            ));
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
