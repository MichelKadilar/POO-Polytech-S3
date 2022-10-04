package TP2.fr.epu.bicycle;

/**
 * Classe représentant la trotinette électrique.
 *
 * @author Michel K
 * @see ElectricVehicle
 * @see GPS
 * @see Battery
 */
public class Scooter extends ElectricVehicle {

    /**
     * Vitesse maximum pouvant être atteinte par la trotinette
     */
    private int maxSpeed;

    /**
     * Constructeur de EBike, définissant le nombre de kilomètres parcourus originellement par le vélo en sortie d'usine,
     * le GPS et la batterie utilisés dans ce vélo, ainsi que la vitesse maximum de la trotinette
     * et l'autorisation d'emprunt.
     *
     * @param position la position de la trotinette.
     * @param maxSpeed la vitesse maximale de cette trotinette.
     * @see GPS
     * @see Battery
     */
    public Scooter(Position position, int maxSpeed) {
        super();
        this.gps.changePosition(position.getX(), position.getY());
        this.maxSpeed = maxSpeed;
        this.isBorrowable = true;
    }

    /**
     * Accesseur en lecture de la vitesse maximale de la trotinette.
     *
     * @return la vitesse maximale de la trotinette.
     */
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    /**
     * Méthode déterminant si la trotinette est empruntable ou non;
     * Si la trotinette n'est pas déjà empruntée et si elle a une charge de sa batterie supérieure à 20%, alors la
     * trotinette est empruntable.
     *
     * @return Vrai si la trotinette est empruntable. Faux sinon.
     */
    @Override
    public boolean isBorrowable() {
        return this.isBorrowable && this.battery.getCharge() >= 20;
    }

}
