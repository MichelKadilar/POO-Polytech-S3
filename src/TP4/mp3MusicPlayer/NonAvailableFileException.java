package TP4.mp3MusicPlayer;

public class NonAvailableFileException extends Exception {
    public NonAvailableFileException(String filename, Throwable e) {
        super ("Error reading file " + filename, e);
    }
    public NonAvailableFileException(String message) {
        super (message);
    }
}
