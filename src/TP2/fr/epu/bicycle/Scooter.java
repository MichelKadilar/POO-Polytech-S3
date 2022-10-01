package TP2.fr.epu.bicycle;

public class Scooter extends ElectricVehicle implements Borrowable {

    /**
     * Vitesse maximum pouvant être atteinte par la trotinette
     */
    private int maxSpeed;

    private boolean isBorrowed;

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
        this.isBorrowed = false;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public void setNotBorrowed() {
        this.isBorrowed = false;
    }

    @Override
    public void setBorrowed() {
        this.isBorrowed = true;
    }

    @Override
    public boolean isBorrowable() {
        return !this.isBorrowed && this.battery.getCharge() >= 20;
    }
}
