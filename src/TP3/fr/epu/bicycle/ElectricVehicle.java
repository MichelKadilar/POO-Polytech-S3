package TP3.fr.epu.bicycle;

import TP3.fr.epu.bicycle.exceptions.BatteryValueException;
import TP3.fr.epu.bicycle.exceptions.KmValueException;

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
    protected int km;
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
    protected ElectricVehicle() throws BatteryValueException {
        this.battery = new Battery(100, 48); // 100% de charge au départ et puissance de 48 Volts par exemple
        this.gps = new GPS();
    }

    /**
     * Méthode permettant d'ajouter des kilomètres au compteur du vélo;
     * Si ce nombre est négatif, le kilomètrage ne change pas.
     *
     * @param kmToAdd nombre de kilomètres à ajouter au compteur du vélo. Ce nombre doit être positif.
     */
    public void addKm(int kmToAdd) throws KmValueException {
        if (kmToAdd >= 0) {
            this.km += kmToAdd;
        } else throw new KmValueException("L'ajout de kilométrage a un problème de valeur.");
    }

    /**
     * Accesseur en lecture du nombre de kilomètres parcourus par le vélo.
     *
     * @return le kilomètrage du vélo.
     */
    public int getKm() {
        return this.km;
    }

    /**
     * mutateur du nombre de kilomètres parcourus par le vélo.
     *
     * @param km le nombre de kilomètres parcourus à associer à ce vélo.
     */
    private void setKm(int km) throws KmValueException {
        if (km >= 0) {
            this.km = km;
        } else throw new KmValueException("Le kilométrage a un problème de valeur.");
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
