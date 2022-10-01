package TP2.fr.epu.bicycle;

import java.util.Optional;

public class ElectricVehicle extends TrackableVehicle implements Trackable{
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
     * Constructeur de ElectricVehicle, définissant le nombre de kilomètres parcourus originellement par le vélo en sortie d'usine,
     * le GPS et la batterie utilisés dans ce vélo.
     *
     * @see GPS
     * @see Battery
     */
    public ElectricVehicle() {
        this.battery = new Battery(100, 48); // 100% de charge au départ et puissance de 48 Volts par exemple
        this.gps = new GPS();
    }

    /**
     * Méthode permettant d'ajouter des kilomètres au compteur du vélo.
     * Si ce nombre est négatif, le kilomètrage ne change pas.
     *
     * @param kmToAdd nombre de kilomètres à ajouter au compteur du vélo. Ce nombre doit être positif.
     */
    public void addKm(int kmToAdd) { // Ou alors on peut lui mettre un unsigned
        if (kmToAdd >= 0) {
            this.km += kmToAdd;
        }
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
     * Accesseur en écriture du nombre de kilomètres parcourus par le vélo.
     *
     * @param km le nombre de kilomètres parcourus à associer à ce vélo.
     */
    private void setKm(int km) {
        this.km = km;
    }

    /**
     * Accesseur en lecture de la position du vélo.
     *
     * @return la position du vélo sous forme d'un objet Position.
     * @see Position
     */
    @Override
    public Optional<Position> getPosition(){
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
}
