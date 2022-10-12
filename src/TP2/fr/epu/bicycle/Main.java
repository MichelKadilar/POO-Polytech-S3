package TP2.fr.epu.bicycle;

import TP3.fr.epu.bicycle.exceptions.KmValueException;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws KmValueException {
        EBike e1 = new EBike(new Position(1, 1), 20);
        final String STOP = "s";
        String stop = "f";
        Scanner keyboard = new Scanner(System.in);
        keyboard.useLocale(Locale.US);//To read the doubles with . and not ,

        while (!STOP.equals(stop)) {
            System.out.print("\t What distance did you travel in km or miles ? ");
            if (keyboard.hasNextLine()) {
                String newD = keyboard.nextLine();
                String[] stringDistance = newD.split(" ");
                double newDistance;
                if (stringDistance.length == 2) {
                    newDistance = Double.parseDouble(stringDistance[0]); //reading a double
                    if (stringDistance[1].equals("km")) {
                        e1.addKm(newDistance);
                    } else if (stringDistance[1].equals("mi")) {
                        e1.addMilesAsKm(newDistance);
                    }
                    System.out.println("\t Your bike has therefore travelled " + e1.getKm() + " km or " + e1.getMiles() + " miles");
                } else {
                    throw new KmValueException("Vous avez entré une valeur étrange en tant que km ou miles");
                }

            } else {
                System.out.println("\t a number is expected for example  1 or 1.5 ");
            }
            System.out.print("Do you want to continue or stop (" + STOP + ") ? ");
            stop = keyboard.nextLine();
        }
    }
}
