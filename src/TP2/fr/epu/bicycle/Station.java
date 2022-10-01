package TP2.fr.epu.bicycle;

import java.util.ArrayList;
import java.util.Optional;

public class Station {

    private ArrayList<Bike> bikeArrayList;

    private Position position;

    public Station(Position position) {
        this.position = position;
        bikeArrayList = new ArrayList<>();
    }

    public Position getPosition() {
        return this.position;
    }

    public void removeBikeFromStation(Bike bike){
        this.bikeArrayList.remove(bike);
        bike.setPosition(null);
    }

    public void addBikeToStation(Bike bike){
        this.bikeArrayList.add(bike);
        bike.setPosition(this.position);
    }

}
