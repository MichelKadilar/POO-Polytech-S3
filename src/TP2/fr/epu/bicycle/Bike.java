package TP2.fr.epu.bicycle;

import java.util.Optional;

public class Bike implements Trackable{

    private Position position;

    public Bike(){
        // TODO document why this constructor is empty
    }

    public void setPosition(Position position){
        this.position = position;
    }

    @Override
    public Optional<Position> getPosition() {
        return Optional.empty();
    }
}
