package TP3.fr.epu.bicycle;

import TP3.fr.epu.bicycle.exceptions.DistanceValueException;

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
public class FleetOfTrackable<T extends Trackable> {
    /**
     * La flotte de véhicules de taille inconnue
     */
    protected List<T> fleetOfVehicles;

    /**
     * Constructeur qui initialise la liste de la flotte de véhicules
     */
    protected FleetOfTrackable() {
        this.fleetOfVehicles = new ArrayList<>();
    }

    public void addToAL(T vehicle){
        this.fleetOfVehicles.add(vehicle);
    }


    public List<Position> getPositions() {
        List<Position> vehiclesPositionList = new ArrayList<>();
        for (T vehicle : fleetOfVehicles) {
            vehicle.getPosition().ifPresent(vehiclesPositionList::add); // Ajoute la valeur de la position à la liste
            // des positions
        }
        return vehiclesPositionList;
    }

    /**
     * Méthode permettant de renvoyer une liste de véhicules dont la position est proche à au plus "distanceMax" de
     * la position du véhicule courant "vehiclePosition".
     *
     * @param vehiclePosition la position du véhicule courant, autour de laquelle on va chercher d'autres véhicules.
     * @param distanceMax     la distance maximum à laquelle on va chercher des véhicules autour de la position courante.
     * @return Une liste de véhicules traçables, qui sont les véhicules trouvés "autour" du véhicule courant.
     */
     public List<T> closeTo(Position vehiclePosition, int distanceMax) throws DistanceValueException {
         if(distanceMax < 0){
             ArrayList<T> vehiclesAround = new ArrayList<>();
             for (T vehicle : fleetOfVehicles) {
                 vehicle.getPosition().ifPresent(value -> {
                     if (Position.distanceBetweenTwoPositions(value, vehiclePosition) <= distanceMax) {
                         vehiclesAround.add(vehicle);
                     }
                 });
             }
             return vehiclesAround;
         }
         else throw new DistanceValueException("La distance maximale est négative, ce qui n'est pas possible.");
    }

    /**
     * Méthode permettant de renvoyer la taille de la liste de véhicules de la flotte.
     *
     * @return la taille de la flotte.
     */
    public int getFleetSize() {
        return fleetOfVehicles.size();
    }
}
