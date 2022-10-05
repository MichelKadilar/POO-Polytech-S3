package TP3.fr.epu.bicycle;

import java.util.ArrayList;

/**
 * Classe représentant une station recensant des vélos classiques.
 *
 * @author Michel K
 * @see Bike
 * @see Position
 */
public class Station {

    /**
     * Liste des vélos classiques garés dans cette station.
     */
    private ArrayList<Bike> bikeArrayList;

    /**
     * La position de la station (qui sera passée aux vélos garés dans la station).
     */
    private Position position;

    /**
     * Constructeur de Station, qui définit notamment la position de la station selon un paramètre;
     * Il initialise également une liste de vélos rangés dans la station, au départ vide.
     *
     * @param position la position de la station.
     */
    public Station(Position position) {
        this.position = position;
        bikeArrayList = new ArrayList<>();
    }

    /**
     * Accesseur en lecture de la position de la station.
     *
     * @return la position de la station.
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Méthode permettant d'indiquer qu'un vélo a été emprunté et ainsi l'enlever de la liste des vélos disponibles
     * dans la station; Cela a pour conséquence que la position du vélo devient inconnue.
     *
     * @param bike le velo emprunté qu'on enlève de la station.
     */
    public void removeBikeFromStation(Bike bike) {
        try {
            this.bikeArrayList.remove(bike);
        } catch (Exception e) {
            System.err.println("Le vélo n'est pas pas présent dans l'arraylist et vous essayez de l'en enlever.");
        }
        bike.setPosition(null);
    }

    /**
     * Méthode permettant d'indiquer qu'un vélo a été rendu à une station et donc de l'ajouter aux vélos garés
     * dans la station; Cela a pour conséquence qu'on connait de nouveau la position du vélo : celle de la station.
     *
     * @param bike le vélo qu'on ajoute à la station.
     */
    public void addBikeToStation(Bike bike) {
        this.bikeArrayList.add(bike);
        bike.setPosition(this.position);
    }

}
