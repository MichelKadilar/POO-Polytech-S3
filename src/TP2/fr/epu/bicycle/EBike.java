package TP2.fr.epu.bicycle;

/**
 * Classe représentant un vélo, avec son nombre de kilomètres parcourus, son GPS et sa batterie.
 *
 * @author Michel K
 * @see Battery
 * @see GPS
 */
public class EBike extends ElectricVehicle implements Borrowable {
    /**
     * La distance initiale parcourue par le vélo en sortie d'usine : 1.
     */
    protected static final int INITIAL_DISTANCE = 1;

    private boolean isBorrowed;

    /**
     * Constructeur de EBike, définissant le nombre de kilomètres parcourus originellement par le vélo en sortie d'usine,
     * le GPS et la batterie utilisés dans ce vélo.
     *
     * @see GPS
     * @see Battery
     */
    public EBike() {
        super();
        this.km = INITIAL_DISTANCE;
        this.isBorrowed = false;
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
