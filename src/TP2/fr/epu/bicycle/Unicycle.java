package TP2.fr.epu.bicycle;

/**
 * Classe représentant un unicycle électrique
 * Il est traçable et a un concept d'emprunt
 * Un unicycle n'est PAS empruntable
 *
 * @author Michel K
 * @see ElectricVehicle
 * @see Position
 */
public class Unicycle extends ElectricVehicle {

    /**
     * Constructeur de Unicycle, définissant notamment la position de l'unicycle selon un paramètre position et
     * son autorisation d'emprunt : toujours FAUX
     * On ne peut jamais emprunter un unicycle
     *
     * @param position la position courante de l'unicycle.
     */
    public Unicycle(Position position) {
        super();
        this.gps.changePosition(position.getX(), position.getY());
        this.isBorrowable = false;
    }

    /**
     * Accesseur en lecture de l'autorisation d'emprunt : toujours FAUSSE
     * Un Unicycle n'est jamais empruntable.
     *
     * @return Faux : un unicycle n'est pas empruntable.
     */
    @Override
    public boolean isBorrowable() {
        return false;
    }
}
