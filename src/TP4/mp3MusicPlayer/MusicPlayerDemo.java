package TP4.mp3MusicPlayer;

import java.util.Scanner;

/**
 * @author Mireille Blay-Fornarino
 */
public class MusicPlayerDemo {

    private static final String USER_DIR_STRING = "user_dir";
    public static final String USER_DIR = System.getProperty(USER_DIR_STRING);

    public static void main(String[] args) {
        MusicPlayer mp = new MusicPlayer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Placez vos fichiers audio sous : " + USER_DIR);
        boolean goOn = true;


        while (goOn) {
            String command = getCommand("What file do you want to listen to (to stop type 's')?", sc);
            goOn = !command.equals("s");
            if (goOn) {
                try {
                    mp.playSample(System.getProperty("user.dir") + command, 500);
                } catch (NonAvailableFileException e) {
                    System.out.println("The file cannot be listen : " + e);

                    command = getCommand("What file do you want to listen to (to stop type 's')?", sc);
                    goOn = !command.equals("s");
                }
            }
        }

        assert !goOn;

        String command = getCommand("What file do you want to listen to for a long time (to stop type 's')?", sc);
        goOn = !command.equals("s");
        while (goOn) {
            try {
                mp.startPlaying(System.getProperty("user.dir") + command);
                command = getCommand("To stop to listen type (s) or a new file name ", sc);
                mp.stop();
                goOn = !command.equals("s");
            } catch (NonAvailableFileException e) {
                System.out.println("The file cannot be listen : " + e);
            }
        }


    }

    private static String getCommand(String s, Scanner sc) {
        String command;
        System.out.print(s);
        command = sc.nextLine();
        return command;
    }
}

