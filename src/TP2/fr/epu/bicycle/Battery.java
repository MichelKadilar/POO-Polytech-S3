package TP2.fr.epu.bicycle;

/**
 * Classe utilisée pour définir la puissance et le niveau de charge de la batterie d'un vélo.
 * @author Michel K
 * @see EBike
 */
public class Battery {

    /**
     * Niveau courant de charge de la batterie.
     */
    private int charge;
    /**
     * Niveau maximum de charge de la batterie.
     */
    private int maxCharge;
    /**
     * Puissance de la batterie, en volts.
     */
    private int puissance;

    /**
     * Constructeur de la classe Battery, la charge initiale et maximum sont confondues au début.
     * @param chargeMaxValue le niveau maximum de la charge de la batterie.
     * @param puissance la puissance de la batterie.
     */
    public Battery(int chargeMaxValue, int puissance) {
        this.maxCharge = chargeMaxValue;
        this.charge = this.maxCharge;
        this.puissance = puissance;
    }

    /**
     * Méthode permettant d'ajouter de l'energie à la charge courante.
     * @param chargeToAdd l'energie à ajouter à la charge courante.
     */
    public void addEnergy(int chargeToAdd) {
        this.charge += chargeToAdd;
    }

    /**
     * Accesseur en lecture du niveau de charge courant de la batterie.
     * @return le niveau de charge courant de la batterie.
     */
    public int getCharge() {
        return this.charge;
    }
    /**
     * Accesseur en lecture du niveau maximum de charge de la batterie.
     * @return le niveau maximum de charge de la batterie.
     */
    public int getMaxCharge() {
        return this.maxCharge;
    }
    /**
     * Accesseur en lecture de la puissance de la batterie.
     * @return la puissance de la batterie, en volts.
     */
    public int getPuissance() {
        return this.puissance;
    }
}
