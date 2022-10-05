package TP3.fr.epu.bicycle;

import TP3.fr.epu.bicycle.exceptions.BatteryValueException;

/**
 * Classe utilisée pour définir la puissance et le niveau de charge de la batterie d'un vélo.
 *
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
     *
     * @param chargeMaxValue le niveau maximum de la charge de la batterie.
     * @param puissance      la puissance de la batterie.
     */
    public Battery(int chargeMaxValue, int puissance) throws BatteryValueException {
        if (chargeMaxValue > 0 && chargeMaxValue <= 100) this.maxCharge = chargeMaxValue;
        else throw new BatteryValueException("Problème dans la valeur de la charge maximum");
        this.charge = this.maxCharge;
        this.puissance = puissance;
    }

    /**
     * Méthode permettant d'ajouter de l'energie à la charge courante.
     *
     * @param chargeToAdd l'energie à ajouter à la charge courante.
     */
    public void addEnergy(int chargeToAdd) throws BatteryValueException {
        if (this.charge + chargeToAdd > 0 && this.charge + chargeToAdd <= 100) {
            this.charge += chargeToAdd;
        } else throw new BatteryValueException("Problème dans l'ajout de batterie à la charge déjà existante");
    }

    /**
     * Accesseur en lecture du niveau de charge courant de la batterie.
     *
     * @return le niveau de charge courant de la batterie.
     */
    public int getCharge() {
        return this.charge;
    }

    /**
     * Accesseur en lecture du niveau maximum de charge de la batterie.
     *
     * @return le niveau maximum de charge de la batterie.
     */
    public int getMaxCharge() {
        return this.maxCharge;
    }

    /**
     * Accesseur en lecture de la puissance de la batterie.
     *
     * @return la puissance de la batterie, en volts.
     */
    public int getPuissance() {
        return this.puissance;
    }
}
