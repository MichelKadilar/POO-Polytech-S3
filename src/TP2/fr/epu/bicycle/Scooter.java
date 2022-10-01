package TP2.fr.epu.bicycle;

public class Scooter extends ElectricVehicle {

    /**
     * Vitesse maximum pouvant être atteinte par la trotinette
     */
    private int maxSpeed;

    /**
     * Constructeur de EBike, définissant le nombre de kilomètres parcourus originellement par le vélo en sortie d'usine,
     * le GPS et la batterie utilisés dans ce vélo.
     *
     * @see ElectricVehicle
     * @see GPS
     * @see Battery
     */
    public Scooter(int maxSpeed) {
        super();
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }
}
