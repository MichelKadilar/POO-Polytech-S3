package TP3.fr.epu.bicycle;

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
public class FleetOfEBike extends FleetOfTrackable<EBike> {

    /**
     * Constructeur qui initialise la liste de la flotte de véhicules
     */
    public FleetOfEBike() {
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
    public List<EBike> around(Position vehiclePosition, int distanceMax) {
        return super.closeTo(vehiclePosition, distanceMax);
    }

    /**
     * Méthode "fun" pour générer une flotte de test de manière très naïve, nulle et moche.
     */
    public void generateFleet() {
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
