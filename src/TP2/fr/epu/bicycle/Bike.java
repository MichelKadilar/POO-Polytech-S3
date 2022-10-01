package TP2.fr.epu.bicycle;

import java.util.Optional;

public class Bike implements Trackable, Borrowable {

    private Position position;

    private boolean isBorrowed;

    public Bike() {
        this.isBorrowed = false;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Optional<Position> getPosition() {
        return Optional.empty();
    }

    @Override
    public boolean isBorrowable() {
        return this.position != null; // S'il a une position, il est en station, il est donc empruntable
    }

    @Override
    public void setNotBorrowed() {
        this.isBorrowed = false;
    }

    @Override
    public void setBorrowed() {
        this.isBorrowed = true;
    }
}
