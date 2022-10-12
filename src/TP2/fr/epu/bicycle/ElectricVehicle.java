package TP2.fr.epu.bicycle;

import java.util.Optional;

/**
 * Classe représentant les véhicules électriques; Ils sont tous traçables grâce à leur GPS et techniquement empruntables.
 *
 * @see Trackable
 * @see Borrowable
 */
public abstract class ElectricVehicle implements Trackable {
    /**
     * Le nombre de kilomètres parcourus par le vélo.
     */
    protected double km;
    /**
     * La batterie associée à ce vélo.
     */
    protected Battery battery;
    /**
     * Le GPS associé à ce vélo.
     */
    protected GPS gps;

    /**
     * Le véhicule est-il autorisé à l'emprunt ?
     */
    protected boolean isBorrowable;

    /**
     * Constructeur de ElectricVehicle, définissant le nombre de kilomètres parcourus originellement par le vélo en sortie d'usine,
     * le GPS et la batterie utilisés dans ce vélo.
     *
     * @see GPS
     * @see Battery
     */
    protected ElectricVehicle() {
        this.battery = new Battery(100, 48); // 100% de charge au départ et puissance de 48 Volts par exemple
        this.gps = new GPS();
    }

    /**
     * Méthode permettant d'ajouter des kilomètres au compteur du vélo;
     * Si ce nombre est négatif, le kilomètrage ne change pas.
     *
     * @param kmToAdd nombre de kilomètres à ajouter au compteur du vélo. Ce nombre doit être positif.
     */
    public void addKm(double kmToAdd) { // Ou alors on peut lui mettre un unsigned
        if (kmToAdd >= 0) {
            this.km += kmToAdd;
        }
    }

    public void addMilesAsKm(double milesToAdd) { // Ou alors on peut lui mettre un unsigned
        if (milesToAdd >= 0) {
            this.km += milesToAdd * 1.609;
        }
    }

    /**
     * Accesseur en lecture du nombre de kilomètres parcourus par le vélo.
     *
     * @return le kilomètrage du vélo.
     */
    public double getKm() {
        return this.km;
    }

    public double getMiles() {
        return this.getKm() / 1.609;
    }

    /**
     * mutateur du nombre de kilomètres parcourus par le vélo.
     *
     * @param km le nombre de kilomètres parcourus à associer à ce vélo.
     */
    private void setKm(double km) {
        this.km = km;
    }

    /**
     * Accesseur en lecture de la position du vélo.
     *
     * @return la position du vélo sous forme d'un objet Position.
     * @see Position
     */
    @Override
    public Optional<Position> getPosition() {
        return Optional.ofNullable(this.gps.getPosition());
    }

    /**
     * Accesseur en lecture du niveau de charge courant du vélo.
     *
     * @return le niveau de charge courant du vélo.
     */
    public int getEnergy() {
        return this.battery.getCharge();
    }

    /**
     * Accesseur en écriture de l'autorisation à l'emprunt.
     *
     * @param isBorrowable la nouvelle autorisation, vraie ou fausse.
     */
    public void setBorrowable(boolean isBorrowable) {
        this.isBorrowable = isBorrowable;
    }

}
