package TP2.fr.epu.bicycle;

/**
 * Interface définissant la signature des fonctions concernant l'emprunt de véhicules
 *
 * @author Michel K
 */
public interface Borrowable {

    /**
     * Méthode permettant de définir si un véhicule est empruntable ou non.
     *
     * @return Vrai si le véhicule est empruntable. Faux sinon.
     */
    boolean isBorrowable();
}
