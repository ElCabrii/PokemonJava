package src;
import src.Destination.*;

import java.util.Scanner;

public class Move {
    public static void move(String destination1, String destination2 ){
        String textToDisplay =
                "Where do you wanna go ?\n" +
                "At " + destination1 + " or " + destination2 + " ?\n" +
                "Enter the name of the destination you want to go to : ";
        Scanner scanner = new Scanner(System.in);
            String destination = scanner.nextLine();
            if (destination.equals(destination1)) {
                System.out.println("You are now at " + destination1);
                Home.home();

            } else if (destination.equals(destination2)) {
                System.out.println("You are now at " + destination2);
                Laboratory.laboratory();
            } else {
                System.out.println("Invalid destination");
            }
            TextDisplayer.displayParagraph(textToDisplay);


        }

    }
