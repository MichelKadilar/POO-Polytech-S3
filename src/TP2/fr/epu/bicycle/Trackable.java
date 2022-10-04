package TP2.fr.epu.bicycle;

import java.util.Optional;

/**
 * Interface définissant les méthodes pour le calcul de la position d'un véhicule;
 * Elle hérite de Borrowable, ainsi un véhicule traçable est un véhicule ayant un concept d'emprunt
 * (que l'emprunt soit possible ou non).
 *
 * @author Michel K
 * @see Borrowable
 * @see Optional
 * @see Position
 */
public interface Trackable extends Borrowable {

    /**
     * Méthode définissant la technique de calcul de la position d'un véhicule (selon ce véhicule).
     *
     * @return La position du véhicule si elle est définie. Null sinon.
     */
    Optional<Position> getPosition();
}
