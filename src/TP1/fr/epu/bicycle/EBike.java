package TP1.fr.epu.bicycle;

/**
 * Classe représentant un vélo, avec son nombre de kilomètres parcourus, son GPS et sa batterie.
 * @author Michel K
 * @see Battery
 * @see GPS
 */
public class EBike {
    /**
     * Le nombre de kilomètres parcourus par le vélo.
     */
    private int km;
    /**
     * La distance initiale parcourue par le vélo en sortie d'usine : 1.
     */
    protected static final int INITIAL_DISTANCE = 1;
    /**
     * La batterie associée à ce vélo.
     */
    private Battery battery;
    /**
     * Le GPS associé à ce vélo.
     */
    private GPS gps;

    /**
     * Constructeur de EBike, définissant le nombre de kilomètres parcourus originellement par le vélo en sortie d'usine,
     * le GPS et la batterie utilisés dans ce vélo.
     * @see GPS
     * @see Battery
     */
    public EBike() {
        this.km = INITIAL_DISTANCE;
        this.gps = new GPS();
        this.battery = new Battery(100, 48); // 100% de charge au départ et puissance de 48 Volts par exemple
    }

    /**
     * Méthode permettant d'ajouter des kilomètres au compteur du vélo.
     * Si ce nombre est négatif, le kilomètrage ne change pas.
     * @param kmToAdd nombre de kilomètres à ajouter au compteur du vélo. Ce nombre doit être positif.
     */
    public void addKm(int kmToAdd) { // Ou alors on peut lui mettre un unsigned
        if (kmToAdd >= 0) {
            this.km += kmToAdd;
        }
    }

    /**
     * Accesseur en lecture du nombre de kilomètres parcourus par le vélo.
     * @return le kilomètrage du vélo.
     */
    public int getKm() {
        return this.km;
    }

    /**
     * Accesseur en écriture du nombre de kilomètres parcourus par le vélo.
     * @param km le nombre de kilomètres parcourus à associer à ce vélo.
     */
    private void setKm(int km) {
        this.km = km;
    }

    /**
     * Accesseur en lecture de la position du vélo.
     * @return la position du vélo sous forme d'un objet Position.
     * @see Position
     */
    public Position getPosition() {
        return this.gps.getPosition();
    }

    /**
     * Accesseur en lecture du niveau de charge courant du vélo.
     * @return le niveau de charge courant du vélo.
     */
    public int getEnergy() {
        return this.battery.getCharge();
    }
}
