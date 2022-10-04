package TP2.fr.epu.bicycle;

/**
 * Classe représentant un vélo, avec son nombre de kilomètres parcourus, son GPS et sa batterie;
 * Cette classe hérite de ElectricVehicle car un vélo électrique est un véhicule électrique.
 *
 * @author Michel K
 * @see Battery
 * @see GPS
 * @see ElectricVehicle
 */
public class EBike extends ElectricVehicle {
    /**
     * La distance initiale parcourue par le vélo en sortie d'usine : 1.
     */
    protected static final int INITIAL_DISTANCE = 1;

    /**
     * La charge minimum de la batterie du vélo nécessaire afin qu'il soit empruntable.
     */
    private int minChargeToBorrow;

    /**
     * Constructeur de EBike, définissant le nombre de kilomètres parcourus originellement par le vélo en sortie d'usine,
     * le GPS et la batterie utilisés dans ce vélo, ainsi que la charge minimale pour qu'il soit empruntable et
     * s'il est actuellement autorisé à l'emprun ou non.
     *
     * @param position          la position de départ du vélo électrique.
     * @param minChargeToBorrow le niveau de charge minimum nécessaire pour emprunter ce vélo.
     * @see GPS
     * @see Battery
     * @see Position
     */
    public EBike(Position position, int minChargeToBorrow) {
        super();
        this.gps.changePosition(position.getX(), position.getY());
        this.km = INITIAL_DISTANCE;
        this.minChargeToBorrow = minChargeToBorrow;
        this.isBorrowable = true;
    }

    /**
     * Méthode permettant de déterminer si un vélo électrique est empruntable;
     * S'il est empruntable (disponible) et que sa batterie est supérieure à un minimum déterminé, alors il est empruntable.
     *
     * @return Vrai si le vélo électrique est empruntable. Faux sinon.
     */
    @Override
    public boolean isBorrowable() {
        return this.isBorrowable && this.battery.getCharge() >= minChargeToBorrow;
    }

    /**
     * Accesseur en lecture du minimum de charge nécessaire pour être emprunté.
     *
     * @return la charge minimum nécessaire pour être empruntée.
     */
    public int getMinChargeToBorrow() {
        return this.minChargeToBorrow;
    }

    /**
     * Accesseur en écriture du minimum de charge nécessaire pour être emprunté.
     *
     * @param minChargeToBorrow la nouvelle charge minimum nécessaire pour être emprunté.
     */
    public void setMinChargeToBorrow(int minChargeToBorrow) {
        this.minChargeToBorrow = minChargeToBorrow;
    }


}
