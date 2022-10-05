package TP3.fr.epu.bicycle;

/**
 * Classe utilisée dans EBike, représentant un GPS avec une position iniquée.
 * @author Michel K
 * @see EBike
 * @see Position
 */

public class GPS {
    /**
     * Position indiquée par le GPS
     */
    private Position position;

    /**
     * Constructeur de la classe GPS.
     * La positon indiquée est initialement x=0 et y=0.
     */
    public GPS() {
        this.position = new Position(0, 0);
    }

    /**
     * Getter de la position indiquée par le GPS
     * @return la position indiquée par le GPS.
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Méthode permettant de changer la position indiquée par le GPS
     * @param newX la position indiquée par le GPS en X
     * @param newY la position indiquée par le GPS en Y
     */
    public void changePosition(int newX, int newY) {
        this.position.setX(newX);
        this.position.setY(newY);
    }
}
