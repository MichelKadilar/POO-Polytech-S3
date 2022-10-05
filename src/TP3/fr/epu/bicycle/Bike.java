package TP3.fr.epu.bicycle;

import java.util.Optional;

/**
 * Classe représentant un vélo classique (non-éléctrique)
 *
 * @author Michel K
 */
public class Bike implements Trackable {

    /**
     * Position du vélo
     *
     * @see Position
     */
    private Position position;

    /**
     * Accesseur en écriture de la position du vélo
     *
     * @param position la nouvelle position du vélo
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Accesseur en lecture de la position du vélo
     *
     * @return Une position si elle existe (si le vélo est à une station), null sinon.
     * @see Optional
     */
    @Override
    public Optional<Position> getPosition() {
        return Optional.ofNullable(this.position);
    }

    /**
     * Méthode permettant de déterminer si un vélo est empruntable selon sa position;
     * Une position null signifie qu'il n'est pas empruntable, une position définie signifie que le vélo est empruntable.
     *
     * @return Vrai si le vélo est empruntable, Faux sinon.
     */
    @Override
    public boolean isBorrowable() {
        return this.position != null; // S'il a une position, il est en station, il est donc empruntable
    }


}
